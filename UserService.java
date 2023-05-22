package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

   ArrayList<User> users=new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;

    }
    public boolean updateUser(int id,User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id)
                users.set(i,user);
            return true;
        }
        return false;
    }

    public void addUser(User user) {
        users.add(user);
    }


    public static boolean deleteUser(int id){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id)
                users.remove(i);
            return true;
        }
        return false;
    }
}

