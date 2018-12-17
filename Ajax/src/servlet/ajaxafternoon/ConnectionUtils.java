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
	// 一旦该类被加载，就运行static代码块，里面的内容有且只加载一次，获取数据以及加载驱动
	static {
		try {
			// 获取数据
			getParam();
			// 加载驱动
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
	 * 加载完驱动之后，通过加载驱动得到的DriverManager对象以及获取到的数据来连接数据库
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * 获取到db_oracle.properties里面的四个数据
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
		// 根据指定的key获取到指定的value
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		url = prop.getProperty("url");
		driver = prop.getProperty("driver");
	}

	// 关流
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

	// 测试，如果没报异常就是连接成功！
	public static void main(String[] args) throws SQLException {
		getConnection();
	}

}
