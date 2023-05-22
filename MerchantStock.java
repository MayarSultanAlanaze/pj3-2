package com.example.demo.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {

    @NotNull(message = "id should not be empty")
    @Min(value = 100,message = "the id should be 3 character long")
    private int id;
    @NotEmpty(message = "productID should not be empty")
    @Min(value =100 ,message = "the id productID be 3 character long")
    private int productID;
    @NotEmpty(message = "merchantID should not be empty")
    @Min(value =100,message = "the merchantID should be 3 length long ")
    private int merchantID;
    @NotNull(message = "stock should not be empty")
    @Min(value = 100,message = "the stock should be more 10 at start")
    private int stock;

}
