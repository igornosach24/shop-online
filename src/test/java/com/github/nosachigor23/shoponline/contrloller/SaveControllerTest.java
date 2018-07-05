package com.github.nosachigor23.shoponline.contrloller;

import com.github.nosachigor23.shoponline.model.*;
import com.github.nosachigor23.shoponline.services.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductSaveController.class)
public class SaveControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productServiceImp;

    @Test
    public void testSaveProduct_ShouldInvokeSaveOrUpdateMethodAndReturnStartPage() throws Exception {
        PeripheralsEntity peripheralsEntity = new PeripheralsEntity();
        peripheralsEntity.setInfo("Some info");
        mockMvc.perform(post("http://localhost:8080/product/save/").param("product", "peripherals"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
        verify(productServiceImp, times(1)).saveOrUpdateProduct(peripheralsEntity);
    }

    @Test(expected = NestedServletException.class)
    public void testSaveProductWithWrongParam_ShouldThrowException() throws Exception {
        PeripheralsEntity peripheralsEntity = new PeripheralsEntity();
        peripheralsEntity.setInfo("Some info");
        mockMvc.perform(post("http://localhost:8080/product/save/").param("product", "peTipherals"))
                .andExpect(status().is3xxRedirection());
    }

}
