import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class Facade {

    //receive query from front-end
    @WebServlet("/searchServlet")
    public class SearchServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String query = request.getParameter("query");

            // build the query and put the serach result into HashMap
            GoogleQuery googleQuery = new GoogleQuery(query);
            HashMap<String, String> queryResult = googleQuery.query();

            //build the WebTree
            WebTree webTree = new WebTree();
            //insert the search result into WebTree
            for(int i = 0; i < queryResult.size(); i++){
                WebNode webNode = new WebNode();
                webNode.webpage.url = queryResult.getValue(i);
                webNode.webpage.title = queryResult.getKey(i);
                WordCounter.countKeyword(webNode.webpage.url);
                webNode.webpage.setScore();
                webTree.insert(webNode);
            }

            //List the WebTree
            ArrayList<WebNode> list = webTree.ListTree();
            ArrayList<String> titleList = new ArrayList<String>();
            ArrayList<String> urlList = new ArrayList<String>();
            for(int i = 0; i< list.size(); i++){
                titleList.add(list.get(i).webpage.title);
                urlList.add(list.get(i).webpage.url);
            }

            JSONArray resultsArray = new JSONArray();

            // 將標題和網址放入 JSON 陣列
            for(int i = 0; i< list.size(); i++){
                JSONObject item = new JSONObject();
                item.put("title", list.get(i).webpage.title);
                item.put("url", list.get(i).webpage.url);
                resultsArray.put(item);
            }

            // 設置響應類型為 JSON
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // 發送 JSON 陣列至前端
            response.getWriter().write(resultsArray.toString());

        }
    }
}
