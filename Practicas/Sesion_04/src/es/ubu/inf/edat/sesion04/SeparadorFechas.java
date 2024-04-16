package es.ubu.inf.edat.sesion04;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Deque;
import java.util.List;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase de librería (solo contiene metodos estáticos auxillares).
 * Incluye el método de resumen de eventos que permite "empaquetar" en una lista la fecha inicial y final de dicho evento. 
 * 
 * @author bbaruque
 *
 */
public class SeparadorFechas {

	/**
	 * Se nos facilita un log de acciones que se han ido recogiendo a lo largo de la sesión de un usuario sobre nuestro sistema.
	 * Por simplicidad, cada acción se representará en nuestro caso solo por la fecha y hora del mismo. 
	 * Se quiere ahora agrupar los eventos concretos que se pueden localizar en esa sesión. Un evento concreto se determina 
	 * porque el intervalo de tiempo entre una acción y la siguiente será corto (y se podrá determinar por el usuario).
	 * 
	 * @param listaFechas: una cola de instantes de tiempo (fecha y hora) consecutivas en el tiempo. 
	 * Por su condición de cola, estas no se pueden desordenar o extraer en orden alterno.
	 * Contiene el conjunto completo de acciones (fechas) recogido en la interacción con el sistema.
	 * @param maxSeparacion: la duración máxima entre fechas para considerarlo como parte del mismo evento. 
	 * Todas aquellas fechas que tengan un espacio entre ellas igual o menor a esta duración se consideran agrupadas en el mismo evento. 
	 * @return conjunto de los eventos encontrados (es decir listas de LocalDateTime) en una estructura que
	 * contenga listas de solo 2 fechas: la inicial y la final del evento. 
	 * Dentro de la colección de tipo Deque que se devuelve, se pide organizar del evento más reciente (en la cabeza de la cola),
	 * compuesto por el grupo de fechas más reciente hasta el más antiguo (en la cola de la cola). 
	 */

	public static Deque<List<LocalDateTime>> separaEventos(Deque<LocalDateTime> listaFechas, Duration maxSeparacion) {
		Deque<List<LocalDateTime>> eventos = new LinkedList<>();
		List<LocalDateTime> eventoActual = new LinkedList<>();

		LocalDateTime fechaAnterior = null;

		for (LocalDateTime fechaActual : listaFechas) {
			if (fechaAnterior != null) {
				Duration duracion = Duration.between(fechaAnterior, fechaActual);
				if (duracion.compareTo(maxSeparacion) <= 0) {
					eventoActual.add(fechaActual);
				} else {
					// Si hay un evento actual, lo agregamos a la lista de eventos
					if (!eventoActual.isEmpty()) {
						eventos.addFirst(eventoActual);
					}
					// Creamos un nuevo evento con la fecha actual
					eventoActual = new LinkedList<>();
					eventoActual.add(fechaActual);
				}
			} else {
				// Agregamos la primera fecha como inicio del primer evento
				eventoActual.add(fechaActual);
			}
			fechaAnterior = fechaActual;
		}

		// Agregamos el último evento a la lista de eventos
		if (!eventoActual.isEmpty()) {
			eventos.addFirst(eventoActual);
		}

		return eventos;
	}

}
