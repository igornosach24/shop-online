package com.github.nosachigor23.shoponline.contrloller;

import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.ProductFactory.ProductFactory;
import com.github.nosachigor23.shoponline.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductSaveController {
    @Autowired
    private ProductService productServiceImp;
    private static final Logger LOG = Logger.getLogger(ProductSaveController.class);

    @PostMapping("product/save")
    public String saveProduct(@ModelAttribute("productInstance") AProductEntity aProductEntity) {
        productServiceImp.saveOrUpdateProduct(aProductEntity);
        LOG.info(aProductEntity + "product was saved!");
        return "redirect:/";
    }

    @ModelAttribute("productInstance")
    public AProductEntity getProductInstance(@RequestParam(value = "product") String product,
                                             @RequestParam(value = "id", required = false) Integer editObjectId) {
        if (editObjectId != null) {
            return productServiceImp.getProductById(editObjectId);
        } else {
            return ProductFactory.getProductInst(product);
        }
    }

}
