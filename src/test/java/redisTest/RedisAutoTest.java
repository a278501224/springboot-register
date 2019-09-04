package redisTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Cherry.cherryPersonalWebSite.CherryPersonalWebSiteApplication;
import com.utils.RedisClusterUtil;

@RunWith(SpringRunner.class)//标识为JUnit的运行环境
@SpringBootTest(classes= CherryPersonalWebSiteApplication.class)//获取启动类、加载配置，确定装载Spring Boot；
public class RedisAutoTest {
	
	@Autowired
	private RedisClusterUtil redisClusterUtil;
	
	@Test
	public void save() {
		redisClusterUtil.set("cherry", "唐一超");
		System.out.println("设置缓存成功");
		Object tt=redisClusterUtil.get("cherry");
		System.out.println(""+tt);
	}
}
