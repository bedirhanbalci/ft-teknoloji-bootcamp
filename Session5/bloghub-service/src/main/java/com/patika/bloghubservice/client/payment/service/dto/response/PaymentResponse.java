package com.patika.bloghubservice.client.payment.service.dto.response;

import com.patika.bloghubservice.client.payment.service.dto.response.enums.PaymentStatus;
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

    private Long userId;

}
