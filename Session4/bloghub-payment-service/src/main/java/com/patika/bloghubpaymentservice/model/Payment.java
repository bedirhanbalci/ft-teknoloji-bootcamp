package com.patika.bloghubpaymentservice.model;

import com.patika.bloghubpaymentservice.model.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private BigDecimal amount;

    private LocalDateTime createdDateTime;

    private PaymentStatus paymentStatus;

    private String email;

}
