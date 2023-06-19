package com.deivid.os.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.deivid.os.domain.Tecnico;
import com.deivid.os.dtos.TecnicoDTO;
import com.deivid.os.services.TecnicoService;
 

//Resource = Controller
//Essa é uma classe controladora Rest que vai receber as requisições HTTP

@RestController
@RequestMapping(value = "/tecnicos") // Exemplo: http://localhost:8080/tecnicos/
public class TecnicoResource {

	// Injeção de dependencias
	@Autowired
	TecnicoService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
		Tecnico obj = service.findById(id);
		TecnicoDTO objDTO = new TecnicoDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll(){
		List<TecnicoDTO> listDTO = service.findAll().stream().map(obj->new TecnicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);

	}
	
	@PostMapping
	//receber no corpo da requisição o parametro do tipo  - @Valid realiza a validação do CPF que configuramos no TecnicoDTO
	public ResponseEntity<TecnicoDTO> create(@RequestBody @Valid TecnicoDTO objDTO){ 
		Tecnico newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
				
	}

}
