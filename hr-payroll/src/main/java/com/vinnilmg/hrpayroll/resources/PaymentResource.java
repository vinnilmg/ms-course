package com.vinnilmg.hrpayroll.resources;

import com.vinnilmg.hrpayroll.entities.Payment;
import com.vinnilmg.hrpayroll.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(
            @PathVariable Long workerId,
            @PathVariable Integer days) {
        log.info("Buscando pagamento para o trabalhador: {}", workerId);
        return ResponseEntity.ok(paymentService.getPayment(workerId, days));
    }

}
