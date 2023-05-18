package study2.Api;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study2.StudyInterface;

public class SearchCrimeDataCommand implements StudyInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int year = request.getParameter("year")==null?0:Integer.parseInt(request.getParameter("year"));
		
		CrimeDAO dao =new CrimeDAO();
		CrimeVO vo = new CrimeVO();
		
		ArrayList<CrimeVO> vos = dao.getYearCrimeDataAll(year);
		
		String res= "";
		if(vos.isEmpty()) {
			res="해당 년도의 데이터 정보가 존재하지 않습니다.";
		}
		else {
			res="해당 년도의 데이터가 존재합니다.";
		}
		
		request.setAttribute("res", res);
		
		request.setAttribute("vos", vos);
		request.setAttribute("vosSize", vos.size());
		
	}

}
