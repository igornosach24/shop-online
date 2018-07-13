package com.github.nosachigor23.shoponline.contrloller;

import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.PurchaseCheck;
import com.github.nosachigor23.shoponline.services.ProductService;
import com.github.nosachigor23.shoponline.services.PurchaseCheckService;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@NoArgsConstructor
public class CheckController {

    private static final Logger LOG = Logger.getLogger(ProductController.class);

    @Autowired
    private PurchaseCheckService purchaseCheckService;
    @Autowired
    private ProductService productService;
    @GetMapping(value = "product/buy/{id}")
    public String buyProduct(@PathVariable Integer id, Model model) {
        AProductEntity purchaseProduct = productService.getProductById(id);
        PurchaseCheck purchaseCheck = purchaseCheckService.convertProductToCheck(purchaseProduct);
        model.addAttribute("check", purchaseCheck);
        return "confirmationPurchase";
    }

    @GetMapping(value = "product/buy/yes/{id}")
    public String finalPurchase(@PathVariable Integer id, Model model) {
        AProductEntity purchaseProduct = productService.getProductById(id);
        PurchaseCheck purchaseCheck = purchaseCheckService.convertProductToCheck(purchaseProduct);
        productService.deleteProductById(purchaseProduct.getId());
        purchaseCheckService.saveOrUpdatePurchaseCheck(purchaseCheck);
        model.addAttribute("complete", true);
        LOG.info("Purchase product " + purchaseProduct + " was successfully");
        return "redirect:/";
    }

    @GetMapping(value = "soldProducts")
    public String showSoldProducts(Model model) {
        model.addAttribute("soldProducts",  purchaseCheckService.getAllPurchaseChecks());
        return "soldProducts";
    }
}
