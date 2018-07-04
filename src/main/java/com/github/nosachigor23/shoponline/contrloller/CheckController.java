package com.github.nosachigor23.shopOnline.contrloller;

import com.github.nosachigor23.shopOnline.model.AProductEntity;
import com.github.nosachigor23.shopOnline.model.CheckProduct;
import com.github.nosachigor23.shopOnline.repositories.CheckRepository;
import com.github.nosachigor23.shopOnline.repositories.ProductsRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

@Controller
public class CheckController {

    private static final Logger LOG = Logger.getLogger(ProductController.class);
    private final CheckRepository checkRepository;
    private final ProductsRepository productsRepository;


    @Autowired
    public CheckController(CheckRepository checkRepository, ProductsRepository productsRepository) {
        this.checkRepository = checkRepository;
        this.productsRepository = productsRepository;
    }

    @GetMapping(value = "product/buy/{id}")
    public String buyProduct(@PathVariable Integer id, Model model) {
        AProductEntity purchaseProduct = productsRepository.findOne(id);
        CheckProduct checkProduct = changingStatusProductToCheck(purchaseProduct);
        model.addAttribute("check", checkProduct);
        return "confirmationPurchase";
    }

    @GetMapping(value = "product/buy/yes/{id}")
    public String finalPurchase(@PathVariable Integer id, Model model) {
        AProductEntity purchaseProduct = productsRepository.findOne(id);
        CheckProduct checkProduct = changingStatusProductToCheck(purchaseProduct);
        productsRepository.delete(purchaseProduct.getId());
        checkRepository.save(checkProduct);
        model.addAttribute("complete", true);
        LOG.info("Purchase product " + purchaseProduct + " was successfully");
        return "redirect:/";
    }

    @GetMapping(value = "soldProducts")
    public String showSoldProducts(Model model) {
        model.addAttribute("soldProducts", checkRepository.findAll());
        return "soldProducts";
    }

    private CheckProduct changingStatusProductToCheck(final AProductEntity purchaseProduct) {
        CheckProduct checkProduct = new CheckProduct();
        checkProduct.setId_product(purchaseProduct.getId());
        checkProduct.setAmount(purchaseProduct.getAmount());
        checkProduct.setDateSale(LocalDateTime.now());
        checkProduct.setDiscount(purchaseProduct.getDiscount());
        checkProduct.setPrice(purchaseProduct.getPrice());
        checkProduct.setInfo(purchaseProduct.toString());
        return checkProduct;
    }

}
