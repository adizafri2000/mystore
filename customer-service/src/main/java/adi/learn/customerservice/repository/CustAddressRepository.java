package adi.learn.customerservice.repository;

import adi.learn.customerservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustAddressRepository extends JpaRepository<Address, String> {
}
