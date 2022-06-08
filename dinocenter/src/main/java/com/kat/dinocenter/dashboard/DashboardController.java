package com.kat.dinocenter.dashboard;

import com.kat.dinocenter.usuario.UsuarioServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private UsuarioServiceAPI usuarioServiceAPI;

    @GetMapping("/")
    public String main(){

        return "index";
    }
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("usuarios",usuarioServiceAPI.cantidad());
        return "dashboard/index";
    }
}
