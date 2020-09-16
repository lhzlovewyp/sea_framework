package com.sea.front;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName
 * @Description TODO
 * @Author lvhaizhen
 * @Date 2020/9/4 下午5:04
 * @Version 1.0
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class FrontApplication {

   private Logger logger = LoggerFactory.getLogger(this.getClass());

   public static void main(String[] args){
     SpringApplication.run(FrontApplication.class, args);
   }
   @GetMapping(value = "/index")
   public String index(){
     return "this is user index";
   }

}
