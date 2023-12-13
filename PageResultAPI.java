import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PageResultAPI")
public class PageResultAPI extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 設定響應內容類型
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        try {
            // 這裡需要替換成你實際的 WebTree 對象
            WebTree webTree = getWebTree();

            // 獲取 WebTree 中的節點列表
            ArrayList<WebNode> nodeList = webTree.ListTree();

            // 構建 JSON 陣列
            out.println("[");
            for (int i = 0; i < nodeList.size(); i++) {
                WebNode node = nodeList.get(i);
                String title = node.webpage.title;
                String url = node.webpage.url;

                // 構建 JSON 對象
                out.println("{");
                out.println("\"title\": \"" + title + "\",");
                out.println("\"url\": \"" + url + "\"");
                out.println("}");

                // 如果不是最後一個節點，加上逗號
                if (i < nodeList.size() - 1) {
                    out.println(",");
                }
            }
            out.println("]");

        } catch (Exception e) {
            // 處理異常情況
            e.printStackTrace();
            out.println("{\"error\": \"An error occurred while processing the request.\"}");
        }
    }

    // 替換為實際的 WebTree 對象
    private WebTree getWebTree() {
        // 在這裡實例化和構建 WebTree 對象
        // 這取決於你的應用程序邏輯
        WebTree webTree = new WebTree();
        // 添加節點到 WebTree

        return webTree;
    }
}