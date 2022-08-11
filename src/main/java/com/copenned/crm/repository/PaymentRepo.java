package com.copenned.crm.repository;

import com.copenned.crm.model.Lead;
import com.copenned.crm.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Date;
import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {
    List<Payment> findAllPaymentByRecipient(String clientManager);


  @Query(value = "SELECT * FROM [CopennedCRM].[dbo].[payments] where last_modified_date >= :inputDate  ", nativeQuery = true)
    List<Payment> findWeekly(Date inputDate);
}