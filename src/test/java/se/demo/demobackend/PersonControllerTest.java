package se.demo.demobackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import se.demo.demobackend.person.PersonController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PersonControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new PersonController()).build();
    }

    @Test
    void demoShouldReturnReceivedValues() throws Exception {
        mockMvc.perform(post("/api/demo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "name": "Diana",
                                  "personnelNumber": "12345"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.receivedName").value("Diana"))
                .andExpect(jsonPath("$.receivedPersonnelNumber").value("12345"))
                .andExpect(jsonPath("$.message").value("Request received successfully"));
    }

    @Test
    void demoShouldAcceptNumericPersonnelNumber() throws Exception {
        mockMvc.perform(post("/api/demo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "name": "Diana",
                                  "personnelNumber": 12345
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.receivedName").value("Diana"))
                .andExpect(jsonPath("$.receivedPersonnelNumber").value("12345"))
                .andExpect(jsonPath("$.message").value("Request received successfully"));
    }
}
