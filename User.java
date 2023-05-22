package com.example.demo.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class User {

    @NotNull
    @Size(min = 3,message = "the id should be 3 character long")
    private int id;

    @NotEmpty
    @Size(min = 5,message = "the usename should be 5 length long ")
    private String username;

    @NotEmpty
    @Size(max = 3,message = "the password should have to be 6 length and be have characters and digits")
    private String password;

    @NotEmpty
    @Email(message = "The email should be valid")
    private String Email;

    @NotEmpty(message = "should be an Admin OR Customer")
    @Pattern(regexp = "Admin|Customer")
    private String role;


    @NotNull
    @Positive(message = "the balance should be positive")
    private int balance;
}
