package com.tcl.assignemnt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SubmissionRequestDTO {

    @NotBlank(message = "Customer ID is required")
    private String customerId;

    @NotNull(message = "Form ID is required")
    private Long formId;

    @NotBlank(message = "Response JSON cannot be empty")
    private String responseJson;
    
    @NotBlank(message = "submissionStatus is required")
    private String submissionStatus;

    public String getSubmissionStatus() {
		return submissionStatus;
	}

	public void setSubmissionStatus(String submissionStatus) {
		this.submissionStatus = submissionStatus;
	}

	// Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }
}
