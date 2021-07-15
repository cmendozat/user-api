package co.com.user.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@JsonInclude
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends Customer {

    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @OneToMany(mappedBy = "userp")
    private List<Phone> phones;

}
