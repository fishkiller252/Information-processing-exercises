package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unigram.Unigram;

/**
 * @author b1013236 齊藤正宏
 */
@WebServlet("/UnigramServlet")
public class UnigramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UnigramServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String text = request.getParameter("inputtext");
		
		if (text != null && !"".equals(text)) {
			List<Entry<String, Integer>> entries =  new ArrayList<Entry<String, Integer>>(
					new Unigram(new ArrayList<String>(Arrays.asList(
							text.split(System.getProperty("line.separator")))))
					.getFrequencies().entrySet());
			
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
			
			request.setAttribute("list", entries);
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
