package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MutterDAO;
import model.Mutter;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_id=request.getParameter("id");
		if(s_id == null) {
			response.sendRedirect("/dokoTsubuDB/Main");
		}else {
			MutterDAO dao = new MutterDAO();
			Mutter mutter = dao.findOne(Integer.parseInt(s_id));
			request.setAttribute("mutter", mutter);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String userText = request.getParameter("text");
		String id = request.getParameter("id");
		Mutter mutter = new Mutter(Integer.parseInt(id), userName, userText);
		MutterDAO dao = new MutterDAO();
		dao.updateOne(mutter);
		
		response.sendRedirect("/dokoTsubuDB/Main");
	}

}
