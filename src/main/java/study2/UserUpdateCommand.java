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
		
		int res = 0;
		vo = dao.getIdxMid(idx,mid);
		
		boolean idxNullSw =false;
		if(idx!=0) { //idx값이 없을 때 개별조회를 유도하기위한 sw
			idxNullSw = true;
		}
		
		
		if(vo.getMid()!=null && idxNullSw) { //idx와 mid가 동일할 때 다른 정보 수정 가능
			res = dao.setUserUpdate(idx,mid,name,age,address);
			if(res==1) {
				str = "수정완료하였습니다.";
			}
		}
		else if(res==0 && idxNullSw){ //idx와 mid가 매치되지 않을때, mid가 중복되지 않으면 정보 수정 가능
			vo = dao.getMidUpdateSearch(mid);
			if(vo.getMid()==null) {
				res = dao.setUserUpdate(idx,mid,name,age,address);
				if(res==1) {
					str = "수정완료하였습니다.";					
				}
				else {
					str = "오류가 발생하여 수정하지 못하였습니다.";
				}
			}
			else {
				str = "중복된 아이디가 있어 수정할 수 없습니다.";
			}
		}
		else str="개별조회를 눌러 유저 정보를 불러와야 수정이 가능합니다.";
			
		
		response.getWriter().write(str);

	}

}
