package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardInterface {
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException;
}
