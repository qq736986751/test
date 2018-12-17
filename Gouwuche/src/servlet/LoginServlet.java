package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.UserDao;
import entity.Product;
@WebServlet(value="/login.do")
public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//拿到后台的数据
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		UserDao userDao=new UserDao();
		ProductDao productDao=new ProductDao();
		try {
			//判断是否登陆成功
			if(userDao.login(username, password)){
				//如果成功，往list页面发送商品的数据
				ArrayList<Product> productslist=productDao.queryProduct();
				req.getSession().setAttribute("products", productslist);
				req.getSession().setAttribute("uname", username);
				req.getRequestDispatcher("list.jsp").forward(req, resp);
			}else{
				//如果失败返回登陆页面，并显示错误信息
				String message="登陆用户或密码错误，请重新登陆！";
				req.setAttribute("message", message);
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
