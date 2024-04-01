package org.meetpl.recodingserver.global.error.exception;

import org.meetpl.recodingserver.global.error.ErrorCode;

public class InternalServerException extends BusinessException {
    public InternalServerException(ErrorCode errorCode) {
        super(errorCode);
    }
}
