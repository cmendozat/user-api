package co.com.user.model.exceptions;

import org.springframework.http.HttpStatus;

public enum SupportedException {

    NULL_POINTER_EXCEPTION(NullPointerException.class, HttpStatus.INTERNAL_SERVER_ERROR),
    EXIST_EMAIL(DuplicateUserException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    EMAIL_INVALID(EmailInvalidException.class,HttpStatus.UNPROCESSABLE_ENTITY ),
    PASSWORD_INVALID(PasswordInvalidException.class, HttpStatus.UNPROCESSABLE_ENTITY);

    private  Class<? extends Throwable> exceptionClass;
    private HttpStatus status;

    private SupportedException(Class<? extends Throwable> exception, HttpStatus status) {
        this.exceptionClass = exception;
        this.status = status;
    }

    public Class<? extends Throwable> getExceptionClass() {
        return this.exceptionClass;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
