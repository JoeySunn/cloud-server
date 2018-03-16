package com.cloud;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/3/15 14:25
 * @UpdateDate: 2018/3/15 14:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class PasTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        System.out.println(encoder.encode("zhiaiweiyi"));
    }
}
