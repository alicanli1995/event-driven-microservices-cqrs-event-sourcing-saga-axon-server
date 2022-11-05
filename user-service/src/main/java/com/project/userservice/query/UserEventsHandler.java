package com.project.userservice.query;

import com.project.coreapi.model.PaymentDetails;
import com.project.coreapi.model.User;
import com.project.coreapi.query.FetchUserPaymentDetailsQuery;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserEventsHandler {


    @QueryHandler
    public User handle(FetchUserPaymentDetailsQuery query) {
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("1234-5678-9123-4562")
                .cvv("123")
                .name("ALI CANLI")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        return User.builder()
                .firstName("ALI")
                .lastName("CANLI")
                .userId(query.getUserId())
                .paymentDetails(paymentDetails)
                .build();
    }


}
