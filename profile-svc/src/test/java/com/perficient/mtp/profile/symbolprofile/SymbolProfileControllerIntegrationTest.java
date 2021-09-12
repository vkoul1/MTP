package com.perficient.mtp.profile.symbolprofile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.perficient.mtp.profile.ProfileServiceApplication;
import com.perficient.mtp.profile.SymbolProfile;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
//@SpringBootTest

@ContextConfiguration(classes = {ProfileServiceApplication.class, SymbolProfileController.class, SimpleMeterRegistry.class})
@WebMvcTest
public class SymbolProfileControllerIntegrationTest {
	  
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetSymbolProfile() throws Exception {
		
		String symbol = "TSLA";
		
	    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/symbol-profile/" + symbol)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
	    
        String json = result.getResponse().getContentAsString();
        assertNotNull(json);
        assertTrue(!json.isEmpty());
        
        ObjectMapper mapper = JsonMapper.builder()
	        .addModule(new JavaTimeModule())
	        .build();
        
        SymbolProfile profile = mapper.readValue(json, SymbolProfile.class);
        
        assertEquals(symbol, profile.getSymbol(), "symbol doesn't match");
	}
}
