package org.cook.lighting

import org.cook.lighting.common.Dao
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Created by cook on 2019/1/12
 */
@SpringBootApplication(scanBasePackages = ["org.cook.lighting"])
@MapperScan(basePackages = ["org.cook.lighting"], annotationClass = Dao::class)
class ApplicationStart

fun main(args: Array<String>) {
    runApplication<ApplicationStart>(*args)
}