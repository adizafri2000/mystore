package adi.learn.customerservice.DTO.customer.profile;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustRegistrationRequest{
    private String firstName;
    private String lastName;
    private String email;
    private CustAddressRequest address;
    private String passwordHash;
}
