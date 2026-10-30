# Hola, Java: tu primer programa

El punto de partida para aprender Java: un programa con `main`, **variables** y **entrada por consola**, explicado paso a paso con comentarios. Java 21 y Maven, sin dependencias externas.

## Qué aprenderás

| Paso | Clase | Contenido |
|------|-------|-----------|
| 1 | `HolaMundo` | El método `main` (qué significa cada palabra de `public static void main(String[] args)`), `println`, `print`, `printf` y los argumentos de la línea de comandos |
| 2 | `Variables` | Los 8 tipos primitivos, `String`, bloques de texto, constantes con `final`, `var`, operadores, división entera, desbordamiento, el problema de `0.1 + 0.2`, conversiones (*casting*), un condicional y un ciclo `for` |
| 3 | `EntradaPorConsola` | Leer con `Scanner`, convertir el texto a número, **validar** la entrada y volver a preguntar si es incorrecta, y manejar el fin de la entrada |

## Requisitos

- JDK 21 y Maven 3.9 o superior.

## Compilar y ejecutar

```bash
mvn compile exec:java

# o como JAR ejecutable (fat jar)
mvn clean package
java -jar target/mvn-hola-java-1.0.0-SNAPSHOT-launcher.jar Ana Luis
```

El programa te hará unas preguntas (nombre, edad, estatura, peso). Prueba a escribir algo incorrecto, como `abc` en la edad, y verás cómo la validación te vuelve a preguntar.

> Si ves caracteres raros en Windows, ejecuta `chcp 65001` antes del comando.

## Ideas para practicar

1. Cambia el programa para que también pregunte tu ciudad y la muestre en el saludo.
2. Agrega una pregunta con `leerDecimal` para convertir de pesos a dólares.
3. Calcula el área de un círculo a partir de un radio escrito por el usuario (usa `Math.PI`).
4. Escribe un método `leerOpcion` que muestre un menú y devuelva el número elegido.

## Siguientes pasos

Condicionales y ciclos a fondo, métodos, arreglos, clases y objetos. Mira también los ejemplos `mvn-calculator`, `mvn-sort` y `mvn-collections`.

## Licencia

Código de ejemplo de uso libre con fines educativos.
