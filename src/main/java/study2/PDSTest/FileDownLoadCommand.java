package study2.PDSTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study2.StudyInterface;

public class FileDownLoadCommand implements StudyInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String realPath = request.getServletContext().getRealPath("/images/PDSTest/"); // 경로를 이어줄 때에는 /를 잘 써야 한다.
		
		String fName = request.getParameter("file")==null?"":request.getParameter("file");
		
		File file = new File(realPath+fName);
		
		/* 프로토콜 형식에 맞게 헤더에 정보를 제공해준다. */
		// mimeType : 파일형식 (ex: 텍스트 파일? 바이너리 파일?...등등) > 파일전송시에는 자바에서는 2진 바이너리 형식으로 전송처리한다.
		String mimeType = request.getServletContext().getMimeType(file.toString());
		if(mimeType==null) { //헤더에 정보가 없으면 무조건 바이너리 형식으로 파일 바꾸기
			response.setContentType("application/octet-stream"); //2진 바이너리 형식 변경
		}
		
		
		String downLoadName = "";
		//사용하는 브라우저에 대한 정보 : 만약 인터넷 익스플로러(특히나 구버전인 경우)에서 인코딩 방식은 'EUC-KR'으로 전송해주어야 한다. 나머지는 utf-8로 전송처리한다.
		if(request.getHeader("user-agent").indexOf("MSIE") == -1) {
			downLoadName 	= new String(fName.getBytes("UTF-8"),"8859_1");
		}
		else {
			downLoadName 	= new String(fName.getBytes("EUC-KR"),"8859_1");
		}
		
		//헤더 정보를 첨부하여 클라이언트에 전송할 준비를 한다.
		response.setHeader("content-Disposition", "attachment;filename="+downLoadName);
		
		// Java를 통하여 실제로 파일을 다운(업)로드 시켜준다. (인터넷을 통해서는 스트리밍 방식 : FileInputStream/FileOutputStream/ServletOutputStream)
		FileInputStream fis = new FileInputStream(file);
		ServletOutputStream sos = response.getOutputStream();
		
		//전송할 객체를 생성한 후에는 실제로 파일을 객체에 Byte 단위로 담아서 처리시켜준다.
		byte[] b = new byte[2048];
		int data = 0;
		
		while((data=fis.read(b,0,b.length)) != -1) {
			sos.write(b,0,data);
		}
		sos.flush();
		//여기까지 오면 다운로드가 완료된 것이다. 이후 사용된 객체를 모두 반납한다.		
		
		sos.close();
		fis.close();
		
	}

}
