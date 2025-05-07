/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Mantenimiento.Controller;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.Mantenimiento.model.Cliente;

/**
 *
 * @author henry.catillo
 */
@Controller
public class ProyectoController {

	private final RestTemplate rt;

	public ProyectoController(RestTemplate rt) {
		this.rt = rt;
	}

	@GetMapping("/mantenimiento")
	public String usersPage(Model model) {
		List<Cliente> clientes = Arrays.asList(rt.getForObject("http://localhost:8081/api/clientes", Cliente[].class));
		model.addAttribute("clientes", clientes);
		model.addAttribute("cliente", new Cliente());
		return "crudclientes2";
	}

	@PostMapping("/mantenimiento")
	public String guardarCliente(@ModelAttribute Cliente cliente) {
		try {
			rt.postForObject("http://localhost:8081/api/cargar", cliente, Cliente.class);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());
		}
		return "redirect:/mantenimiento";
	}
}
