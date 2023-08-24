package com.vinnilmg.hrpayroll.services;

import com.vinnilmg.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        // TODO: Mockado
        return new Payment("Teste", 100.0, days);
    }
}
