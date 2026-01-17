package com.tcl.assignemnt.service;

 
 
import com.tcl.assignemnt.dto.FormRequestDTO;
 
import com.tcl.assignemnt.model.Form;
import com.tcl.assignemnt.model.FormType;
 


public interface FormService {
	public Form createForm(FormRequestDTO dto);
	public Form getLatestForm(FormType type);

}