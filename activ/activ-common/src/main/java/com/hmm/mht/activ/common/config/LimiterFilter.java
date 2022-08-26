package com.hmm.mht.activ.common.config;

import cn.hutool.extra.servlet.ServletUtil;
import com.google.common.util.concurrent.RateLimiter;
import com.hmm.mht.activ.common.constant.CommonConstants;
import com.hmm.mht.activ.common.exception.FastAccessException;
import com.hmm.mht.activ.common.repository.LoadingCacheService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * @author hmm
 * @date 2021/6/22 11:54
 * @Description:
 */
//@WebFilter(filterName = "limiterFilter", urlPatterns = "/*")
@WebFilter(filterName = "limiterFilter", urlPatterns = "/sms/*")
public class LimiterFilter implements Filter {
    @Autowired
    private LoadingCacheService loadingCacheService;

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        String sign = ServletUtil.getHeaderIgnoreCase((HttpServletRequest) request, CommonConstants.LIMITER_LABEL);
        RateLimiter limiter = loadingCacheService.getLimiter(sign);
        if (limiter.tryAcquire()) {
            chain.doFilter(request, response);
        } else {
            throw new FastAccessException();
        }
    }
}
