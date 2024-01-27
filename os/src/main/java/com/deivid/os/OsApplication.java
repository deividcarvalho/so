package com.deivid.os;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deivid.os.domain.Cliente;
import com.deivid.os.domain.OS;
import com.deivid.os.domain.Tecnico;
import com.deivid.os.domain.enuns.Prioridade;
import com.deivid.os.domain.enuns.Status;
import com.deivid.os.repositories.ClienteRepository;
import com.deivid.os.repositories.OSRepository;
import com.deivid.os.repositories.TecnicoRepository;

@SpringBootApplication
public class OsApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}


}
