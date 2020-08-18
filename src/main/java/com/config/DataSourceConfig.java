package com.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Description: 数据库连接配置
 * Auther:cherry
 * CreateTime:2020-08-10 10:37
 */
@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource  dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(dataSourceUrl);
        config.setUsername(userName);
        config.setPassword(password);
        return  new HikariDataSource(config);
    }

}
