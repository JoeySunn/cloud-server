package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/9 13:49
 * @UpdateDate: 2018/2/9 13:49
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@EnableEurekaServer
@SpringBootApplication
public class CenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CenterApplication.class,args);
    }
}
