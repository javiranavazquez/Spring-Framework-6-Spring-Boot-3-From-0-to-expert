package com.tutorial.tutorial_spring_boot.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tutorial.tutorial_spring_boot.models.User;

@Controller
@RequestMapping("/api")

public class UserController {

    // http://localhost:8081/api/details
    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Javier", "Raña");
        user.setEmail("macareno@gmail.com");

        model.addAttribute("usuario", user);
        model.addAttribute("edad", "29");
        model.addAttribute("sexo", "Masculino");
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {

        model.addAttribute("title", "Lista de Usuarios");
        return "list";
    }

    // Podemos llamar a users desde cualquier vista
    @ModelAttribute("userlist")
    public List<User> usersModel() {

        return Arrays.asList(new User("Javier", "Raña", "javierranha@gmail.com"), new User("Marcos", "Rodriguez"),
                new User("Nuria", "Lopez"));
    }

}
