package com.copenned.crm.controller;

import com.copenned.crm.dto.ListResponse.PaymentsListResponse;
import com.copenned.crm.dto.SingleResponse.PaymentResponse;
import com.copenned.crm.dto.request.PaymentAttributeFilter;
import com.copenned.crm.model.Payment;
import com.copenned.crm.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Component

@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/registerPayment")
    public PaymentResponse addPayment(@RequestBody @Valid Payment payment) {
        return paymentService.savePayment(payment);
    }

    @GetMapping("/payment/weekly-payments")
    public PaymentsListResponse weeklyPayments() {
        System.out.println("Login");
        return paymentService.getWeeklyPayments();
    }

    @GetMapping("/payment/payments")
    public PaymentsListResponse findAllPayments() {
        return paymentService.getPayments();
    }

    @GetMapping("/payment/payments/getAllLeadsOfAClientManager/{clientManager}")
    public PaymentsListResponse findAllPaymentsByClientManager(@PathVariable String clientManager) {
        return paymentService.getPaymentsByClientManager(clientManager);
    }

    @GetMapping("/payment/payments/getAllLeadsOfATeamLead/{teamLead}")
    public String findAllPaymentsByTeamLead(@PathVariable String teamLead) {
        return "Logic left";
//        return paymentService.getPaymentsByTeamLead(teamLead);
    }

    //    @PutMapping("/payment/teamlead/update/{id}")
//    public PaymentResponse updatePayment(@RequestBody  Payment payment){
//        return paymentService.updatePayment(payment);
//    }
    @GetMapping("/payment/paymentId/{id}")
    public PaymentResponse findPaymentById(@PathVariable int id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/payment/attributeSearch")
    public PaymentsListResponse paymentAttributeFilter(@RequestBody @Valid PaymentAttributeFilter filter)
    {
        return paymentService.filterByAttribute(filter);
    }
}
