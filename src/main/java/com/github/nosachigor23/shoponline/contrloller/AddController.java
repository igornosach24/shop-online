package com.github.nosachigor23.shoponline.contrloller;

import com.github.nosachigor23.shoponline.model.*;
import com.github.nosachigor23.shoponline.model.ProductFactory.FactoryException;
import com.github.nosachigor23.shoponline.model.ProductFactory.ProductFactory;
import com.github.nosachigor23.shoponline.repositories.CheckRepository;
import com.github.nosachigor23.shoponline.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AddController {

    private   final ProductsRepository productsRepository;

    public AddController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    @ModelAttribute("productInstance")
    public AProductEntity getProductInstance(@RequestParam(value="product",required = false) String product) throws FactoryException {
       return ProductFactory.getProductInst(product);
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public   String saveProduct(@ModelAttribute("productInstance")AProductEntity aProductEntity, @CookieValue("edit") String edit, HttpSession session) throws IllegalAccessException, InstantiationException {

        if (edit.equalsIgnoreCase("true")){
            AProductEntity aProductEntity1= productsRepository.findOne(aProductEntity.getId()-1);
            if(aProductEntity1!=null)productsRepository.save(aProductEntity1);

        }
        productsRepository.save(aProductEntity);


        return  "redirect:/";
    }

}