package co.com.user.validation.impl;

import co.com.user.model.User;
import co.com.user.model.exceptions.PasswordInvalidException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PasswordValidationTest {

    @InjectMocks
    private PasswordValidation passwordValidation;
    @Mock
    private User user;

    @Test
    public void validateEmailShouldThrowPasswordValidationExceptionWhenEmailIsInvalid(){
        when(user.getPassword()).thenReturn("carlos123");

        try {
            passwordValidation.validate(user);
        }catch (PasswordInvalidException p){
            assertEquals("Password carlos123 isn't valid", p.getMessage());
            return;
        }
        fail();
    }

    @Test
    public void validateEmailShouldntThrowPasswordValidationExceptionWhenEmailIsValid(){
        when(user.getPassword()).thenReturn("Carlos12");

        passwordValidation.validate(user);

        verify(user, times(1)).getPassword();
    }
}
