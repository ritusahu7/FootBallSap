package com.football.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.football.StandingsService;
import com.football.model.Standing;

@Controller
public class StandingsController {
	Logger logger = LoggerFactory.getLogger(StandingsController.class);
	@Autowired
	StandingsService standingService;

	@GetMapping("/football")
	public String getStandings(@RequestParam("countryName") String countryName,
			@RequestParam("leagueName") String leagueName, @RequestParam("teamName") String teamName, Model model)
			throws StandingNotFoundException {

		Standing standing = standingService.getStanding(countryName, leagueName, teamName);
		if (logger.isDebugEnabled()) {
			logger.debug("standing :" + standing.toString());
		}
		model.addAttribute("standing", standing);
		return "football";
	}
}
