package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value={"classpath:db.properties"})
public class JavaConfig {

    @Value("${dataSource.jdbcUrl}")
    private String jdbcUrl;
    @Value("${dataSource.driverClass}")
    private String jdbcDriverClassName;
    @Value("${dataSource.user}")
    private String jdbcUserName;
    @Value("${dataSource.password}")
    private String jdbcPasswd;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcDriverClassName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPasswd);

        return dataSource;
    }

}
