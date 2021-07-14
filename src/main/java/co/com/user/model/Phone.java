package co.com.user.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude
@NoArgsConstructor
public class Phone {

    private String number;
    private String citycode;
    private String contrycode;

}
