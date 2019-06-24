package org.yuanxing.bootdatasource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.yuanxing.bootdatasource.annotation.DataSource;
import org.yuanxing.bootdatasource.service.TestService2;

import java.util.Map;

/**
 * @author yuanxing
 * @version 0.0.1
 * @create 2019-06-24 16:05
 * @see (1)
 */
@Service("testService2")
public class TestService2Impl implements TestService2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @DataSource( name = "yuanxingDataSource")
    public Boolean insertData(Map<String, Object> map) {
        String sql = "delete from loginlogmfail where id = ?" ;

        return jdbcTemplate.update(sql,1) == 1;
    }
}
