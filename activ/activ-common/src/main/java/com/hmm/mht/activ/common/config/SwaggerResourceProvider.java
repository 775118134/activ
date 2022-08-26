package com.hmm.mht.activ.common.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hmm
 * @date 2020/11/4 16:50 @Description:
 */
@Primary
@Component
@EnableConfigurationProperties({MySwaggerProperties.class})
@AllArgsConstructor
public class SwaggerResourceProvider implements SwaggerResourcesProvider {
    private final MySwaggerProperties mySwaggerProperties;

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();

        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);

        return swaggerResource;
    }

    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();

        resources.add(swaggerResource("活动处理模块 API", mySwaggerProperties.getOperationPath() + "/v2/api-docs", mySwaggerProperties.getVersion()));
        resources.add(swaggerResource("活动处理模块2 API", mySwaggerProperties.getHandlePath() + "/v2/api-docs", mySwaggerProperties.getVersion()));
        resources.add(swaggerResource("消费通知模块 API", mySwaggerProperties.getNotifyPath() + "/v2/api-docs", mySwaggerProperties.getVersion()));
        resources.add(swaggerResource("数据落地模块 API", mySwaggerProperties.getShufflePath() + "/v2/api-docs", mySwaggerProperties.getVersion()));

        return resources;
    }
}
