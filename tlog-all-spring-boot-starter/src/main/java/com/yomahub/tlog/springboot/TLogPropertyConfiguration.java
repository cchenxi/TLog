package com.yomahub.tlog.springboot;

import com.yomahub.tlog.spring.TLogSpringAware;
import com.yomahub.tlog.springboot.property.TLogProperty;
import com.yomahub.tlog.spring.TLogPropertyInit;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

/**
 * TLog的参数自动装配类
 *
 * @author Bryan.Zhang
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(TLogProperty.class)
@AutoConfigureAfter(TLogCommonAutoConfiguration.class)
@PropertySource(
        name = "TLog Default Properties",
        value = "classpath:/META-INF/tlog-default.properties")
public class TLogPropertyConfiguration {

    @Bean
    public TLogPropertyInit tLogPropertyInit(TLogProperty tLogProperty) {
        TLogPropertyInit tLogPropertyInit = new TLogPropertyInit();
        tLogPropertyInit.setPattern(tLogProperty.getPattern());
        tLogPropertyInit.setEnableInvokeTimePrint(tLogProperty.enableInvokeTimePrint());
        tLogPropertyInit.setIdGenerator(tLogProperty.getIdGenerator());
        tLogPropertyInit.setMdcEnable(tLogProperty.getMdcEnable());
        return tLogPropertyInit;
    }
}
