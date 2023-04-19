package com.codegym.casestudy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 50)
    private String name;

    @NotBlank
    @Size(min = 5, max = 50)
    private String username;

    @JsonIgnore
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NaturalId
    @NotBlank
    @Email
    @Size(max = 50)
    private String email;

    @NotBlank
    @Min(18)
    private int age;

    @NotBlank
    @Pattern(regexp = "^0\\d{9}$", message = "Phone number must be a 10-digit number starting with 0")
    private String phone;

    @Max(255)
    private String address;

    @Lob
    private String avatar;

    private boolean activated = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles = new ArrayList<>();
}
