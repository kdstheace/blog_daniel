package com.danielsoo.blog_daniel.web;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mmvc;

    @Test
    public void 헬로테스트() throws Exception{
        mmvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string("hello"));
    }

    @Test
    public void jsonTest() throws Exception{
        String name = "sexy";
        int amount = 1999;
        mmvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", Matchers.is(name)))
            .andExpect(jsonPath("$.amount", Matchers.is(amount)));
    }
}
