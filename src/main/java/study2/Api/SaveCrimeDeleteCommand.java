package study2.Api;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study2.StudyInterface;

public class SaveCrimeDeleteCommand implements StudyInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int year = request.getParameter("year")==null?0:Integer.parseInt(request.getParameter("year"));
		CrimeDAO dao = new CrimeDAO();
		
		CrimeVO vo = new CrimeVO();
		
	
		
		String res = dao.setCrimeDeleteOk(year);
		
		response.getWriter().write(res);;
	}

}
