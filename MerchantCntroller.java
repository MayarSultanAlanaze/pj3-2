package com.example.demo.Cntroller;

import com.example.demo.Model.Category;
import com.example.demo.Model.Merchant;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/Merchant")
@RequiredArgsConstructor
public class MerchantCntroller {
    ArrayList<Merchant> merchants = new ArrayList<>();

    private final MerchantService merchantService;

    @GetMapping("/get")
    public ArrayList get() {
        return merchants;

    }

    @PostMapping("/add")
    public ResponseEntity getMerchant(@Valid @RequestBody Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new AipResponse(message));
        }
        merchants.add(merchant);
        return ResponseEntity.status(200).body(new AipResponse("merchant add"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable int id) {
        merchants.remove(id);
        return ResponseEntity.status(200).body(new AipResponse("merchant delete it"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@Valid @RequestBody Merchant merchant, int id, Errors errors) {
        if (errors.hasErrors()) {

            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AipResponse(message));
        }
        merchants.set(id, merchant);
        return ResponseEntity.status(200).body(new AipResponse("message"));
    }
}

