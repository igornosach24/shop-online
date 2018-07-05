package com.github.nosachigor23.shoponline.contrloller;

import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.ProductFactory.ProductFactory;
import com.github.nosachigor23.shoponline.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private static final Logger LOG = Logger.getLogger(ProductController.class);
    @Autowired
    private ProductService productServiceImp;

    @GetMapping("product/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        AProductEntity editProduct = productServiceImp.getProductById(id);
        model.addAttribute("productInstance", editProduct);
        model.addAttribute("edit", true);
        return getPathToViewDependsOnProductType(editProduct);
    }

    @PostMapping(value = "product/add")
    public String getProductPathForSaving(@RequestParam(value = "product") String type, Model model) {
        model.addAttribute("productInstance", ProductFactory.getProductInst(type));
        return "add" + type;
    }

    @GetMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        LOG.info("Product with id " + id + " was delete!");
        productServiceImp.deleteProductById(id);
        return "index";
    }


    private String getPathToViewDependsOnProductType(AProductEntity editProduct) {
        return "add" + editProduct.getClass().getSimpleName().replaceAll("Entity", "");
    }
}
