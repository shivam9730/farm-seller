package com.choice.reigster.shared.utility.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="farmer_product_details")
public class RegisterItem {

    @Column(name = "product_id")
    @Id
    private Long productId;

    @Column(name = "seller_id", nullable = false)
    private Long sellerId;

    @Column(name = "product_name", nullable = false, columnDefinition = "TEXT")
    private String productName;

    @Column(name = "est_qunty", nullable = false)
    private Integer estimatedQuantity;

    @Column(name = "avability_on", nullable = false)
    private LocalDate availabilityOn;

}
