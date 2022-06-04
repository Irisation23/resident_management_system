package com.nhnacademy.residentmanagementsystem.config;

import com.nhnacademy.residentmanagementsystem.Base;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
 excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
        basicDataSource.setUrl("jdbc:mysql://133.186.211.156:3306/nhn_academy_31");
        basicDataSource.setUsername("nhn_academy_31");
        basicDataSource.setPassword("3u.SF)xeXWIfzB[Y");
        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxTotal(5);
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(5);

        basicDataSource.setMaxWaitMillis(1000);

        basicDataSource.setTestOnBorrow(true);
        basicDataSource.setTestOnReturn(true);
        basicDataSource.setTestWhileIdle(true);
        return basicDataSource;
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
