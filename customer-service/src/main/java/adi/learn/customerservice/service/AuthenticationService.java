package adi.learn.customerservice.service;

import adi.learn.customerservice.DTO.auth.LoginRequest;
import adi.learn.customerservice.DTO.auth.LoginResponse;

/**
 * Manage customer authentication processes
 */
public interface AuthenticationService {
    LoginResponse login(LoginRequest loginRequest);
    void logout();
    void register();
}
