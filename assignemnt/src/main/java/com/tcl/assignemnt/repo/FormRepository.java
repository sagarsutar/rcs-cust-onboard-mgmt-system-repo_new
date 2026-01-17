package com.tcl.assignemnt.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcl.assignemnt.model.Form;
import com.tcl.assignemnt.model.FormType;
@Repository
public interface FormRepository extends JpaRepository<Form, Long> {
Optional<Form> findTopByFormTypeAndActiveTrueOrderByVersionDesc(FormType type);
}