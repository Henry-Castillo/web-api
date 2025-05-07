/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Mantenimiento.Controller;

import com.Mantenimiento.model.Cliente;
import com.Mantenimiento.servicio.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author henry.catillo
 */
/*@Controller*/

public class ClienteController {

	
	// obj de repositorio
	@Autowired
	private ClienteService serCli;



	// Controlador para cargar la pag y enviar los datos a guardar
	/*@GetMapping("/cargar")
	public String cargaryEnviarDatos(Model model, @RequestParam(required = false) Long id) {
		model.addAttribute("clientes", serCli.listar());
		model.addAttribute("cliente", id != null ? serCli.obtener(id) : new Cliente());
		return "crudclientes";
	}

	// Controlador para leer los datos ingresados
	@PostMapping("/cargar")
	public String leerDatosCrud(@ModelAttribute Cliente cliente, Model model) {
		serCli.guardar(cliente);
		return "redirect:/cargar";
	}

	@GetMapping("/eliminar")
	public String listarCliente(@RequestParam Long id) {
		serCli.eliminar(id);
		return "redirect:/cargar";
	}
*/
}
