package com.copenned.crm.repository;

import com.copenned.crm.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Date;
import java.util.List;
@Repository

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
    List<Payment> findAllPaymentByRecipient(String clientManager);
  List<Payment> findAllPaymentByTeamLead(String teamLead);


  //find all payments of week month or 15 days
  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where last_modified_date >= :inputDate  ", nativeQuery = true)
    List<Payment> findWeekly(Date inputDate);

  //find all payments of week month or 15 days of a clientManager
  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where last_modified_date >= :inputDate AND recepient=:clientManager ", nativeQuery = true)
  List<Payment> findClientManagerDataWeekly(Date inputDate,String clientManager);

  //find all payments of week month or 15 days of a teamlead
  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where last_modified_date >= :inputDate AND  recepient=:teamLead", nativeQuery = true)
  List<Payment> findTeamLeadDataWeekly(Date inputDate,String teamLead);




  //clientManager filters
  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where payee=:leadName AND recipient = :recipient   ", nativeQuery = true)
  List<Payment> findAllClientManagerPaymentsByPayee(String leadName,  String recipient);

  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where service_type= :serviceType AND recipient = :recipient   ", nativeQuery = true)
  List<Payment> findAllClientManagerPaymentsByServiceType(String serviceType,  String recipient);

  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where amount<= :amount2 AND amount>= :amount1 AND recipient = :recipient   ", nativeQuery = true)
  List<Payment> findAllByClientManagerPaymentsAmountBetween(Double amount1, Double amount2,  String recipient);


  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where payment_method= :paymentMethod AND recipient = :recipient   ", nativeQuery = true)
  List<Payment> findAllClientManagerPaymentsByPaymentMethod(String paymentMethod,  String recipient);

  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where createdDate<= :date2 AND  createdDate>= :date1 AND recipient = :recipient   ", nativeQuery = true)
  List<Payment> findAllClientManagerPaymentsByPaymentDateBetween(Date date1, Date date2,  String recipient);


  //teamLead filters
  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where payee= :leadName AND team_lead = :recipient   ", nativeQuery = true)
  List<Payment> findAllTeamLeadPaymentsByPayee(String leadName,  String recipient);

  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where service_type= :serviceType AND team_lead = :recipient   ", nativeQuery = true)
  List<Payment> findAllTeamLeadPaymentsByServiceType(String serviceType,  String recipient);

  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where amount> :amount1 AND amount < :amount2 AND team_lead = :recipient   ", nativeQuery = true)
  List<Payment> findAllTeamLeadPaymentsByAmountBetween(Double amount1, Double amount2,  String recipient);

  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where payee= :leadName AND team_lead = :recipient", nativeQuery = true)
  List<Payment> findAllTeamLeadPaymentsByRecipientContainingIgnoreCase(String leadName,  String recipient);

  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where payment_method= :paymentMethod AND team_lead = :recipient   ", nativeQuery = true)
  List<Payment> findAllTeamLeadPaymentsByPaymentMethod(String paymentMethod,  String recipient);

  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where created_date<= :date2 AND created_date>= :date1 AND team_lead = :recipient   ", nativeQuery = true)
  List<Payment> findAllTeamLeadPaymentsByPaymentDateBetween(Date date1, Date date2,  String recipient);



  List<Payment> findAllByPayee(String leadName);

    List<Payment> findAllByServiceType(String serviceType);

    List<Payment> findAllByAmountGreaterThan(Double amount);
    List<Payment> findAllByAmountBetween(Double amount1, Double amount2);

    List<Payment> findAllByAmountLessThanEqual(Double amount);

    List<Payment> findAllByRecipientContainingIgnoreCase(String name);

    List<Payment> findAllByPaymentMethod(String  method);

    List<Payment> findAllByPaymentDateBetween(Date date1, Date date2);


}
