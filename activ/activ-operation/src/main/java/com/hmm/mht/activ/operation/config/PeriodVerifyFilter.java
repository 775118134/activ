package com.hmm.mht.activ.operation.config;

import com.hmm.mht.activ.common.exception.UnperiodException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author hmm
 * @date 2021/6/22 15:48
 * @Description:
 */
@WebFilter(filterName = "periodVerifyFilter", urlPatterns = "/*")
public class PeriodVerifyFilter implements Filter {
    @Autowired
    private MhtActiveVerify mhtActiveVerify;

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        if (mhtActiveVerify.verify()) {
            chain.doFilter(request, response);
        } else {
            throw new UnperiodException();
        }
    }
}
