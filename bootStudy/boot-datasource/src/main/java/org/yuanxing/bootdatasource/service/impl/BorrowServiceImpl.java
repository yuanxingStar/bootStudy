package org.yuanxing.bootdatasource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yuanxing.bootdatasource.service.BorrowService;
import org.yuanxing.bootdatasource.service.TestService1;
import org.yuanxing.bootdatasource.service.TestService2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanxing
 * @version 0.0.1
 * @create 2019-06-24 14:18
 * @see (1)
 */
@Service("borrowService")
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private TestService1 testService1;
    @Autowired
    private TestService2 testService2;


    @Override
    public Map<String, Object> testBorrow(Map<String, Object> map) {
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("test1" , "yuan");
        returnMap.put("test2" , "xing");

        returnMap = testService1.selectData();
        testService2.insertData(map);
        return returnMap;
    }


}
