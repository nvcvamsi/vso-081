package com.example.vaultapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class VaultApplicationTests {

    @Autowired
    private VaultController vaultController;

    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
        assertThat(vaultController).isNotNull();
    }

    @Test
    public void testGetSecret() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(vaultController).build();
        mockMvc.perform(get("/get-secret"))
                .andExpect(status().isOk());
    }
}
