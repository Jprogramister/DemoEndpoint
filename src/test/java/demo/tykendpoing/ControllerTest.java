package demo.tykendpoing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
@ComponentScan
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPostApplicationsWithTransactionId() throws Exception {
        final var response = mockMvc.perform(post("/applications")
                .content(TestBody.getValid())
                .contentType(MediaType.APPLICATION_JSON)
                .header("X-Global-Transaction-ID", "1"))
                .andExpect(jsonPath("$.id").isNumber())
                .andReturn().getResponse();

        Assert.assertEquals("Service should return the same transaction header value", response.getHeader("X-Global-Transaction-ID"), "1");
    }

    @Test
    public void testPostApplicationsWithoutTransactionId() throws Exception {
        final var response = mockMvc.perform(post("/applications")
                .content(TestBody.getValid())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andReturn().getResponse();

        Assert.assertNotNull("Service should fill transaction header if it's empty", response.getHeader("X-Global-Transaction-ID"));
    }
}