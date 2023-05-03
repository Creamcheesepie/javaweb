package study2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PassOkCommand implements StudyInterface {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 오늘의 과제!
		 DB에 무작위로 숫자를 저장한다 >>이 것을 키값으로 지정하고 데이터베이스에 저장
		 그리고 DB에 암호화된 값을 저장하고
		 이 둘을 다시 복호화하여 로그인 처리하자.
		*/
		
		String mid = request.getParameter("mid")==null?"":request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null?"":request.getParameter("pwd").toUpperCase();
		int idx = request.getParameter("idx")==null?0:Integer.parseInt(request.getParameter("idx"));
		
		System.out.println("원본자료");
		System.out.println("mid : "+mid);
		System.out.println("pwd : "+pwd);
		System.out.println("idx : "+idx);
		System.err.println("dd?");
		if(idx==1) {
			//숫자만 암호화 하는 경우
			//암호화를 위한 키 설정(0x1234ABCD)
			int key = 0x1234ABCD;
			
			int encPwd, decPwd;
			
			//암호화...(EOR)방식
			encPwd= Integer.parseInt(pwd)^key;
			
			System.out.println("암호화된 자료");
			System.out.println("encPwd : "+encPwd);
			System.out.println("~~~DB에 암호화된 비밀번호 저장~~~");
			System.out.println("암호화된 비밀번호를 DB에 저장한 후 인증을 위해 다시 불러와서 디코딩한다.");
			
			decPwd = encPwd ^ key;
			
			System.out.println("복호화된 자료");
			System.out.println("decPwd : "+decPwd);
		
			
		}
		else if(idx == 2) {
			//숫자/분자 혼합 암호화...영문 소문자 입력시에는 대문자로 변경해서 처리
			System.out.println("1.원본비밀번호 : " + pwd);
			long intPwd;
			String strPwd ="";
			for(int i=0; i<pwd.length(); i++) {
				intPwd = pwd.charAt(i);
				strPwd += intPwd;
			}
			System.out.println("2.아스키코드로 변환된 비밀번호 : " + strPwd);
			 intPwd = Long.parseLong(strPwd);
			
			 long encPwd;
			 long key = 0X1234ABCD;
			 
			 encPwd = intPwd ^ key;
			 
			 //데이터 베이스 저장
			 strPwd = String.valueOf(encPwd);
			 System.out.println("3.인코딩된 비밀번호 DB에 저장시킬 비밀번호가 된다. : "+encPwd );
			 System.out.println("~~DB저장~~");
			 //DB에 저장된 암호를 불러와서 복호화
			 long decPwd;
			 intPwd = Long.parseLong(strPwd);
			 decPwd = intPwd ^ key;
			 System.out.println("4.복호화된 비밀번호 : " + decPwd);
			 
			 //복원된 아스키코드 비밀번호를 문자로 변환하여 2자리씩 분리처리한다.
			 strPwd = String.valueOf(decPwd);
			 
			 char ch;
			 String result ="";
			 for(int i=0; i<strPwd.length();i+=2) {
				 ch = (char)Integer.parseInt(strPwd.substring(i,i+2));
				 result+=ch;
			 }
			 System.out.println("5.최종적으로 아스키코드에서 문자로 복원한 비밀번호 : " + result);
			 
		}
	}
}
