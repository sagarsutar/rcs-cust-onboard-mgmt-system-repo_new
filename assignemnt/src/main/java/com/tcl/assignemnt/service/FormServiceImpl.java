package com.tcl.assignemnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcl.assignemnt.dto.FormRequestDTO;
import com.tcl.assignemnt.exception.ResourceNotFoundException;
import com.tcl.assignemnt.model.Form;
import com.tcl.assignemnt.model.FormType;
import com.tcl.assignemnt.repo.FormRepository;

@Service
public class FormServiceImpl implements FormService{

	 
	@Autowired
	private FormRepository formRepository;

	@Override
	public Form createForm(FormRequestDTO dto) {
	Form form = new Form();
	form.setFormType(dto.getFormType());
	form.setSchemaJson(dto.getSchemaJson());
	form.setVersion(dto.getVersion());
	form.setActive(true);
	return formRepository.save(form);
	}

	@Override
	public Form getLatestForm(FormType type) {
	return formRepository.findTopByFormTypeAndActiveTrueOrderByVersionDesc(type)
	.orElseThrow(() -> new ResourceNotFoundException("Form not found"));
	}
}
