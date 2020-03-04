package com.football;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.football.controller.StandingsController;
import com.football.model.Standing;

@WebMvcTest(StandingsController.class)
@SpringBootTest
public class StandingsControllerTest {

	
	@MockBean
	private StandingsController standingController;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getStandingsPositive() throws Exception {
		Standing s = new Standing(41,"England",148,"Premier League",2626,"Manchester City",2);
		String uri = "http://localhost:9001/football?countryName=England&leagueName=Premier League&teamName=Manchester City";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		
		assertTrue(mvcResult.equals(s));
	}
	
}
