package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Medicamento;
import com.empresa.repository.MedicamentoRepository;


@Service
public class MedicamentoServiceImpl implements MedicamentoService{

	//CALL REPOSITORY JPA
	@Autowired
	public MedicamentoRepository repo;
	
	
	
	
	@Override
	public List<Medicamento> listarMedicamento() {
		
		return repo.findAll();
	}

	@Override
	public Medicamento insertaMedicamento(Medicamento nuevo) {
		
		return repo.save(nuevo);
	}

	@Override
	public Optional<Medicamento> buscarPorId(int id) {
		
		return repo.findById(id);
	}

	@Override
	public List<Medicamento> buscarPorNombre(String nomnbre) {
		
		return repo.findByNombreLike(nomnbre);
	}

	@Override
	public List<Medicamento> buscarPorStock(int stok) {
		
		return repo.findByStock(stok);
	}

}
