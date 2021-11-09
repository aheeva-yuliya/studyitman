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
public class ExampleControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Nested
    public class Extract {
        @Test
        public void shouldExecutedWith200WhenPassAllParams() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.post
                                    ("/extract/one/1?required=r&optional=opt&default=0&missing=world")
                            .content("all params");
            ExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "pathVariable = one\n" +
                                    "second = 1\n" +
                                    "required = r\n" +
                                    "optional = opt\n" +
                                    "default = 0\n" +
                                    "body = all params\n"
                    ));
        }

        @Test
        public void shouldExecutedWith200WhenPassOnlyRequired() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.post
                                    ("/extract/two/2?required=r&missing=world")
                            .content("only required");
            ExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "pathVariable = two\n" +
                                    "second = 2\n" +
                                    "required = r\n" +
                                    "optional = null\n" +
                                    "default = -1\n" +
                                    "body = only required\n"
                    ));
        }

        @Test
        public void shouldExecutedWith400WhenPassMissingRequired() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.post
                                    ("/extract/three/3?missing=world")
                            .content("missing required");
            ExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }
    }

    @Nested
    public class GetMapping {
        @Test
        public void shouldExecutedWith200WhenGet() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.get
                            ("/");
            ExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "I'm your first web-service"
                    ));
        }

        @Test
        public void shouldExecutedWith200WhenGetSecond() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.get
                            ("/second");
            ExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "I'm the second binding"
                    ));
        }
    }

    @Nested
    public class Methods {
        @Test
        public void shouldExecutedWith200WhenPost() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.post
                            ("/second");
            ExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "I'm post mapping"
                    ));
        }

        @Test
        public void shouldExecutedWith200WhenPut() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.put
                            ("/second");
            ExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "I'm put mapping"
                    ));
        }

        @Test
        public void shouldExecutedWith200WhenPatch() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.patch
                            ("/second");
            ExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "I'm patch mapping"
                    ));
        }

        @Test
        public void shouldExecutedWith200WhenDelete() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.delete
                            ("/second");
            ExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "I'm delete mapping"
                    ));
        }
    }

    @Nested
    public class GetNumbers {
        @Test
        public void shouldExecutedWith200WhenTryGetNumbersFromQuery() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.get
                            ("/api/range?from=33&to=37");
            ExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "33\n" +
                                    "34\n" +
                                    "35\n" +
                                    "36"
                    ));
        }

        @Test
        public void shouldExecutedWith200WhenTryGetNumbersFromPath() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.get
                            ("/api/range/33/37");
            ExampleControllerTests.this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "33\n" +
                                    "34\n" +
                                    "35\n" +
                                    "36"
                    ));
        }
    }
}