package org.yuanxing.bootdatasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yuanxing.bootdatasource.service.BorrowService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanxing
 * @version 0.0.1
 * @create 2019-06-24 14:20
 * @see (1)  http://localhost:8080/test?name=yuan&age=10
 */

@RestController("borrowController")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @RequestMapping("/test")
    public Map<String,Object> testBorrow(@RequestParam("name") String name,
                                         @RequestParam("age") String age) {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("name" , name);
        paramMap.put("age" , age);

        return borrowService.testBorrow(paramMap);

    }
}
