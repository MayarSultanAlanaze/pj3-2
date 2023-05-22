package com.example.demo.Cntroller;

import com.example.demo.Model.MerchantStock;
import com.example.demo.Model.Product;
import com.example.demo.Service.MerchantStockService;
import com.example.demo.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Product")

public class ProductCntroller {
    ArrayList<Product>products=new ArrayList<>();

    private final ProductService productService;

    @GetMapping("/get")
    public ArrayList get(){
        return products;

    }

    @PostMapping("/add")
    public ResponseEntity getProduct(@Valid @RequestBody Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new AipResponse(message));
        }
        products.add(product);
        return ResponseEntity.status(200).body(new AipResponse("Product add"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        products.remove(id);
        return ResponseEntity.status(200).body(new AipResponse("Product delete it"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@Valid @RequestBody Product product,int id,Errors errors){
        if (errors.hasErrors()) {

            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AipResponse(message));
        }
        products.set(id, product);
        return ResponseEntity.status(200).body(new AipResponse("message"));

    }

    public Object getProducts() {
    }
}

