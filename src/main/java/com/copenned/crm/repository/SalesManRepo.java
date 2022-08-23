package com.copenned.crm.repository;

import com.copenned.crm.model.Payment;
import com.copenned.crm.model.SalesMan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesManRepo extends JpaRepository<SalesMan,Integer> {
    List<SalesMan> findAllByTeamLead(String teamLead);

}
