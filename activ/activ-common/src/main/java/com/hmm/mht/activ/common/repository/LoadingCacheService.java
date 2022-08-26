package com.hmm.mht.activ.common.repository;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutionException;

/**
 * @author hmm
 * @date 2021/6/22 14:41
 * @Description:
 */
public interface LoadingCacheService {
    RateLimiter getLimiter(String sign) throws ExecutionException;
}
