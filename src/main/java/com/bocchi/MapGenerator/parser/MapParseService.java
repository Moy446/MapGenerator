package com.bocchi.MapGenerator.parser;

import org.springframework.stereotype.Service;
import java.io.StringReader;
import java.util.ArrayList;

@Service
public class MapParseService {
    public ArrayList<Parser.ElementoMapa> parsearMapa(String entrada) throws Exception {
        Lexer lexer = new Lexer(new StringReader(entrada));
        Parser parser = new Parser(lexer);
        @SuppressWarnings("unchecked")
        ArrayList<Parser.ElementoMapa> elementos = (ArrayList<Parser.ElementoMapa>) parser.parse().value;
        return elementos;
    }
}