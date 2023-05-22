package com.example.demo.Service;

import com.example.demo.Model.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;

@Service
public class CategoryService {
    ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> getCategories() {
        return categories;

    }
    public boolean updateCategory(int id, Category category) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id)
                categories.set(i, category);
            return true;
        }
        return false;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }


        public boolean deleteCategory (int id ){
            for (int i = 0; i < categories.size(); i++) {
                if (categories.get(i).getId() == id)
                  categories.remove(i);
                return true;
            }
            return false;
        }
    }



