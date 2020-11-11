package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//本身就是一个组件
//标注这个类是一个SpringBoot的应用
@SpringBootApplication
public class Springboot01logindApplication {

    public static void main(String[] args) {
        //将SpringBoot应用启动
        //SpringApplication类
        //run方法
        SpringApplication.run(Springboot01logindApplication.class, args);
    }

}
