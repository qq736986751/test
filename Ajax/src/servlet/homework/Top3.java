package servlet.homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
@WebServlet(value="/top.do")
public class Top3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8"); 
		req.setCharacterEncoding("UTF-8");
		SalesDao salesDao=new SalesDao();
		PrintWriter pw = resp.getWriter();
		try {
			ArrayList<Sales> lists=salesDao.querysales();
			Object oempist=JSON.toJSON(lists);
			pw.write(oempist.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
