package com.github.nosachigor23.shoponline.utils;

import com.github.nosachigor23.shoponline.model.*;
import org.junit.Before;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class ProductTestUtils {

    private static final List<AProductEntity> productEntityList;

    static {
        productEntityList = new ArrayList<>();
        productEntityList.add(new PeripheralsEntity());
        productEntityList.add(new InputDeviceEntity());
        productEntityList.add(new DisplayEntity());
        productEntityList.add(new StorageDeviceEntity());
        productEntityList.add(new InputDeviceEntity());
    }

    public static List<AProductEntity> getTestProductEntityList() {
        return productEntityList;
    }
}
