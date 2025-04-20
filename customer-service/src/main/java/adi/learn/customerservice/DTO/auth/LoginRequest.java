package adi.learn.customerservice.DTO.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {

    /**
     * Customer email
     */
    private String email;

    /**
     * Customer password
     */
    private String password;
}
