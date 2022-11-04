package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SentimentRequestServlet")
public class SentimentRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public SentimentRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/sen_request.jsp").forward(request, response);
	}

}
