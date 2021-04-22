package limiters;

import enums.EnumLimiter;

public class LimiterFactory {

    public static Limiter getCountLimiter(EnumLimiter Enumlimiter, int qps) {

        return new LingPaiTongLimiter(qps);
    }

}