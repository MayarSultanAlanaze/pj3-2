package com.example.demo.Cntroller;

import com.example.demo.Model.Category;
import com.example.demo.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Category")
@RequiredArgsConstructor

public class CategoryCntroller {
    ArrayList<Category>categoryees=new ArrayList<>();

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ArrayList get(){
        return categoryees;

    }

    @PostMapping("/add")
    public ResponseEntity getCategory(@Valid @RequestBody Category category,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new AipResponse(message));
        }
        categoryees.add(category);
        return ResponseEntity.status(200).body(new AipResponse("category add"));
    }
       @DeleteMapping("/delete/{Category}")
        public ResponseEntity deleteCategory(@PathVariable int index) {
        categoryees.remove(index);
            return ResponseEntity.status(200).body(new AipResponse(" Category delete it"));
        }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@Valid @RequestBody Category category,int index,Errors errors){
        if (errors.hasErrors()) {

            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AipResponse(message));
        }
        categoryees.set(index, category);
        return ResponseEntity.status(200).body(new AipResponse("message"));

    }
    }



