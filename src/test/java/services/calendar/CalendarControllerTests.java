package services.calendar;

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
public class CalendarControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    public class NegativeScenario {
        @Test
        public void shouldReturnOkStatusWithAllCalledMethodsWhenNegativeScenario() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/add")
                    .contentType("application/json")
                    .content("{\"year\":1991,\"month\":15,\"day\":8,\"name\":\"Aba\"}");
            mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "Invalid event." + "\n"
                                    + "\n"
                                    + "Valid event example:" + "\n"
                                    + "{" + "\n"
                                    + "    \"year\" : 2021," + "\n"
                                    + "    \"month\" : 9," + "\n"
                                    + "    \"day\" : 3," + "\n"
                                    + "    \"name\" : " + "\"event\"" + "\n"
                                    + "}" + "\n"
                                    + "\n"
                                    + "Field " + "\"name\"" + " should contain maximum 100 characters."
                    ));
            request = MockMvcRequestBuilders.post("/api/add")
                    .contentType("application/json")
                    .content("{\"year\":1991,\"month\":9,\"day\":8,\"name\":\"Aba\"}");
            mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "Event has been successfully added."));
            request = MockMvcRequestBuilders.patch("/api/set/5")
                    .contentType("application/json")
                    .content("{\"year\":1991,\"month\":9,\"day\":8,\"name\":\"Aba\"}");
            mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "Event with id#5 has not been found."));
            request = MockMvcRequestBuilders.delete("/api/delete/5");
            mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "Event with id#5 has not been found."));
            request = MockMvcRequestBuilders.get("/api/get/day/2/month/10/year/1991");
            mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json("[]"));
            request = MockMvcRequestBuilders.get("/api/get/month/10/year/1991");
            mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json("[]"));
            request = MockMvcRequestBuilders.get("/api/get/year/1992");
            mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json("[]"));
        }
    }

    @Nested
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    public class PositiveScenario {
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
                                    "        \"id\": 2,\n" +
                                    "        \"year\": 1991,\n" +
                                    "        \"month\": 9,\n" +
                                    "        \"day\": 8,\n" +
                                    "        \"name\": \"Aaa\"\n" +
                                    "    },\n" +
                                    "    {\n" +
                                    "        \"id\": 1,\n" +
                                    "        \"year\": 1991,\n" +
                                    "        \"month\": 9,\n" +
                                    "        \"day\": 8,\n" +
                                    "        \"name\": \"Aba\"\n" +
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
                                    "        \"id\": 2,\n" +
                                    "        \"year\": 1991,\n" +
                                    "        \"month\": 9,\n" +
                                    "        \"day\": 8,\n" +
                                    "        \"name\": \"Aaa\"\n" +
                                    "    }\n" +
                                    "]"
                    ));
            request = MockMvcRequestBuilders.get("/api/get/month/10/year/1991");
            mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(
                            "[\n" +
                                    "    {\n" +
                                    "        \"id\": 1,\n" +
                                    "        \"year\": 1991,\n" +
                                    "        \"month\": 10,\n" +
                                    "        \"day\": 8,\n" +
                                    "        \"name\": \"Aba\"\n" +
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
                                    "        \"id\": 2,\n" +
                                    "        \"year\": 1991,\n" +
                                    "        \"month\": 9,\n" +
                                    "        \"day\": 8,\n" +
                                    "        \"name\": \"Aaa\"\n" +
                                    "    }\n" +
                                    "]"
                    ));
        }
    }
}