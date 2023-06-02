package Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;

    @NotNull
    @Column(unique = true)
    @Email
    public String mailAddress;

    @NotNull
    @Column(unique = true)
    @Min(6)
    public String nickname;

    @NotNull
    @Column
    @Min(10)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
             message = "Le mot de pass doit contenir au moins une lettre MAJUSCULE, une lettre minuscule et un chiffre")
    public String password;
}
