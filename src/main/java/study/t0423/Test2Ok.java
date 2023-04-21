package study.t0423;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/t0423/Test2Ok")
public class Test2Ok extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name") == null? "" : request.getParameter("name"); 
		String hakbun = request.getParameter("hakbun") == null? "" : request.getParameter("hakbun"); 
		int kor = request.getParameter("kor") == null? 0 :  Integer.parseInt(request.getParameter("kor")); 
		int eng = request.getParameter("eng") == null? 0 :  Integer.parseInt(request.getParameter("eng")); 
		int mat = request.getParameter("mat") == null? 0 :  Integer.parseInt(request.getParameter("mat")); 
		int soc = request.getParameter("soc") == null? 0 :  Integer.parseInt(request.getParameter("soc")); 
		int sci = request.getParameter("sci") == null? 0 :  Integer.parseInt(request.getParameter("sci")); 
		int sum = kor+eng+mat+soc+sci;
		double avg = sum/5.0;
		char grade =' ';
		
		switch ((int)(avg/10)) {
			case 10:
			case 9:
				grade='A';
				
				break;
			case 8:
				grade='B';
				
				break;
			case 7:
				grade='C';
				
				break;
			case 6:
				grade='D';
				
				break;
			default:
				grade='F';
				
				break;
		}
		//객체를 통한 값 전달 VO활용 
		test2VO vo = new test2VO(name, hakbun, kor, eng, mat, soc, sci, sum, avg, grade);
		
		request.setAttribute("vo", vo);
		String viewPage="/study/0423/test2Res.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		
		dispatcher.forward(request, response);
	}
}
