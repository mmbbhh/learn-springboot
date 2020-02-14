package com.day01.day01.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

@Configuration
public class FastJson {
    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd"); //日期格式化
        config.setCharset(StandardCharsets.UTF_8); //编码格式化
        config.setSerializerFeatures(
                //SerializerFeature.WriteClassName, //输出类名
                SerializerFeature.WriteMapNullValue, //输出空值
                SerializerFeature.PrettyFormat, //Json格式化
                SerializerFeature.WriteNullListAsEmpty, //输出空集
                SerializerFeature.WriteNullStringAsEmpty //空字符串输出

        );
        converter.setFastJsonConfig(config);
        return converter;
    }
}
