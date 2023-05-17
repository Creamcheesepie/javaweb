package study2.calendar;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study2.StudyInterface;

public class Calendar2Command implements StudyInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//오늘 날짜 처리
		Calendar calToday = Calendar.getInstance();
		int toYear = calToday.get(Calendar.YEAR);
		int toMonth = calToday.get(Calendar.MONTH);
		int toDay = calToday.get(Calendar.DATE);
		
		//화면에 보여줄 해당 '년/월'세팅
		Calendar calView = Calendar.getInstance();
		int yy = request.getParameter("yy")==null?calView.get(Calendar.YEAR): Integer.parseInt(request.getParameter("yy"));
		int mm = request.getParameter("mm")==null?calView.get(Calendar.MONTH): Integer.parseInt(request.getParameter("mm"));
		
		if(mm<0) {
			yy--;
			mm = 11;
		}
		if(mm>11) {
			yy++;
			mm=0;
		}
		
		//해당 '년/월'의 1일을 기준으로 날짜를 세팅한다.
		calView.set(yy,mm,1);
		
		//앞에서 세팅한 당 (년/월)의 1일에 해당하는 요일값을 숫자로 기억하낟.
		int startWeek = calView.get(Calendar.DAY_OF_WEEK);
		
		//해당 년/월의 마지막 일자를 가져온다
		int lastDay = calView.getActualMaximum(Calendar.DAY_OF_MONTH);

		//출력된 달력의 '앞쪽/뒤쪽'의 빈공간에 해당월의 '이전/다음'의 날짤를 채워보자.
		int preYear = yy;
		int preMonth = (mm)-1;
		int nextYear = yy;
		int nextMonth = (mm)+1;
		
		if(preMonth<0) {
			preMonth=11;
			preYear--;
		}
		if(nextMonth>11) {
			nextMonth=0;
			nextYear++;
		}
		//현재월의 이전에 해달하는 달의 마지막 날짜를 구한다
		Calendar calPre = Calendar.getInstance();
		calPre.set(preYear,preMonth,1 );
		int preLastDay = calPre.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		//현재월의 다음에 해달하는 달의 1일에 해당하는 요일를 구한다
		Calendar calNext = Calendar.getInstance();
		calNext.set(nextYear,nextMonth,1 );
		int nextStartWeek = calNext.get(Calendar.DAY_OF_WEEK);
		
		//값을 다시 저장소에 저장하여 넘겨주시기
		request.setAttribute("preYear", preYear);
		request.setAttribute("preMonth", preMonth);
		request.setAttribute("nextYear", nextYear);
		request.setAttribute("nextMonth", nextMonth);
		request.setAttribute("preLastDay", preLastDay);
		request.setAttribute("nextStartWeek", nextStartWeek);
		
		
		
		
		
		
		// 화면에 보여줄 달력의 해당 내역(년/월/요일 숫자...)를 저장소에 저장하여 넘겨준다.
		
		request.setAttribute("yy", yy);
		request.setAttribute("mm", mm);
		request.setAttribute("startWeek", startWeek);
		request.setAttribute("lastDay", lastDay);
		
		//오늘 날짜를 저장소에
		request.setAttribute("toYear", toYear);
		request.setAttribute("toMonth", toMonth);
		request.setAttribute("toDay", toDay);
	}
}
