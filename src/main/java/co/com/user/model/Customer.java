package co.com.user.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@JsonInclude
@Data
@SuperBuilder
@NoArgsConstructor
public class Customer {

    private String id;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
    private LocalDateTime lastLogin;
    private String token;
    private boolean isActive;


}
