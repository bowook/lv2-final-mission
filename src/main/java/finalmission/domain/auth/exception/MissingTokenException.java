package finalmission.domain.auth.exception;

import finalmission.infrastructure.exception.AuthenticationException;

public class MissingTokenException extends AuthenticationException {
    public MissingTokenException(final String message) {
        super(message);
    }
}
