package com.farm.product.shared.utility.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_email_details")
public class ContactDetails {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "email_registered", nullable = false)
    private String email;

    @Column(name = "email_active", nullable = false)
    private Boolean emailActive;
}