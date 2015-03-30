package trade;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjProps {
	
	String maxSizeResult;
	String maxSizeInv;
	
	String dbJdbcClass;
	String dbJdbcURL;
	String user="root";
	String password="root";



	public ProjProps() {
		
		maxSizeResult = "2000";
		maxSizeInv = "1000";
	
		dbJdbcClass="com.mysql.jdbc.Driver";
		dbJdbcURL="jdbc:mysql://127.0.0.1:3306/test";
		
	}
	
	public boolean loadProps(String projPropertyFilePath) {
		boolean bResult = true;
		Properties props = new Properties();
		try {
	        //load a properties file
	 		props.load(new FileInputStream(projPropertyFilePath));
	 		
	 		maxSizeResult = props.getProperty("maxsize.result","2000");
	 		maxSizeInv = props.getProperty("maxsize.inv","1000");
	 		
	 		dbJdbcClass =  props.getProperty("db.jdbc.class","com.mysql.jdbc.Driver");
	 		dbJdbcURL = props.getProperty("db.jdbc.url","jdbc:mysql://127.0.0.1:3306/test");
	 		
	
	 	} catch (IOException ex) {
	 		bResult = false;
	 		ex.printStackTrace();
	    }
		
		return bResult;
	}
	
	public String getMaxSizeResult() { return maxSizeResult; }
	public String getMaxSizeInv() { return maxSizeInv; }
	
	public String getDbJdbcClass() { return dbJdbcClass; }
	public String getDbJdbcURL() { return dbJdbcURL; }
	
	public String getUser() { return user; }
	public String getPassword() { return password; }

}
