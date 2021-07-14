package co.com.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController {


    @RequestMapping("/users")
    public String getUsers(){
        return "All Users";
    }

}
