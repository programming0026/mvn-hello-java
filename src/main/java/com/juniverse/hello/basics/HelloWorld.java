package com.juniverse.hello.basics;


import java.util.logging.Logger;
import com.juniverse.hello.AppLogger;
/**
 * Paso 1: el programa más pequeño de Java.
 *
 * <p>Todo programa Java empieza en el método {@code main}. La JVM lo busca con exactamente esta firma:
 * {@code public static void main(String[] args)}.</p>
 *
 * <ul>
 *   <li>{@code public}: la JVM debe poder llamarlo desde fuera de la clase.</li>
 *   <li>{@code static}: se llama sin crear un objeto de la clase.</li>
 *   <li>{@code void}: no devuelve ningún valor.</li>
 *   <li>{@code String[] args}: los argumentos que se escriben en la línea de comandos.</li>
 * </ul>
 */
public final class HelloWorld {
    private static final Logger LOGGER = AppLogger.get(HelloWorld.class);


    private HelloWorld() {
    }

    /**
     * Imprime saludos de varias formas y muestra los argumentos recibidos.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void run(String[] args) {
        LOGGER.info("¡Hola, Java!");                 // println: imprime y salta de línea
        LOGGER.info("Hola, " + "mundo");                // el logger siempre salta de línea: se une el texto antes
        LOGGER.info("");                                // salto de línea vacío
        LOGGER.info(String.format("Estás usando Java %d", Runtime.version().feature())); // printf: texto con formato (%n = salto)

        if (args.length == 0) {
            LOGGER.info("(No se recibieron argumentos. Prueba: java -jar ... Ana Luis)");
        } else {
            LOGGER.info("Argumentos recibidos: " + String.join(", ", args));
        }
    }
}
