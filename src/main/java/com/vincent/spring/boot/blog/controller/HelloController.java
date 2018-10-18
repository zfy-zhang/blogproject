package com.vincent.spring.boot.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vincent
 * on 2018/5/18 上午9:27
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello World!");
        return "Hello World! Welcome to visit vincent.com!";
    }
}
