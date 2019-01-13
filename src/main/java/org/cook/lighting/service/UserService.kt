package org.cook.lighting.service

import org.cook.lighting.dao.UserDao
import org.cook.lighting.model.UserBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

/**
 * Created by cook on 2019/1/13
 */
@Service
class UserService {

    @Autowired
    lateinit var userDao: UserDao;

    /**
     *
     */
    fun getByUserId(userId: Int): UserBean {
        val u = UserBean();
        u.createTime = LocalDateTime.now();
        return userDao.getById(userId);
    }

    /**
     *
     */
    fun saveUser(user: UserBean): Int {
        userDao.save(user)
        return user.id
    }

    /**
     *
     */
    fun updateUser(user: UserBean): Int {
        return userDao.update(user)
    }

}