package co.com.user.service.impl;

import co.com.user.model.User;
import co.com.user.service.CreateUserService;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateUserServiceImpl implements CreateUserService {

    private static final Logger LOG = Logger.getLogger(CreateUserServiceImpl.class);

    @Override
    public User createNewUser(final User user) {
        setCustommerData(user);
        return user;
    }

    private void setCustommerData(final User user){
        user.setId("ddsfd5fdgfd");
        user.setCreatedTime(LocalDateTime.now());
        user.setModifiedTime(LocalDateTime.now());
        user.setActive(true);
    }
}
