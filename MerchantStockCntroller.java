package com.example.demo.Cntroller;

import com.example.demo.Model.Merchant;
import com.example.demo.Model.MerchantStock;
import com.example.demo.Service.MerchantService;
import com.example.demo.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequiredArgsConstructor
@RequestMapping ("/api/v1/MerchantStock")

public class MerchantStockCntroller {
    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ArrayList get() {
        return merchantStocks;

    }

    @PostMapping("/add")
    public ResponseEntity getMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new AipResponse(message));
        }
        merchantStocks.add(merchantStock);
        return ResponseEntity.status(200).body(new AipResponse("merchantStock add"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable int id) {
        merchantStocks.remove(id);
        return ResponseEntity.status(200).body(new AipResponse("MerchantStock delete it"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@Valid @RequestBody MerchantStock merchantStock, int id, Errors errors) {
        if (errors.hasErrors()) {

            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AipResponse(message));
        }
        merchantStocks.set(id, merchantStock);
        return ResponseEntity.status(200).body(new AipResponse("message"));
    }
    //aaddproduct
   @PutMapping("/update/{merchantID},{productId},{stock}")
    public ResponseEntity addProduct(@Valid @PathVariable int merchantId, int productId, int stock, Errors errors, @PathVariable String id) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new AipResponse(message));
        }
        boolean Addit=MerchantStockService.addProduct( productId,merchantId,stock);
        if (Addit){
            String message=errors.getFieldError().getDefaultMessage(productId,merchantId,stock);
            return ResponseEntity.status(200).body("Add it Succssufully");
        }
        return ResponseEntity.status(400).body("wrong id");
    }
}

