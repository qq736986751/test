package servlet.ajaxafternoon;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {
	static String username;
	static String password;
	static String url;
	static String driver;
	// һ�����౻���أ�������static����飬�������������ֻ����һ�Σ���ȡ�����Լ���������
	static {
		try {
			// ��ȡ����
			getParam();
			// ��������
			Class.forName(driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ����������֮��ͨ�����������õ���DriverManager�����Լ���ȡ�����������������ݿ�
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * ��ȡ��db_oracle.properties������ĸ�����
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void getParam() throws FileNotFoundException, IOException {
		ClassLoader cl = ConnectionUtils.class.getClassLoader();
		Properties prop = new Properties();
		InputStream is = ConnectionUtils.class.getClassLoader()
				.getResourceAsStream("db_oracle.properties");
		prop.load(is);
		// ����ָ����key��ȡ��ָ����value
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		url = prop.getProperty("url");
		driver = prop.getProperty("driver");
	}

	// ����
	public static void CloseResource(Connection conn, PreparedStatement psmt) {
		CloseResource(conn, psmt, null);
	}

	public static void CloseResource(Connection conn, PreparedStatement psmt,
			ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// ���ԣ����û���쳣�������ӳɹ���
	public static void main(String[] args) throws SQLException {
		getConnection();
	}

}
