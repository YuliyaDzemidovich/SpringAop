package com.github.yuliyadzemidovich.springaop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    /**
     * Call this endpoint to test Spring AOP
     * @return check logs to see output for this method execution and AOP advices
     */
    @GetMapping
    public String test() {
        String msg = "hello from TEST ENDPOINT";
        log.info(msg);
        return msg;
    }
}
