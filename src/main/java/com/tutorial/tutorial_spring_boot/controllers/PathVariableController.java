package com.tutorial.tutorial_spring_boot.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.tutorial_spring_boot.models.dto.ParamixDTO;

@RestController
@RequestMapping("api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.code}")
    private Integer code;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;

    @Value("#{${config.valuesMap}}")
    private Map<String,Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.precio}")
    private Long precio;
    


    @GetMapping("/baz/{message}")
    // El message que mandamos en api/var/baz/holaquetal es devuelto en el
    // paramixDTO.
    public ParamixDTO baz(@PathVariable() String message) {
        ParamixDTO paramixDTO = new ParamixDTO();
        paramixDTO.setMessage(message);
        return paramixDTO;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String message){
        Map<String,Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("code", code);
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("precio", precio);
        return json;
    }

}
