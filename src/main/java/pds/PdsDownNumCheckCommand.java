package pds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PdsDownNumCheckCommand implements PdsInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		PdsDAO dao = new PdsDAO();
		
		int idx= request.getParameter("idx")==null?0:Integer.parseInt(request.getParameter("idx"));
		
		dao.setPdsDownNumCheck(idx);

	}

}
