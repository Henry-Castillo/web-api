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
	public String usersPage(Model model, @RequestParam(required = false) Long id) {
		List<Cliente> clientes = Arrays.asList(rt.getForObject("http://localhost:8081/api/clientes", Cliente[].class));
		model.addAttribute("clientes", clientes);
		if (id != null) {
			Cliente cliente = rt.getForObject("http://localhost:8081/api/clientes/" + id, Cliente.class);
			model.addAttribute("cliente", cliente);
		} else {

			model.addAttribute("cliente", new Cliente());
		}
		return "crudclientes";
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

	@PostMapping("/mantenimiento/actualizar")
	public String actualizarCliente(@ModelAttribute Cliente cliente) {
		try {
			rt.put("http://localhost:8081/api/clientes", cliente);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
		}
		return "redirect:/mantenimiento";
	}

	@GetMapping("/mantenimiento/eliminar")
	public String eliminarCliente(@RequestParam Long id) {
		try {
			rt.delete("http://localhost:8081/api/clientes/" + id);
		} catch (Exception e) {
			System.out.println();
		}
		return "redirect:/mantenimiento";
	}
}
