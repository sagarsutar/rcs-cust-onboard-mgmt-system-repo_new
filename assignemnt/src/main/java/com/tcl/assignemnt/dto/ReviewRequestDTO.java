package com.tcl.assignemnt.dto;

import com.tcl.assignemnt.model.SubmissionStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReviewRequestDTO {

    @NotNull(message = "Status is required")
    private SubmissionStatus status;

    @NotBlank(message = "Remarks are required")
    private String remarks;

    // Getters and Setters
    public SubmissionStatus getStatus() {
        return status;
    }

    public void setStatus(SubmissionStatus status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}