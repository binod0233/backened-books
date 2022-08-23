package com.copenned.crm.repository;

import com.copenned.crm.model.SalesMan;
import com.copenned.crm.model.TeamLead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamLeadRepo extends JpaRepository<TeamLead,Integer> {

    List<TeamLead> findByName(String name);

}
