package adi.learn.customerservice.controller;

import adi.learn.customerservice.DTO.customer.profile.CustAddressRequest;
import adi.learn.customerservice.DTO.customer.profile.CustRegistrationRequest;
import adi.learn.customerservice.DTO.BaseResponse;
import adi.learn.customerservice.model.Address;
import adi.learn.customerservice.model.Customer;
import adi.learn.customerservice.service.ProfileService;
import adi.learn.customerservice.util.enums.ResponseEnum;
import adi.learn.customerservice.util.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@Slf4j
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Operation(summary = "Get customer by id or all customers")
    @GetMapping("/")
    public BaseResponse<?> getCustomer(
            @RequestParam(value = "id", required = false) String id
    ) {
        if(id != null) {
            log.info("Get customer with id: {}", id);
            return BaseResponse.builder()
                    .responseCode(ResponseEnum.SUCCESS.getCode())
                    .responseMessage(ResponseEnum.SUCCESS.getMessage())
                    .data(profileService.getCustomer(id))
                    .build();
        }
        log.info("Get all customers");
        return BaseResponse.builder()
                .responseCode(ResponseEnum.SUCCESS.getCode())
                .responseMessage(ResponseEnum.SUCCESS.getMessage())
                .data(profileService.getAllCustomers())
                .build();
    }

    @Operation(summary = "Create new customer")
    @PostMapping("/")
    public BaseResponse<?> createCustomer(
            @RequestBody CustRegistrationRequest customer
            ) {
        log.info("Creating new customer: {}", customer);
        return BaseResponse.builder()
                .responseCode(ResponseEnum.SUCCESS.getCode())
                .responseMessage(ResponseEnum.SUCCESS.getMessage())
                .data(profileService.createCustomer(mapUser(customer)))
                .build();
    }

    @Operation(summary = "Delete customer by id")
    @DeleteMapping("/")
    public BaseResponse<?> deleteCustomer(
            @RequestParam(value = "id") String id
    ) {
        log.info("Deleting customer with id: {}", id);
        if(!profileService.deleteCustomer(id))
            throw new ResourceNotFoundException("Customer with id: " + id + " not found");
        return BaseResponse.builder()
                .responseCode(ResponseEnum.SUCCESS.getCode())
                .responseMessage(ResponseEnum.SUCCESS.getMessage())
                .data(id)
                .build();
    }

    private Customer mapUser(CustRegistrationRequest customer) {
        return Customer.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .address(mapAddress(customer.getAddress()))
                .build();
    }

    private Address mapAddress(CustAddressRequest request){
        return Address.builder()
                .line1(request.getLine1())
                .line2(request.getLine2())
                .line3(request.getLine3())
                .city(request.getCity())
                .postCode(request.getPostCode())
                .country(request.getCountry())
                .customerId(request.getCustomerId())
                .build();
    }

}
