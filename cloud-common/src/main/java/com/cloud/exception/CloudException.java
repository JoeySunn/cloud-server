package com.cloud.exception;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.exception
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/4/23 14:34
 * @UpdateDate: 2018/4/23 14:34
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class CloudException extends RuntimeException {
    private static final long serialVersionID = 1L;

    public CloudException(String exceptionStr){
        super(exceptionStr);
    }

}
