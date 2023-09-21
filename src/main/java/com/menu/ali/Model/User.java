package com.menu.ali.Model;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



    @NotNull(message = "bu alanı boş geçilemez.")
    @NotBlank(message = "bu alan boş geçilemez.")
    @Column(name = "full_name")
    private String fullName;


    @NotNull(message = "Parola alanı boş geçilemez.")
    @NotBlank(message = "Parola alanı boş geçilemez.")
    @Column(name = "password")
    private String password;

}
