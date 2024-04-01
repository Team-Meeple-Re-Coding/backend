package org.meetpl.recodingserver.global.error.exception;

import org.meetpl.recodingserver.global.error.ErrorCode;

public class ConflictException extends BusinessException {
    public ConflictException() {
        super(ErrorCode.CONFLICT);
    }

    public ConflictException(ErrorCode errorCode) {
        super(errorCode);
    }
}

