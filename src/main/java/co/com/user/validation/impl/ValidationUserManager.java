package co.com.user.validation.impl;

import co.com.user.model.User;
import co.com.user.repository.UserRepository;
import co.com.user.validation.IValidationUser;
import co.com.user.validation.IValidationUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ValidationUserManager implements IValidationUserManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("duplicateValidation")
    private IValidationUser duplicateValidation;

    private final List<IValidationUser> VALIDATIONS_USER = Arrays.asList(new EmailValidation(),
            new PasswordValidation());

    @Override
    public void validateUser(User user) {
        duplicateValidation.validate(user);
        VALIDATIONS_USER.forEach(iValidationUser -> iValidationUser.validate(user));
    }
}
