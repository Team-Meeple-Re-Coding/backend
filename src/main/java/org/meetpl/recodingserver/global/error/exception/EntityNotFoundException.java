package org.meetpl.recodingserver.global.error.exception;

import org.meetpl.recodingserver.global.error.ErrorCode;

public class EntityNotFoundException extends BusinessException {
    public EntityNotFoundException() {
        super(ErrorCode.ENTITY_NOT_FOUND);
    }

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
