package com.deivid.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deivid.os.domain.Tecnico;
import com.deivid.os.dtos.TecnicoDTO;
import com.deivid.os.repositories.TecnicoRepository;
import com.deivid.os.services.exceptions.DataIntegratyViolationException;
import com.deivid.os.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	// Injeção de dependencias
	@Autowired
	private TecnicoRepository repository;

	// Método
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		// orElseThrow = ou se não lança uma excessão
		// ()-> new ObjectNotFoundException = Chama o método que criamos passando uma
		// mensagem personalizada
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tecnico.class.getName()));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create (TecnicoDTO objDTO) {
		//Implementação 1 (Em uma linha)	
		if(findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		return repository.save(new Tecnico(null, objDTO.getNomeString(), objDTO.getCpf(), objDTO.getTelefone()));
		
		//Implementação 2 (em duas linhas)
		//Tecnico newObj = new Tecnico(null, objDTO.getNomeString(), objDTO.getCpf(), objDTO.getTelefone());
		//return repository.save(newObj);
		
	}

	private Tecnico findByCPF(TecnicoDTO objDTO) {
		Tecnico obj = repository.findByCPF(objDTO.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
		
	}
	
	
	





}
