package JdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bean.User;

@RunWith(SpringRunner.class)//标识为JUnit的运行环境
@SpringBootTest//获取启动类、加载配置，确定装载Spring Boot；
public class JdbcConnect {
	private final static Logger logger = LoggerFactory.getLogger(JdbcConnectTest.class);
	@Autowired
	public User user;
	@Test
	public void isConnect() {
		//获取mySql数据库的驱动类
				String driver="com.mysql.cj.jdbc.Driver";
				//连接数据库
				String url="jdbc:mysql://localhost:3306/mytest?useSSL=false&serverTimezone=UTC";
				//连接mySql的用户名
				String name="root";
				//连接mySql的密码
				String password="yourpassword1";
				
				try {
					Class.forName(driver);
					Connection conn=DriverManager.getConnection(url, name, password);
					logger.info("成功连接数据库");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					logger.error("加载驱动程序有错误");
				} catch(SQLException e) {
					e.printStackTrace();
					logger.error("取得连接时有错误，核对用户名和密码");
				}
}
}
