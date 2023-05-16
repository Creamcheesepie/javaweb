package pds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PdsListCommand implements PdsInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String part = request.getParameter("part")==null?"전체":request.getParameter("part");
		
		PdsDAO dao = new PdsDAO();
		
//		ArrayList<PDSVO> vos = dao.getPdsList(--,--,--); 추후 페이지 처리를 위함.
		ArrayList<PDSVO> vos = dao.getPdsList(part);
		
		request.setAttribute("vos", vos);
		
		request.setAttribute("part", part);
				

	}

}
