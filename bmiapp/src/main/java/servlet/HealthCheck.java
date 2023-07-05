package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;

//ユーザーがurlを入力するとdoGetメソッドが発動
@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//繋がったら最初に入力画面を表示させたいからjspにフォワード
		RequestDispatcher dispatcher =
			request.getRequestDispatcher("WEB-INF/jsp/healthCheck.jsp");	
		dispatcher.forward(request, response);
	}
	
	//post通信で飛んできたらdoPostメソッド発動
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");
		
		//Healthクラスからhealthインスタンス作成
		Health health = new Health();
		health.setHeight(Double.parseDouble(height));
		health.setWeight(Double.parseDouble(weight));
		
		//ロジッククラスのインスタンス生成してメソッド実行させる
		HealthCheckLogic healthCheckLogic = new HealthCheckLogic();
		healthCheckLogic.execute(health);
	
		//完成したhealthインスタンスを閉じ込める
		request.setAttribute("health", health);
		
		//リザルトjspにフォワード
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("WEB-INF/jsp/healthCheckResult.jsp");
		dispatcher.forward(request, response);
	}
}
