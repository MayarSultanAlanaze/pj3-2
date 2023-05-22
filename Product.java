package com.example.demo.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    @NotNull(message = "id should not be empty")
    @Min(value=100,message = "the id should be 3 character long")
    private int id;
    @NotEmpty
    @Size(min = 3,message = "the name should be 3 length long ")
    private String name;

    @NotNull(message = "price should not be empty")
    @Min(value =0)
    private double price;

    @NotEmpty(message = "categoryID should not be empte")
    @Min(value = 100,message = "the categoryID should be 3 character long ")
    private int categoryID;

}
