package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/9 13:53
 * @UpdateDate: 2018/2/9 13:53
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class,args);
    }
}
