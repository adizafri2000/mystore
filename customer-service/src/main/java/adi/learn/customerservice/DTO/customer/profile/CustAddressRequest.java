package adi.learn.customerservice.DTO.customer.profile;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustAddressRequest {
    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String postCode;
    private String country;
    private String customerId;
}
