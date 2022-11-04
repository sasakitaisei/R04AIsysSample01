package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/SentimentResultServlet")
public class SentimentResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public SentimentResultServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String string = "生姜焼定食";
		try {
			Sentiments result = Sentiment.getSentiment(string);
			double positive = result.documents[0].confidenceScores.positive;
			double neutral = result.documents[0].confidenceScores.neutral;
			double negative = result.documents[0].confidenceScores.negative;
			request.setAttribute("positive", positive);
			request.setAttribute("neutral", neutral);
			request.setAttribute("negative", negative);
			request.getRequestDispatcher("/WEB-INF/jsp/sen_result.jsp").forward(request, response);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("string");
		request.setAttribute("string", string);

		try {
			Sentiments result = Sentiment.getSentiment(string);
			double positive = result.documents[0].confidenceScores.positive;
			double neutral = result.documents[0].confidenceScores.neutral;
			double negative = result.documents[0].confidenceScores.negative;
			request.setAttribute("positive", positive);
			request.setAttribute("neutral", neutral);
			request.setAttribute("negative", negative);
			request.getRequestDispatcher("/WEB-INF/jsp/sen_result.jsp").forward(request, response);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	

}
