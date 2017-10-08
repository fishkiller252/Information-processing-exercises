package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author b1013236 齊藤正宏
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResultServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("message");
		int len = text.length(); // 文字数を数える
		String[] words = text.split("[ ¥n]"); // 空白か改行で分割
		request.setAttribute("numofcharacters", len); // 文字数をセット
		request.setAttribute("numofwords", words.length); // 語数をセット
		request.setAttribute("text", text); // テキストそのものをセット
		request.getRequestDispatcher("result.jsp").forward(request, response); // result.jspに飛ぶ
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
