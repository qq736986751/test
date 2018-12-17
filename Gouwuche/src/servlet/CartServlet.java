package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.ProductDao;
import entity.Cart;
import entity.Product;
/**
 * 
 * @author 刘江徽
 *	点击添加到购物车按钮可以往数据库添加购物车数据
 */
@WebServlet(value="/cart.do")
public class CartServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ProductDao productDao=new ProductDao();
		CartDao cartDao=new CartDao();
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int pid=Integer.parseInt(req.getParameter("cid"));
		ArrayList<Product> products;
		try {
			products = productDao.queryProductbypid(pid);
			Cart cart=new Cart(products.get(0).getId(), products.get(0).getName(), products.get(0).getPrice());
			cartDao.addProduct(cart);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
