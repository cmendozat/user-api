package co.com.user.validation.impl;

import co.com.user.model.User;
import co.com.user.model.exceptions.EmailInvalidException;
import co.com.user.validation.IValidationUser;

import java.util.regex.Pattern;

public class EmailValidation implements IValidationUser {

    private static final String EXPRESION = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$";

    private Pattern pattern = Pattern.compile(EXPRESION);

    @Override
    public void validate(User user) {
        String email = user.getEmail();
        if(!pattern.matcher(email).matches()){
            throw new EmailInvalidException(email);
        }
    }
}
