package com.cloud.controller;

import com.cloud.constant.MessageConstant;
import com.cloud.result.ResultBean;

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

    protected HttpServletRequest request;

    protected ResultBean<Object> resultBean = new ResultBean<>();
    //操作成功
    protected  String success=MessageConstant.SUCCESS;

    protected String error=MessageConstant.ERROR;

    protected Boolean ok=MessageConstant.OK;

    protected Boolean no=MessageConstant.NO;
}
