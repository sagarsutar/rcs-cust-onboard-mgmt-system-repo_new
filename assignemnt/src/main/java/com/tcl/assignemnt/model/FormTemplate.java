package com.tcl.assignemnt.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "form_templates")
public class FormTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FormType formType; // CUSTOMER_ORDER, QUALIFICATION

    private Integer version;
    private Boolean active;

    @Lob
    private String schemaJson; // JSON schema of the form

    // Audit
    private String createdBy;
    private LocalDateTime createdAt;
}
