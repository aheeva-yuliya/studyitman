package services.example;

import org.junit.jupiter.api.Assertions;
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
    @Nested
    public class Extract {
        @Autowired
        private MockMvc mockMvc;
        @Test
        public void shouldExecutedWith200WhenPassAllParams() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.post
                                    ("/extract/one/1?required=r&optional=opt&default=0&missing=world")
                            .content("all params");
            this.mockMvc.perform(request)
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
            this.mockMvc.perform(request)
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
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }
    }

    @Nested
    public class GetMapping {
        @Test
        public void shouldReturnStringWhenGet() {
            ExampleController controller = new ExampleController();
            String expected = "I'm your first web-service";
            String actual = controller.index();
            Assertions.assertEquals(expected,actual);
        }

        @Test
        public void shouldReturnStringWhenGetSecond() {
            ExampleController controller = new ExampleController();
            String expected = "I'm the second binding";
            String actual = controller.second();
            Assertions.assertEquals(expected,actual);
        }
    }

    @Nested
    public class Methods {
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldReturnStringWhenMappingSecondPost() {
            ExampleController controller = new ExampleController();
            String expected = "I'm post mapping";
            String actual = controller.secondPost();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldExecutedWith200WhenPost() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.post
                                    ("/second");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "I'm post mapping"
                    ));
        }

        @Test
        public void shouldReturnStringWhenMappingSecondPut() {
            ExampleController controller = new ExampleController();
            String expected = "I'm put mapping";
            String actual = controller.secondPut();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldExecutedWith200WhenPut() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.put
                            ("/second");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "I'm put mapping"
                    ));
        }

        @Test
        public void shouldReturnStringWhenMappingSecondPatch() {
            ExampleController controller = new ExampleController();
            String expected = "I'm patch mapping";
            String actual = controller.secondPatch();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldExecutedWith200WhenPatch() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.patch
                            ("/second");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "I'm patch mapping"
                    ));
        }

        @Test
        public void shouldReturnStringWhenSecondDelete() {
            ExampleController controller = new ExampleController();
            String expected = "I'm delete mapping";
            String actual = controller.secondDelete();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldExecutedWith200WhenDelete() throws Exception {
            final MockHttpServletRequestBuilder request =
                    MockMvcRequestBuilders.delete
                            ("/second");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(
                            "I'm delete mapping"
                    ));
        }
    }
}