package com.perficient.mtp.profile.pricehistory;

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
import com.perficient.mtp.profile.pricehistory.PriceHistoryController;
import com.perficient.mtp.profile.PriceHistory;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {ProfileServiceApplication.class, PriceHistoryController.class, SimpleMeterRegistry.class})
@WebMvcTest
public class PriceHistoryControllerIntegrationTest {
	  
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetPriceHistory() throws Exception {
		
		String symbol = "TSLA";
		int days = 5;
		
	    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/price-history/" + symbol)
	    		.param("days", Integer.toString(days))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
	    
        String json = result.getResponse().getContentAsString();
        assertNotNull(json);
        assertTrue(!json.isEmpty());
        
        ObjectMapper mapper = JsonMapper.builder()
	        .addModule(new JavaTimeModule())
	        .build();
        
        PriceHistory profile = mapper.readValue(json, PriceHistory.class);
        
        assertEquals(symbol, profile.getSymbol(), "symbol doesn't match");
        assertEquals(days, profile.getQuoteList().size(), "quoteList.size() incorrect");
	}
}
