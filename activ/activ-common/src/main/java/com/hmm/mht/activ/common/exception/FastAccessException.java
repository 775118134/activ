package com.hmm.mht.activ.common.exception;

import com.hmm.mht.activ.common.result.BR;

/**
 * @author hmm
 * @date 2021/6/22 17:56
 * @Description:
 */
public class FastAccessException extends Exception {

    @Override
    public String getMessage() {
        return BR.FAST_ACCESS_ERROR.getMsg();
    }
}
