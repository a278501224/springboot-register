package com.Cherry.cherryPersonalWebSite;


import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com")
@MapperScan(basePackages="com.mapper")
public class CherryPersonalWebSiteApplication implements TomcatConnectorCustomizer{

	public static void main(String[] args) {
		SpringApplication.run(CherryPersonalWebSiteApplication.class, args);
	}
	
	//拦截
	@Bean
	   public TomcatServletWebServerFactory servletContainer() {
	      TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
	         @Override
	         protected void postProcessContext(Context context) {
	            SecurityConstraint constraint = new SecurityConstraint();
	            constraint.setUserConstraint("CONFIDENTIAL");
	            SecurityCollection collection = new SecurityCollection();
	            collection.addPattern("/*");
	            constraint.addCollection(collection);
	            context.addConstraint(constraint);
	         }
	      };
	      tomcat.addAdditionalTomcatConnectors(createHTTPConnector());
	      return tomcat;
	   }
		
		//监听http端口号，然后转向https端口
		@Bean
		public Connector createHTTPConnector() {
			Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
			//同时启用http（80）、https（8443）两个端口
			connector.setScheme("http");
			//监听http的端口号
			connector.setPort(80);
			connector.setSecure(false);
			//监听到http的端口号后转向到的https的端口号
			connector.setRedirectPort(443);
			return connector;
		}

		@Override
		public void customize(Connector connector) {
			connector.setPort(443);
		}
}
