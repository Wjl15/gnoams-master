package niit.wei.utils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 数据库 连接
 * @author 15415
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	private static ThreadLocal<Connection> pool = new ThreadLocal<>();
	private static Properties properties = null;
	static {
		InputStream input = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
		properties = new Properties();
//		System.out.println(properties);
		try {
			properties.load(input);
//			System.out.println(properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = pool.get();
		if (conn == null) {
			Class.forName(properties.getProperty("jdbc_driver_class"));
			conn = DriverManager.getConnection(properties.getProperty("jdbc_url"), properties.getProperty("jdbc_user"),
					properties.getProperty("jdbc_password"));
		}

		return conn;

	}

	public static void close() {
		Connection conn = pool.get();
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	public static void main(String[] args) {
//		
//	}
}
