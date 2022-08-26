package com.hmm.mht.activ.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author hmm
 * @date 2021/6/10 16:19
 * @Description:
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "myswagger")
public class MySwaggerProperties {
    private String version;

    private String operationPath;
    private String shufflePath;
    private String notifyPath;
    private String handlePath;
}



