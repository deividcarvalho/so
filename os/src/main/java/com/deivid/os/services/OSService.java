package com.deivid.os.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deivid.os.domain.Cliente;
import com.deivid.os.domain.OS;
import com.deivid.os.domain.Tecnico;
import com.deivid.os.domain.enuns.Prioridade;
import com.deivid.os.domain.enuns.Status;
import com.deivid.os.dtos.OSDTO;
import com.deivid.os.repositories.OSRepository;
import com.deivid.os.services.exceptions.ObjectNotFoundException;

@Service
public class OSService {
	
	@Autowired
	private OSRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public OS findById(Integer id){
		Optional<OS> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+OS.class.getName()));
	}
	
	public List<OS> findAll(){
		return repository.findAll();
	}

	public OS create(@Valid OSDTO obj) {
		return fromDTO(obj);
	}
	
	public OS update(@Valid OSDTO obj) {
		findById(obj.getId());
		return fromDTO(obj);
		
	}
	
	private OS fromDTO(OSDTO obj) {
		OS newObj = new OS();
		newObj.setId(obj.getId());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade().getCod()));
		newObj.setStatus(Status.toEnum(obj.getStatus().getCod()));

		Tecnico tec =  tecnicoService.findById(obj.getTecnico());
		Cliente cli =  clienteService.findById(obj.getCliente());
		
		newObj.setTecnico(tec);
		newObj.setCliente(cli);
		
		if(newObj.getStatus().getCod().equals(2)) {
			newObj.setDataFechamento(LocalDateTime.now());
		}
		
		return repository.save(newObj);
		
	}


}
