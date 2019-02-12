package com.victor.io.ControllerTest;

import com.victor.io.Controller.HelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorld.class)
public class HelloWorldTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloWorld helloWorld;

    @Test
    public void helloWorldTest() throws Exception{
        given(this.helloWorld.helloWorld()).willReturn("Hello World!");
        this.mockMvc.perform(get("/hello/api").accept(MediaType.TEXT_PLAIN)).andExpect(status().isOk()).andExpect(content().string("Hello World!"));
    }
}
