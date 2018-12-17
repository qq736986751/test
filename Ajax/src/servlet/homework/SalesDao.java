package servlet.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import servlet.ajaxafternoon.ConnectionUtils;
	public class SalesDao {
		public ArrayList<Sales> querysales() throws SQLException {
			ArrayList<Sales> salesList = new ArrayList<Sales>();
			String sql = "select * from (select * from sales order by p_sale_num desc) where rownum<4";
			Connection conn = ConnectionUtils.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Sales sales = new Sales();
				sales.setP_id(rs.getInt(1));
				sales.setP_name(rs.getString(2));
				sales.setP_sale_num(rs.getInt(3));
				salesList.add(sales);
			}
			ConnectionUtils.CloseResource(conn, psmt, rs);
			return salesList;
		}
}
