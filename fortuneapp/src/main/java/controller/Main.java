package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Main")
public class Main extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストスコープに保存するインスタンスを生成
		Random rand = new Random();
		String[] results = {"大吉","中吉","吉","凶"};
		int idx = rand.nextInt(results.length);
		String result = results[idx];
		
		//リクエストスコープにインスタンスを保存
		request.setAttribute("result", result);
		
		//フォワード先を指定
		RequestDispatcher rd = 
				request.getRequestDispatcher("/WEB-INF/view/result.jsp");
		//フォワードする内容を記述
		rd.forward(request, response);
	}
}
