package com.empresa.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;


@RestController
@RequestMapping("/rest/Medicamento")
public class MedicamentoController {

	//CALL INTERFACE SERVICE
	@Autowired
	private MedicamentoService serviceM;
	
	
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listarMed(){
		
		List<Medicamento> lista=serviceM.listarMedicamento();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{idParam}")
	@ResponseBody
	public ResponseEntity<Medicamento> listarMededicamentoXId(@PathVariable("idParam") Integer idMededicamento){
		
		Optional<Medicamento> optionalMedica=serviceM.buscarPorId(idMededicamento);
		if(optionalMedica.isEmpty()) {
			return ResponseEntity.noContent().build();	
		}else {
			return ResponseEntity.ok(optionalMedica.get());
		}
		
	}
	
	@GetMapping("/nombre/{nameParam}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listarMededicamentoXNombre(@PathVariable("nameParam") String nombreMed){
		
		List<Medicamento> listaMedicamento=serviceM.buscarPorNombre(nombreMed);
		if(CollectionUtils.isEmpty(listaMedicamento)) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(listaMedicamento);
		}
		
	}
	
	@GetMapping("/stock/{stockParam}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listarMededicamentoXStock(@PathVariable("stockParam") Integer stockMed){
		
		List<Medicamento> listaMedicamento=serviceM.buscarPorStock(stockMed);
		if(CollectionUtils.isEmpty(listaMedicamento)) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(listaMedicamento);
		}
		
	}
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Medicamento> insertaAlumno(@RequestBody Medicamento nuevoMedicamento){
		if (nuevoMedicamento == null) {
			return ResponseEntity.noContent().build();	
		}else {
			nuevoMedicamento.setIdMedicamento(0);
			Medicamento objSalida = serviceM.insertaMedicamento(nuevoMedicamento);
			return ResponseEntity.ok(objSalida);
		}
	}
}
