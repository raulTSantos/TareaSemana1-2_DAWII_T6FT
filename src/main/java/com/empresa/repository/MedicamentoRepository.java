package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{

	public abstract List<Medicamento> findByNombreLike(String nomnbre);
	 public abstract List<Medicamento> findByStock(int stok);
}
