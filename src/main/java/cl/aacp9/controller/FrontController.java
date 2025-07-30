package cl.aacp9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import cl.aacp9.service.ClienteService;

@Controller
public class FrontController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/")  	//"/":indica que es el primero en ejecutar
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("clientes", clienteService.findAll());
		modelAndView.setViewName("index");//nombre de la vista index.html
		return modelAndView;
	}
	
	//metodo de prueba
	@GetMapping(value="/{id}")
	public ModelAndView showCliente(@PathVariable("id") String idCliente) {
		System.out.println("### idCliente="+idCliente);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("cliente", clienteService.findByIdCliente(idCliente)); //"cliente" es lo que envio a la vista, lo uso con  th:value="*{cliente.[nombre-atributo]}"
		modelAndView.setViewName("showCliente"); //nombre de la vista showCliente.html
		return modelAndView;
	}
	
}
