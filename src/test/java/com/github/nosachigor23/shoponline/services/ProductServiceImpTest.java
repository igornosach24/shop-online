package com.github.nosachigor23.shoponline.services;

import com.github.nosachigor23.shoponline.exceptions.ProductNotFoundException;
import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.InputDeviceEntity;
import com.github.nosachigor23.shoponline.model.PeripheralsEntity;
import com.github.nosachigor23.shoponline.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImpTest {

    @Mock
    private JpaRepository<AProductEntity,Integer> repository;
    private List<AProductEntity> productEntityList;
    private ProductService productServiceImp;

    @Before
    public void setUp() {
        this.productServiceImp = new ProductServiceImp(repository);
        this.productEntityList = new ArrayList<>();
        this.productEntityList.add(new PeripheralsEntity());
        this.productEntityList.add(new InputDeviceEntity());
    }

    @Test
    public void testFindAllProducts_ShouldReturnAllProducts() {
        given(repository.findAll()).willReturn(productEntityList);
        Assert.assertEquals(productEntityList, productServiceImp.getAllProducts());
        verify(repository, times(1)).findAll();
        Assert.assertTrue(productServiceImp.getAllProducts().size() > 0);
    }

    @Test
    public void testFindAllProducts_ShouldReturnEmptyListIfProductsDoNotExist() {
        Assert.assertEquals(productServiceImp.getAllProducts(), Collections.emptyList());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testFindOneProductById_ShouldReturnProductById() {
        InputDeviceEntity inputDeviceEntity = new InputDeviceEntity();
        inputDeviceEntity.setAmount(10);

        given(repository.findOne(inputDeviceEntity.getId())).willReturn(inputDeviceEntity);

        AProductEntity productById = productServiceImp.getProductById(inputDeviceEntity.getId());

        Assert.assertEquals(inputDeviceEntity, productById);
        Assert.assertEquals(productById.getAmount(), 10);
        verify(repository, times(1)).findOne(inputDeviceEntity.getId());
    }

    @Test(expected = ProductNotFoundException.class)
    public void testFindOneProductById_ShouldThrowProductNotFoundExceptionIfProductDoesNotExist() {
        productServiceImp.getProductById(1);
    }

    @Test
    public void testDeleteProductById_ShouldInvokeMethodDeleteProductInRepository() {
        InputDeviceEntity inputDeviceEntity = new InputDeviceEntity();
        inputDeviceEntity.setAmount(10);
        given(repository.exists(inputDeviceEntity.getId())).willReturn(true);
        productServiceImp.deleteProductById(inputDeviceEntity.getId());
    }

    @Test(expected = ProductNotFoundException.class)
    public void testDeleteProductById_ShouldThrowProductNotFoundExceptionIfProductDoesNotExist() {
        InputDeviceEntity inputDeviceEntity = new InputDeviceEntity();
        inputDeviceEntity.setAmount(10);
        given(repository.exists(inputDeviceEntity.getId())).willReturn(false);
        productServiceImp.deleteProductById(inputDeviceEntity.getId());
    }

    @Test
    public void testSaveOrUpdateProduct_ShouldSaveOrUpdateProduct() {
        InputDeviceEntity inputDeviceEntity = new InputDeviceEntity();
        inputDeviceEntity.setAmount(10);
        given(repository.exists(inputDeviceEntity.getId())).willReturn(true);
        productServiceImp.deleteProductById(inputDeviceEntity.getId());
    }


    // TODO
    public void testCalculateDiscountForProductDependsOnType_ShouldReturnValidDiscountForProduct() {

    }

}
