package co.com.user.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@JsonInclude
@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "customers")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private LocalDateTime createdTime;
    @Column
    private LocalDateTime modifiedTime;
    @Column
    private LocalDateTime lastLogin;
    @Column
    private String token;
    @Column
    private boolean isActive;


}
