package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductLogic;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		List<Product> productList = (List<Product>) application.getAttribute("productList");
		if (productList == null) {
			productList = new ArrayList<>();
			application.setAttribute("productList", productList);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		LocalDateTime nowDate = LocalDateTime.now();
		DateTimeFormatter dtf1 =
				DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String date = dtf1.format(nowDate);

		if ((name != null && name.length() != 0) && (price != null && price.length() != 0)) {
			ServletContext application = this.getServletContext();
			List<Product> productList = (List<Product>) application.getAttribute("productList");

			Product product = new Product(name, price, date);

			ProductLogic productlogic = new ProductLogic();
			productlogic.execute(product, productList);

			application.setAttribute("productList", productList);
			request.setAttribute("msg", "1件登録しました");
		}else {
			request.setAttribute("msg", "未記入の項目があります!");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}
}
