package services.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class EventExampleControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Nested
    public class SaveEvent {
        @Test
        public void shouldSaveEventWhenNotNull() throws Exception {
            final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/event")
                    .contentType("application/json")
                    .content("{\"year\":1992,\"month\":2,\"day\":22,\"name\":\"birthday\"}");
            EventExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(""));
        }
    }

    @Nested
    public class GetEvent {
        @Test
        public void shouldReturnEventWhenNotNull() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/event")
                    .contentType("application/json")
                    .content("{\"year\":1992,\"month\":2,\"day\":22,\"name\":\"birthday\"}");
            EventExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk());
            request = MockMvcRequestBuilders.get("/api/event");
            EventExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(
                            "{\"year\":1992,\"month\":2,\"day\":22,\"name\":\"birthday\"}"));
        }
    }
}