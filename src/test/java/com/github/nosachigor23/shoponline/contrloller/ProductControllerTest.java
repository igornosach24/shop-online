package com.github.nosachigor23.shoponline.contrloller;


import com.github.nosachigor23.shoponline.model.*;
import com.github.nosachigor23.shoponline.services.ProductService;
import com.github.nosachigor23.shoponline.utils.ProductTestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productServiceImp;

    @Test
    public void testEditProduct_ShouldReturnViewWithNameDependsOnProductTypeAndWithNecessaryAttributes() throws Exception {
        for (AProductEntity aProductEntity : ProductTestUtils.getTestProductEntityList()) {
            testEditProductForEachAProductInst(aProductEntity);
        }
    }

    // TODO Changed getting name of view
    private void testEditProductForEachAProductInst(AProductEntity product) throws Exception {

        given(productServiceImp.getProductById(product.getId())).willReturn(product);

        mockMvc.perform(get("http://localhost:8080/product/edit/" + product.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("add" + getViewName(product)))
                .andExpect(model().attribute("productInstance", equalTo(product)))
                .andExpect(model().attribute("edit", true));
    }

    @Test
    public void testGetProductPathForSaving_ShouldReturnViewWithNameDependsOnProductTypeAndObjectAttribute() throws Exception {
        for (AProductEntity aProductEntity : ProductTestUtils.getTestProductEntityList()) {
            testAddProductForEachAProductInst(aProductEntity);
        }
    }

    private void testAddProductForEachAProductInst(AProductEntity product) throws Exception {

        given(productServiceImp.getProductById(product.getId())).willReturn(product);

        mockMvc.perform(post("http://localhost:8080/product/add")
                .param("product", getViewName(product)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("add" + getViewName(product)))
                .andExpect(model().attribute("productInstance", equalTo(product)));
    }

    @Test
    public void testDeleteProduct_ShouldInvokeDeleteMethodAndReturnStartingPage() throws Exception {
        DisplayEntity displayEntity = new DisplayEntity();
        displayEntity.setDiagonal(20);
        mockMvc.perform(get("http://localhost:8080/product/delete/" + displayEntity.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
        verify(productServiceImp, times(1)).deleteProductById(displayEntity.getId());
    }

    private String getViewName(AProductEntity product) {
        return product.getClass().getSimpleName().replaceAll("Entity", "");
    }
}
