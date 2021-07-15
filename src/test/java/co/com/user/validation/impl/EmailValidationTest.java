package co.com.user.validation.impl;

import co.com.user.model.Phone;
import co.com.user.model.User;
import co.com.user.model.exceptions.EmailInvalidException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailValidationTest {

    @InjectMocks
    private EmailValidation emailValidation;

    private User user;


    @Before
    public void init(){
        user = User.builder().email("carlos.jose0294@gmail.com")
                .name("Carlos").password("123456").phones(Collections.singletonList(Phone.builder().citycode("5")
                        .contrycode("57").number("3554486234").build())).build();
    }

    @Test
    public void validateShouldThrowEmailValidationExceptionWhenEmailIsInvalidTest(){
         user.setEmail("algo@dominio");

         try {
             emailValidation.validate(user);
         }catch (EmailInvalidException e){
             assertEquals("Email algo@dominio isn't valid", e.getMessage());
             return;
         }
         fail();
    }

    @Test
    public void validateShouldntThrowEmailValidationExceptionWhenEmailIsValidTest(){
        User userMock = mock(User.class);
        when(userMock.getEmail()).thenReturn(user.getEmail());
        emailValidation.validate(userMock);
        verify(userMock, times(1)). getEmail();
    }
}
