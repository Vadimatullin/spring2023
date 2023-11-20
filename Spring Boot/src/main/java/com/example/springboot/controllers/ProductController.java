package com.example.springboot.controllers;

import com.example.springboot.services.ProductService;
import com.fasterxml.jackson.databind.Module;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*отвечает за прием всех запросов*/
@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public  String products(Model model){
        model.addAttribute("products",productService.listProducts());
        return "products";              /*товары*/

    }
}
