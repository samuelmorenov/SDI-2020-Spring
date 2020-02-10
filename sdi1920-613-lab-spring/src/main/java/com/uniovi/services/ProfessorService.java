package com.uniovi.services;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Professor;

@Service
public class ProfessorService {
	
	private List<Professor> professorList = new LinkedList<Professor>();
	
	@PostConstruct
	public void init() {
		professorList.add(new Professor("11111111", "Pedro", "Sanchez", "Matematicas"));
		professorList.add(new Professor("22222222", "Juan", "Rubio", "Fisica"));
	}
	
	
	public List<Professor> getProfessors() {
		return professorList;
	}
	
	public Professor getProfessor(Long id) {
		return professorList.stream().filter(professor -> professor.getDNI().equals(id)).findFirst().get();
	}
	
	public void addProfessor(Professor professor) {
		// Si en Id es null le asignamos el ultimo + 1 de la lista
		if (professor.getDNI() == null) {
			professor.setDNI(professorList.get(professorList.size() - 1).getDNI() + 1);
		}
		professorList.add(professor);
	}

	public void deleteProfessor(Long id) {
		professorList.removeIf(professor -> professor.getDNI().equals(id));
	}
	


}
