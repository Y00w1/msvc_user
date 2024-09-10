package com.microservice.user.infrastructure.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String idDocument;
    private String phone;
    private LocalDate birthDate;
    private String email;
    private String password;
    @ManyToOne
    private RoleEntity role;

    public UserEntity() {
    }
}
