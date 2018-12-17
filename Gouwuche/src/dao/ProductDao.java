package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import servlet.ConnectionUtils;
import entity.Product;

public class ProductDao {
	public ArrayList<Product> queryProduct() throws SQLException {
		ArrayList<Product> productList = new ArrayList<Product>();
		String sql = "select * from t_product";
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setDescription(rs.getString(3));
			p.setPrice(rs.getDouble(4));
			p.setPic(rs.getString(5));
			productList.add(p);
		}
		ConnectionUtils.CloseResource(conn, psmt, rs);
		return productList;
	}
	
	public ArrayList<Product> queryProductbypid(int pid) throws SQLException {
		ArrayList<Product> productList = new ArrayList<Product>();
		String sql = "select * from t_product where id=?";
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, pid);
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setDescription(rs.getString(3));
			p.setPrice(rs.getDouble(4));
			p.setPic(rs.getString(5));
			productList.add(p);
		}
		ConnectionUtils.CloseResource(conn, psmt, rs);
		return productList;
	}
}
