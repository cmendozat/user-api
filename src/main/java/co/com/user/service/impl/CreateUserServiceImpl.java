package co.com.user.service.impl;

import co.com.user.model.User;
import co.com.user.repository.UserRepository;
import co.com.user.service.CreateUserService;
import co.com.user.validation.IValidationUserManager;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateUserServiceImpl implements CreateUserService {

    private static final Logger LOG = Logger.getLogger(CreateUserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IValidationUserManager iValidationUserManager;

    @Override
    public User createNewUser(final User user) {
        iValidationUserManager.validateUser(user);
        setCustommerData(user);
        userRepository.save(user);
        return user;
    }

    private void setCustommerData(final User user){
        //user.setId(1);
        user.setCreatedTime(LocalDateTime.now());
        user.setModifiedTime(LocalDateTime.now());
        user.setActive(true);
    }
}
