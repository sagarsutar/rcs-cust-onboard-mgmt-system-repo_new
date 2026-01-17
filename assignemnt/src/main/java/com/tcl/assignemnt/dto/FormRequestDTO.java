package com.tcl.assignemnt.dto;

 
import com.tcl.assignemnt.model.FormType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class FormRequestDTO {

    @NotNull(message = "Form type is required")
    private FormType formType;

    @NotNull(message = "Version is required")
    @Positive(message = "Version must be greater than 0")
    private Integer version;

    @NotBlank(message = "Form schema JSON cannot be empty")
    private String schemaJson;

    // Getters and Setters
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
}