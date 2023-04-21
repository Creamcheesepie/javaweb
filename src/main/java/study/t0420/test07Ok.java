package study.t0420;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/t0420/Test7Ok")
public class test07Ok extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		String part = request.getParameter("part");
		String[] products = request.getParameterValues("product");
		String[] prices = request.getParameterValues("price");
		String[] sus = request.getParameterValues("su");
		int[] res = new int[products.length];
		int sumPrice = 0;
		//결과를 콘솔로 출력
		for(int i=0; i<sus.length;i++) {
			res[i] = Integer.parseInt(prices[i])*Integer.parseInt(sus[i]);
			sumPrice +=res[i];
			
			System.out.print((i+1)+". 상품명 : " +products[i] +"\t");
			System.out.print(" 가격 : " + prices[i]+"\t");
			System.out.print(" 개수 : " + sus[i] +"\t" ) ;
			System.out.print(" 총액 : " + res[i]+"\n");
		}
		System.out.println("총 금액 : " + sumPrice);
		
		PrintWriter out =response.getWriter();
		
		out.print("<script>");
		out.print("alert('작업완료!')");
		out.print("location.href='"+request.getContextPath()+"/study/0420/test7.jsp';");
		out.print("<script>");
	}
	
}
