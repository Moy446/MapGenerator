package com.bocchi.MapGenerator.parser;

import org.springframework.stereotype.Service;
import java.io.StringReader;
import java.util.ArrayList;
import com.bocchi.MapGenerator.model.ElementoMapa; // ← Import correcto

@Service
public class MapParseService {
    public ArrayList<ElementoMapa> parsearMapa(String entrada) throws Exception {
        Lexer lexer = new Lexer(new StringReader(entrada));
        Parser parser = new Parser(lexer);
        @SuppressWarnings("unchecked")
        ArrayList<ElementoMapa> elementos = (ArrayList<ElementoMapa>) parser.parse().value;
        return elementos;
    }
}