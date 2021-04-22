package limiters;

/**
 * 令牌桶限流算法
 */
public class LingPaiTongLimiter extends Limiter {

    final int capacity;
    int curTokenNum;
    long lastTime;

    LingPaiTongLimiter(int qps) {
        super(qps);
        capacity = qps;
        curTokenNum = 0;
        lastTime = 0;
    }

    @Override
    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();
        int intoToken = (int)((now - lastTime)/1000.0 * capacity);
        lastTime = now;
        if (intoToken + curTokenNum > capacity) {
            curTokenNum = capacity - 1;
            return true;
        } else if (intoToken + curTokenNum >= 1) {
            curTokenNum = intoToken + curTokenNum - 1;
            return true;
        } else return false;
    }
}

