package com.tutorial.tutorial_spring_boot.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.tutorial_spring_boot.models.User;
import com.tutorial.tutorial_spring_boot.models.dto.userDTO;

@RestController
@RequestMapping("/api")
public class UserRestController {

    // http://localhost:8081/api/details
    // Devuelve Json con los datos insertados en body
    @GetMapping("/details1")
    public userDTO details() {

        // Trabajamos con DTO para mejorar el manejo de datos y poder filtrar datos de,
        // en este caso, User.
        User user = new User("Javier", "Raña");
        userDTO userDTO = new userDTO();
        userDTO.setTitle("Hola Mundo Spring Boot");
        userDTO.setUser(user);

        return userDTO;
    }

    @GetMapping("/apiList")
    public static List<User> listUsers() {

        List<User> userList = new ArrayList<User>();
        User user1 = new User("Javier", "Vazquez");
        User user2 = new User("Manu", "Gómez");
        User user3 = new User("Alejandro", "Piñeiro");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return userList;
    }

}
