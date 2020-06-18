package com.twilight.currency.art.exception;

import java.text.MessageFormat;

/**
 * @Description:
 * @Author: guojun
 * @Date: 2020/6/15
 */
public interface BusinessExceptionAssert extends IResponseEnum, Assert{
    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg, t);
    }
}
