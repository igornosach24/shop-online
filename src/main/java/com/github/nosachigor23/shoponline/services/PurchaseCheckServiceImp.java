package com.github.nosachigor23.shoponline.services;

import com.github.nosachigor23.shoponline.Utils.TimeMachine;
import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.PurchaseCheck;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class PurchaseCheckServiceImp implements PurchaseCheckService {
    private JpaRepository<PurchaseCheck, Integer> checkRepository;
    private ProductService productService;

    public PurchaseCheckServiceImp(
            @Qualifier("CheckRepository") JpaRepository<PurchaseCheck, Integer> checkRepository,
            ProductService productService) {
        this.checkRepository = checkRepository;
        this.productService = productService;
    }

    @Override
    public PurchaseCheck convertProductToCheck(AProductEntity productEntity) {
        PurchaseCheck purchaseCheck = new PurchaseCheck();
        purchaseCheck.setId_product(productEntity.getId());
        purchaseCheck.setAmount(productEntity.getAmount());
        purchaseCheck.setDateSale(TimeMachine.now());
        purchaseCheck.setDiscount(productEntity.getDiscount());
        purchaseCheck.setPrice(productEntity.getPrice());
        purchaseCheck.setInfo(productEntity.toString());
        return purchaseCheck;
    }

    @Override
    public void saveOrUpdatePurchaseCheck(PurchaseCheck purchaseCheck) {

    }

    @Override
    public List<PurchaseCheck> getAllPurchaseChecks() {
        return checkRepository.findAll();
    }
}
