package co.com.user.model.exceptions;

public class PasswordInvalidException extends RuntimeException {

    public PasswordInvalidException(String password){
        super(String.format("Password %s isn't valid", password));
    }
}
