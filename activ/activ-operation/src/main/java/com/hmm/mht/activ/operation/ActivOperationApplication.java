package com.hmm.mht.activ.operation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.hmm.mht.activ.**"})
@ComponentScan(basePackages = {"com.hmm.mht.activ.**"})
//@EnableScheduling
@ServletComponentScan(basePackages = {"com.hmm.mht.activ.**"})
@EnableCaching
@Slf4j
public class ActivOperationApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(ActivOperationApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
