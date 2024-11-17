package com.keepcoding.appfinalKC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keepcoding.appfinalKC.entity.Articulo;
import com.keepcoding.appfinalKC.service.ArticuloService;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public String listarArticulos(Model model) {
        try {
            model.addAttribute("articulos", articuloService.listarTodos());
            return "articulos/lista";
        } catch (Exception e) {
            model.addAttribute("error", "Error al listar artículos: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoArticulo(Model model) {
        try {
            model.addAttribute("articulo", new Articulo());
            return "articulos/formulario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el formulario: " + e.getMessage());
            return "error";
        }
    }

    @PostMapping
    public String guardarArticulo(@ModelAttribute Articulo articulo, Model model) {
        try {
            articuloService.guardarArticulo(articulo);
            return "redirect:/articulos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el artículo: " + e.getMessage());
            model.addAttribute("articulo", articulo);
            return "articulos/formulario";
        }
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarArticulo(@PathVariable Long id, Model model) {
        try {
            Articulo articulo = articuloService.obtenerPorId(id);
            if (articulo == null) {
                throw new RuntimeException("El artículo con ID " + id + " no existe.");
            }
            model.addAttribute("articulo", articulo);
            return "articulos/formulario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el artículo: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarArticulo(@PathVariable Long id, Model model) {
        try {
            articuloService.eliminar(id);
            return "redirect:/articulos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el artículo: " + e.getMessage());
            return "error";
        }
    }
}
