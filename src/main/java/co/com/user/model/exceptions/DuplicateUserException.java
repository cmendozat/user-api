package co.com.user.model.exceptions;

public class DuplicateUserException extends RuntimeException {

    public DuplicateUserException(){
        super("El correo ya registrado");
    }
}
