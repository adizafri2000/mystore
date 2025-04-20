package adi.learn.customerservice.repository;

import adi.learn.customerservice.model.CustomerAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustAuthRepository extends JpaRepository<CustomerAuth, String> {
}
