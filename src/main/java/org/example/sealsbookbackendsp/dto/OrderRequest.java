package org.example.sealsbookbackendsp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private String paymentMethod;
    private String shippingAddress;
}

