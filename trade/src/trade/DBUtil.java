package trade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	public static  Connection getConnection() {
		Connection connection = null;
		String maxSizeResult;
		String maxSizeInv;
		try {
			System.out.println("Application tries to register the driver.");

			ProjProps projProps = new ProjProps();

			maxSizeResult = projProps.getMaxSizeResult();
			maxSizeInv = projProps.getMaxSizeInv();

			Class.forName(projProps.getDbJdbcClass()).newInstance();
			String sCon = projProps.getDbJdbcURL();
			Properties props = new Properties();
			props.put("StatementCache", "32");
			props.put("user",projProps.getUser());
			props.put("password", projProps.getPassword());
			connection = java.sql.DriverManager.getConnection(sCon, props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection conn){
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Connect close failed.");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		DBUtil.getConnection();
	}

}
