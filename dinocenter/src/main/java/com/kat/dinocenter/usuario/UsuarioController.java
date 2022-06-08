package com.kat.dinocenter.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceAPI usuarioServiceAPI;

    //Listar con paginacion
    @GetMapping("/index")
    public String index(@RequestParam Map<String, Object> params, Model model){

        int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
        PageRequest pageRequest = PageRequest.of(page, 8);
        Page<Usuario> usuarioPage = usuarioServiceAPI.listarPage(pageRequest);

        int totalPage = usuarioPage.getTotalPages();
        if(totalPage > 0){
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages",pages);
        }

        model.addAttribute("list", usuarioPage.getContent());

        model.addAttribute("current",page + 1);
        model.addAttribute("next",page + 2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        return "usuario/index";
    }
    @PostMapping("/guardar")
    public String guardar(Usuario usuario){
        usuarioServiceAPI.guardar(usuario);
        return "redirect:/usuario/index";
    }
    @GetMapping("/eliminar")
    public String eliminar(Long id){
        usuarioServiceAPI.eliminar(id);
        return "redirect:/usuario/index";
    }
    @GetMapping("/buscar")
    @ResponseBody
    public Usuario buscar(Long id){
        return  usuarioServiceAPI.buscar(id);
    }

}
