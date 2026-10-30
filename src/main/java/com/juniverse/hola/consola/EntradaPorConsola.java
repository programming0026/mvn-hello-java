package com.juniverse.hola.consola;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Paso 3: leer datos que escribe el usuario.
 *
 * <p>{@link Scanner} lee de la entrada estándar ({@code System.in}). Lo importante: <b>los datos entran siempre como texto</b>;
 * hay que convertirlos al tipo que se necesita y validar que el usuario escribió algo correcto.</p>
 */
public final class EntradaPorConsola {

    private EntradaPorConsola() {
    }

    /**
     * Pide un texto.
     *
     * @param in lector de la consola
     * @param pregunta mensaje que se muestra
     * @return lo que el usuario escribió, sin espacios sobrantes
     */
    public static String leerTexto(Scanner in, String pregunta) {
        System.out.print(pregunta);
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
    public static int leerEntero(Scanner in, String pregunta, int minimo, int maximo) {
        while (true) {
            String texto = leerTexto(in, pregunta);
            try {
                int valor = Integer.parseInt(texto);
                if (valor >= minimo && valor <= maximo) {
                    return valor;
                }
                System.out.println("  El número debe estar entre " + minimo + " y " + maximo + ".");
            } catch (NumberFormatException e) {
                System.out.println("  \"" + texto + "\" no es un número entero. Inténtalo de nuevo.");
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
    public static double leerDecimal(Scanner in, String pregunta) {
        while (true) {
            String texto = leerTexto(in, pregunta).replace(',', '.');
            try {
                double valor = Double.parseDouble(texto);
                if (valor > 0) {
                    return valor;
                }
                System.out.println("  Debe ser mayor que cero.");
            } catch (NumberFormatException e) {
                System.out.println("  \"" + texto + "\" no es un número. Inténtalo de nuevo.");
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
    public static boolean leerSiNo(Scanner in, String pregunta) {
        String respuesta = leerTexto(in, pregunta + " (s/n): ").toLowerCase();
        return respuesta.startsWith("s") || respuesta.startsWith("y");
    }

    /** Hace unas preguntas, calcula con las respuestas y muestra el resultado. */
    public static void run() {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Vamos a conocernos. Responde las preguntas:");
            String nombre = leerTexto(in, "¿Cómo te llamas? ");
            if (nombre.isEmpty()) {
                nombre = "desconocido";
            }
            int edad = leerEntero(in, "¿Cuántos años tienes? ", 0, 120);
            double estatura = leerDecimal(in, "¿Cuánto mides, en metros? (por ejemplo 1.75) ");
            double peso = leerDecimal(in, "¿Cuánto pesas, en kg? ");
            boolean programa = leerSiNo(in, "¿Ya has programado antes?");

            double imc = peso / (estatura * estatura);
            System.out.println();
            System.out.printf("¡Mucho gusto, %s!%n", nombre);
            System.out.printf("Tienes %d años y dentro de 10 tendrás %d.%n", edad, edad + 10);
            System.out.printf("Tu índice de masa corporal es %.1f.%n", imc);
            System.out.println(programa
                    ? "Genial, ya tienes experiencia: ¡sigue con los siguientes ejemplos!"
                    : "¡Bienvenido al mundo de la programación! Este es tu primer paso.");
        } catch (NoSuchElementException e) {
            // Ocurre cuando la entrada termina antes de tiempo (por ejemplo, Ctrl+D o una entrada redirigida incompleta)
            System.out.println("\nSe terminó la entrada de datos antes de responder todo.");
        }
    }
}
