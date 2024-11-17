package com.keepcoding.appfinalKC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keepcoding.appfinalKC.entity.Cliente;
import com.keepcoding.appfinalKC.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model) {
        try {
            model.addAttribute("clientes", clienteService.listarTodos());
            return "clientes/lista";
        } catch (Exception e) {
            model.addAttribute("error", "Error al listar clientes: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoCliente(Model model) {
        try {
            model.addAttribute("cliente", new Cliente());
            return "clientes/formulario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el formulario: " + e.getMessage());
            return "error";
        }
    }

    @PostMapping
    public String guardarCliente(@ModelAttribute Cliente cliente, Model model) {
        try {
            clienteService.guardarCliente(cliente);
            return "redirect:/clientes";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el cliente: " + e.getMessage());
            model.addAttribute("cliente", cliente);
            return "clientes/formulario";
        }
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarCliente(@PathVariable Long id, Model model) {
        try {
            Cliente cliente = clienteService.obtenerPorId(id);
            if (cliente == null) {
                throw new RuntimeException("El cliente con ID " + id + " no existe.");
            }
            model.addAttribute("cliente", cliente);
            return "clientes/formulario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el cliente: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id, Model model) {
        try {
            clienteService.eliminar(id);
            return "redirect:/clientes";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el cliente: " + e.getMessage());
            return "error";
        }
    }
}
