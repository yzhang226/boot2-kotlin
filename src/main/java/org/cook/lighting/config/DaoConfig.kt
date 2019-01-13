package org.cook.lighting.config

import org.cook.lighting.common.Dao
import org.mybatis.spring.annotation.MapperScan
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration

/**
 * Created by cook on 2019/1/13
 */
@Configuration
@MapperScan(basePackages = ["org.cook.lighting"], annotationClass = Dao::class)
class DaoConfig {

    private final val logger: Logger = LoggerFactory.getLogger(javaClass)



}