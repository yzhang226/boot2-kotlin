package org.cook.lighting.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import javax.annotation.PostConstruct


/**
 * Created by cook on 2019/1/13
 */
@Component
class ActuatorLogger {

    private final val logger: Logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    var requestMappingHandlerMapping: RequestMappingHandlerMapping? = null

    @PostConstruct
    fun initActuatorLogger() {
        for (handlerMethod in requestMappingHandlerMapping!!.handlerMethods) {
            logger.info("request mapping - " + handlerMethod.key)
        }
    }

}