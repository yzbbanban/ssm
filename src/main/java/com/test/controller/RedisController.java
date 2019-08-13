package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/v1/redis")
public class RedisController {

    /**
     * redis数据删除工具
     *
     * @param key
     * @return
     */
//    @GetMapping(value = "/del")
//    public String delAsset(String key) {
//        Set<String> keys = redisClient.getKeys(key + "*");
//        for (String k : keys) {
//            redisClient.delCacheByKey(k);
//        }
//        return "success";
//    }

}
