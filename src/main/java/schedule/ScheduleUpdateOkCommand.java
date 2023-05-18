package schedule;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScheduleUpdateOkCommand implements ScheduleInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null?0:Integer.parseInt(request.getParameter("idx"));
		String ymd = request.getParameter("ymd")==null?"":request.getParameter("ymd");
		String part = request.getParameter("part")==null?"":request.getParameter("part");
		String content = request.getParameter("content")==null?"":request.getParameter("content");
		
		ScheduleDAO dao = new ScheduleDAO();
		ScheduleVO vo =  new ScheduleVO();
		
		vo.setContent(content);
		vo.setIdx(idx);
		vo.setPart(part);
		vo.setsDate(ymd);
		
		String res = dao.setUpdateSchedule(vo);
		
		resonse.getWriter().write(res);
	}

}
