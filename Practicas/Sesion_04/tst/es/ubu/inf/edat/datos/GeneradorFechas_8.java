package es.ubu.inf.edat.datos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GeneradorFechas_8 {

	// Instante actual
	private static LocalDateTime timePoint = LocalDateTime.now();

	public static void setTime(LocalDateTime inicio) {
		timePoint = inicio;
	}

	public static LocalDateTime getFechaAleatoria() {
		return modificaTiempo();
	}

	public static LocalDateTime getFechaIncremental() {
		return incrementaTiempo();
	}

	public static LocalDateTime getFechaIncremental(Duration incremento) {
		return incrementaTiempo(incremento);
	}

	public static List<LocalDateTime> getFechasIncrementales(int tamano) {
		List<LocalDateTime> fechas = new ArrayList<LocalDateTime>(tamano);
		while (fechas.size() < tamano) {
			fechas.add(getFechaIncremental());
		}
		return fechas;
	}

	public static List<LocalDateTime> getFechasIncrementales(int tamano, Duration incremento) {
		List<LocalDateTime> fechas = new ArrayList<LocalDateTime>(tamano);
		while (fechas.size() < tamano) {
			fechas.add(getFechaIncremental(incremento));
		}
		return fechas;
	}

	public static List<LocalDateTime> getFechasAleatorias(int tamano) {
		List<LocalDateTime> fechas = new ArrayList<LocalDateTime>(tamano);
		while (fechas.size() < tamano) {
			fechas.add(getFechaAleatoria());
		}
		return fechas;
	}

	private static LocalDateTime modificaTiempo() {
		if (Math.random() >= 0.5) {
			return decrementaTiempo();
		} else {
			return incrementaTiempo();
		}
	}

	private static LocalDateTime decrementaTiempo() {
		int hours = (int) (Math.random() * 24);
		int minutes = (int) (Math.random() * 60);
		int seconds = (int) (Math.random() * 60);

		Duration decremento = Duration.ofHours(hours);
		decremento = decremento.minusMinutes(minutes);
		decremento = decremento.minusMinutes(seconds);

		return decrementaTiempo(decremento);
	}

	public static LocalDateTime decrementaTiempo(Duration decremento) {
		timePoint = timePoint.minus(decremento);
		return LocalDateTime.from(timePoint);
	}

	private static LocalDateTime incrementaTiempo() {
		int hours = (int) (Math.random() * 24);
		int minutes = (int) (Math.random() * 60);
		int seconds = (int) (Math.random() * 60);

		Duration incremento = Duration.ofHours(hours);
		incremento = incremento.plusMinutes(minutes);
		incremento = incremento.plusSeconds(seconds);

		return incrementaTiempo(incremento);
	}

	public static LocalDateTime incrementaTiempo(Duration incremento) {
		timePoint = timePoint.plus(incremento);
		return LocalDateTime.from(timePoint);
	}
}
