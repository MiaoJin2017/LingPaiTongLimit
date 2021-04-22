package limiters;

import enums.EnumLimiter;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class AcInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod)handler;
            AcLimit acLimit = hm.getMethodAnnotation(AcLimit.class);
            if (acLimit == null) {
                return true;
            }

            int qps = acLimit.qps();
            EnumLimiter Enumlimiter = acLimit.Enumlimiter();

            Limiter limiter = LimiterFactory.getCountLimiter(Enumlimiter, qps);
            return limiter.tryAcquire();
        }
        return true;
    }
}