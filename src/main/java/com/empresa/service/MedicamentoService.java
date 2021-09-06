package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {

	public abstract List<Medicamento> listarMedicamento();
	public abstract Medicamento insertaMedicamento(Medicamento nuevo);
	public abstract Optional<Medicamento> buscarPorId(int id);
	public abstract List<Medicamento> buscarPorNombre(String nomnbre);
	public abstract List<Medicamento> buscarPorStock(int stok);
	

}
