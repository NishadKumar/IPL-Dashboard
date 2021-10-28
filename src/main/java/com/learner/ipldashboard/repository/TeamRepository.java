package com.learner.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;
import com.learner.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByTeamName(String teamName);
}
