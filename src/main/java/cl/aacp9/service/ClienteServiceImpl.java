package cl.aacp9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.aacp9.DTO.ClienteDTO;
@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<ClienteDTO> findAll() {
		ResponseEntity<List<ClienteDTO>> response = restTemplate.exchange(
				"http://localhost:8081/api/v1/clientes", //ruta o url del endpoint proveedor (Backend)
				HttpMethod.GET, //metodo 
				null, //objeto o parametro necesario
				new ParameterizedTypeReference<List<ClienteDTO>>(){} //retorno de la respuesta 
				);
		return response.getBody();	
	}

	@Override
	public ClienteDTO findByIdCliente(String id) {
		ResponseEntity<ClienteDTO> response = restTemplate.exchange(
				"http://localhost:8081/api/v1/cliente/"+id, //ruta o url endpoint proveedor(backend)
				HttpMethod.GET, //metodo 
				null, //objeto o parametro necesario
				new ParameterizedTypeReference<ClienteDTO>(){} //retorno de la respuesta un OBJETO Cliente.
				);
		return response.getBody();	
	}

}
