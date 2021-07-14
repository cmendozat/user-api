package co.com.user.validation.impl;

import co.com.user.model.Phone;
import co.com.user.model.User;
import co.com.user.model.exceptions.DuplicateUserException;
import co.com.user.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DuplicateValidationTest {

    @InjectMocks
    private DuplicateValidation duplicateValidation;

    @Mock
    private UserRepository userRepository;

    private  User user;

    @Before
    public void init(){
        user = User.builder().email("carlos.jose0294@gmail.com")
                .name("Carlos").password("123456").phones(Collections.singletonList(Phone.builder().citycode("5")
                        .contrycode("57").number("3554486234").build())).build();
    }

    @Test
    public void validateUserShouldThrowException(){
        when(userRepository.getUserByEmail(user.getEmail()))
                .thenReturn(user);
        try {
            duplicateValidation.validate(user);
        } catch (DuplicateUserException d){
            assertEquals("El correo ya registrado", d.getMessage());
        }
    }

    @Test
    public void validateUserNotShouldThrowException(){
        when(userRepository.getUserByEmail(user.getEmail()))
                .thenReturn(null);

            duplicateValidation.validate(user);

            verify(userRepository, times(1)).getUserByEmail(user.getEmail());
    }

}
