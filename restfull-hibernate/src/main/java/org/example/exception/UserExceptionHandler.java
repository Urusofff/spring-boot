package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<UserException> handeUserNotFoundException(UserNotFoundException userNotFoundException) {
        UserException userException = new UserException(
                userNotFoundException.getMessage(),
                userNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(userException, userException.httpStatus());
    }

    @ExceptionHandler(value = UserExistingEmailException.class)
    public ResponseEntity<UserException> handeUserExistingEmailException(UserExistingEmailException userExistingEmailException) {
        UserException userException = new UserException(
                userExistingEmailException.getMessage(),
                userExistingEmailException.getCause(),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(userException, userException.httpStatus());
    }
}
