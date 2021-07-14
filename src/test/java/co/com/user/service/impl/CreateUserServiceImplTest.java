package co.com.user.service.impl;

import co.com.user.model.Phone;
import co.com.user.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserServiceImplTest {

    @InjectMocks
    private CreateUserServiceImpl createUserServiceImpl;

    private  User user;

    @Before
    public void init(){
        user = User.builder().email("carlos.jose0294@gmail.com")
                .name("Carlos").password("123456").phones(Collections.singletonList(Phone.builder().citycode("5")
                        .contrycode("57").number("3554486234").build())).build();
    }

    @Test
    public void createNewUserShouldReturnUserTest(){
        User userResponse = createUserServiceImpl.createNewUser(user);
        assertTrue(userResponse.isActive());
        assertNotNull(userResponse.getCreatedTime());
        assertNotNull(userResponse.getId());
    }
}
