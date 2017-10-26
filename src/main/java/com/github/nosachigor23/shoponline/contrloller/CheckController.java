package com.github.nosachigor23.shoponline.contrloller;

import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.CheckProduct;
import com.github.nosachigor23.shoponline.repositories.CheckRepository;
import com.github.nosachigor23.shoponline.repositories.ProductsRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

@Controller
public class CheckController {

	private static final Logger LOG = Logger.getLogger(MainController.class);

	private final CheckRepository checkRepository;

	private final ProductsRepository productsRepository;


	public CheckController(CheckRepository checkRepository, ProductsRepository productsRepository) {

		this.checkRepository = checkRepository;

		this.productsRepository = productsRepository;

	}

	@RequestMapping(value = "product/buy/{id}", method = RequestMethod.GET)
	public String buyProduct(@PathVariable Integer id, Model model) {

		final AProductEntity purchaseProduct = productsRepository.findOne(id);

		try {

			final CheckProduct checkProduct = changingStatusProductToCheck(purchaseProduct);

			model.addAttribute("check", checkProduct);

		} catch (NullPointerException e) {

			LOG.error(e);

		}

		return "confirmationPurchase";

	}

	@RequestMapping(value = "product/buy/yes/{id}", method = RequestMethod.GET)
	public String finalPurchase(@PathVariable Integer id, Model model) {

		try {
			final AProductEntity purchaseProduct = productsRepository.findOne(id);

			final CheckProduct checkProduct = changingStatusProductToCheck(purchaseProduct);

			productsRepository.delete(purchaseProduct.getId());

			checkRepository.save(checkProduct);

			model.addAttribute("complete", true);

			LOG.info("Purchase product " + purchaseProduct + " was successfully");

			LOG.info("The " + checkProduct + " would be stored in the database");

		} catch (NullPointerException e) {

			LOG.error(e);

		}

		return "redirect:/";

	}

	private CheckProduct changingStatusProductToCheck(final AProductEntity purchaseProduct) {

		final CheckProduct checkProduct = new CheckProduct();

		checkProduct.setId_product(purchaseProduct.getId());

		checkProduct.setAmount(purchaseProduct.getAmount());

		checkProduct.setDateSale(LocalDateTime.now());

		checkProduct.setDiscount(purchaseProduct.getDiscount());

		checkProduct.setPrice(purchaseProduct.getPrice());

		checkProduct.setInfo(purchaseProduct.toString());

		return checkProduct;

	}

	@RequestMapping(value = "soldProducts", method = RequestMethod.GET)
	public String showSoldProducts(Model model) {

		model.addAttribute("soldProducts", checkRepository.findAll());

		return "soldProducts";

	}

}
