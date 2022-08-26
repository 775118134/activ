package com.hmm.mht.activ.common.config;

import com.hmm.mht.activ.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author hmm
 * @date 2021/6/22 10:22
 * @Description: 异常统一处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R doError(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception ex) {

        log.error(ex.getMessage());
        return R.failed();

    }
}
