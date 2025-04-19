package com.tutorial.tutorial_spring_boot.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.tutorial_spring_boot.models.dto.ParamDTO;
import com.tutorial.tutorial_spring_boot.models.dto.ParamixDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDTO foo(
            @RequestParam(required = false, defaultValue = "Hola que tal", name = "mensaje") String message) {
        // Con name = "mensaje" renombramos el requestParam de 'message' a 'mensaje'.
        // Si ponemos required = false pero sin defaultValue, message = null
        ParamDTO param = new ParamDTO();
        param.setMessage(message);
        return param;

    }

    @GetMapping("/bar")

    public ParamixDTO bar(@RequestParam(name = "texto") String text, @RequestParam String code) {

        int codigo = 0;
        try {
            codigo = Integer.parseInt(code);
        } catch (Exception e) {
            // TODO: handle exception
        }
        ParamixDTO paramixDto = new ParamixDTO();
        paramixDto.setMessage(text);
        paramixDto.setCode(codigo);

        return paramixDto;

        // Consulta ejemplo: localhost:8081/api/params/bar?text=Buenas que tal&code=1112
    }

    @GetMapping("/request")
    public ParamixDTO request(HttpServletRequest req){
        
        Integer code = 0;
        try {
            code = Integer.parseInt(req.getParameter("code"));
        } catch (NumberFormatException e) {
            // TODO: handle exception
        }

        //Con try catch y NumberFormatException no rompe el endpoint al meter String y pone un 0.

        ParamixDTO params = new ParamixDTO();
        params.setCode(code);
        params.setMessage(req.getParameter("text"));

        return params;
    }
}