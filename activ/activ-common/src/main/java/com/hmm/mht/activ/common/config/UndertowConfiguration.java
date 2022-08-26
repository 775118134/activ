package com.hmm.mht.activ.common.config;

import io.undertow.Undertow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xnio.SslClientAuthMode;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hmm
 * @date 2021/6/23 17:53
 * @Description:
 */
@Configuration
@Slf4j
@ConditionalOnClass({Servlet.class, Undertow.class, SslClientAuthMode.class})
@ConditionalOnMissingBean(
        value = {ServletWebServerFactory.class},
        search = SearchStrategy.CURRENT
)
public class UndertowConfiguration {

    @Bean
    public UndertowServletWebServerFactory embeddedServletContainerFactory() {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        factory.addDeploymentInfoCustomizers(deploymentInfo -> deploymentInfo.setExceptionHandler((exchange, request, response, throwable) -> {
            if (throwable instanceof RuntimeException) {
                ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_BAD_REQUEST);
                log.warn("Request rejected due to: {} for URI {}", throwable.getMessage(), ((HttpServletRequest) request).getRequestURI());
                return true;
            }
            return false;
        }));
        return factory;
    }
}
