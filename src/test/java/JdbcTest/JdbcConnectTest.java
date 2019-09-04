package JdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcConnectTest {
	private final static Logger logger = LoggerFactory.getLogger(JdbcConnectTest.class);
	
	public static Connection getConnection() {
		//获取mySql数据库的驱动类
		String driver="com.mysql.cj.jdbc.Driver";
		//连接数据库
		String url="jdbc:mysql://localhost:3306/mytest?useSSL=false&serverTimezone=UTC";
		//连接mySql的用户名
		String name="root";
		//连接mySql的密码
		String password="yourpassword";
		
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url, name, password);
			logger.info("成功连接数据库");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("加载驱动程序有错误");
			return null;
		} catch(SQLException e) {
			e.printStackTrace();
			logger.error("取得连接时有错误，核对用户名和密码");
			return null;
		}
	}
	
	public static void main(String[] args) throws SQLException{
			
			Connection cc=JdbcConnectTest.getConnection();
		}
}
