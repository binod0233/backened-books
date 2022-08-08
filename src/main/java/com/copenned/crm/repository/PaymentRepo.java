package com.copenned.crm.repository;

import com.copenned.crm.model.Lead;
import com.copenned.crm.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {
    List<Payment> findAllPaymentByRecipient(String clientManager);


}
