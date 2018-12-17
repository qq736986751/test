package ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

@WebServlet(value="/testjson.do")
public class TestJson extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ArrayList<User> list = new ArrayList<User>();
		Collections.addAll(list, new User(1001,"zhangsan","123456"),
				new User(1002,"lisi","123456"),
				new User(1003,"wangwu","123456"));
		//½øÐÐ×ªÂë
		Object obj = JSON.toJSON(list);
		resp.getWriter().write(obj.toString());
	}
}
