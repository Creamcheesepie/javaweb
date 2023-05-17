package schedule;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScheduleMenuCommand implements ScheduleInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null?"":request.getParameter("mid");
		String ymd = request.getParameter("ymd")==null?"":request.getParameter("ymd");
		
		String[] ymds= ymd.split("-");
		
		if(ymds[1].length()==1) ymds[1]="0"+ymds[1];
		if(ymds[2].length()==1) ymds[2]="0"+ymds[2];
		
		ymd = ymds[0] + "-" + ymds[1] + "-" + ymds[2];
		
		ScheduleDAO dao = new ScheduleDAO();
		
		ArrayList<ScheduleVO> vos = dao.getSchedule(mid, ymd,1);
		
		request.setAttribute("vos", vos);
		request.setAttribute("ymd", ymd);
		request.setAttribute("scheduleCnt", vos.size());
	}
}
