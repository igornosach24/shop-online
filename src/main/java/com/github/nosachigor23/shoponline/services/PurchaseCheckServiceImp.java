package com.github.nosachigor23.shoponline.services;

import com.github.nosachigor23.shoponline.Utils.TimeMachine;
import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.PurchaseCheck;
import com.github.nosachigor23.shoponline.repositories.CheckRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseCheckServiceImp implements PurchaseCheckService {
    private ProductService productService;
    private CheckRepository checkRepository;

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
