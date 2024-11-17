package com.keepcoding.appfinalKC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {
	
	@GetMapping("/login")
	public String mostrarLogin() {
		return "login";
	}
	@GetMapping("/403")
	public String accesoDenegado(Model model) {
		model.addAttribute("error", "No tienes permisos para acceder a esta página.");
		return "403";
	}
	
}
