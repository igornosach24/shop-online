package com.github.nosachigor23.shoponline.contrloller;

import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.ProductFactory.FactoryException;
import com.github.nosachigor23.shoponline.model.ProductFactory.ProductFactory;
import com.github.nosachigor23.shoponline.repositories.ProductsRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	private static final Logger LOG = Logger.getLogger(MainController.class);

	private final ProductsRepository productsRepository;

	public MainController(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("products", productsRepository.findAll());

		return "index";

	}

	@RequestMapping("product/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {

		try {

			final AProductEntity editProduct = productsRepository.findOne(id);

			if (editProduct != null) {

				model.addAttribute("productInstance", editProduct);

			} else throw new NullPointerException("editProduct is null");

			model.addAttribute("edit", true); //pass to model information, that the object is changing

			String name = editProduct.getClass().getSimpleName().replaceAll("Entity", "");
			//Get the name of the view, depending on the type of product

			return "add" + name;

		} catch (NullPointerException e) {

			LOG.error(e);

		}

		return "index";

	}

	@RequestMapping(value = "addProduct")
	public String addProduct(@RequestParam(value = "product") String type, Model model) {

		try {

			model.addAttribute("productInstance", ProductFactory.getProductInst(type));

			return "add" + type;

		} catch (FactoryException e) {

			LOG.error(e);

		}

		return "redirect:/";
	}

	@RequestMapping("product/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		try {

			productsRepository.delete(id);

			LOG.info("Product with " + id + " was delete!");

		} catch (Exception e) {

			LOG.error(e);

		}

		return "redirect:/";
	}

}
