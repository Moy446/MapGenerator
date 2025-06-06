package com.bocchi.MapGenerator.controllers;

import com.bocchi.MapGenerator.NoiseGenerator;
import com.bocchi.MapGenerator.parser.Lexer;
import com.bocchi.MapGenerator.parser.MapParseService;
import com.bocchi.MapGenerator.model.ElementoMapa;
import com.bocchi.MapGenerator.parser.sym;
import java_cup.runtime.Symbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/component")
    public String[] component(@RequestBody Map<String, String> body) {
        String component = body.get("newComponent");
        String[] valores = {"", "", "", ""};
        int i = 0;

        try {
            Lexer lexer = new Lexer(new StringReader(component));
            Symbol token;
            int tokenCount = 0; // Contador de tokens

            do {
                token = lexer.next_token();
                tokenCount++; // Incrementar contador
                if(
                        (tokenCount % 2 != 0) &&
                        (i < 4)
                )
                {
                       if (i > 0)
                       {
                           valores[i] = token.value + "";
                       }
                       else
                       {
                           valores[i] = token.sym + "";
                       }

                       i++;

                }
            } while (token.sym != sym.EOF);


        } catch (Exception e) {
            System.err.println("Error durante el análisis léxico: " + e.getMessage());
            e.printStackTrace();
            valores[0] = 404 + "";
        }

        for (int n = 0; n < 4; n++)
        {
            if (valores[n].equals("null") || valores[n].equals(""))
            {
                valores[0] = 404 + "";
            }
        }

        return valores;
    }

}