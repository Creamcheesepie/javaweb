package study2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ant.jmx.JMXAccessorQueryTask;

import study2.ajax2.UserDAO;
import study2.ajax2.UserVO;

public class UserUpdateCommand implements StudyInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null?0:Integer.parseInt(request.getParameter("idx")); 
		String mid = request.getParameter("mid")==null?"":request.getParameter("mid");
		String name = request.getParameter("name")==null?"":request.getParameter("name");
		int age = request.getParameter("age")==null?0:Integer.parseInt(request.getParameter("age")); 
		String address = request.getParameter("address")==null?"":request.getParameter("address");
		
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		String str ="";
		
		vo = dao.getIdxMid(idx,mid);
		if(vo.getMid()!=null) {
			dao.setUserUpdate(idx, mid,name,age,address);
			str = "수정완료하였습니다.";
		}
		else {
			vo = dao.getMidUpdateSearch(mid);
			if(vo.getMid()==null) {
				dao.setUserUpdate(idx,mid,name,age,address);
				str = "수정완료하였습니다.";
			}
			else {
				str = "중복된 아이디가 있어 수정할 수 없습니다.";
			}
		}
		
		response.getWriter().write(str);

	}

}
