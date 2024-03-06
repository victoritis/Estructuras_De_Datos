package es.ubu.inf.edat.pr01;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.ubu.lsi.edat.pr01.SubArrayComunMasLargo;

/**
 * @author prenedo
 *
 */
public class SubArrayComunMasLargoTest_Integer {

	private SubArrayComunMasLargo<Integer> gestor;

	@Before
	public void antes() {
	}

	@Test
	public void comprobar() {

		List<Integer> arrayUno = Arrays.asList(1, 2, 4, 5, 3, 4, 6, 7, 9, 4, 5, 33, 45, 63, 2, 4, 44, 32);
		List<Integer> arrayDos = Arrays.asList(4, 2, 1, 2, 4, 5, 3, 4, 6, 7, 9, 4, 5, 33, 45, 63, 2, 4, 55, 2, 9, 10);

		gestor = new SubArrayComunMasLargo<Integer>(arrayUno, arrayDos);

		List<Integer> resultado = Arrays.asList(1, 2, 4, 5, 3, 4, 6, 7, 9, 4, 5, 33, 45, 63, 2, 4);

		System.out.println("-- testComprobar método 1 --");

		long startTime1 = System.currentTimeMillis(); // Tiempo de inicio

		assertTrue(resultado.equals(gestor.metodoIterativo()));

		long endTime1 = System.currentTimeMillis(); // Tiempo de inicio

		System.out.println("Tiempo ejecucion : " + (endTime1-startTime1));


		System.out.println("funcionando");

		long startTime2 = System.currentTimeMillis(); // Tiempo de inicio

		System.out.println("-- testComprobar método 2 --");
		assertTrue(resultado.equals(gestor.metodoProgDinamica()));

		long endTime2 = System.currentTimeMillis(); // Tiempo de inicio

		System.out.println("Tiempo ejecucion : " + (endTime2-startTime2));

		System.out.println("funcionando");

	}

	@Test
	public void disjuntos() {

		List<Integer> arrayUno = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> arrayDos = Arrays.asList(11, 12, 13, 14, 15, 16, 17);

		gestor = new SubArrayComunMasLargo<Integer>(arrayUno, arrayDos);

		List<Integer> resultado = Arrays.asList();

		System.out.println("-- testComprobar método 1 --");
		assertTrue(resultado.equals(gestor.metodoIterativo()));

		System.out.println("funcionando");

		System.out.println("-- testComprobar método 2 --");
		assertTrue(resultado.equals(gestor.metodoProgDinamica()));

		System.out.println("funcionando");

	}

	@Test
	public void limiteIzquierdo() {

		List<Integer> arrayUno = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> arrayDos = Arrays.asList(1, 11, 12, 13, 14, 15, 16, 17);

		gestor = new SubArrayComunMasLargo<Integer>(arrayUno, arrayDos);

		List<Integer> resultado = Arrays.asList(1);

		System.out.println("-- testComprobar método 1 --");
		assertTrue(resultado.equals(gestor.metodoIterativo()));

		System.out.println("funcionando");

		System.out.println("-- testComprobar método 2 --");
		assertTrue(resultado.equals(gestor.metodoProgDinamica()));

		System.out.println("funcionando");

	}

	@Test
	public void limiteDerecho() {

		List<Integer> arrayUno = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 17);
		List<Integer> arrayDos = Arrays.asList(11, 12, 13, 14, 15, 16, 17);

		gestor = new SubArrayComunMasLargo<Integer>(arrayUno, arrayDos);

		List<Integer> resultado = Arrays.asList(17);

		System.out.println("-- testComprobar método 1 --");
		assertTrue(resultado.equals(gestor.metodoIterativo()));

		System.out.println("funcionando");

		System.out.println("-- testComprobar método 2 --");
		assertTrue(resultado.equals(gestor.metodoProgDinamica()));

		System.out.println("funcionando");

	}

	@Test
	public void iguales() {

		List<Integer> arrayUno = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 17);
		List<Integer> arrayVacio = Arrays.asList();

		List<Integer> resultado = Arrays.asList();

		gestor = new SubArrayComunMasLargo<Integer>(arrayUno, arrayVacio);
		assertTrue(resultado.equals(gestor.metodoIterativo()));
		assertTrue(resultado.equals(gestor.metodoProgDinamica()));

		gestor = new SubArrayComunMasLargo<Integer>(arrayVacio, arrayUno);
		assertTrue(resultado.equals(gestor.metodoIterativo()));
		assertTrue(resultado.equals(gestor.metodoProgDinamica()));

		gestor = new SubArrayComunMasLargo<Integer>(arrayVacio, arrayVacio);
		assertTrue(resultado.equals(gestor.metodoIterativo()));
		assertTrue(resultado.equals(gestor.metodoProgDinamica()));
	}

	@Test
	public void vacios() {

		List<Integer> arrayUno = Arrays.asList(11, 12, 13, 14, 15, 16, 17);
		List<Integer> arrayDos = Arrays.asList(11, 12, 13, 14, 15, 16, 17);

		gestor = new SubArrayComunMasLargo<Integer>(arrayUno, arrayDos);

		List<Integer> resultado = Arrays.asList(11, 12, 13, 14, 15, 16, 17);

		System.out.println("-- testComprobar método 1 --");


		assertTrue(resultado.equals(gestor.metodoIterativo()));



		System.out.println("funcionando");

		System.out.println("-- testComprobar método 2 --");
		assertTrue(resultado.equals(gestor.metodoProgDinamica()));

		System.out.println("funcionando");

	}
}
