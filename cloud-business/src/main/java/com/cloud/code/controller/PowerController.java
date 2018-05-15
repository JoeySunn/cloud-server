package com.cloud.code.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.code.service.UserService;
import com.cloud.code.util.Role;
import com.cloud.controller.BaseController;
import com.cloud.util.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.controller
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/4/27 16:25
 * @UpdateDate: 2018/4/27 16:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@RestController
@RequestMapping("power")
@Api(value = "PowerController", description = "获取（头部，左侧，列表子级）权限的Controller")
public class PowerController extends BaseController {

    @Resource
    private UserService userService;

    @ResponseBody
    @PostMapping("head_menu")
    @ApiOperation(value = "获取头部权限")
    public JSONObject getHeadMenuPower(Integer id) {
        return JSONUtil.successData(new Role().getHeadMenu(userService.findUserById(id).getRole().getRoleCode()));
    }

    @ResponseBody
    @PostMapping(value = "left_menu")
    @ApiOperation(value = "获取左侧权限")
    public JSONObject getLeftMenu(Integer id, String code) {
        return JSONUtil.successData(new Role().getLeftTree(code, userService.findUserById(id).getRole().getRoleCode()));
    }

    @ResponseBody
    @PostMapping(value = "right_menu")
    @ApiOperation(value = "获取右键权限，点击左侧菜单之后下的子级权限（增删改查）")
    public JSONObject getRightMenu(Integer id, String code) {
        return null;
    }

}
