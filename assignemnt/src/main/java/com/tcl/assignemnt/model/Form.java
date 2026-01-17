package com.tcl.assignemnt.model;

import jakarta.persistence.*;

 
 

@Entity
@Table(
    name = "form",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"formType", "version"})
    }
)
public class Form extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FormType formType;

    @Column(nullable = false)
    private Integer version;

    @Lob
    @Column(nullable = false)
    private String schemaJson;

    @Column(nullable = false)
    private boolean active = true;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public FormType getFormType() {
        return formType;
    }

    public void setFormType(FormType formType) {
        this.formType = formType;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getSchemaJson() {
        return schemaJson;
    }

    public void setSchemaJson(String schemaJson) {
        this.schemaJson = schemaJson;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
