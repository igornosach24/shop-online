package com.github.nosachigor23.shoponline.services;

import com.github.nosachigor23.shoponline.Utils.TimeMachine;
import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.PeripheralsEntity;
import com.github.nosachigor23.shoponline.model.PurchaseCheck;
import com.github.nosachigor23.shoponline.repositories.CheckRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringJUnit4ClassRunner.class)
public class PurchaseCheckServiceImpTest {
    @Mock
    private ProductService productService;
    @Mock
    private CheckRepository checkRepository;
    private PurchaseCheckService purchaseCheckService;

    @Before
    public void setUp() {
        this.purchaseCheckService = new PurchaseCheckServiceImp(productService, checkRepository);
    }

    @Test
    public void testConvertProductToCheck_ShouldCovertProductAndReturnCheck() {
        PeripheralsEntity peripheralsEntity = new PeripheralsEntity();
        peripheralsEntity.setAmount(10);
        peripheralsEntity.setPrice(10);

        PurchaseCheck purchaseCheck = this.purchaseCheckService.convertProductToCheck(peripheralsEntity);

        Assert.assertEquals(peripheralsEntity.getDiscount(), purchaseCheck.getDiscount());
        Assert.assertEquals(peripheralsEntity.getAmount(),purchaseCheck.getAmount());
        Assert.assertEquals(peripheralsEntity.getPrice(),purchaseCheck.getPrice());
    }

    @Test
    public void name() {

    }
}
