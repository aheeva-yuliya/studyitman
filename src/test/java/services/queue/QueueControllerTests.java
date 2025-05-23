package services.queue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class QueueControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    public class EndToEndTests {
        @Test
        public void shouldReturnTwoTicketsTotalWhenTwoDaysWithOneTicket() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/queue/nextTicket");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(
                            "{\"number\":1,\"place\":\"bank\"}"));
            request = MockMvcRequestBuilders.get("/api/queue/totalTickets");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("1"));
            request = MockMvcRequestBuilders.get("/api/queue/getVisitsByDays");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(
                            "[1]"));
            request = MockMvcRequestBuilders.post("/api/queue/toNextWorkDay");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(""));
            request = MockMvcRequestBuilders.get("/api/queue/nextTicket");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(
                            "{\"number\":1,\"place\":\"bank\"}"));
            request = MockMvcRequestBuilders.get("/api/queue/totalTickets");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("2"));
            request = MockMvcRequestBuilders.get("/api/queue/getVisitsByDays");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(
                            "[1, 1]"));
        }

        @Test
        public void shouldReturnCurrentQueueWhenTwoDays() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/queue/nextTicket");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(
                            "{\"number\":1,\"place\":\"bank\"}"));
            request = MockMvcRequestBuilders.get("/api/queue/totalTickets");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("1"));
            request = MockMvcRequestBuilders.post("/api/queue/toNextWorkDay");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(""));
            request = MockMvcRequestBuilders.get("/api/queue/nextTicket");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(
                            "{\"number\":1,\"place\":\"bank\"}"));
            request = MockMvcRequestBuilders.get("/api/queue/getCurrentQueue");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(
                            "[\n" +
                                    "    {\n" +
                                    "        \"number\": 1,\n" +
                                    "        \"place\": \"bank\"\n" +
                                    "    }\n" +
                                    "]"));
            request = MockMvcRequestBuilders.post("/api/queue/callNext");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(
                            "{\"number\":1,\"place\":\"bank\"}"));
            request = MockMvcRequestBuilders.get("/api/queue/getCurrentQueue");
            QueueControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json("[]"));
        }
    }
}