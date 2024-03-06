package es.ubu.inf.edat.pr01;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.ubu.lsi.edat.pr01.SubArrayComunMasLargo;
/*
 * IMPORTANTE, SEGURAMENTE PARA EJECUTAR CORRECTAMENTE HAGA FALTA CAMBIAR lsi POR inf
 * YA QUE YO LO HE CAMBIADO POR CUESTIONES DE CONFIGURACION
 * */

/**
 * @author prenedo
 *
 */
public class SubArrayComunMasLargoTest_Character {

	private SubArrayComunMasLargo<Character> gestor;

	@Before
	public void antes() {
	}

	@Test
	public void comprobar() {

		List<Character> arrayUno = Arrays.asList('Q', 'u', 'e', ' ', 't', 'r', 'a', 't', 'a', ' ', 'd', 'e', ' ', 'l',
				'a', ' ', 'c', 'o', 'n', 'd', 'i', 'c', 'i', 'o', 'n', ' ', 'y', ' ', 'e', 'j', 'e', 'r', 'c', 'i', 'c',
				'i', 'o', ' ', 'd', 'e', 'l', ' ', 'f', 'a', 'm', 'o', 's', 'o', ' ', 'h', 'i', 'd', 'a', 'l', 'g',
				'o');
		List<Character> arrayDos = Arrays.asList('Q', 'u', 'e', ' ', 't', 'r', 'a', 't', 'a', ' ', 'd', 'e', ' ', 'l',
				'a', ' ', 'c', 'o', 'n', 'd', 'i', 'c', 'i', 'o', 'n', ' ', 'y', ' ', 'e', 'j', 'e', 'r', 'c', 'i', 'c',
				'i', 'o', ' ', 'd', 'e', 'l', ' ', 'f', 'a', 'm', 'o', 's', 'o', ' ', 'h', 'i', 'd', 'a', 'l', 'g',
				'o');

		gestor = new SubArrayComunMasLargo<Character>(arrayUno, arrayDos);

		List<Character> resultado = Arrays.asList('Q', 'u', 'e', ' ', 't', 'r', 'a', 't', 'a', ' ', 'd', 'e', ' ', 'l',
				'a', ' ', 'c', 'o', 'n', 'd', 'i', 'c', 'i', 'o', 'n', ' ', 'y', ' ', 'e', 'j', 'e', 'r', 'c', 'i', 'c',
				'i', 'o', ' ', 'd', 'e', 'l', ' ', 'f', 'a', 'm', 'o', 's', 'o', ' ', 'h', 'i', 'd', 'a', 'l', 'g',
				'o');

		assertTrue(resultado.equals(gestor.metodoIterativo()));
		List<Character> temporal = gestor.metodoProgDinamica();
		assertTrue(resultado.equals(temporal));

		System.out.println("funcionando");

	}
}
