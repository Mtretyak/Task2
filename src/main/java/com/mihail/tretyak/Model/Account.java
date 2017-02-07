package com.mihail.tretyak.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@Data
public class Account {

    private String lastName;

    private String firstName;

    private String birthDate;

    private String email;

    private String password;

    private void setEncodedPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    private void setBirthDate(Date birthDate) {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yy");
        this.birthDate = date.format(birthDate);
    }

    @JsonCreator
    public Account(@JsonProperty("lastName") String lastName, @JsonProperty("firstName") String firstName,
                   @JsonProperty("birthDate") Date birthDate, @JsonProperty("email") String email,
                   @JsonProperty("password") String password) {

        setBirthDate(birthDate);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setEncodedPassword(password);
    }
}