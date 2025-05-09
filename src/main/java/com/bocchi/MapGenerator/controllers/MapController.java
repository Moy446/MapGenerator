package com.bocchi.MapGenerator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bocchi.MapGenerator.NoiseGenerator;

@RequestMapping("/map")
public class MapController {
    
    @GetMapping("/{seed}")
    public double[][] getSeed(){
        int width = 100;
        int height = 100;
        double[][] map = new double[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double noise = NoiseGenerator.noise(x * 0.1, y * 0.1); // usa una lib de ruido
                map[x][y] = noise;
            }
        }

        return map;
    }
}
