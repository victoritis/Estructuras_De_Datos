package es.ubu.lsi.edat.pr01;
/*
 * IMPORTANTE, SEGURAMENTE PARA EJECUTAR CORRECTAMENTE HAGA FALTA CAMBIAR lsi POR inf
 * YA QUE YO LO HE CAMBIADO POR CUESTIONES DE CONFIGURACION
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Comprobacion_tiempos<T> {

    public Comprobacion_tiempos() {

    }

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
            System.out.printf("\n\n");

        } else {
            // Imprimir los tiempos medidos
            System.out.println("Midiendo tiempo para un array de longitud : " + secuencia1.size());
            System.out.println("Tiempo del método iterativo: " + tiempoIterativo + " milisegundos");
            System.out.println("Tiempo del método de programación dinámica: " + tiempoProgDinamica + " milisegundos");
            System.out.printf("\n\n");
        }
    }

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
