package service;

import enums.EnumLimiter;
import limiters.Limiter;
import limiters.LimiterFactory;
import org.springframework.stereotype.Service;

/**
 * qps一秒10个请求
 */
@Service
public class AcLimitService {

    private Limiter rateLimiter = LimiterFactory.getCountLimiter(EnumLimiter.RATE_LIMITER, 10);

    //令牌桶算法
    public boolean rateLimiterAcquire() {
        return rateLimiter.tryAcquire();
    }

}