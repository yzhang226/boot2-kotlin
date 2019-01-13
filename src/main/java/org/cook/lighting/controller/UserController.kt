package org.cook.lighting.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.cook.lighting.biz.UserBiz
import org.cook.lighting.model.UserRequest
import org.cook.lighting.model.UserResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by cook on 2019/1/12
 */
@RestController
@Api(tags = ["User"])
class UserController {

    @Autowired
    lateinit var userBiz: UserBiz

    @GetMapping("/user/{userId}")
    @ApiOperation(tags = ["User"], value = "getUserById", httpMethod = "GET", notes = "通过主键获取用户信息")
    fun getUserById(@PathVariable userId: Int): UserResponse {
        return userBiz.getByUserId(userId)
    }

    @PostMapping("/user")
    @ApiOperation(tags = ["User"], value = "addUser", httpMethod = "POST", notes = "新增用户")
    fun addUser(@RequestBody user: UserRequest): Int {
        return userBiz.addUser(user)
    }

    @PutMapping("/user")
    @ApiOperation(tags = ["User"], value = "updateUser", httpMethod = "PUT", notes = "更新用户")
    fun updateUser(@RequestBody user: UserRequest): Int {
        return userBiz.updatUser(user)
    }

}