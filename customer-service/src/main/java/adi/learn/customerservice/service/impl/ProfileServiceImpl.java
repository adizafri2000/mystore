package adi.learn.customerservice.service.impl;

import adi.learn.customerservice.model.Customer;
import adi.learn.customerservice.repository.CustAddressRepository;
import adi.learn.customerservice.repository.CustomerRepository;
import adi.learn.customerservice.service.ProfileService;
import adi.learn.customerservice.util.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final CustomerRepository customerRepository;
    private final CustAddressRepository custAddressRepository;

    public ProfileServiceImpl(CustomerRepository customerRepository, CustAddressRepository custAddressRepository) {
        this.customerRepository = customerRepository;
        this.custAddressRepository = custAddressRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getAllActiveCustomers() {
        return customerRepository.findAllActiveUsers();
    }

    @Override
    public Customer getCustomer(String id) {
        log.info("Fetching customer with id: {}", id);
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer with id: " + id + " not found"));
    }

    @Transactional
    @Override
    public Customer createCustomer(Customer customer) {
        log.info("Creating new customer: {}", customer);
        Customer tempCust = customerRepository.save(customer);
        customer.getAddress().setCustomerId(tempCust.getId());
        custAddressRepository.save(customer.getAddress());
        return customerRepository.findById(tempCust.getId()).orElseThrow(() -> new RuntimeException("DB persistence error"));
    }

    @Override
    public boolean updateCustomer(String id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            log.info("Customer with id: {} not found, update fail", id);
            return false;
        }
        log.info("Updating customer with id: {}", id);
        customerRepository.save(mapUser(customer));
        return true;
    }

    @Override
    public boolean deleteCustomer(String id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            log.info("Customer with id: {} not found, delete fail", id);
            return false;
        }
        log.info("Deleting customer with id: {}", id);
        customerRepository.delete(customer);
        return true;
    }

    private Customer mapUser(Customer customer) {
        return Customer.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .isDeleted(customer.isDeleted())
                .build();
    }
}
