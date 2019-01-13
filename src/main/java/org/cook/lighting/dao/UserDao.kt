package org.cook.lighting.dao

import org.apache.ibatis.annotations.Param
import org.cook.lighting.common.Dao
import org.cook.lighting.model.UserBean

/**
 * Created by cook on 2019/1/13
 */
@Dao
interface UserDao {

    /**
     * get-by-id
     */
    fun getById(userId: Int): UserBean

    /**
     *
     */
    fun save(user: UserBean): Int

    /**
     *
     */
    fun update(user: UserBean): Int

}