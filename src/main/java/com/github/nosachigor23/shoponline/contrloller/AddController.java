package com.github.nosachigor23.shoponline.contrloller;

import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.ProductFactory.FactoryException;
import com.github.nosachigor23.shoponline.model.ProductFactory.ProductFactory;
import com.github.nosachigor23.shoponline.repositories.ProductsRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddController {

	private static final Logger LOG = Logger.getLogger(AddController.class);

	private final ProductsRepository productsRepository;

	public AddController(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}


	@ModelAttribute("productInstance")
	public AProductEntity getProductInstance(@RequestParam(value = "product", required = false) String product,
	                                         @RequestParam(value = "id", required = false) Integer edit)
			throws FactoryException {
		if (edit != null) {
			return productsRepository.findOne(edit);
		}

		return ProductFactory.getProductInst(product);
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("productInstance") AProductEntity aProductEntity)
			throws IllegalAccessException, InstantiationException {

		productsRepository.save(aProductEntity);

		LOG.error(productsRepository + "was created");

		return "redirect:/";

	}

}