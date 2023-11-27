package com.example.springboot.services;

import com.example.springboot.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products =new ArrayList<>();
    public long ID=0;
    {
        products.add(new Product(++ID,"Game","new",5000,"Ekaterinburg","Vadim"));
        products.add(new Product(++ID,"Game","old",2500,"Ekaterinburg","Misha"));
    }
    public List<Product> listProducts() {return products;}
    public void saveProduct(Product product){
        product.setId(++ID);
        products.add(product);
    }

    public  void deleteProduct(Long id){
        products.removeIf(product -> product.getId().equals(id));

    }

    public Product getProductById(Long id) {
        for (Product product:products){
            if (product.getId().equals(id))return product;
        }
        return null;
    }
}
