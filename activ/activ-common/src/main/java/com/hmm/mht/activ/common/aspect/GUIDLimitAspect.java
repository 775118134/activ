package com.hmm.mht.activ.common.aspect;

import com.google.common.util.concurrent.RateLimiter;
import com.hmm.mht.activ.common.repository.LoadingCacheService;
import com.hmm.mht.activ.common.result.BR;
import com.hmm.mht.activ.common.result.R;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hmm
 * @date 2021/6/22 15:08
 * @Description:
 */
@Component
@Scope
@Aspect
public class GUIDLimitAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LoadingCacheService loadingCacheService;

    @Pointcut("@annotation(GUIDLimit)")
    public void guidLimit() {

    }

    @Around("guidLimit()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;

        /**
         * TODO
         * 用户标识，可为手机、身份证等逻辑参数
         */
        String sign = null;

        RateLimiter limiter = loadingCacheService.getLimiter(sign);
        if (limiter.tryAcquire()) {
            obj = joinPoint.proceed();
        } else {
            obj = R.failed(BR.FAST_ACCESS_ERROR);
        }
        return obj;
    }

}