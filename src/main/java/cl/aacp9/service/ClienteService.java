package cl.aacp9.service;

import java.util.List;

import cl.aacp9.modelDTO.ClienteDTO;

public interface ClienteService {
	List<ClienteDTO> findAll();
	ClienteDTO findByIdCliente(String id);
}
