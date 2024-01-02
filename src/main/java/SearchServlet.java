import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;


//public class Facade {
	
//	public Facade() {
//		super();
//	}
	
    //receive query from front-end
    @WebServlet("/searchServlet")
    public class SearchServlet extends HttpServlet {
    	
    	
    	private static final long serialVersionUID =1L;
    	
    	public SearchServlet() {
    		super();
    	}
        protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            	String query = request.getParameter("query");

            // build the query and put the serach result into HashMap
            GoogleQuery googleQuery = new GoogleQuery(query);
//            System.out.println(googleQuery);
            HashMap<String, String> queryResult = googleQuery.query();
            System.out.println("排序後");
            for(String key:queryResult.keySet()) {
            	System.out.println(key);
            }

            //build the WebTree
            WebTree webTree = new WebTree();
//            WordCounter counter = new WordCounter();
            //insert the search result into WebTree
            for(String key: queryResult.keySet()) {
            	Webpage page = new Webpage(queryResult.get(key),key);
            	WebNode webnode = new WebNode(page);
//            	webnode.webpage.url = ;
//            	webnode.webpage.title = key;
//            	counter.countKeyword();
//            	webnode.webpage.setScore();
            	webTree.insert(webnode);
    
            }
            

            //List the WebTree
            ArrayList<WebNode> list = webTree.ListTree();
            for(WebNode n: list) {
            	System.out.println(n.webpage.title);
            }
            System.out.println(list);
//            ArrayList<String> titleList = new ArrayList<String>();
//            ArrayList<String> urlList = new ArrayList<String>();
            
//            for(int i = 0; i< list.size(); i++){
//                titleList.add(list.get(i).webpage.title);
//                urlList.add(list.get(i).webpage.url);
//            }
//            for(String s:titleList) {
//            	System.out.println(s);
//            }

            JSONArray resultsArray = new JSONArray();

            // 將標題和網址放入 JSON 陣列
            for(int i = 0; i< list.size(); i++){
                JSONObject item = new JSONObject();
//                item.put("title", titleList.get(i));
//                item.put("url", urlList.get(i));
                resultsArray.put(item);
            }
            System.out.println(resultsArray);

            // 設置響應類型為 JSON
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // 發送 JSON 陣列至前端
            response.getWriter().write(resultsArray.toString());
            
//            for(String s: titleList) {
//            	System.out.println(titleList);
//            }

        }
    }
