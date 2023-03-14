package com.example.server.entity;

import lombok.Data;
import javax.validation.constraints.NotNull;

import javax.persistence.*;


@Entity
@Data
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_name")
    @NotNull(message = "Имя пользователя не может быть пустым")
    private String name;
    @NotNull(message = "Пароль не можкет быть пустым")
    private String password;
    @NotNull
    private Boolean role;
}
