package com.github.nosachigor23.shoponline.contrloller;

import com.github.nosachigor23.shoponline.model.PeripheralsEntity;
import com.github.nosachigor23.shoponline.services.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(SaveController.class)
public class SaveControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void testSaveProduct_ShouldInvokeSaveOrUpdateMethodAndReturnStartPage() throws Exception {
        PeripheralsEntity peripheralsEntity = new PeripheralsEntity();
        given(productService.getProductById(anyInt())).willReturn(peripheralsEntity);
        mockMvc.perform(post("http://localhost:8080/product/save/").param("product", "peripherals"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
        verify(productService, times(1)).saveOrUpdateProduct(peripheralsEntity);
    }
}
