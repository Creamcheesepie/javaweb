package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminOneClickChangeCommand implements Admin {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String stridx = request.getParameter("stridx");
		int level =  Integer.parseInt(request.getParameter("level"));
		AdminDAO dao = new AdminDAO();
		
		
		String[] arridx = stridx.split("/");
		
		for(int i=0; i<arridx.length;i++) {
			dao.setMemberLevelOnIdx(level, arridx[i]);
		}
		
	}

}
