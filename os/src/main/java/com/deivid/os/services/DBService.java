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
	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;

	public void instaciaDB() {
		Tecnico t1 = new Tecnico(null, "Vanêssa Milena", "127.470.930-00", "(77) 9-9811-9811");
		Tecnico t2 = new Tecnico(null, "Fernanda Milena", "641.760.040-88", "(77) 9-9811-7272");
		Cliente c1 = new Cliente(null, "Deivid Carvalho", "070.998.590-80", "(77) 9-9800-9800");
		OS os1 = new OS(null, Prioridade.ALTA, "Chamado da Oi", Status.ANDAMENTO, t1, c1);

		c1.getList().add(os1);
		t1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1,t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
