package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/4/23 11:34
 * @UpdateDate: 2018/4/23 11:34
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class,args);
    }
}
