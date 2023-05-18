package study2.Api;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study2.StudyInterface;

public class SerchCrimeByPoliceOrderCommand implements StudyInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int year = request.getParameter("year")==null?0:Integer.parseInt(request.getParameter("year"));
		String order = request.getParameter("order")==null?"":request.getParameter("order");
		CrimeDAO dao =new CrimeDAO();
		
		
		ArrayList<CrimeVO> vos = dao.getYearCrimeDataOrderByPolice(year,order);
		
		String res= "";
		if(vos.isEmpty()) {
			res="해당 년도의 데이터 정보가 존재하지 않습니다.";
		}
		else {
			res="해당 년도의 데이터가 존재합니다.";
		}
		
		request.setAttribute("res", res);
		request.setAttribute("whichOrder", order);
		request.setAttribute("whichYear", year);
		request.setAttribute("vos", vos);
		request.setAttribute("vosSize", vos.size());
		
	

	}

}
