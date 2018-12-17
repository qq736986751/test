package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import servlet.ConnectionUtils;
import entity.Cart;
import entity.Product;

public class CartDao {
	public boolean addProduct(Cart cart) throws SQLException {
		if(queryCartbyid(cart.getId()).size()==1){
			String sql="update t_cart set num=num+1 where id=?";
			Connection conn = ConnectionUtils.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cart.getId());
			if(psmt.executeUpdate()!=0){
				ConnectionUtils.CloseResource(conn, psmt);
				return true;
			}else{
				return false;
			}
		}else{
			String sql = "insert into t_cart values(?,?,?,?)";
			Connection conn = ConnectionUtils.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cart.getId());
			psmt.setString(2, cart.getP_name());
			psmt.setDouble(3, cart.getPrice());
			psmt.setDouble(4, 1);
			if(psmt.executeUpdate()!=0){
				ConnectionUtils.CloseResource(conn, psmt);
				return true;
			}else{
				return false;
			}
		}
		
	}
	
	public ArrayList<Cart> queryCart() throws SQLException {
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		String sql = "select * from t_cart";
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			Cart c = new Cart();
			c.setId(rs.getInt(1));
			c.setP_name(rs.getString(2));
			c.setPrice(rs.getDouble(3));
			c.setNum(rs.getInt(4));
			cartList.add(c);
		}
		ConnectionUtils.CloseResource(conn, psmt, rs);
		return cartList;
	}
	
	public ArrayList<Cart> queryCartbyid(int id) throws SQLException {
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		String sql = "select * from t_cart where id=?";
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, id);
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			Cart c = new Cart();
			c.setId(rs.getInt(1));
			c.setP_name(rs.getString(2));
			c.setPrice(rs.getDouble(3));
			cartList.add(c);
		}
		ConnectionUtils.CloseResource(conn, psmt, rs);
		return cartList;
	}
	
	public void clearAll() throws SQLException{
		String sql="delete t_cart";
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.executeUpdate();
		conn.setAutoCommit(true);
	}
}
