package servlet.ajaxmorning;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/checkname.do")
public class Ajaxdemo1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uname = req.getParameter("username");
		PrintWriter pw = resp.getWriter();
		if(uname.equals("zhangsan")){
			pw.write("用户名已存在!");
		}
	}
}
