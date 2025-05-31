package com.bocchi.MapGenerator.controllers;

import com.bocchi.MapGenerator.parser.MapParseService;
import com.bocchi.MapGenerator.model.ElementoMapa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mapa")
public class MapController {

    @Autowired
    private MapParseService mapParseService;

    @PostMapping("/parse")
    public List<ElementoMapa> parsearMapa(@RequestBody String entrada) throws Exception {
        return mapParseService.parsearMapa(entrada);
    }
}