package co.com.user.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@JsonInclude
@NoArgsConstructor
@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String number;
    @Column
    private String citycode;
    @Column
    private String contrycode;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User userp;

}
