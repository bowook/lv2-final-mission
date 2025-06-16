package finalmission.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<String> handleDuplicateException(final DuplicateException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(final NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleMissingTokenException(final AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}
