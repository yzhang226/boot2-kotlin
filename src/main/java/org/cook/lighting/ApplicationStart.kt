package org.cook.lighting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

/**
 * Created by cook on 2019/1/12
 */
@SpringBootApplication(scanBasePackages = ["org.cook.lighting"])
@PropertySources(
        PropertySource("classpath:\${spring.profiles.active}/application.properties", "classpath:application.properties"),
        PropertySource("classpath:local/local.properties", ignoreResourceNotFound = true)
)

private class ApplicationStart

fun main(args: Array<String>) {
    runApplication<ApplicationStart>(*args)
}