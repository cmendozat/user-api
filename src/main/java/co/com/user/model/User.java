package co.com.user.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@JsonInclude
@SuperBuilder
@NoArgsConstructor
public class User extends Customer {

    private String name;
    private String email;
    private String password;
    private List<Phone> phones;

}
