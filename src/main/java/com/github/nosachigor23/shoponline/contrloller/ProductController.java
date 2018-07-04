package com.github.nosachigor23.shopOnline.contrloller;

import com.github.nosachigor23.shopOnline.model.AProductEntity;
import com.github.nosachigor23.shopOnline.model.ProductFactory.ProductFactory;
import com.github.nosachigor23.shopOnline.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private static final Logger LOG = Logger.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;

    @GetMapping("product/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        AProductEntity editProduct = productService.getProductById(id);
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
        productService.deleteProductById(id);
        return "index";
    }

    @PostMapping("product/save")
    public String saveProduct(@ModelAttribute("productInstance") AProductEntity aProductEntity) {
        productService.saveOrUpdateProduct(aProductEntity);
        LOG.info(aProductEntity + "product was saved!");
        return "redirect:/";
    }

    @ModelAttribute("productInstance")
    public AProductEntity getProductInstance(@RequestParam(value = "product", required = false) String product,
                                             @RequestParam(value = "id", required = false) Integer editObjectId) {
        if (editObjectId != null) {
            return productService.getProductById(editObjectId);
        } else {
            return ProductFactory.getProductInst(product);
        }
    }

    private String getPathToViewDependsOnProductType(AProductEntity editProduct) {
        return "add" + editProduct.getClass().getSimpleName().replaceAll("Entity", "");
    }
}
