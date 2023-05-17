package pds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PdsInputCommand implements PdsInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String part = request.getParameter("part")==null?"":request.getParameter("part");
		
		int nowPage = request.getParameter("nowPage")==null?0: Integer.parseInt(request.getParameter("nowPage"));
		int pageSize = request.getParameter("pageSize")==null?0: Integer.parseInt(request.getParameter("pageSize"));
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageSize", pageSize);
		
		request.setAttribute("part", part);

	}

}
