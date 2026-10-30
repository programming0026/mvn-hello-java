package com.juniverse.hola;

import com.juniverse.hola.basico.HolaMundo;
import com.juniverse.hola.basico.Variables;
import com.juniverse.hola.consola.EntradaPorConsola;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Tu primer programa en Java: un saludo, las variables y la lectura de datos por consola.
 */
public final class Main {

    private Main() {
    }

    private static void titulo(String texto) {
        System.out.println("\n=========== " + texto + " ===========");
    }

    /**
     * Punto de entrada: la JVM empieza a ejecutar el programa aquí.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        // Salida en UTF-8 para que se vean bien los acentos y la ñ en cualquier consola
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        titulo("1. HOLA, MUNDO");
        HolaMundo.run(args);
        titulo("2. VARIABLES Y TIPOS DE DATOS");
        Variables.run();
        titulo("3. ENTRADA POR CONSOLA");
        EntradaPorConsola.run();
    }
}
