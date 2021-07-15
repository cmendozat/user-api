package co.com.user.controller;


import co.com.user.model.Phone;
import co.com.user.model.User;
import co.com.user.service.CreateUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserControllerTest {

    private  User user;
    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private CreateUserController createUserController;

    @Mock
    private CreateUserService createUserService;


    @Before
    public void init(){
         user = User.builder().email("carlos.jose0294@gmail.com")
                .name("Carlos").password("123456").phones(Collections.singletonList(Phone.builder().citycode("5")
                        .contrycode("57").number("3554486234").build())).build();
    }

    @Test
    public void createUserShouldReturn200WithUser(){

       User userResponse = User.builder().email("carlos.jose0294@gmail.com")
                .name("Carlos").password("123456").phones(Collections.singletonList(Phone.builder().citycode("5")
                        .contrycode("57").number("3554486234").build()))
               .id(1).isActive(true).build();

        when(createUserService.createNewUser(user))
                .thenReturn(userResponse);

        ResponseEntity<User> response  = createUserController.createUser(user, request);

        try {
            User userReponseCall = response.getBody();
            assertEquals(user.getEmail(), userReponseCall.getEmail());
            assertNotNull(userReponseCall.getId());
            assertTrue(userReponseCall.isActive());
        }catch (Exception e){
            fail();
        }

    }

    @Test
    public void createUserShouldReturErrorMessage(){

        doThrow(new Exception("Email is not valid"))
                .when(createUserService)
                .createNewUser(user);
        try {

            ResponseEntity<User> response = createUserController.createUser(user, request);
        }catch (Exception e){
            assertEquals("{\"mensaje\": \"Email is not valid\"}", e.getMessage());
        }

    }

}
