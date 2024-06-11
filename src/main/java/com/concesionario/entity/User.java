package com.concesionario.entity;

import java.time.LocalDateTime;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @JsonIgnore
    @Column(name = "username")
    private String username;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_rol")
    private String rol ="ROLE_USER";

    @Column(unique = true, name = "user_email")
    private String email;

    @Column(name = "user_dni")
    private String dni;

    @Column(name = "user_firstName")
    private String firstName;

    @Column(name = "user_secondLastName")
    private String secondLastName;

    @Column(name = "user_birthday")
    private String birthday;

    @Column(name = "user_phone")
    private String phone;

    @Column(name = "user_address")
    private String address;

    @Column(name = "user_country")
    private String country;

    @Column(name = "user_province")
    private String province;

    @Column(name = "registration_date")
    private Date registrationDate;

    public void setRegistrationDate(Date date) {
        this.registrationDate = date;
    }
    
    @Column(name = "password_reset_token")
    private String passwordResetToken;

    @Column(name = "password_reset_token_generated_at")
    private LocalDateTime passwordResetTokenGeneratedAt;

}