package controller;

import enums.EnumLimiter;
import limiters.AcLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import result.Result;
import result.info;
import service.AcLimitService;

@Controller
public class AcLimitController {

    @Autowired
    private AcLimitService accessLimitService;

    @RequestMapping("/RateLimiter")
    @ResponseBody
    @AcLimit(qps = 10, Enumlimiter = EnumLimiter.MYRATE_LIMITER)
    public Result rateLimiter() {
        if (accessLimitService.rateLimiterAcquire()) {
            return new Result(info.ACQUIRE_SUCCESS);
        }
        return new Result(info.ACQUIRE_LIMITED);
    }
}