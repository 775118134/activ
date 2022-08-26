package com.hmm.mht.activ.common.repository;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import com.hmm.mht.activ.common.constant.CommonConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author hmm
 * @date 2021/6/22 12:02
 * @Description:
 */
@Service()
@Configuration
public class GUIDLoadingCacheService implements LoadingCacheService {
    private LoadingCache<String, RateLimiter> guidRequestCaches = CacheBuilder.newBuilder()
            .maximumSize(CommonConstants.LIMITER_MAXIMUM_SIZE)
            .expireAfterWrite(1, TimeUnit.MINUTES)
            .build(new CacheLoader<String, RateLimiter>() {
                @Override
                public RateLimiter load(String s) throws Exception {
                    return RateLimiter.create(1);
                }
            });

    @Override
    public RateLimiter getLimiter(String sign) throws ExecutionException {
        return guidRequestCaches.get(sign);
    }
}
