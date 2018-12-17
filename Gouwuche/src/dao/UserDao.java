package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import servlet.ConnectionUtils;

public class UserDao {
	public boolean login(String uname,String pwd) throws SQLException{
		String sql = "select * from t_user where uname=? and pwd=?";
		Connection conn=ConnectionUtils.getConnection();
		PreparedStatement psmt=conn.prepareStatement(sql);
		psmt.setString(1, uname);
		psmt.setString(2, pwd);
		ResultSet rs = psmt.executeQuery();
		if(rs.next()){
			return true;
		}
		return false;
	}
}
