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
		//�õ���̨������
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		UserDao userDao=new UserDao();
		ProductDao productDao=new ProductDao();
		try {
			//�ж��Ƿ��½�ɹ�
			if(userDao.login(username, password)){
				//����ɹ�����listҳ�淢����Ʒ������
				ArrayList<Product> productslist=productDao.queryProduct();
				req.getSession().setAttribute("products", productslist);
				req.getSession().setAttribute("uname", username);
				req.getRequestDispatcher("list.jsp").forward(req, resp);
			}else{
				//���ʧ�ܷ��ص�½ҳ�棬����ʾ������Ϣ
				String message="��½�û���������������µ�½��";
				req.setAttribute("message", message);
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
