package com.juniverse.hola.basico;

/**
 * Paso 2: variables y tipos de datos.
 *
 * <p>Una variable es un nombre que guarda un valor de un tipo determinado. Java es un lenguaje de <b>tipado estático</b>:
 * el tipo se decide al declarar la variable y no cambia.</p>
 */
public final class Variables {

    private Variables() {
    }

    /** Muestra los tipos primitivos, String, constantes, inferencia con var, operadores y conversiones. */
    public static void run() {
        // ---- Tipos primitivos (guardan el valor directamente)
        byte pequeno = 127;                 // 8 bits: -128 a 127
        short corto = 32_000;               // 16 bits
        int edad = 30;                      // 32 bits: el entero más usado
        long poblacion = 8_000_000_000L;    // 64 bits: necesita la L final
        float temperatura = 36.6f;          // decimal de 32 bits: necesita la f final
        double precio = 1234.56;            // decimal de 64 bits: el decimal más usado
        char letra = 'J';                   // un carácter Unicode, entre comillas simples
        boolean activo = true;              // true o false

        System.out.println("byte=" + pequeno + ", short=" + corto + ", int=" + edad + ", long=" + poblacion);
        System.out.println("float=" + temperatura + ", double=" + precio + ", char=" + letra + ", boolean=" + activo);
        System.out.println("Rango de int: " + Integer.MIN_VALUE + " a " + Integer.MAX_VALUE);

        // ---- String: texto (es un objeto, no un primitivo, y es inmutable)
        String nombre = "Ana";
        String saludo = "Hola, " + nombre + " (" + nombre.length() + " letras)";
        System.out.println(saludo + " | mayúsculas: " + nombre.toUpperCase() + " | ¿empieza con A? " + nombre.startsWith("A"));
        System.out.println("Comparar textos: usa equals, no ==  ->  " + nombre.equals("Ana"));

        // ---- Bloque de texto (Java 15): varias líneas sin concatenar ni escapar comillas
        String tarjeta = """
                +-------------------+
                | Nombre: %s
                | Edad:   %d años
                +-------------------+
                """.formatted(nombre, edad);
        System.out.print(tarjeta);

        // ---- Constantes: final impide reasignar
        final double IVA = 0.16;
        System.out.println("Precio con IVA: " + precio * (1 + IVA));

        // ---- var (Java 10): el compilador deduce el tipo, que sigue siendo estático
        var ciudad = "Monterrey";           // String
        var cantidad = 42;                  // int
        System.out.println("var -> " + ciudad + " (" + ((Object) ciudad).getClass().getSimpleName() + "), " + cantidad);

        // ---- Operadores y trampas habituales
        System.out.println("División entera 7 / 2 = " + (7 / 2) + "  |  decimal 7 / 2.0 = " + (7 / 2.0) + "  |  resto 7 % 2 = " + (7 % 2));
        System.out.println("Desbordamiento: Integer.MAX_VALUE + 1 = " + (Integer.MAX_VALUE + 1) + " (da la vuelta, sin error)");
        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2) + " (los decimales binarios son aproximados; usa BigDecimal para dinero)");

        // ---- Conversiones (casting)
        int entero = (int) 9.99;            // explícita: se pierde la parte decimal (no redondea)
        double ampliado = edad;             // implícita: int cabe en double
        System.out.println("(int) 9.99 = " + entero + ", int a double = " + ampliado + ", Math.round(9.99) = " + Math.round(9.99));
        System.out.println("De texto a número: Integer.parseInt(\"25\") + 1 = " + (Integer.parseInt("25") + 1));
        System.out.println("De número a texto: String.valueOf(25) + 1 = " + (String.valueOf(25) + 1));

        // ---- Condicional y ciclo, para empezar a tomar decisiones y repetir
        String categoria = edad >= 18 ? "adulto" : "menor";
        System.out.println("Con " + edad + " años eres " + categoria);
        StringBuilder tabla = new StringBuilder("Tabla del 3:");
        for (int i = 1; i <= 5; i++) {
            tabla.append(' ').append(3 * i);
        }
        System.out.println(tabla);
    }
}
