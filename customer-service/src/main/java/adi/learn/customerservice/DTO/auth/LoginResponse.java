package adi.learn.customerservice.DTO.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private String email;
    private long accessTokenExpiry;
    private long refreshTokenExpiry;
}
