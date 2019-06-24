package org.yuanxing.bootdatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2019-06-24 10:53
 * @see  (1) 当前类DataSources配置类
 */


@Log
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
                                   DataSourceTransactionManagerAutoConfiguration.class,
                                   JdbcTemplateAutoConfiguration.class})
@PropertySource("classpath:datasource.properties")
@Configuration
public class DataSourceConfig {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        log.info(Arrays.toString(ac.getBeanDefinitionNames()));
    }

    @Bean(name = "mainDataSource")
    @ConfigurationProperties("spring.datasource.druid.main")
    public DruidDataSource mainDataSource() throws SQLException {
        DruidDataSource mainDataSource =  DruidDataSourceBuilder.create().build();
        log.info("mainDataSource ---" + mainDataSource);
        return mainDataSource;


    }

    @Bean(name = "yuanxingDataSource")
    @ConfigurationProperties("spring.datasource.druid.yuanxing")
    public DruidDataSource yuanxingDataSource() throws SQLException {
        DruidDataSource yuanxingDataSource = DruidDataSourceBuilder.create().build();
        log.info("yuanxingDataSource ---" + yuanxingDataSource);
        return yuanxingDataSource;


    }

    @Bean
    public MultipleDataSource multipleDataSource(@Qualifier("mainDataSource") DruidDataSource mainDataSource,
                                                 @Qualifier("yuanxingDataSource") DruidDataSource yuanxingDataSource)
            throws SQLException {
        Map<Object, Object> map = new HashMap<>();
        map.put("mainDataSource", mainDataSource);
        map.put("yuanxingDataSource", yuanxingDataSource);

        MultipleDataSource multipleDataSource = new MultipleDataSource();
        multipleDataSource.setDefaultTargetDataSource(mainDataSource);
        multipleDataSource.setTargetDataSources(map);
        return multipleDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(MultipleDataSource multipleDataSource) {
        return new JdbcTemplate(multipleDataSource);
    }

    @Bean
    @Description("事务管理器")
    public PlatformTransactionManager transactionManager(MultipleDataSource multipleDataSource) {
        return new DataSourceTransactionManager(multipleDataSource);
    }


}
