package co.com.user.validation.impl;

import co.com.user.model.User;
import co.com.user.model.exceptions.DuplicateUserException;
import co.com.user.repository.UserRepository;
import co.com.user.validation.IValidationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Qualifier("duplicateValidation")
public class DuplicateValidation implements IValidationUser {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(User user) {
        User userResult = userRepository.findByEmail(user.getEmail());
        if(Optional.ofNullable(userResult).isPresent()){
            throw new DuplicateUserException();
        }
    }
}
