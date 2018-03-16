package com.cloud.code.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.code.model.user.User;
import com.cloud.code.service.RoleService;
import com.cloud.code.service.UserService;
import com.cloud.constant.MessageConstant;
import com.cloud.controller.BaseController;
import com.cloud.util.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.controller
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/27 13:56
 * @UpdateDate: 2018/2/27 13:56
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@RestController
@RequestMapping("user")
@Api(value = "UserController", description = "用户管理控制层")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @ApiOperation(value = "添加一个用户", httpMethod = "POST")
    @PostMapping("add_user")
    @ResponseBody
    public JSONObject addUser(@ApiParam(name = "user", value = "用户信息") @RequestBody User user) {
        if (userService.findUserByName(user.getUserName()) == null) {
            user.setRole(roleService.findById(user.getRole().getId()));
            if (userService.addUser(user) != null) {
                return JSONUtil.finalData(new User(), MessageConstant.INSERT_MESSAGE_OK, MessageConstant.OK);
            } else {
                return JSONUtil.finalData(user, MessageConstant.INSERT_MESSAGE_ERROR, MessageConstant.NO);
            }
        }
        return JSONUtil.finalData(user, "已存在的用户名！", MessageConstant.NO);
    }


    @ApiOperation(value = "查询一个用户",httpMethod = "POST")
    @PostMapping("get_user")
    @ResponseBody
    public JSONObject getUser(@ApiParam(name = "id", value = "用户Id") @RequestParam Integer id){
         User user=userService.findUserById(id);
         if(user!=null){
            JSONUtil.successData(user);
         }
         return JSONUtil.errorData("用户不存在!");
    }

}
