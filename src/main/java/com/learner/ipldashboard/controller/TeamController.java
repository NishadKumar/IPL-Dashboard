package com.learner.ipldashboard.controller;

import com.learner.ipldashboard.model.Team;
import com.learner.ipldashboard.repository.MatchRepository;
import com.learner.ipldashboard.repository.TeamRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    
    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {

       Team team =  this.teamRepository.findByTeamName(teamName);
       team.setLatestMatches(this.matchRepository.findLatestMatchesByTeam(teamName, 4));

       return team;
    }
}
