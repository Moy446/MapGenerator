package com.bocchi.MapGenerator;

import com.bocchi.MapGenerator.parser.Lexer;
import com.bocchi.MapGenerator.parser.sym;
import java_cup.runtime.Symbol;

import java.io.StringReader;

public class TestLexer {

    public static void main(String[] args) {
        try {
            // Texto de prueba
            String input = """
                pino(10, 20, 30);
                cueva(5, 15, 25);
                dragon(100, 200, 300);
                """;
            Lexer lexer = new Lexer(new StringReader(input));

            System.out.println("=== ANÁLISIS LÉXICO ===");
            Symbol token;
            int tokenCount = 0; // Contador de tokens

            do {
                token = lexer.next_token();
                tokenCount++; // Incrementar contador

                if (token.value != null) {
                    System.out.printf("Token %d - ID: %d, Valor: %s, Posición: [%d,%d]%n",
                            tokenCount, token.sym, token.value, token.left, token.right);
                } else {
                    System.out.printf("Token %d - ID: %d, Posición: [%d,%d]%n",
                            tokenCount, token.sym, token.left, token.right);
                }

            } while (token.sym != sym.EOF);

            // Mostrar el total de tokens procesados
            System.out.println("\n=== RESUMEN ===");
            System.out.printf("Total de tokens procesados: %d%n", tokenCount);

        } catch (Exception e) {
            System.err.println("Error durante el análisis léxico: " + e.getMessage());
            e.printStackTrace();
        }
    }
}