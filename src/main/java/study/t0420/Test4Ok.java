package study.t0420;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")

@WebServlet("/t0420/Test4Ok")
public class Test4Ok extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name= request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String hostIp = request.getParameter("hostIp");
		//자료 받아오는 단
		String str = "";
			for(String hobby : hobbys){
				str += hobby+"/";
			}
			str = str.substring(0, str.length()-1);
		

		System.out.println("성명 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("성별 : " + gender);
		System.out.println("취미 : " + str);
		System.out.println("접속자IP : " + hostIp);
		//setAttribute를 통해 기본 객체의 속성 설정 >  값을 넘겨주기 위해서는 해줘야함.
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("gender", gender);
		request.setAttribute("str", str);
		request.setAttribute("hostIp", hostIp);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/0420/test4Res.jsp"); //직렬화 : 넘어온 값을 가지고 다음으로 이동
		dispatcher.forward(request, response);
		
	}
}
