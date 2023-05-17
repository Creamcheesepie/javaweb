package pds;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import conn.SecurityUtil;

public class PdsInputOkCommand implements PdsInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String realPath = request.getServletContext().getRealPath("/images/pds/");
		int maxSize = 1024*1024*15; //  서버에 저장할 최대용량을 15MBtye로 제한한다.
		String encoding = "UTF-8";
		
		//파일 처리....(객체가 생성되면서 파일이 자동으로 업로드 처리~)
		MultipartRequest multiPartRequest = new MultipartRequest(request,realPath,maxSize,encoding,new DefaultFileRenamePolicy());
		
		//업로드된 파일의 추출해보자~
		Enumeration fileNames = multiPartRequest.getFileNames();
		String originalFileName = "";
		String originalFilesystemName = "";
		String file = "";

		while(fileNames.hasMoreElements()) {
			file = (String) fileNames.nextElement();
			
			if(multiPartRequest.getFilesystemName(file) != null) {
				originalFileName += multiPartRequest.getOriginalFileName(file)+"/";
				originalFilesystemName += multiPartRequest.getFilesystemName(file)+"/";
			}
			
			System.out.println("원본 파일명 : " + originalFileName);
			System.out.println("서버에 저장된 파일명 : " + originalFilesystemName);
		}
		originalFileName = originalFileName.substring(0,originalFileName.length()-1);
		originalFilesystemName = originalFilesystemName.substring(0,originalFilesystemName.length()-1);
		
		HttpSession session = request.getSession();
		
		String mid = (String) session.getAttribute("sMid");
		String nickName = (String) session.getAttribute("sNickName");
		
		//전송된 폼의 값들을 전부 받아준다.
		int fSize = multiPartRequest.getParameter("fileSize")==null?0:Integer.parseInt(multiPartRequest.getParameter("fileSize"));
		String title = multiPartRequest.getParameter("title")==null?"":multiPartRequest.getParameter("title");
		String part = multiPartRequest.getParameter("part")==null?"":multiPartRequest.getParameter("part");
		String pwd = multiPartRequest.getParameter("pwd")==null?"":multiPartRequest.getParameter("pwd");
		String openSw = multiPartRequest.getParameter("openSw")==null?"":multiPartRequest.getParameter("openSs");
		String content = multiPartRequest.getParameter("content")==null?"":multiPartRequest.getParameter("content");
		String hostIp = multiPartRequest.getParameter("hostIp")==null?"":multiPartRequest.getParameter("hostIp");
				
		//비밀번호 암호화(sha-256)
		SecurityUtil security = new SecurityUtil();
		pwd = security.encryptSHA256(pwd);
		
		//앞에서 전송받은 자료와 가공된 자료들을 전부 vo에 담아서 DB에 저장할 수 있게 한다.
		PDSVO vo = new PDSVO();
		
		vo.setMid(mid);
		vo.setNickName(nickName);
		vo.setfName(originalFileName);
		vo.setfSName(originalFilesystemName);
		vo.setfSize(fSize);
		vo.setTitle(title);
		vo.setPart(part);
		vo.setPwd(pwd);
		vo.setOpenSw(openSw);
		vo.setContent(content);
		vo.setHostIp(hostIp);
		
		PdsDAO dao = new PdsDAO();
		
		int res = dao.setPdsInputOk(vo);
		
		int nowPage = request.getParameter("nowPage")==null?0: Integer.parseInt(request.getParameter("nowPage"));
		int pageSize = request.getParameter("pageSize")==null?0: Integer.parseInt(request.getParameter("pageSize"));
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageSize", pageSize);
		
		if(res==1) {
		request.setAttribute("msg", "자료실에 자료를 등록하였습니다~");
		request.setAttribute("url", request.getContextPath()+"/PdsList.pds");
		}
		else {
			request.setAttribute("msg", "자료실에 자료가 저장되지 않았습니다.");
			request.setAttribute("url", request.getContextPath()+"/PdsInput.pds");
			
		}
	}

}
