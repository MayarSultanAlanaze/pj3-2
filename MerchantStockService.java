package com.example.demo.Service;


import com.example.demo.Model.Category;
import com.example.demo.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;

    }

    public boolean updateCategory(int id, MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id)
                merchantStocks.set(i, merchantStock);
            return true;
        }
        return false;
    }

    // public void addMerchantStock(MerchantStock merchantStock) {
    //   merchantStocks.add(merchantStock);
    public boolean addStock(int merchantId, int productId, int stock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getProductID() == productId && merchantStocks.get(i).getMerchantID() == merchantId) {
                merchantStocks.get(i).setStock(merchantStocks.get(i).getStock() + stock);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCategory(int id) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id) {
                if (merchantStocks.get(i).getStock() > 0) {
                    merchantStocks.get(i).setStock(merchantStocks.get(i).getStock() - 1);
                    return true;
                }
            }
        }
        return false;
    }
}


