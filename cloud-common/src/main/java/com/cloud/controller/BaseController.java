package com.cloud.controller;

import com.cloud.result.ResultBean;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.controller
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/9 15:02
 * @UpdateDate: 2018/2/9 15:02
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class BaseController {
    @Resource
    protected HttpServletRequest request;

    protected ResultBean<Object> resultBean = new ResultBean<>();
}
