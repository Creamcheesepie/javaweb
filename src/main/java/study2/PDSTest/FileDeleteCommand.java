package study2.PDSTest;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import study2.StudyInterface;

public class FileDeleteCommand implements StudyInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = request.getParameter("file")==null?"":request.getParameter("file");
		
		String realPath = request.getServletContext().getRealPath("/images/PDSTest/");
		
		 File file = new File(realPath + fName);

		 String res = "0";
		 
		 if(file.exists()) {
			 System.out.println(res);
			 file.delete();
			 res="1";
		 }
		 
		 response.getWriter().write(res);
	}
	//주의점 : 소스코드와 데이터베이스까지 백업 했던 것에서 이젠 데이터 파일까지 백업해둘것!
	// 프로젝트 완료 후에는 소스코드 파일과, 데이터베이스 파일, 이미지 데이터 파일 3개를 제출한다.

}
