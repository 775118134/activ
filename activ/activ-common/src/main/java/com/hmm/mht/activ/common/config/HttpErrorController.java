package com.hmm.mht.activ.common.config;

import com.hmm.mht.activ.common.exception.FastAccessException;
import com.hmm.mht.activ.common.exception.UnperiodException;
import com.hmm.mht.activ.common.result.BR;
import com.hmm.mht.activ.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hmm
 * @date 2021/6/22 17:23
 * @Description: *  异常统一处理
 */

@Slf4j
@RestController
public class HttpErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    @ResponseBody
    @RequestMapping(path = ERROR_PATH)
    public R error(HttpServletRequest request, HttpServletResponse response) {
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        if (throwable != null) {
            if (throwable.getCause() instanceof FastAccessException) {
                return R.failed(BR.FAST_ACCESS_ERROR);
            } else if (throwable.getCause() instanceof UnperiodException) {
                return R.failed(BR.UNPERIOD_ERROR);
            }
        }
        return R.failed();
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}