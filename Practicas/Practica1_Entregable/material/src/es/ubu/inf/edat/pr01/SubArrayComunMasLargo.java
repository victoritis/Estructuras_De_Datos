package es.ubu.lsi.edat.pr01;


import java.util.ArrayList;
import java.util.List;

public class SubArrayComunMasLargo<T> {
	List<T> secuencia1;
	List<T> secuencia2;

	public SubArrayComunMasLargo(List<T> secuencia1, List<T> secuencia2) {
		this.secuencia1 = secuencia1;
		this.secuencia2 = secuencia2;
	}

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
