package study2.PDSTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import study2.StudyInterface;

public class FileUpLoad1OkCommand implements StudyInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String fName = request.getParameter("fName")==null?"":request.getParameter("fName");
		//System.out.println(fName + "(파일명)");
		/*
		 	COS 라이브러리에서 제공해주는 객체 : MultipartRequest() / DefaultFileRenamePolicy()
		 	사용법 : MultipartRequest(저장소명(request),"서버에 저장될 파일의 경로","서버에 저장될 파일의 최대용량","코드변환방식","기타옵션(파일명 중복방지 처리)")
		 	
		 	ServletContext application = request.getServletContext(); //서블릿 컨텍스트 객체 생성
			String realPath = request.getServletContext().getRealPath("/");  //실제 경로 생성
		  
		 */
		
		String realPath = request.getServletContext().getRealPath("/images/PDSTest");
		//System.out.println("realpath" + realPath);
		int maxSize = 1024*1024*15; //  서버에 저장할 최대용량을 15MBtye로 제한한다.
		String encoding = "UTF-8";
		
		//파일 처리....(객체가 생성되면서 파일이 자동으로 업로드 처리~)
		MultipartRequest multiPartRequest = new MultipartRequest(request,realPath,maxSize,encoding,new DefaultFileRenamePolicy());
		
		
		//업로드된 파일의 추출해보자~
		String originalFileName = multiPartRequest.getOriginalFileName("fname");
		String originalFilesystemName =  multiPartRequest.getFilesystemName("fname");
		
		
		System.out.println("원본 파일명 : " + originalFileName);
		System.out.println("서버에 저장경로 : " + realPath);
		System.out.println("서버에 저장된 파일명 : " + originalFilesystemName);
		
		if(!originalFileName.equals("")) {
		request.setAttribute("msg", "파일이 업로드 됨");
		}
		else {
			request.setAttribute("msg", "파일이 업로드 안됨");
			
		}
		request.setAttribute("url", request.getContextPath()+"/FileUpLoad1.st");

	}

}
