package co.com.user.validation.impl;

import co.com.user.model.User;
import co.com.user.model.exceptions.PasswordInvalidException;
import co.com.user.validation.IValidationUser;

import java.util.regex.Pattern;

public class PasswordValidation implements IValidationUser {

    private static final String EXPRESION = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$";

    private Pattern pattern = Pattern.compile(EXPRESION);

    @Override
    public void validate(User user) {
        String password = user.getPassword();
        if(!pattern.matcher(password).matches()){
            throw new PasswordInvalidException(password);
        }

    }
}
