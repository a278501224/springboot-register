package JdbcTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Cherry.cherryPersonalWebSite.CherryPersonalWebSiteApplication;
import com.mapper.UserMapper;

/**
 * @author cherry
 * @version 1.0.0
 * @since 
 * 创建时间：2019年2月23日
 * 功能描述：注册界面每个功能的测试类
 * 官方网站：www.cindy.com
 * 邮箱地址：yichaotang@qq.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=CherryPersonalWebSiteApplication.class)
public class registerTest {
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	/**
	 * 校验
	 */
	public void checkUsername() {
		System.out.println("校验用户名是否存在："+userMapper.findUserByUsername("admin1"));
	}
	
	/**
	 * 校验存在的手机号
	 */
	@Test
	public void checkphoneExists() {
		System.out.println("校验存在的手机号数量:"+userMapper.getCountByPhone("15901808150"));
	}
	
	/**
	 * 校验存在的邮箱地址
	 */
	@Test
	public void checkEmailExists() {
		System.out.println("校验存在的邮箱地址数量:"+userMapper.getCountByEmail("yichaotang@qq.com"));
	}
	
}
