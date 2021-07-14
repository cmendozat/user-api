package co.com.user.controller;

import co.com.user.model.User;
import co.com.user.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class CreateUserController {

    private static final String HEADER = "Authorization";

    @Autowired
    private CreateUserService createUserService;

    @PostMapping(value = "/createuser")
    public ResponseEntity<User> createUser(@RequestBody final User user, HttpServletRequest request){
        user.setToken(request.getHeader(HEADER));
        return new ResponseEntity<User>(createUserService.createNewUser(user),
                HttpStatus.OK);
    }

}
