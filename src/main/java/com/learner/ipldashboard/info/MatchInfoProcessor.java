package com.learner.ipldashboard.info;



import java.time.LocalDate;

import com.learner.ipldashboard.model.Match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class MatchInfoProcessor implements ItemProcessor<MatchInfo, Match> { 

  private static final Logger log = LoggerFactory.getLogger(MatchInfoProcessor.class);

  @Override
  public Match process(final MatchInfo matchInfo) throws Exception {

    String firstInningsTeam, secondInningsTeam;

    Match match = new Match();

    match.setId(Long.parseLong(matchInfo.getId()));
    match.setCity(matchInfo.getCity());

    match.setDate(LocalDate.parse(matchInfo.getDate()));

    match.setPlayerOfMatch(matchInfo.getPlayerOfMatch());
    match.setVenue(matchInfo.getVenue());


    if("bat".toUpperCase().equals(matchInfo.getTossDecision().toUpperCase())) {
        firstInningsTeam = matchInfo.getTossWinner();
        secondInningsTeam = matchInfo.getTossWinner().equals(matchInfo.getTeam1())
                            ? matchInfo.getTeam2() : matchInfo.getTeam1();
    } else {
        secondInningsTeam = matchInfo.getTossWinner();
        firstInningsTeam = matchInfo.getTossWinner().equals(matchInfo.getTeam1())
                            ? matchInfo.getTeam2() : matchInfo.getTeam1();
    }

    match.setTeam1(firstInningsTeam);
    match.setTeam2(secondInningsTeam);

    match.setTossWinner(matchInfo.getTossWinner());
    match.setTossDecision(matchInfo.getTossDecision());
    match.setMatchWinner(matchInfo.getWinner());
    match.setResult(matchInfo.getResult());
    match.setResultMargin(matchInfo.getResultMargin());

    match.setUmpire1(matchInfo.getUmpire1());
    match.setUmpire2(matchInfo.getUmpire2());

    return match;
  }

}