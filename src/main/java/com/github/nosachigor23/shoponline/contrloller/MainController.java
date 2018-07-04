package com.github.nosachigor23.shoponline.contrloller;

import com.github.nosachigor23.shoponline.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }
}
