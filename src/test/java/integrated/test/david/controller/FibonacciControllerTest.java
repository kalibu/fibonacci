package integrated.test.david.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import test.david.FibonacciApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = FibonacciApplication.class)
@AutoConfigureMockMvc
public class FibonacciControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void given1_thanReturn1() throws Exception {
        mockMvc.perform(get("/fib?n=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void given10_thanReturn55() throws Exception {
        mockMvc.perform(get("/fib?n=10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("55"));
    }

    @Test
    void given0_thanThrownError() throws Exception {
        mockMvc.perform(get("/fib?n=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenLetter_thanThrownError() throws Exception {
        mockMvc.perform(get("/fib?n=a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenNoValue_thanThrownError() throws Exception {
        mockMvc.perform(get("/fib"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
