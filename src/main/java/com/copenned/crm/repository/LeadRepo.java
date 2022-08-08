package com.copenned.crm.repository;

import com.copenned.crm.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepo extends JpaRepository<Lead,Integer> {
    List<Lead> findAllBySource(String source);
    List<Lead> findAllByClientManager(String clientManager);

}
