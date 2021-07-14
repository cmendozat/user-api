package co.com.user.model.exceptions;

public class EmailInvalidException extends RuntimeException {

    public EmailInvalidException(String email){
        super(String.format("Email %s isn't valid", email));
    }
}
