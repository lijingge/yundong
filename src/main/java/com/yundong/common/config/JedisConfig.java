package com.yundong.common.config;

import com.yundong.common.utils.JedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author feri
 *@Date Created in 2019/1/16 10:13
 */
@Configuration
public class JedisConfig {
    @Bean
    public JedisUtil creareJedis(){
        return new JedisUtil("39.105.189.141",6379,"qfjava");
    }
}
