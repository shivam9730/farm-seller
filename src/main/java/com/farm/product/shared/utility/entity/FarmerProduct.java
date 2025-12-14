package com.farm.product.shared.utility.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="farmer_product_details")
public class FarmerProduct {

    @Column(name = "product_id")
    @Id
    private Long productId;

    @Column(name = "seller_id", nullable = false)
    private Long sellerId;

    @Column(name = "product_name", nullable = false, columnDefinition = "TEXT")
    private String productName;

    @Column(name = "est_qunty", nullable = false)
    private Integer estimatedQuantity;

    @Column(name = "ach_qunt", nullable = false)
    private Integer achivedQuantity;

    @Column(name = "avability_on", nullable = false)
    private LocalDate availabilityOn;

    @Column(name = "product_state")
    private Integer productState;

    @Column(name = "product_status", length = 40)
    private String productStatus;

    @CreationTimestamp
    @Column(name = "created_time_stamp", nullable = false, updatable = false)
    private LocalDateTime createdTimeStamp;

    @UpdateTimestamp
    @Column(name = "updated_time_stamp")
    private LocalDateTime updatedTimeStamp;
}
