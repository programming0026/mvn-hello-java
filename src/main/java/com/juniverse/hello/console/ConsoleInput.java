package com.juniverse.hello.console;

import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.logging.Logger;
import com.juniverse.hello.AppLogger;
/**
 * Paso 3: leer datos que escribe el usuario.
 *
 * <p>{@link Scanner} lee de la entrada estándar ({@code System.in}). Lo importante: <b>los datos entran siempre como texto</b>;
 * hay que convertirlos al tipo que se necesita y validar que el usuario escribió algo correcto.</p>
 */
public final class ConsoleInput {
    private static final Logger LOGGER = AppLogger.get(ConsoleInput.class);


    private ConsoleInput() {
    }

    /**
     * Pide un texto.
     *
     * @param in lector de la consola
     * @param pregunta mensaje que se muestra
     * @return lo que el usuario escribió, sin espacios sobrantes
     */
    public static String readText(Scanner in, String question) {
        LOGGER.info(question);
        return in.nextLine().trim();
    }

    /**
     * Pide un número entero y vuelve a preguntar mientras el usuario no escriba uno válido.
     *
     * @param in lector de la consola
     * @param pregunta mensaje que se muestra
     * @param minimo menor valor permitido
     * @param maximo mayor valor permitido
     * @return entero dentro del rango
     */
    public static int readInteger(Scanner in, String question, int min, int max) {
        while (true) {
            String text = readText(in, question);
            try {
                int value = Integer.parseInt(text);
                if (value >= min && value <= max) {
                    return value;
                }
                LOGGER.info("  El número debe estar entre " + min + " y " + max + ".");
            } catch (NumberFormatException e) {
                LOGGER.info("  \"" + text + "\" no es un número entero. Inténtalo de nuevo.");
            }
        }
    }

    /**
     * Pide un número decimal (acepta coma o punto como separador).
     *
     * @param in lector de la consola
     * @param pregunta mensaje que se muestra
     * @return decimal positivo
     */
    public static double readDecimal(Scanner in, String question) {
        while (true) {
            String text = readText(in, question).replace(',', '.');
            try {
                double value = Double.parseDouble(text);
                if (value > 0) {
                    return value;
                }
                LOGGER.info("  Debe ser mayor que cero.");
            } catch (NumberFormatException e) {
                LOGGER.info("  \"" + text + "\" no es un número. Inténtalo de nuevo.");
            }
        }
    }

    /**
     * Pide una respuesta de sí o no.
     *
     * @param in lector de la consola
     * @param pregunta mensaje que se muestra
     * @return {@code true} si respondió s, si, sí, y o yes
     */
    public static boolean readYesNo(Scanner in, String question) {
        String respuesta = readText(in, question + " (s/n): ").toLowerCase();
        return respuesta.startsWith("s") || respuesta.startsWith("y");
    }

    /** Hace unas preguntas, calcula con las respuestas y muestra el resultado. */
    public static void run() {
        Scanner in = new Scanner(System.in);
        try {
            LOGGER.info("Vamos a conocernos. Responde las preguntas:");
            String name = readText(in, "¿Cómo te llamas? ");
            if (name.isEmpty()) {
                name = "desconocido";
            }
            int edad = readInteger(in, "¿Cuántos años tienes? ", 0, 120);
            double height = readDecimal(in, "¿Cuánto mides, en metros? (por ejemplo 1.75) ");
            double weight = readDecimal(in, "¿Cuánto pesas, en kg? ");
            boolean program = readYesNo(in, "¿Ya has programado antes?");

            double bmi = weight / (height * height);
            LOGGER.info("");
            LOGGER.info(String.format("¡Mucho gusto, %s!", name));
            LOGGER.info(String.format("Tienes %d años y dentro de 10 tendrás %d.", edad, edad + 10));
            LOGGER.info(String.format("Tu índice de masa corporal es %.1f.", bmi));
            LOGGER.info(program
                    ? "Genial, ya tienes experiencia: ¡sigue con los siguientes ejemplos!"
                    : "¡Bienvenido al mundo de la programación! Este es tu primer paso.");
        } catch (NoSuchElementException e) {
            // Ocurre cuando la entrada termina antes de tiempo (por ejemplo, Ctrl+D o una entrada redirigida incompleta)
            LOGGER.info("\nSe terminó la entrada de datos antes de responder todo.");
        }
    }
}
