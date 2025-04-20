package adi.learn.customerservice.service;

import adi.learn.customerservice.model.Customer;

import java.util.List;

/**
 * Business logic for managing customer profiles
 */
public interface ProfileService {
    List<Customer> getAllCustomers();
    List<Customer> getAllActiveCustomers();
    Customer getCustomer(String id);
    Customer createCustomer(Customer customer);
    boolean updateCustomer(String id);
    boolean deleteCustomer(String id);
}
