package adi.learn.customerservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Customer authentication details
 * @see Customer
 */
@Entity
@Table(name = "cust_auth")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String email;
    private String passwordHash;
}
