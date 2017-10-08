package servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import unigram.Unigram;

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
		HttpSession session = request.getSession(true);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
		   Iterator<FileItem> iterator = upload.parseRequest(request).iterator();
		    while (iterator.hasNext()) {
		        FileItem item = iterator.next();
		        if (item.isFormField()) {
		            if (item.getFieldName().equals("sort")) {
//		            	final String sort = item.getString();
		            	System.out.println(((Unigram)session.getAttribute("unigram")).getFrequencies());
		            }
		        } else {
		            Unigram unigram = new Unigram(new InputStreamReader(item.getInputStream()));
		            session.setAttribute("unigram", unigram);
		            List<Entry<String, Integer>> entries = 
		            		new ArrayList<Entry<String, Integer>>(unigram.getFrequencies().entrySet());
		            final String sort = request.getParameter("sort");
					
					Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
						public int compare(Entry<String, Integer> x, Entry<String, Integer> y) {
							if (sort == null || sort.equals("word")) {
								return x.getKey().compareTo(y.getKey());
							} else {
								return y.getValue().compareTo(x.getValue());
							}
						}
					});
					
					session.setAttribute("list", entries);
		        }
		    }
		    response.sendRedirect("upload.jsp");
		} catch (FileUploadException e) {
		    // ファイルアップロード例外発生時の処理(以下はエラー表示の実装例)
		    response.setCharacterEncoding("UTF-8");
		    PrintWriter out = response.getWriter();
		    out.println("Upload error");
		    out.close();
		}
	}

}
