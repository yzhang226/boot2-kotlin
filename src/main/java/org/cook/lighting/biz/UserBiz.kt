package org.cook.lighting.biz

import org.cook.lighting.model.UserBean
import org.cook.lighting.model.UserRequest
import org.cook.lighting.model.UserResponse
import org.cook.lighting.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by cook on 2019/1/13
 */
@Component
class UserBiz {

    @Autowired
    lateinit var userService: UserService

    /**
     *
     */
    fun getByUserId(userId: Int): UserResponse {
        val u = userService.getByUserId(userId)

        val ur = UserResponse()
        ur.id = u.id
        ur.userName = u.userName
        ur.userCode = u.userCode
        ur.createTime = u.createTime
        return ur
    }

    fun addUser(user: UserRequest): Int {
        val u = UserBean()
        u.id = user.id
        u.userName = user.userName
        u.userCode = user.userCode
        u.createTime = user.createTime
        return userService.saveUser(u)
    }

    fun updatUser(user: UserRequest): Int {
        val u = UserBean()
        u.id = user.id
        u.userName = user.userName
        u.userCode = user.userCode
        u.createTime = user.createTime
        return userService.updateUser(u)
    }

}