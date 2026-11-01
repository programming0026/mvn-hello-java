package com.juniverse.hello;

import com.juniverse.hello.basics.HelloWorld;
import com.juniverse.hello.basics.Variables;
import com.juniverse.hello.console.ConsoleInput;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import java.util.logging.Logger;
/**
 * Tu primer programa en Java: un saludo, las variables y la lectura de datos por consola.
 */
public final class Main {
    private static final Logger LOGGER = AppLogger.get(Main.class);


    private Main() {
    }

    private static void title(String text) {
        LOGGER.info("\n=========== " + text + " ===========");
    }

    /**
     * Punto de entrada: la JVM empieza a ejecutar el programa aquí.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        // Salida en UTF-8 para que se vean bien los acentos y la ñ en cualquier consola
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        title("1. HOLA, MUNDO");
        HelloWorld.run(args);
        title("2. VARIABLES Y TIPOS DE DATOS");
        Variables.run();
        title("3. ENTRADA POR CONSOLA");
        ConsoleInput.run();
    }
}
