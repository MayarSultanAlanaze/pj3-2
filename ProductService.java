package com.example.demo.Service;

import com.example.demo.Model.Category;
import com.example.demo.Model.Merchant;
import com.example.demo.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product>products=new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;

    }
    public boolean updateProduct(int id,Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id)
                products.set(i,product);
            return true;
        }
        return false;
    }

    public void addProduct(Product product) {
        products.add(product);
    }


    public boolean deleteProduct (int id ){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id)
                products.remove(i);
            return true;
        }
        return false;
    }
}
