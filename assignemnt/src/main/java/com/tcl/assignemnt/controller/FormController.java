package com.tcl.assignemnt.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tcl.assignemnt.dto.FormRequestDTO;
import com.tcl.assignemnt.model.Form;
import com.tcl.assignemnt.model.FormType;
import com.tcl.assignemnt.service.FormService;

import jakarta.validation.Valid;

/****
 * This is created for forms
 * @author Sagar
 *
 */

@RestController
@RequestMapping("/api/forms")
public class FormController {


@Autowired
private FormService formService;


@PostMapping("/createForm")
public ResponseEntity<Form> createForm(@RequestBody @Valid FormRequestDTO dto) {
return ResponseEntity.ok(formService.createForm(dto));
}


@GetMapping("/latest/{formType}")
public ResponseEntity<Form> getLatest(@PathVariable("formType") FormType formType) {
return ResponseEntity.ok(formService.getLatestForm(formType));
}
}