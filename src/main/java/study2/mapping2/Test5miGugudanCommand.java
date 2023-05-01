package study2.mapping2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test5miGugudanCommand implements Test5miInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dan = request.getParameter("dan")==null? 0 : Integer.parseInt(request.getParameter("dan"))  ;
		int temp;
		String danOut = "";
		for(int i=1; i<10;i++) {
			temp= i*dan;
			danOut += i +"*"+ dan +"="+ temp+"<br/>";
		}
		
		request.setAttribute("danOut", danOut);

	}

}
