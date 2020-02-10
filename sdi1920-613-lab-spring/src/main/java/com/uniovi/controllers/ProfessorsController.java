package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@RestController
public class ProfessorsController {
	
	@Autowired
	private ProfessorService professorService;

	@RequestMapping("/professor/list")
	public String getList() {
		return professorService.getProfessors().toString();
	}

	@RequestMapping(value = "/professor/add/{id}")
	public String setProfessor(@ModelAttribute Professor professor) {
		professorService.addProfessor(professor);
		return "Ok";
	}

	@RequestMapping("/professor/details/{id}")
	public String getProfessor(@PathVariable Long id) {
		return professorService.getProfessor(id).toString();
	}
	
	@RequestMapping("/professor/delete/{id}")
	public String deleteProfessor(@PathVariable Long id) {
		professorService.deleteProfessor(id);
		return "Ok";
	}
	
	@RequestMapping(value = "/professor/edit/{id}")
	public String getProfessor(Model model, @PathVariable Long id) {
		model.addAttribute("professor", professorService.getProfessor(id));
		return "professor/edit";
	}

}
