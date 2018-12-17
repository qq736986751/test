package servlet.ajaxafternoon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Empdao {

	public ArrayList<Emp> queryEmp() throws SQLException {
		ArrayList<Emp> empList = new ArrayList<Emp>();
		String sql = "select empno,ename,job,nvl(mgr,0),hiredate,sal,nvl(comm,0),nvl(deptno,0) from emp";
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setMgr(rs.getInt(4));
			emp.setHiredate(rs.getDate(5));
			emp.setSal(rs.getDouble(6));
			emp.setComm(rs.getDouble(7));
			emp.setDeptno(rs.getInt(8));
			empList.add(emp);
		}
		ConnectionUtils.CloseResource(conn, psmt, rs);
		return empList;
	}

	public String[] getCol() throws SQLException {
		String sql = "select empno,ename,job,nvl(mgr,0),hiredate,sal,nvl(comm,0),nvl(deptno,0) from emp";
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int num = rsmd.getColumnCount();
		String sname[] = new String[num];
		for (int i = 0; i < num; i++) {
			sname[i] = rsmd.getColumnName(i);
		}
		return sname;
	}

	public void addEmp(Emp emp) throws SQLException {
		String sql = "insert into emp2 values(?,?,?,?,to_date(?,'yyyy/mm/dd'),?,?,?)";
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, emp.getEmpno());
		psmt.setString(2, emp.getEname());
		psmt.setString(3, emp.getJob());
		psmt.setInt(4, emp.getMgr());
		// 时间类型以后不想玩了
		Date date1 = emp.getHiredate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(date1);
		psmt.setString(5, date);
		psmt.setDouble(6, emp.getSal());
		psmt.setDouble(7, emp.getComm());
		psmt.setInt(8, emp.getDeptno());
		psmt.executeUpdate();
		ConnectionUtils.CloseResource(conn, psmt);
	}
}
