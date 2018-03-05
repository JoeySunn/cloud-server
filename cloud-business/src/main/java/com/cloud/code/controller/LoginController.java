package com.cloud.code.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.code.model.user.User;
import com.cloud.code.service.UserService;
import com.cloud.controller.BaseController;
import com.cloud.util.JSONUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.controller
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/9 14:07
 * @UpdateDate: 2018/2/9 14:07
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/login")
@Api(value = "LoginController", description = "登陆验证")
public class LoginController extends BaseController{

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录验证", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "success！")
    })
    @ResponseBody
    @RequestMapping(value = "/to_login", method = RequestMethod.POST)
    public JSONObject login(@ApiParam(name = "userName", value = "用户名")
                            @RequestParam(value = "userName") String userName,
                            @ApiParam(name = "passWord", value = "密码")
                            @RequestParam(value = "passWord") String passWord) {
        User user=userService.validate(userName,passWord);
        if(user==null){
            resultBean.message("用户不存在！");
        }
        resultBean.data(user);
        return JSONUtil.parseResultBean(resultBean);
    }
}
