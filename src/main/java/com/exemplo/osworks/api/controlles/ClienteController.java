package com.exemplo.osworks.api.controlles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.osworks.domain.model.Cliente;
import com.exemplo.osworks.domain.repository.ClienteRepository;

@RestController
public class ClienteController
{
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar()
	{
		return clienteRepository.findAll();
	}
	
	@GetMapping("/cliente/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId)
	{
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		
		if(cliente.isPresent())
		{
			return ResponseEntity.ok(cliente.get());
		}
		
		return ResponseEntity.notFound().build();
	}
}