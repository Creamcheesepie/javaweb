package study2.PDSTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import study2.StudyInterface;

public class FileUpLoad2OkCommand1 implements StudyInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String realPath = request.getServletContext().getRealPath("/images/PDSTest");
		//System.out.println("realpath" + realPath);
		int maxSize = 1024*1024*15; //  서버에 저장할 최대용량을 15MBtye로 제한한다.
		String encoding = "UTF-8";
		
		//파일 처리....(객체가 생성되면서 파일이 자동으로 업로드 처리~)
		MultipartRequest multiPartRequest = new MultipartRequest(request,realPath,maxSize,encoding,new DefaultFileRenamePolicy());
		
		String originalFileName = "";
		//업로드된 파일의 추출해보자~
		for(int i = 1 ; i<=3; i ++) {
			 originalFileName = multiPartRequest.getOriginalFileName("fname"+i);
			String originalFilesystemName =  multiPartRequest.getFilesystemName("fname"+i);
			
			System.out.println("원본 파일명 : " + originalFileName);
			System.out.println("서버에 저장경로 : " + realPath);
			System.out.println("서버에 저장된 파일명 : " + originalFilesystemName);
		}
		
		
		if(!originalFileName.equals("")) {
		request.setAttribute("msg", "파일이 업로드 됨");
		}
		else {
			request.setAttribute("msg", "파일이 업로드 안됨");
			
		}
		request.setAttribute("url", request.getContextPath()+"/FileUpLoad2.st");

	}

	

}
