package com.github.nosachigor23.shoponline.model.ProductFactory;

import com.github.nosachigor23.shoponline.model.*;

public class ProductFactory {

    private ProductFactory(){}

    public static AProductEntity getProductInst(String type) throws FactoryException {

        if (type==null||type.isEmpty())throw new FactoryException();

        if (type.equalsIgnoreCase("accessories")){
            return new AccessoriesEntity();
        }

        if (type.equalsIgnoreCase("display")){
            return new DisplayEntity();
        }

        if (type.equalsIgnoreCase("storageDevice")){
            return new StorageDeviceEntity();
        }

        if (type.equalsIgnoreCase("peripherals")){
            return new PeripheralsEntity();
        }

        if (type.equalsIgnoreCase("inputDevice")){
            return new InputDeviceEntity();
        }

        else throw new FactoryException();
    }
}
