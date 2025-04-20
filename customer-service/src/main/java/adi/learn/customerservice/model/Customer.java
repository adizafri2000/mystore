package adi.learn.customerservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a customer user details/metadata in the system
 */
@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String firstName;
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_address")
    private Address address;

    /**
     * Flag to see if customer has activated their account
     */
    private boolean isActivated = false;

    /**
     * Soft delete status
     */
    private boolean isDeleted = false;

}
