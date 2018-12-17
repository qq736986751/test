package servlet.ajaxafternoon;

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


@WebServlet(value="/show.do")
public class Showemp extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/text;charset=utf-8"); 
		req.setCharacterEncoding("UTF-8");
		Empdao empdao=new Empdao();
		PrintWriter pw = resp.getWriter();
		try {
			ArrayList<Emp> emplists=empdao.queryEmp();
//			String sname[]=empdao.getCol();
//			ArrayList allList=new ArrayList();
//			allList.add(sname);
//			allList.add(emplists);
			Object oempist=JSON.toJSON(emplists);
			pw.write(oempist.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
