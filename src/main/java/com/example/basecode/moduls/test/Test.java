package com.example.basecode.moduls.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/test")
public class Test {
    @RequestMapping("/test")
    public String test(){
        log.info("12312");
        return "123123";
    }
}
