package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroTest {
	public static void main(String[] args) {
		//获取安全管理器
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		//设置安全管理器
		SecurityUtils.setSecurityManager(securityManager);
		//获取用户
		Subject currentUser = SecurityUtils.getSubject();
		Session session =currentUser.getSession();
		//用户登陆验证
		session.setAttribute("name", "唐一超");
		String value=(String) session.getAttribute("name");
		if(value!=null) {
			System.out.println("获取到指定对象的值value:"+value);
		}
		
		if(currentUser.isAuthenticated()==false) {
			//usernamePasswordToken
			UsernamePasswordToken token = new UsernamePasswordToken("root","secret");
			token.setRememberMe(true);
			try {
				currentUser.login(token);	
				System.out.println("用户名密码正确，登陆成功");
			} catch (UnknownAccountException e) {
				System.out.println("账户不存在");
			} catch(IncorrectCredentialsException e) {
				System.out.println("密码错误");
			} catch(LockedAccountException e) {
				System.out.println("用户已锁死");
			} catch(AuthenticationException e) {
				System.out.println("认证异常");
			}
			
		}
		//权限管理
		//角色管理
		//session
	}
}
