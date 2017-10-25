package com.github.nosachigor23.shoponline.model;

public enum ProductType {

    Accessories, Display, Input_device, Peripherals, Storage_device;

     /*

    The function converts the value of the enumerated type to a string value.

    */

    public static String convertEnumToString(ProductType productType) {

        switch (productType) {
            case Display:
                return "display";
            case Accessories:
                return "accessories";
            case Peripherals:
                return "peripherals";
            case Input_device:
                return "input_device";
            case Storage_device:
                return "storage_device";
            default:
                return "incorrect_type";
        }

    }
}
