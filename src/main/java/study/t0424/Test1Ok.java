package study.t0424;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/t0424/test1Ok")
public class Test1Ok extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리를 필트에서 처리하게 되면 아래 2 줄은 생략이 가능해진다.
		
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; cherset=utf-8");
		
		String name = request.getParameter("name")==null? "" :request.getParameter("name");  
		int age = request.getParameter("age")==null? 0 : Integer.parseInt(request.getParameter("age"));  
		String gender = request.getParameter("gender")==null? "성별을 선택하지 않았습니다." : request.getParameter("gender");  
		String job = request.getParameter("job")==null? "" :request.getParameter("job");  
		String address = request.getParameter("address")==null? "" :request.getParameter("address");  
		System.out.println(gender);
		System.out.println(address);
		System.out.println(job);
		//DB에 삽입처리 하려면 입력받은 변수의 값은 vo에 담아서 처리한다.
		Test1VO vo = new Test1VO();
		
		vo.setName(name);
		vo.setAge(age);
		vo.setGender(gender);
		vo.setJob(job);
		vo.setAddress(address);
		
		//vo에 담긴자료를 DB에 저장하는 작업처리가 일어난다,
		
		//처리된 자료를 view에 보여주기우해서는 저장소(request)에 담아서 넘겨준다,
		request.setAttribute("vo", vo);
		
		String viewPage = "/study/0424/test1Res.jsp";
//		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
//		dispatcher.forward(request, response);
		request.getRequestDispatcher(viewPage).forward(request, response);
	}
}
