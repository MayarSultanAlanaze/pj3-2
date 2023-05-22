package com.example.demo.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {

    @NotNull
    @Size(min = 3,message = "the id should be 3 character long")
    private int id;
    @NotNull
    @Size(min = 3,message = "the name should be 3 length long")
    private String name;

}

