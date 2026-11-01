package com.juniverse.hello.basics;


import java.util.logging.Logger;
import com.juniverse.hello.AppLogger;
/**
 * Paso 2: variables y tipos de datos.
 *
 * <p>Una variable es un nombre que guarda un valor de un tipo determinado. Java es un lenguaje de <b>tipado estático</b>:
 * el tipo se decide al declarar la variable y no cambia.</p>
 */
public final class Variables {
    private static final Logger LOGGER = AppLogger.get(Variables.class);


    private Variables() {
    }

    /** Muestra los tipos primitivos, String, constantes, inferencia con var, operadores y conversiones. */
    public static void run() {
        // ---- Tipos primitivos (guardan el valor directamente)
        byte small = 127;                 // 8 bits: -128 a 127
        short shortValue = 32_000;               // 16 bits
        int edad = 30;                      // 32 bits: el entero más usado
        long population = 8_000_000_000L;    // 64 bits: necesita la L final
        float temperature = 36.6f;          // decimal de 32 bits: necesita la f final
        double precio = 1234.56;            // decimal de 64 bits: el decimal más usado
        char letter = 'J';                   // un carácter Unicode, entre comillas simples
        boolean active = true;              // true o false

        LOGGER.info("byte=" + small + ", short=" + shortValue + ", int=" + edad + ", long=" + population);
        LOGGER.info("float=" + temperature + ", double=" + precio + ", char=" + letter + ", boolean=" + active);
        LOGGER.info("Rango de int: " + Integer.MIN_VALUE + " a " + Integer.MAX_VALUE);

        // ---- String: texto (es un objeto, no un primitivo, y es inmutable)
        String name = "Ana";
        String greeting = "Hola, " + name + " (" + name.length() + " letras)";
        LOGGER.info(greeting + " | mayúsculas: " + name.toUpperCase() + " | ¿empieza con A? " + name.startsWith("A"));
        LOGGER.info("Comparar textos: usa equals, no ==  ->  " + name.equals("Ana"));

        // ---- Bloque de texto (Java 15): varias líneas sin concatenar ni escapar comillas
        String card = """
                +-------------------+
                | Nombre: %s
                | Edad:   %d años
                +-------------------+
                """.formatted(name, edad);
        LOGGER.info(card);

        // ---- Constantes: final impide reasignar
        final double VAT = 0.16;
        LOGGER.info("Precio con VAT: " + precio * (1 + VAT));

        // ---- var (Java 10): el compilador deduce el tipo, que sigue siendo estático
        var city = "Monterrey";           // String
        var quantity = 42;                  // int
        LOGGER.info("var -> " + city + " (" + ((Object) city).getClass().getSimpleName() + "), " + quantity);

        // ---- Operadores y trampas habituales
        LOGGER.info("División entera 7 / 2 = " + (7 / 2) + "  |  decimal 7 / 2.0 = " + (7 / 2.0) + "  |  resto 7 % 2 = " + (7 % 2));
        LOGGER.info("Desbordamiento: Integer.MAX_VALUE + 1 = " + (Integer.MAX_VALUE + 1) + " (da la vuelta, sin error)");
        LOGGER.info("0.1 + 0.2 = " + (0.1 + 0.2) + " (los decimales binarios son aproximados; usa BigDecimal para dinero)");

        // ---- Conversiones (casting)
        int integer = (int) 9.99;            // explícita: se pierde la parte decimal (no redondea)
        double widened = edad;             // implícita: int cabe en double
        LOGGER.info("(int) 9.99 = " + integer + ", int a double = " + widened + ", Math.round(9.99) = " + Math.round(9.99));
        LOGGER.info("De texto a número: Integer.parseInt(\"25\") + 1 = " + (Integer.parseInt("25") + 1));
        LOGGER.info("De número a texto: String.valueOf(25) + 1 = " + (String.valueOf(25) + 1));

        // ---- Condicional y ciclo, para empezar a tomar decisiones y repetir
        String category = edad >= 18 ? "adulto" : "menor";
        LOGGER.info("Con " + edad + " años eres " + category);
        StringBuilder table = new StringBuilder("Tabla del 3:");
        for (int i = 1; i <= 5; i++) {
            table.append(' ').append(3 * i);
        }
        LOGGER.info(String.valueOf(table));
    }
}
