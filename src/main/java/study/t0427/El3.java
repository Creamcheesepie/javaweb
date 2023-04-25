package study.t0427;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/t0427/El3")
public class El3 extends  HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		El3VO vo = new El3VO();
		
		ArrayList<El3VO> vos = new ArrayList<>();
		
		vos = new ArrayList<>();
		
		vo.setName("홍길동");
		vo.setAge(25);
		vo.setGender("남자");
		vo.setJob("학생");
		vo.setAddress("");
		
		vo.setName("감말숙");
		vo.setAge(22);
		vo.setGender("여자");
		vo.setJob("회사원");
		vo.setAddress("");
		
		vo.setName("이기자");
		vo.setAge(38);
		vo.setGender("남자");
		vo.setJob("군인");
		vo.setAddress("");
		
		System.out.println("vos의 자료들");
		for(int i=0; i<vos.size();i++) {
			System.out.println("vos["+i+"]:" + vos.get(i).getName()+"/");
			System.out.println("vos["+i+"]:" + vos.get(i).getAge()+"/");
			System.out.println("vos["+i+"]:" + vos.get(i).getGender()+"/");
			System.out.println("vos["+i+"]:" + vos.get(i).getJob()+"/");
			System.out.println("vos["+i+"]:" + vos.get(i).getAddress()+"/");
		}
		
		request.setAttribute("vos", vos);
		String viewPage = "/stage/0427/el3Res.jsp";
		
		
	}
}
