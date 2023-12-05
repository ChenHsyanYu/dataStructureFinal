import java.io.IOException;
import java.util.HashMap;

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


            }


            // 處理查詢
            String searchResults = processSearchQuery(query);

            // 設置回應類型為文本
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");

            // 發送處理結果回前端
            response.getWriter().write(searchResults);
        }

    }




}
