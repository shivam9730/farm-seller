package com.choice.reigster.shared.utility.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "code_grp_desc")
@Data
public class CodeGroupDesc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_un_id")
    private Long busUnId;


    @Column(name = "id", nullable = false)
    private Long codeId;

    @Column(name = "description", length = 40)
    private String description;
}
