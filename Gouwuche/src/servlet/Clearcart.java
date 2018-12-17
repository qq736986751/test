package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
@WebServlet(value="/clearcart.do")
public class Clearcart extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("123");
		CartDao cartDao=new CartDao();
		try {
			cartDao.clearAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
