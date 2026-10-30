package com.juniverse.hola.basico;

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
public final class HolaMundo {

    private HolaMundo() {
    }

    /**
     * Imprime saludos de varias formas y muestra los argumentos recibidos.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void run(String[] args) {
        System.out.println("¡Hola, Java!");                 // println: imprime y salta de línea
        System.out.print("Hola, ");                          // print: imprime sin saltar de línea
        System.out.print("mundo");
        System.out.println();                                // salto de línea vacío
        System.out.printf("Estás usando Java %d%n", Runtime.version().feature()); // printf: texto con formato (%n = salto)

        if (args.length == 0) {
            System.out.println("(No se recibieron argumentos. Prueba: java -jar ... Ana Luis)");
        } else {
            System.out.println("Argumentos recibidos: " + String.join(", ", args));
        }
    }
}
