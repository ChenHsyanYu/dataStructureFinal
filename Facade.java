import java.io.IOException;
import java.util.HashMap;

public class Facade {

    @WebServlet("/searchServlet")
    public class SearchServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String query = request.getParameter("query");

            // 處理查詢
            String searchResults = processSearchQuery(query);

            // 設置回應類型為文本
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");

            // 發送處理結果回前端
            response.getWriter().write(searchResults);
        }

        private String processSearchQuery(String query) {
            // 在這裡處理查詢
            // 返回處理結果
            return "Processed results for: " + query;
        }
    }

}
