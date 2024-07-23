package com.patika.bloghubpaymentservice.dto.response;

import com.patika.bloghubpaymentservice.model.enums.PaymentStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {

    private BigDecimal amount;

    private LocalDateTime createdDateTime;

    private PaymentStatus paymentStatus;

    private String email;

}
