package co.com.user.validation.impl;

import co.com.user.model.User;
import co.com.user.model.exceptions.DuplicateUserException;
import co.com.user.repository.UserRepository;
import co.com.user.validation.IValidationUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DuplicateValidation implements IValidationUser {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(User user) {
        User userResult = userRepository.getUserByEmail(user.getEmail());
        if(Optional.ofNullable(userResult).isPresent()){
            throw new DuplicateUserException();
        }
    }
}
