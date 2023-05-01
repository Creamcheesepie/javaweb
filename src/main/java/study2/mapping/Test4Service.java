int su1 = request.getParameter("su1") ==null ? 0: Integer.parseInt(request.getParameter("su1"));
		int su2 = request.getParameter("su2") ==null ? 0: Integer.parseInt(request.getParameter("su2"));package study2.mapping;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;

public class Test4Service {
	int su1,su2;
	
	public Test4Service(int su1,int su2) {
		this.su1 = su1;
		this.su2 = su2;
	}
	
	public int test4calc() {
		int res = su1+su2;
		return res;
	}
	
	
}
