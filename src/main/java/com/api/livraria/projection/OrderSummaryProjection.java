package com.api.livraria.projection;

import java.time.LocalDateTime;

public interface OrderSummaryProjection {

    Long getId();
    LocalDateTime getCreatedAt();
    String getCustomerName();
}
