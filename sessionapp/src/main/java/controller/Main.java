package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Main")
public class Main extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "山田";
		int age = 28;
		//超重要(sessionインスタンスの取得方法)
		//HttpSessionを書けるかがテストに必ず出る、eclipseのヒントなしで書き始めなくちゃいけないから。
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("age", age);
		
		/*
		RequestDispatcher rd =
				request.getRequestDispatcher("/WEB-INF/view/result.jsp");
		rd.forward(request, response);
		*/
		
		//メソッドチェーンで1行で書ける
		request.getRequestDispatcher("/WEB-INF/view/result.jsp")
		.forward(request, response);
	}
}
