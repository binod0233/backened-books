package com.copenned.crm.repository;

import com.copenned.crm.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LeadRepo extends JpaRepository<Lead,Integer> {
    List<Lead> findAllBySource(String source);
    List<Lead> findAllByClientManager(String clientManager);

    List<Lead> findAllByName(String leadName);
    List<Lead> findAllByServiceType(String serviceType);

    List<Lead> findAllByDealValue(Double Amount);

    List<Lead> findAllByPotential(String potential);

    List<Lead> findAllByCreatedDate(Date Date1);


//fetch data weekly monthly or of 15 days
    @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[leads] where created_date >= :inputDate  ", nativeQuery = true)
    List<Lead> findWeekly(Date inputDate);

    //find all payments of week month or 15 days of a clientManager
    @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[leads] where created_date >= :inputDate AND recepient=:clientManager ", nativeQuery = true)
    List<Lead> findClientManagerDataWeekly(Date inputDate,String clientManager);

    //find all payments of week month or 15 days of a teamlead
    @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[leads] where created_date >= :inputDate AND  recepient=:teamLead", nativeQuery = true)
    List<Lead> findTeamLeadDataWeekly(Date inputDate,String teamLead);




    //clientManager filters
    @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[leads] where name=:leadName AND clientManager = :clientManager   ", nativeQuery = true)
    List<Lead> findAllClientManagerLeadsByLeadName(String leadName, String clientManager);

    @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[leads] where service_type=:serviceType AND recipient = :clientManager   ", nativeQuery = true)
    List<Lead> findAllClientManagerLeadsByServiceType(String serviceType,  String clientManager);

    @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[leads] where deal_value >=:amount AND recipient = :clientManager   ", nativeQuery = true)
    List<Lead> findAllClientManagerLeadsByAmount(Double amount,   String clientManager);

    @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[leads] where potential=:potential AND recipient = :clientManager   ", nativeQuery = true)
    List<Lead> findAllClientManagerLeadsByPotential(String potential,  String clientManager);

    @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[leads] where created_date=:createdDate AND recipient = :clientManager   ", nativeQuery = true)
    List<Lead> findAllClientManagerLeadsByCreatedDate(Date createdDate,  String clientManager);



    //teamLead filters
    @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[leads] where name=:leadName AND teamLead = :recipient   ", nativeQuery = true)
    List<Lead> findAllTeamLeadLeadsByLeadName(String leadName, String recipient);

    @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[leads] where service_type=:serviceType AND teamLead = :recipient   ", nativeQuery = true)
    List<Lead> findAllTeamLeadLeadsByServiceType(String serviceType,  String recipient);

    @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[leads] where deal_value >=:amount AND teamLead = :recipient   ", nativeQuery = true)
    List<Lead> findAllTeamLeadLeadsByAmount(Double amount,   String recipient);

    @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[leads] where potential=:potential AND teamLead = :recipient   ", nativeQuery = true)
    List<Lead> findAllTeamLeadLeadsByPotential(String potential,  String recipient);

    @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[leads] where created_date=:createdDate AND teamLead = :recipient   ", nativeQuery = true)
    List<Lead> findAllTeamLeadLeadsByCreatedDate(Date createdDate,  String recipient);


}
