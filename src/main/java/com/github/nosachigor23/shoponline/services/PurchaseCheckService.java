package com.github.nosachigor23.shoponline.services;

import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.PurchaseCheck;

import java.util.List;

public interface PurchaseCheckService {
    PurchaseCheck convertProductToCheck(AProductEntity productEntity);
    void saveOrUpdatePurchaseCheck(PurchaseCheck purchaseCheck);
    List<PurchaseCheck> getAllPurchaseChecks();
}
