package com.github.nosachigor23.shoponline.contrloller;

import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.ProductFactory.FactoryException;
import com.github.nosachigor23.shoponline.model.ProductFactory.ProductFactory;
import com.github.nosachigor23.shoponline.repositories.ProductsRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaveController {

	private static final Logger LOG = Logger.getLogger(SaveController.class);

	private final ProductsRepository productsRepository;

	public SaveController(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	/*

	This method creates object that is a subclass of AProductEntity using the ProductFactory. The first argument to
	the product indicates the type of product that is specified when the object is created on the Thymeleaf page.
	The second argument is not required, and is passed when the product is edited.

	 */

	@ModelAttribute("productInstance")
	public AProductEntity getProductInstance(@RequestParam(value = "product") String product,
	                                         @RequestParam(value = "id", required = false) Integer edit) throws Exception {

		if (edit != null) {

			return productsRepository.findOne(edit);
		}

		try {

			return ProductFactory.getProductInst(product);

		} catch (FactoryException e) {

			LOG.error("Incorrect type " + e);

		}

		throw new FactoryException("Incorrect incorrect method arguments");

	}


	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("productInstance") AProductEntity aProductEntity) {

		try {

			productsRepository.save(aProductEntity);

			LOG.info(productsRepository + " was created!");

		} catch (Exception e) {

			LOG.error("Exceptions happen! ", e);

		}

		return "redirect:/";

	}

}