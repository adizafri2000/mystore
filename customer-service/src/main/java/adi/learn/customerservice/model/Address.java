package adi.learn.customerservice.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cust_address")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String line1;
    private String line2;

    @Nullable
    private String line3;

    private String city;

    /**
     * Also known as zip code
     */
    private String postCode;
    private String country;

    private String customerId;
}
