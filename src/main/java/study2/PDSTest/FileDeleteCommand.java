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
			 res="1";
			 System.out.println(res);
			 file.delete();
		 }
		 
		 response.getWriter().write(res);
	}

}
