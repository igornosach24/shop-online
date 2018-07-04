package com.github.nosachigor23.shoponline.contrloller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(CheckController.class)
public class CheckControllerTest {

    @Test
    public void testBuyProduct_ShouldReturnViewWithNameDependsOnProductTypeAndWithNecessaryAttributes() {
    }
}
