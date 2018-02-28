package com.cloud.result;

/**
 * 作用描述
 *
 * @ProjectName: cloud-manager
 * @Package: com.cloud.result
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/1/18 15:35
 * @UpdateDate: 2018/1/18 15:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class BaseResult {
    private int code = 200;

    private String message = "success";

    public BaseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResult() {
    }

    public BaseResult message(String message) {
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
