package co.com.user.validation.impl;

import co.com.user.model.User;
import co.com.user.validation.IValidationUser;
import co.com.user.validation.IValidationUserManager;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ValidationUserManager implements IValidationUserManager {

    private static final List<IValidationUser> VALIDATIONS_USER = Arrays.asList(new DuplicateValidation(),
            new EmailValidation(), new PasswordValidation());

    @Override
    public void validateUser(User user) {
        VALIDATIONS_USER.forEach(iValidationUser -> iValidationUser.validate(user));
    }
}
