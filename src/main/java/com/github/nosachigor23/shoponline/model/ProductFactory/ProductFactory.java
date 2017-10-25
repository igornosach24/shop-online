package com.github.nosachigor23.shoponline.model.ProductFactory;

import com.github.nosachigor23.shoponline.model.*;
import org.apache.log4j.Logger;

public class ProductFactory {

	private static final Logger LOG = Logger.getLogger(ProductFactory.class);

	private ProductFactory() {
	}

	public static AProductEntity getProductInst(String type) throws FactoryException {

		if (type == null || type.isEmpty()) {

			String errMsg =  "Incorrect method argument value";

			LOG.error(errMsg);

			throw new FactoryException(errMsg);

		}

		if (type.equalsIgnoreCase("accessories")) {

			return new AccessoriesEntity();
		}

		if (type.equalsIgnoreCase("display")) {

			return new DisplayEntity();
		}

		if (type.equalsIgnoreCase("storageDevice")) {

			return new StorageDeviceEntity();

		}

		if (type.equalsIgnoreCase("peripherals")) {

			return new PeripheralsEntity();

		}

		if (type.equalsIgnoreCase("inputDevice")) {

			return new InputDeviceEntity();

		} else {

			String errMsg =  "Incorrect type in factory";

			LOG.error(errMsg);

			throw new FactoryException(errMsg);

		}
	}
}
