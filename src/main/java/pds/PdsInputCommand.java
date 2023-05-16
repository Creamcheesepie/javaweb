package pds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PdsInputCommand implements PdsInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String part = request.getParameter("part")==null?"":request.getParameter("part");
		
		request.setAttribute("part", part);

	}

}
