package es.ubu.lsi.edat.pr01;
/*
* IMPORTANTE, SEGURAMENTE PARA EJECUTAR CORRECTAMENTE HAGA FALTA CAMBIAR lsi POR inf
* YA QUE YO LO HE CAMBIADO POR CUESTIONES DE CONFIGURACION
* */


/**
 * @param <E> the type of elements in this list
 * @see java.util.Vector
 * @since 1.2
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;



/**
 * The SubArrayComunMasLargo class represents a utility for finding the longest common subarray between two sequences of elements.
 *
 * @param <T> the type of elements in the sequences
 *
 * @author VICTOR GONZALEZ DEL CAMPO- JUAN GARCIA LOPEZ
 */
public class SubArrayComunMasLargo<T> {
	List<T> secuencia1;
	List<T> secuencia2;

	/**
	 * Constructs a new SubArrayComunMasLargo object with the given sequences.
	 *
	 * @param secuencia1 the first sequence
	 * @param secuencia2 the second sequence
	 */
	public SubArrayComunMasLargo(List<T> secuencia1, List<T> secuencia2) {
		this.secuencia1 = secuencia1;
		this.secuencia2 = secuencia2;
	}
	
	/**
	 * Gets the size of the first sequence.
	 *
	 * @return the size of the first sequence
	 */
	public int getSecuencia1tamano(){

		int size = secuencia1.size();
		return size;
	}


	/**
	 * Encuentra el subarray común más largo entre dos secuencias de elementos de manera iterativa.
	 *
	 * @author Victor Gonzalez Del Campo  ---- Juan Garcia lopez
	 *
	 * @return el subarray común más largo encontrado entre las dos secuencias
	 */
	public List<T> metodoIterativo() {
		List<T> R = new ArrayList<>();
		int maxLongitud = 0;
		int inicioSecuencia1 = 0;
		int inicioSecuencia2 = 0;
		int tamProbado = 0;
		int tamSecuencia1 = secuencia1.size();
		int tamSecuencia2 = secuencia2.size();

		for (inicioSecuencia1 = 0; inicioSecuencia1 < tamSecuencia1; inicioSecuencia1++) {
			for (tamProbado = 1; tamProbado <= (tamSecuencia1 - inicioSecuencia1); tamProbado++) {
				for (inicioSecuencia2 = 0; inicioSecuencia2 <= (tamSecuencia2 - tamProbado); inicioSecuencia2++) {
					if (secuencia1.subList(inicioSecuencia1, inicioSecuencia1 + tamProbado).equals(secuencia2.subList(inicioSecuencia2, inicioSecuencia2 + tamProbado))) {
						if (maxLongitud < tamProbado) {
							R = new ArrayList<>(secuencia1.subList(inicioSecuencia1, inicioSecuencia1 + tamProbado));
							maxLongitud = tamProbado;
						}
					}
				}
			}
		}
		return R;
	}

	/**
	 * Encuentra el subarray común más largo entre dos secuencias de elementos utilizando programación dinámica.
	 *
	 * @author Victor Gonzalez Del Campo ---- Juan Garcia lopez
	 *
	 * @return el subarray común más largo encontrado entre las dos secuencias
	 *
	 */
	public List<T> metodoProgDinamica() {
		List<T> resultado = new ArrayList<>();
		int n = secuencia1.size();
		int m = secuencia2.size();
		int[][] matrizCalculo = new int[n + 1][m + 1];
		int maxLongitud = 0;

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0) {
					matrizCalculo[i][j] = 0;
				} else if (secuencia1.get(i - 1).equals(secuencia2.get(j - 1))) {
					matrizCalculo[i][j] = matrizCalculo[i - 1][j - 1] + 1;
					if (matrizCalculo[i][j] > maxLongitud) {
						maxLongitud = matrizCalculo[i][j];
						resultado = new ArrayList<>(secuencia1.subList(i - maxLongitud, i));
					}
				} else {
					matrizCalculo[i][j] = 0;
				}
			}
		}
		return resultado;
	}
	
}
