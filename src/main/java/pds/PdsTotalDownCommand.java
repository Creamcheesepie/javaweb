package pds;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PdsTotalDownCommand implements PdsInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null?0:Integer.parseInt(request.getParameter("idx"));
		
		PdsDAO dao = new PdsDAO();
		
		PDSVO vo = dao.getIdxSearch(idx);
		
		String[] fSNames = vo.getfSName().split("/");
		String[] fNames =  vo.getfName().split("/");
		
		//파일 압축에 필요한 객체를 선언 / 준비 
		FileInputStream fis = null;
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		ServletOutputStream sos = null;
		
		String zipPath = request.getServletContext().getRealPath("/images/pds/temp/");
		String realPath = request.getServletContext().getRealPath("/images/pds/");
		String zipName = vo.getTitle()+".zip";
		
		fos = new FileOutputStream(zipPath+zipName);
		zos = new ZipOutputStream(fos);
		 
		 
		byte[] b = new byte[2048];
		int data = 0;
		
		for(int i = 0 ; i<fNames.length;i++) {
			File file = new File(realPath+fSNames[i]);
			
			 fis = new FileInputStream(file);
			
			 zos.putNextEntry(new ZipEntry(fNames[i]));
			 
			while((data=fis.read(b,0,b.length)) != -1) {
				zos.write(b,0,data);
			}
			zos.flush();
			zos.closeEntry();
			fis.close();
		}
		zos.close();
		
		
		//서버에서 압축작업이 완료되면, 압축파일을 클라이언트로 전송하고, 서버에 존재하는 압축파일을 삭제한다.
		/* 프로토콜 형식에 맞게 헤더에 정보를 제공해준다. */
		String mimeType = request.getServletContext().getMimeType(zipName.toString());
		if(mimeType==null) { //헤더에 정보가 없으면 무조건 바이너리 형식으로 파일 바꾸기
			resonse.setContentType("application/octet-stream"); //2진 바이너리 형식 변경
		}
		
		
		String downLoadName = "";
		//사용하는 브라우저에 대한 정보 : 만약 인터넷 익스플로러(특히나 구버전인 경우)에서 인코딩 방식은 'EUC-KR'으로 전송해주어야 한다. 나머지는 utf-8로 전송처리한다.
		if(request.getHeader("user-agent").indexOf("MSIE") == -1) {
			downLoadName 	= new String(zipName.getBytes("UTF-8"),"8859_1");
		}
		else {
			downLoadName 	= new String(zipName.getBytes("EUC-KR"),"8859_1");
		}
		
		//헤더 정보를 첨부하여 클라이언트에 전송할 준비를 한다.
		resonse.setHeader("content-Disposition", "attachment;filename="+downLoadName);
		
		// Java를 통하여 실제로 파일을 다운(업)로드 시켜준다. (인터넷을 통해서는 스트리밍 방식 : FileInputStream/FileOutputStream/ServletOutputStream)
		fis = new FileInputStream(zipPath+zipName);
		sos = resonse.getOutputStream();
		
		//전송할 객체를 생성한 후에는 실제로 파일을 객체에 Byte 단위로 담아서 처리시켜준다.
		b = new byte[2048];
		data = 0;
		
		while((data=fis.read(b,0,b.length)) != -1) {
			sos.write(b,0,data);
		}
		sos.flush();
		//여기까지 오면 다운로드가 완료된 것이다. 이후 사용된 객체를 모두 반납한다.		
		
		sos.close();
		fis.close();
		//여기까지가 클라이언트로 전송이 완료되는 구간이다.
		
		//서버에 존재하는 temp 폴더 내의 zip 파일을 삭제처리한다.
		new File(zipPath+zipName).delete();
		
		//다운로드 횟수 증가
		dao.setPdsDownNumCheck(idx);
		
		
		
	}

}
