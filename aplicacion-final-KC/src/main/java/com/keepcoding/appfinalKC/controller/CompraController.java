package com.keepcoding.appfinalKC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keepcoding.appfinalKC.entity.Compra;
import com.keepcoding.appfinalKC.service.ArticuloService;
import com.keepcoding.appfinalKC.service.ClienteService;
import com.keepcoding.appfinalKC.service.CompraService;

@Controller
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public String listarCompras(Model model) {
        try {
            model.addAttribute("compras", compraService.listarTodas());
            model.addAttribute("compra", new Compra());
            model.addAttribute("articulos", articuloService.listarTodos());
            model.addAttribute("clientes", clienteService.listarTodos());
            return "compras/lista";
        } catch (Exception e) {
            model.addAttribute("error", "Error al listar compras: " + e.getMessage());
            return "error";
        }
    }


    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevaCompra(Model model) {
        try {
            model.addAttribute("compra", new Compra());
            model.addAttribute("clientes", clienteService.listarTodos());
            model.addAttribute("articulos", articuloService.listarTodos());
            return "compras/formulario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el formulario de compra: " + e.getMessage());
            return "error";
        }
    }

    @PostMapping("/guardar")
    public String guardarCompra(@ModelAttribute Compra compra, Model model) {
        try {
            if (compra.getId() != null) { 
                Compra compraExistente = compraService.obtenerPorId(compra.getId());
                if (compraExistente != null) {
                    compraExistente.setCliente(compra.getCliente());
                    compraExistente.setArticulo(compra.getArticulo());
                    compraExistente.setCantidad(compra.getCantidad());
                    compraExistente.setFecha(compra.getFecha());
                    compraExistente.setTotal(compra.getTotal());
                    compraExistente.setIva(compra.getIva());
                    compraExistente.setTotalIva(compra.getTotalIva());
                    compraService.guardarCompra(compraExistente);
                } else {
                    throw new RuntimeException("La compra a editar no existe");
                }
            } else {
                compraService.guardarCompra(compra);
            }
            return "redirect:/compras";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar la compra: " + e.getMessage());
            model.addAttribute("compra", compra);
            model.addAttribute("clientes", clienteService.listarTodos());
            model.addAttribute("articulos", articuloService.listarTodos());
            return "compras/formulario";
        }
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarCompra(@PathVariable Long id, Model model) {
        try {
            Compra compra = compraService.obtenerPorId(id);
            if (compra == null) {
                throw new RuntimeException("La compra con ID " + id + " no existe.");
            }
            model.addAttribute("compra", compra);
            model.addAttribute("clientes", clienteService.listarTodos());
            model.addAttribute("articulos", articuloService.listarTodos());
            return "compras/formulario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar la compra: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCompra(@PathVariable Long id, Model model) {
        try {
            compraService.eliminar(id);
            return "redirect:/compras";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar la compra: " + e.getMessage());
            return "error";
        }
    }
}
