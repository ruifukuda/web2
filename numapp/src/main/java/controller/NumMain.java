package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Num;
import model.NumLogic;

@WebServlet("/NumMain")
public class NumMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("WEB-INF/view/form.jsp");
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numbers = request.getParameter("numbers");
		
		Num num = new Num();
		num.setNumbers(numbers);
		
		/*
		NumLogic.split(num);
		NumLogic.count(num);
		NumLogic.max(num);
		NumLogic.min(num);
		NumLogic.sum(num);
		*/
		//NumLogic.execute(num);
		NumLogic logic = new NumLogic();
		logic.execute(num);
		
		request.setAttribute("num", num);
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/view/result.jsp");
		dispatcher.forward(request,response);
	}

}
