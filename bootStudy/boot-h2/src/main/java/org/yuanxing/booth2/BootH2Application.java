package org.yuanxing.booth2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @version 0.0.1
 * @see (1) 继承CommandLineRunner 实现run方法，可使程序在启动时执行一个任务
 *          这里是打印数据源 及数据源连接信息
 *          如果多个类实现了CommandLineRunner接口 可使用@order注解决定其执行顺序
 *
 *      (2) boot 2.0默认使用
* */
@SpringBootApplication
@Slf4j
public class BootH2Application implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BootH2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        showConnection();
        showData();
    }

    private void showConnection() throws SQLException {
        //HikariDataSource (HikariPool-1)
        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        //HikariProxyConnection@1005344801 wrapping conn0: url=jdbc:h2:mem:test user=ROOT
        log.info(conn.toString());
        conn.close();
    }

    private void showData() {
        jdbcTemplate.queryForList("SELECT * FROM FOO")
                .forEach(row -> log.info(row.toString()));
    }

}
