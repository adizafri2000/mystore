package adi.learn.customerservice.repository;

import adi.learn.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    /**
     * Retrieves all active users
     * @return List of active users
     */
    @Query("SELECT u FROM Customer u WHERE u.isDeleted = false")
    List<Customer> findAllActiveUsers();
}
