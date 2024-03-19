package es.ubu.lsi.edat.pr01;

/*
 * IMPORTANTE, SEGURAMENTE PARA EJECUTAR CORRECTAMENTE HAGA FALTA CAMBIAR lsi POR inf
 * YA QUE YO LO HE CAMBIADO POR CUESTIONES DE CONFIGURACION
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Clase que se encarga de comprobar los tiempos de ejecución de dos métodos para encontrar el subarray común más largo.
 * Los tiempos se miden para diferentes tamaños de listas de elementos aleatorios.
 *
 * @param <T> el tipo de elementos en las listas
 */
public class Comprobacion_tiempos<T> {

    /**
     * Constructor de la clase Comprobacion_tiempos.
     */
    public Comprobacion_tiempos() {

    }

    /**
     * Comprueba los tiempos de ejecución de dos métodos para encontrar el subarray común más largo.
     *
     * @param tamano el tamaño de las listas de elementos aleatorios
     */
    public void comprobarTiempos(int tamano) {
        // Inicializar las listas con elementos aleatorios del mismo tamaño
        List<T> secuencia1 = inicializarListaAleatoria(tamano);
        List<T> secuencia2 = inicializarListaAleatoria(tamano);

        // Crear una instancia de SubArrayComunMasLargo
        SubArrayComunMasLargo<T> sacml = new SubArrayComunMasLargo<>(secuencia1, secuencia2);

        // Medir el tiempo de ejecución para el método iterativo
        long tiempoIterativo = medirTiempoMetodoIterativo(sacml);

        // Medir el tiempo de ejecución para el método de programación dinámica
        long tiempoProgDinamica = medirTiempoMetodoProgDinamica(sacml);


        if(sacml.getSecuencia1tamano()<60){
            // Imprimir los tiempos medidos
            System.out.println("Midiendo tiempo para un array de longitud : " + secuencia1.size());
            System.out.println("Tiempo del método iterativo: " + tiempoIterativo + " microsegundos");
            System.out.println("Tiempo del método de programación dinámica: " + tiempoProgDinamica + " microsegundos");
            System.out.print("\n\n");

        } else {
            // Imprimir los tiempos medidos
            System.out.println("Midiendo tiempo para un array de longitud : " + secuencia1.size());
            System.out.println("Tiempo del método iterativo: " + tiempoIterativo + " milisegundos");
            System.out.println("Tiempo del método de programación dinámica: " + tiempoProgDinamica + " milisegundos");
            System.out.print("\n\n");
        }
    }

    /**
     * Inicializa una lista con elementos aleatorios.
     *
     * @param tamano el tamaño de la lista a inicializar
     * @return una lista con elementos aleatorios
     */
    private List<T> inicializarListaAleatoria(int tamano) {
        List<T> listaAleatoria = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < tamano; i++) {
            // Generar un número aleatorio y agregarlo a la lista
            // Por ejemplo, para Integer:
            Integer elementoAleatorio = random.nextInt(100); // Genera números aleatorios entre 0 y 99
            listaAleatoria.add((T) elementoAleatorio);
        }

        return listaAleatoria;
    }

    /**
     * Mide el tiempo de ejecución del método iterativo en la clase SubArrayComunMasLargo.
     * Si el tamaño de la secuencia 1 es menor que 60, se utiliza el tiempo en nanosegundos.
     * Si el tamaño de la secuencia 1 es mayor o igual a 60, se utiliza el tiempo en milisegundos.
     *
     * @param sacml el objeto SubArrayComunMasLargo en el que se va a medir el tiempo de ejecución
     * @return el tiempo de ejecución en nanosegundos si el tamaño de la secuencia 1 es menor que 60,
     *         o en milisegundos si el tamaño de la secuencia 1 es mayor o igual a 60
     */
    private long medirTiempoMetodoIterativo(SubArrayComunMasLargo<T> sacml) {
        if(sacml.getSecuencia1tamano()<60){
            long startTime1 = System.nanoTime(); // Tiempo de inicio con nanosegundos

            sacml.metodoProgDinamica(); // Llamar al método de programación dinámica

            long endTime1 = System.nanoTime(); // Tiempo de finalización con nanosegundos
            long elapsedTime = endTime1 - startTime1;
            return elapsedTime/1000;

        } else {
            long startTime1 = System.currentTimeMillis(); // Tiempo de inicio

            sacml.metodoIterativo(); // Llamar al método iterativo

            long endTime1 = System.currentTimeMillis(); // Tiempo de finalización
            return endTime1 - startTime1; // Devolver el tiempo transcurrido en nanosegundos
        }
    }

    /**
     * Mide el tiempo de ejecución del método de programación dinámica en la clase SubArrayComunMasLargo.
     * Si el tamaño de la secuencia es menor que 60, se utiliza el tiempo en nanosegundos para medir el tiempo de ejecución.
     * De lo contrario, se utiliza el tiempo en milisegundos.
     *
     * @param sacml el objeto SubArrayComunMasLargo en el que se va a llamar al método de programación dinámica
     * @return el tiempo de ejecución del método en microsegundos
     */
    private long medirTiempoMetodoProgDinamica(SubArrayComunMasLargo<T> sacml) {
        if(sacml.getSecuencia1tamano()<60){
            long startTime1 = System.nanoTime(); // Tiempo de inicio con nanosegundos

            sacml.metodoProgDinamica(); // Llamar al método de programación dinámica

            long endTime1 = System.nanoTime(); // Tiempo de finalización con nanosegundos
            long elapsedTime = endTime1 - startTime1;
            return elapsedTime/1000;

        } else {
            long startTime1 = System.currentTimeMillis(); // Tiempo de inicio

            sacml.metodoProgDinamica(); // Llamar al método de programación dinámica

            long endTime1 = System.currentTimeMillis(); // Tiempo de finalización
            return endTime1 - startTime1; // Devolver el tiempo transcurrido en nanosegundos
        }
    }

    /**
     * Método principal que se encarga de ejecutar la comprobación de tiempos para diferentes tamaños de datos.
     *
     * @param args los argumentos de la línea de comandos (no se utilizan en este caso)
     */
    public static void main(String[] args) {
        Comprobacion_tiempos<Integer> comprobacion = new Comprobacion_tiempos<>();
        comprobacion.comprobarTiempos(10);
        comprobacion.comprobarTiempos(50);
        comprobacion.comprobarTiempos(100);
        comprobacion.comprobarTiempos(300);
        comprobacion.comprobarTiempos(600);
        comprobacion.comprobarTiempos(1000);
        comprobacion.comprobarTiempos(2000);
        comprobacion.comprobarTiempos(3000);
    }
}
