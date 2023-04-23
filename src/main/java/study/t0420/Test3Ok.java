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
//@WebServlet("/Test3Ok")
@WebServlet("/t0420/Test3Ok")
public class Test3Ok extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //서버에서 문자 인코딩 utf-8로 해달라고 요청.
		response.setContentType("text/html; charset=utf-8"); // 브라우저에 응답할때, text는 html로, 문자셋은 utf-8로 응답.
		
		PrintWriter out = response.getWriter();
		
		//서버에 들어있는 데이터 요청
		String name= request.getParameter("name"); 
		int age = Integer.parseInt(request.getParameter("age")); 
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String str = "";
			for(String hobby : hobbys){
				str += hobby+"/";
			}
			str = str.substring(0, str.length()-1);
		

		System.out.println("성명 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("성별 : " + gender);
		System.out.println("취미 : " + str);
		
//		out.print("<script>");
//		out.print("alert('자료가 저장되었습니다.')");
//		out.print("</script>");
//		out.print("<script>");
////		out.print("<location.href='"+request.getContextPath()+"/study/0420/test3.jsp'>");
//		out.print("location.href='"+request.getContextPath()+"/study/0420/test3.jsp'");
//		out.print("</script>");
		
//		DB에 저장 후 view로 이동하기~
		response.sendRedirect(request.getContextPath()+"/study/0420/test3Res.jsp?name="+name); // location.href와 같은명령어
//		dispatcher 객체 사용
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/0420/test3Res.jsp"); //직렬화 : 넘어온 값을 가지고 다음으로 이동
//		dispatcher.forward(request, response);
//		
	}
}
