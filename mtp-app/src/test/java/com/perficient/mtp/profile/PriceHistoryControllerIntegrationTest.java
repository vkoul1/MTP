package com.perficient.mtp.profile;

import org.junit.jupiter.api.Disabled;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@Disabled
@AutoConfigureMockMvc
//@ContextConfiguration(classes = {MTP_Appliction.class, PriceHistoryController.class, PriceHistoryService.class, SimpleMeterRegistry.class})
//@WebMvcTest(PriceHistoryController.class)
@WebMvcTest
public class PriceHistoryControllerIntegrationTest {
/*
	private static final String SYMBOL = "TSLA";
	private static final int DAYS = 5;
	
	
    @Autowired
	private MockMvc mockMvc;

//    @MockBean
//	private ProfileService priceHistoryService;
	
	@Value("${mtp.profile-svc.base-url}") String baseURL;

    @BeforeEach
    public void setup() {
    	
		LocalDate start = LocalDate.now().minusDays(DAYS);
		
		List<Quote> quoteList = Stream.iterate(start, d -> d.plusDays(1))
				  .limit(DAYS)
				  .map(dt -> new Quote(dt, 1.42, 1000000))
				  .collect(Collectors.toList());

		PriceHistory ph = PriceHistory.builder()
								.symbol(SYMBOL)
								.quoteList(quoteList)
								.build();
		
    	when(priceHistoryService.getPriceHistory(SYMBOL, DAYS)).thenReturn(Mono.just(ph));
    }
	
	    
	    
	@Test
	public void testGetPriceHistory() throws Exception {

	    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/mtp/price-history/" + SYMBOL)
	    		.param("days", Integer.toString(DAYS))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
	    
        String json = result.getResponse().getContentAsString();
        assertNotNull(json);
        assertFalse(json.isEmpty());
        
        ObjectMapper mapper = JsonMapper.builder()
	        .addModule(new JavaTimeModule())
	        .build();
        
        PriceHistory ph = mapper.readValue(json, PriceHistory.class);
        
        assertEquals(SYMBOL, ph.getSymbol(), "symbol doesn't match");
        assertEquals(DAYS, ph.getQuoteList().size(), "quoteList.size() incorrect");
	}
	*/
}
