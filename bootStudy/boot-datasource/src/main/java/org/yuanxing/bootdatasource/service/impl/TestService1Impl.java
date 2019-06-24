package org.yuanxing.bootdatasource.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.yuanxing.bootdatasource.service.TestService1;

import java.util.Map;

/**
 * @author yuanxing
 * @version 0.0.1
 * @create 2019-06-24 16:05
 * @see (1)
 */
@Service("testService1")
@Slf4j
public class TestService1Impl implements TestService1 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object>  selectData() {
        String sql = "select * from loginlogmfail where id = ?";
        Map<String, Object> returnMap = jdbcTemplate.queryForMap(sql, 1);
        log.info("returnMap -------" + returnMap);
        return returnMap;
    }
}
