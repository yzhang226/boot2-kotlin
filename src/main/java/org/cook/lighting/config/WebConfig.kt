package org.cook.lighting.config

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Created by cook on 2019/1/12
 */
@Configuration
class WebConfig : WebMvcConfigurer {

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(customJackson2HttpMessageConverter())
    }

    @Bean
    fun customJackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter {
        val jsonConverter = MappingJackson2HttpMessageConverter()
        val objectMapper = createMapper()
        jsonConverter.objectMapper = objectMapper
        return jsonConverter
    }

    fun createMapper(): ObjectMapper {
        val mapper = ObjectMapper()
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true)
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)

        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)

        mapper.configure(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING, true)

        // 忽略大小写
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
        // 兼容lombok
        mapper.configure(MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES, false)
        // 禁用自动检测public属性, 必须使用getter-setter
        mapper.configure(MapperFeature.AUTO_DETECT_FIELDS, false)

        val module = JavaTimeModule()

        mapper.registerModule(module)

        //        SimpleModule enumModule = new SimpleModule();
        //        enumModule.setDeserializers(new CustomEnumDeserializers());
        //        mapper.registerModule(enumModule);

        return mapper
    }

}