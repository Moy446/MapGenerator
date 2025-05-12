package com.bocchi.MapGenerator.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bocchi.MapGenerator.NoiseGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class MapController {

    
    @GetMapping("/getMap")
    public double[][] getMap(@RequestParam(defaultValue = "0") long seed) {
        int width = 100;
        int height = 100;
        double[][] map = new double[width][height];

        NoiseGenerator noiseGenerator = new NoiseGenerator(seed);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double noise = noiseGenerator.noise(x * 0.1, y * 0.1); // usa una lib de ruido

                map[x][y] = (noise + 1) / 2.0;
            }
        }

        return map;
    }
}
