package com.github.nosachigor23.shoponline.contrloller;

import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.DisplayEntity;
import com.github.nosachigor23.shoponline.model.InputDeviceEntity;
import com.github.nosachigor23.shoponline.model.PeripheralsEntity;
import com.github.nosachigor23.shoponline.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;
    private List<AProductEntity> productEntityList;

    @Before
    public void setUp() {
        this.productEntityList = new ArrayList<>();
        this.productEntityList.add(new PeripheralsEntity());
        this.productEntityList.add(new InputDeviceEntity());
        this.productEntityList.add(new DisplayEntity());
    }

    @Test
    public void getAllProducts_ShouldReturnViewWithProductsList() throws Exception {

        given(productService.getAllProducts()).willReturn(productEntityList);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("index"))
                .andExpect(model().attribute("products", equalTo(productEntityList)));
        verify(productService, times(1)).getAllProducts();
    }
}