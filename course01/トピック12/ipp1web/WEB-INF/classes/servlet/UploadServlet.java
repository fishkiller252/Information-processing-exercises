package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author b1013236 齊藤正宏
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
		   Iterator<FileItem> iterator = upload.parseRequest(request).iterator();
		    while (iterator.hasNext()) {
		        FileItem item = iterator.next();
		        if (item.isFormField()) {
		            // 通常のフォームパラメータの場合の処理
		        } else {
		            // ファイルアップロードパラメータの場合の処理(今回はテキストファイルとして読み込んでrequestにsetAttributeする)
		            String text = "";
		            BufferedReader in = new BufferedReader(new InputStreamReader(item.getInputStream()));
		            String s;
		            while ((s = in.readLine()) != null) {
		                text += s;
		            }
		            // 以下はResultServletと同様の処理
		            int len = text.length();
		            String[] words = text.split("[ ¥n]");
		            request.setAttribute("numofcharacters", len);
		            request.setAttribute("numofwords", words.length);
		            request.setAttribute("text", text);
		        }
		    }
		    request.getRequestDispatcher("result.jsp").forward(request, response); // result.jspにforward
		} catch (FileUploadException e) {
		    // ファイルアップロード例外発生時の処理(以下はエラー表示の実装例)
		    response.setCharacterEncoding("UTF-8");
		    PrintWriter out = response.getWriter();
		    out.println("Upload error");
		    out.close();
		}
	}

}
