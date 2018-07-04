package com.github.nosachigor23.shoponline.services;

import com.github.nosachigor23.shoponline.exceptions.ProductNotFoundException;
import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.InputDeviceEntity;
import com.github.nosachigor23.shoponline.model.PeripheralsEntity;
import com.github.nosachigor23.shoponline.repositories.ProductsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductsRepository repository;
    private List<AProductEntity> productEntityList;
    private ProductService productService;

    @Before
    public void setUp() {
        this.productService = new ProductService(repository);
        this.productEntityList = new ArrayList<>();
        this.productEntityList.add(new PeripheralsEntity());
        this.productEntityList.add(new InputDeviceEntity());
    }

    @Test
    public void testFindAllProducts_ShouldReturnAllProducts() {
        given(repository.findAll()).willReturn(productEntityList);
        Assert.assertEquals(productEntityList, productService.getAllProducts());
        verify(repository, times(1)).findAll();
        Assert.assertTrue(productService.getAllProducts().size() > 0);
    }

    @Test
    public void testFindAllProducts_ShouldReturnEmptyListIfProductsDoNotExist() {
        Assert.assertEquals(productService.getAllProducts(), Collections.emptyList());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testFindOneProductById_ShouldReturnProductById() {
        InputDeviceEntity inputDeviceEntity = new InputDeviceEntity();
        inputDeviceEntity.setAmount(10);

        given(repository.findOne(inputDeviceEntity.getId())).willReturn(inputDeviceEntity);

        AProductEntity productById = productService.getProductById(inputDeviceEntity.getId());

        Assert.assertEquals(inputDeviceEntity, productById);
        Assert.assertEquals(productById.getAmount(), 10);
        verify(repository, times(1)).findOne(inputDeviceEntity.getId());
    }

    @Test(expected = ProductNotFoundException.class)
    public void testFindOneProductById_ShouldThrowProductNotFoundExceptionIfProductDoesNotExist() {
        productService.getProductById(1);
    }

    @Test
    public void testDeleteProductById_ShouldInvokeMethodDeleteProductInRepository() {
        InputDeviceEntity inputDeviceEntity = new InputDeviceEntity();
        inputDeviceEntity.setAmount(10);
        given(repository.exists(inputDeviceEntity.getId())).willReturn(true);
        productService.deleteProductById(inputDeviceEntity.getId());
    }

    @Test(expected = ProductNotFoundException.class)
    public void testDeleteProductById_ShouldThrowProductNotFoundExceptionIfProductDoesNotExist() {
        InputDeviceEntity inputDeviceEntity = new InputDeviceEntity();
        inputDeviceEntity.setAmount(10);
        given(repository.exists(inputDeviceEntity.getId())).willReturn(false);
        productService.deleteProductById(inputDeviceEntity.getId());
    }

    // TODO
    @Test(expected = ProductNotFoundException.class)
    public void testCalculateDiscountForProductDependsOnType_ShouldReturnValidDiscountForProduct() {

    }

}
