package services.calendar;

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
public class CalendarControllerTestPositive {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnOkStatusWithAllCalledMethodsWhenPositiveScenario() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/add")
                .contentType("application/json")
                .content("{\"year\":1991,\"month\":9,\"day\":8,\"name\":\"Aba\"}");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        "Event has been successfully added."));
        request = MockMvcRequestBuilders.post("/api/add")
                .contentType("application/json")
                .content("{\"year\":1991,\"month\":9,\"day\":8,\"name\":\"Aaa\"}");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        "Event has been successfully added."));
        request = MockMvcRequestBuilders.get("/api/get/all");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        "[\n" +
                                "    {\n" +
                                "        \"year\": 1991,\n" +
                                "        \"month\": 9,\n" +
                                "        \"day\": 8,\n" +
                                "        \"name\": \"Aaa\",\n" +
                                "        \"id\": 2\n" +
                                "    },\n" +
                                "    {\n" +
                                "        \"year\": 1991,\n" +
                                "        \"month\": 9,\n" +
                                "        \"day\": 8,\n" +
                                "        \"name\": \"Aba\",\n" +
                                "        \"id\": 1\n" +
                                "    }\n" +
                                "]"
                ));
        request = MockMvcRequestBuilders.patch("/api/set/1")
                .contentType("application/json")
                .content("{\"year\":1991,\"month\":10,\"day\":8,\"name\":\"Aba\"}");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        "Event with id#1 has been successfully changed."));
        request = MockMvcRequestBuilders.get("/api/get/day/8/month/9/year/1991");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        "[\n" +
                                "    {\n" +
                                "        \"year\": 1991,\n" +
                                "        \"month\": 9,\n" +
                                "        \"day\": 8,\n" +
                                "        \"name\": \"Aaa\",\n" +
                                "        \"id\": 2\n" +
                                "    }\n" +
                                "]"
                ));
        request = MockMvcRequestBuilders.get("/api/get/month/10/year/1991");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        "[\n" +
                                "    {\n" +
                                "        \"year\": 1991,\n" +
                                "        \"month\": 10,\n" +
                                "        \"day\": 8,\n" +
                                "        \"name\": \"Aba\",\n" +
                                "        \"id\": 1\n" +
                                "    }\n" +
                                "]"
                ));
        request = MockMvcRequestBuilders.delete("/api/delete/1");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        "Event with id#1 has been successfully removed."));
        request = MockMvcRequestBuilders.get("/api/get/year/1991");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        "[\n" +
                                "    {\n" +
                                "        \"year\": 1991,\n" +
                                "        \"month\": 9,\n" +
                                "        \"day\": 8,\n" +
                                "        \"name\": \"Aaa\",\n" +
                                "        \"id\": 2\n" +
                                "    }\n" +
                                "]"
                ));
    }
}