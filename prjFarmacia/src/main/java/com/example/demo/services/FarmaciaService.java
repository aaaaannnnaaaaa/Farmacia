package com.example.demo.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Farmacia;
import com.example.demo.repositories.FarmaciaRepository;

@Service
public class FarmaciaService {
	
	//instanciaSalvar
	private final FarmaciaRepository farmaciaRepository;
		
	@Autowired
	public FarmaciaService(FarmaciaRepository farmaciaRepository) {
		this.farmaciaRepository = farmaciaRepository;
	}

	public Farmacia salvarFarmacia(Farmacia farmacia) {
		return farmaciaRepository.save(farmacia);
	}
	
	//instanciaConsultarPorId
	public Farmacia consultarFarmaciaPorId(Long id) {
		return farmaciaRepository.findById(id).orElse(null);
	}
	
	//instanciaConsultarTodos
	public List<Farmacia> consultarTodos() {
		return farmaciaRepository.findAll();
	}
	
	//instanciaDeletar
	public void excluirFarmacia(Long id) {
		farmaciaRepository.deleteById(id);
	}
	
	//instanciaUpdate
	public Farmacia atualizarFarmacia(Long id, Farmacia farmaciaAtualizado) {
		Optional<Farmacia> farmaciaExistente = farmaciaRepository.findById(id);
		if (farmaciaExistente.isPresent()) {
			Farmacia farmacia = farmaciaExistente.get();
			farmacia.setNome(farmaciaAtualizado.getNome());
			farmacia.setBula(farmaciaAtualizado.getBula());
			farmacia.setDataValidade(farmaciaAtualizado.getDataValidade());
			return farmaciaRepository.save(farmacia);
		}
		else {
			return null;
		}	
	}
}
	
