package cl.aacp9.service;

import java.util.List;

import cl.aacp9.DTO.ClienteDTO;

public interface ClienteService {
	List<ClienteDTO> findAll();
	ClienteDTO findByIdCliente(String id);
}
