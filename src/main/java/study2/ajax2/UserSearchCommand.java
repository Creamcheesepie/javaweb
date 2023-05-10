package study2.ajax2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study2.StudyInterface;

public class UserSearchCommand implements StudyInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null?0:Integer.parseInt(request.getParameter("idx"));
		
		UserDAO dao = new UserDAO();
		UserVO vo = dao.getUserSearch(idx);
		
		
		String str="";
		if(vo.getName()==null) {
			System.out.println(">><<");
			str="찾으시는분이 없구먼유...";
		}
		else {
			System.out.println("결과 유");
			str= vo.getMid()+"/"+ vo.getName()+"/"+ vo.getAge()+"/"+vo.getAddress()+"/"+idx;
		}
		
		response.getWriter().write(str);
		
		
		/*
		 * HashMap<String,String> map = new HashMap<>(); map.put("mid", vo.getMid());
		 * map.put("name", vo.getName()); map.put("age", vo.getAge()+"");
		 * map.put("address", vo.getAddress());
		 * 
		 * JSONObject userObj = new JSONObject(map);
		 * 
		 * String str = userObj.toString();
		 * 
		 * response.getWriter().write(str);
		 */
	}

}
