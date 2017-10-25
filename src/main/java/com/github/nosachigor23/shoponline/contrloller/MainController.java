package com.github.nosachigor23.shoponline.contrloller;

import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.AccessoriesEntity;
import com.github.nosachigor23.shoponline.model.DisplayEntity;
import com.github.nosachigor23.shoponline.model.ProductFactory.ProductFactory;

import com.github.nosachigor23.shoponline.repositories.CheckRepository;
import com.github.nosachigor23.shoponline.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    private   final ProductsRepository productsRepository;


    public MainController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/")
    public String index(Model model) {



        model.addAttribute("products",productsRepository.findAll());

        return "index";
    }


    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model,HttpServletResponse response){
        Cookie cookie = new Cookie("edit","true");
        response.addCookie(cookie);
        AProductEntity editProduct = productsRepository.findOne(id);
        model.addAttribute("productInstance",editProduct);
        model.addAttribute("edit",true);
        return "add" +editProduct.getClass().getSimpleName().replaceAll("Entity","") ;
    }


    @RequestMapping(value = "addProduct", method = RequestMethod.POST)
    public String addProduct(@RequestParam(value="product") String type,Model model ) throws Exception {

            model.addAttribute("productInstance", ProductFactory.getProductInst(type));

            return "add" + type;

    }

    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        System.out.println(id);
        productsRepository.delete(id);
        return "redirect:/";
    }



}
