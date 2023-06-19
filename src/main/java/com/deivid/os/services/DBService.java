package com.deivid.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deivid.os.domain.Cliente;
import com.deivid.os.domain.OS;
import com.deivid.os.domain.Tecnico;
import com.deivid.os.domain.enuns.Prioridade;
import com.deivid.os.domain.enuns.Status;
import com.deivid.os.repositories.ClienteRepository;
import com.deivid.os.repositories.OSRepository;
import com.deivid.os.repositories.TecnicoRepository;

@Service
public class DBService {

	// Injeção de Dependencias
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private OSRepository osRepository;
 
	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "Deivid", "989.383.270-51", "(77) 9-9800-9800");
		Tecnico t2 = new Tecnico(null, "Carvalho", "066.010.180-74", "(77) 9-9800-9800");

		Cliente c1 = new Cliente(null, "Vanêssa", "811.284.870-04", "(77) 9-9846-9846");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste de criação de Objetos", Status.ANDAMENTO, t1, c1);
 
		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1,t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
