package es.ubu.gii.edat.pr03_2324;

import java.util.*;

/**
 * La clase HashMapTable implementa la interfaz Table.
 * Esta clase utiliza un HashMap para almacenar los datos.
 *
 * @param <R> El tipo de los datos que se usan como clave en las filas de la tabla
 * @param <C> El tipo de los datos que se usan como clave en las columnas de la tabla
 * @param <V> El tipo de los datos que se usan como valor en la tabla
 *
 * @author Victor Gonzalez Del Campo -- vgd1005@alu.ubu.es-v.gdelcampo@udc.es
 */
public class HashMapTable<R,C,V> implements Table<R,C,V> {
	// Mapa principal que almacena los datos
	private final Map<R, Map<C, V>> map = new HashMap<>();
	// Variable para almacenar el tamaño de la tabla
	private int size = 0;

	/**
	 * Asocia el valor especificado con su correspondiente par de claves.
	 * Si la tabla ya contiene una asociacion con esas mismas claves, el valor anterior se
	 * reemplaza por el valor introducido como parámetro
	 *
	 * @param row    Clave de fila con la que se asocia el valor
	 * @param column Clave de columna con la que se asocia el valor
	 * @param value  Valor a asociar a las dos claves determinadas
	 * @return Valor previamente asociado a ambas claves o nulo si no existía esa asociación
	 */

	@Override
	// Sobrescribe el método put de la interfaz Map para añadir un valor a una fila y columna específicas.
	public V put(R row, C column, V value) {
		// Obtiene el mapa interno correspondiente a la fila especificada, o crea uno nuevo si no existe.
		Map<C, V> innerMap = map.computeIfAbsent(row, k -> new HashMap<>());
		// Añade el valor a la columna especificada en el mapa interno, y guarda el valor anterior (si existía).
		V oldValue = innerMap.put(column, value);
		// Si el valor anterior era nulo, significa que se añadió un nuevo valor a la fila.
		if (oldValue == null) size++;
		// Devuelve el valor anterior asociado con la columna especificada, o nulo si no había ninguno.
		return oldValue;
	}



	/**
	 * Elimina la asociación entre las dos claves y su valor, si existía anteriormente.
	 * Se eliminarán los 3 elementos de la tabla, no solo el valor.
	 *
	 * @param row    Clave de fila de la asociación a ser eliminada.
	 * @param column Clave de columna de la asociación a ser eliminada.
	 * @return Valor previamente asociado a ambas claves o nulo si no existía esa asociación.
	 */
	@Override
	// Elimina un valor de una fila y columna específicas.
	public V remove(R row, C column) {
		// Obtiene el mapa interno correspondiente a la fila especificada.
		Map<C, V> innerMap = map.get(row);
		// Si no hay ningún mapa interno para la fila, devuelve nulo.
		if (innerMap == null) return null;
		// Remueve el valor de la columna especificada en el mapa interno, y guarda el valor anterior (si existía).
		V oldValue = innerMap.remove(column);
		// Si se removió con éxito un valor, decrementa el tamaño.
		if (oldValue != null) size--;
		// Si el mapa interno está vacío después de remover el valor, lo elimina de la estructura de datos principal.
		if (innerMap.isEmpty()) map.remove(row);
		// Devuelve el valor que fue removido.
		return oldValue;
	}

	/**
	 * Devuelve el valor correspondiente asociado a una determinada combinación de claves de fila
	 * y de columna o null si no existe esa asociación.
	 *
	 * @param row    Clave de fila de la asociación correspondiente al valor a recuperar.
	 * @param column Clave de columna de la asociación correspondiente al valor a recuperar.
	 * @return Valor asociado a las dos claves facilitadas o null si no existe esa asociación.
	 */
	@Override
	// Obtiene el valor asociado con una fila y columna específicas.
	public V get(Object row, Object column) {
		// Obtiene el mapa interno correspondiente a la fila especificada.
		Map<C, V> innerMap = map.get(row);
		// Si no hay ningún mapa interno para la fila, devuelve nulo.
		return innerMap == null ? null : innerMap.get(column);
	}
	/**
	 * Devuelve verdadero si la tabla contiene una asociación que incluye las claves de fila
	 * y de columna que se especifican.
	 *
	 * @param row    Clave de fila de la asociación que se pretende consultar.
	 * @param column Clave de columna de la asociación que se pretende consultar.
	 * @return true si existe la asociación y false en otro caso.
	 */
	@Override
	// Verifica si una fila y columna específicas están presentes en el mapa.
	public boolean containsKeys(Object row, Object column) {
		// Obtiene el mapa interno correspondiente a la fila especificada.
		Map<C, V> innerMap = map.get(row);
		// Devuelve verdadero si el mapa interno existe y contiene la columna especificada.
		return innerMap != null && innerMap.containsKey(column);
	}

	/**
	 * Devuelve verdadero si la tabla contiene un valor igual al que se especifica como
	 * parámetro, sin importar las claves a las que esté asociado.
	 *
	 * @param value Valor a buscar.
	 * @return true si la tabla contiene ese valor y falso en caso contrario.
	 */
	@Override
	// Verifica si el mapa contiene un valor específico.
	public boolean containsValue(V value) {
		// Utiliza un flujo para buscar en todos los mapas internos si contienen el valor especificado.
		return map.values().stream().anyMatch(innerMap -> innerMap.containsValue(value));
	}


	/**
	 * Devuelve una vista de todas las asociaciones que coinciden en emplear la misma clave
	 * de fila. Por cada asociación de clave de fila / clave de columna / valor en la tabla
	 * original, el mapa devuelto contendrá la correspondiente asociación de clave de columna / valor.
	 *
	 * @param rowKey clave de fila que se debe recuperar de la tabla
	 * @return mapa correspondiente asociando las claves de columna a su valor
	 */
	@Override
	// Devuelve un mapa que contiene todas las columnas y sus valores asociados para una fila específica.
	public Map<C, V> row(R rowKey) {
		// Obtiene el mapa interno correspondiente a la fila especificada, o un mapa vacío si la fila no existe.
		return map.getOrDefault(rowKey, Collections.emptyMap());
	}

	/**
	 * Devuelve una vista de todas las asociaciones que coinciden en emplear la misma clave
	 * de columna. Por cada asociación de clave de fila / clave de columna / valor en la tabla
	 * original, el mapa devuelto contendrá la correspondiente asociación de clave de fila / valor.
	 *
	 * @param columnKey clave de columna que se debe recuperar de la tabla
	 * @return mapa correspondiente asociando las claves de fila a su valor
	 */
	@Override
	// Devuelve un mapa que contiene todas las filas y sus valores asociados para una columna específica.
	public Map<R, V> column(C columnKey) {
		// Crea un nuevo mapa para almacenar las filas y sus valores asociados para la columna especificada.
		Map<R, V> columnMap = new HashMap<>();
		// Recorre todos los pares fila-columna en el mapa principal.
		for (Map.Entry<R, Map<C, V>> entry : map.entrySet()) {
			// Obtiene el valor asociado con la columna especificada para la fila actual.
			V value = entry.getValue().get(columnKey);
			// Si el valor no es nulo, lo agrega al mapa de columna junto con la fila correspondiente.
			if (value != null) {
				columnMap.put(entry.getKey(), value);
			}
		}
		// Devuelve el mapa de columna.
		return columnMap;
	}

	/**
	 * Devuelve el contenido completo de la tabla en forma de una conjunto de tripletas de
	 * clave de fila / clave de columna / valor. Se tratará de una vista, por lo que los cambios sobre
	 * los datos de la colección se realizarán también sobre los datos contenidos en la tabla.
	 *
	 * @return contenido
	 */
	@Override
	// Devuelve una colección de celdas que contiene todas las filas, columnas y sus valores asociados.
	public Collection<Cell<R, C, V>> cellSet() {
		// Crea una lista para almacenar todas las celdas.
		List<Cell<R, C, V>> cells = new ArrayList<>();
		// Itera sobre todas las filas en el mapa principal.
		for (R row : map.keySet()) {
			// Itera sobre todas las columnas en el mapa interno de la fila actual.
			for (C column : map.get(row).keySet()) {
				// Crea una nueva celda y agrégala a la lista de celdas.
				cells.add(new CellImpl<>(row, column, map.get(row).get(column)));
			}
		}
		// Devuelve la lista de celdas.
		return cells;
	}

	/**
	 * Devuelve el número de asociaciones de clave de columna / clave de fila / valor que
	 * se encuentran almacenadas en el mapa.
	 *
	 * @return número de asociaciones almacenadas en el mapa.
	 */
	@Override
	// Devuelve el número de elementos en el mapa.
	public int size() {
		// Retorna el tamaño almacenado previamente, que se actualiza al agregar o eliminar elementos.
		return size;
	}

	/**
	 * Devuelve true si la tabla no contiene ninguna asociación de datos y false en caso contrario.
	 *
	 * @return true si la tabla no contiene ninguna asociación de datos y false en caso contrario.
	 */
	@Override
	// Verifica si el mapa está vacío.
	public boolean isEmpty() {
		// Retorna verdadero si el tamaño del mapa es cero, lo que indica que no hay elementos.
		return size == 0;
	}

	/**
	 * Elimina todas las asociaciones de datos incluidas en el mapa.
	 */
	@Override
	// Elimina todos los elementos del mapa y restablece el tamaño a cero.
	public void clear() {
		map.clear();
		size = 0;
	}

	/**
	 * Clase interna que implementa la interfaz Cell. Esta clase encapsula los datos correspondientes
	 * a las asociaciones que se incluyen en la clase HashMapTable.
	 *
	 * @param <R> Tipo de datos que se emplean como clave en las filas de la tabla
	 * @param <C> Tipo de datos que se emplean como clave en las columnas de la tabla
	 * @param <V> Tipo de datos que se emplean como valor en la tabla
	 */
	private static class CellImpl<R, C, V> implements Cell<R, C, V> {
		// Campos para la clave de fila, clave de columna y valor de la celda.
		private final R row;
		private final C column;
		private V value;

		/**
		 * Constructor de la clase CellImpl.
		 *
		 * @param row    Clave de fila
		 * @param column Clave de columna
		 * @param value  Valor asociado a las claves de fila y columna
		 */
		private CellImpl(R row, C column, V value) {
			this.row = row;
			this.column = column;
			this.value = value;
		}

		/**
		 * Devuelve la clave de fila de la celda.
		 *
		 * @return Clave de fila de la celda
		 */
		@Override
		public R getRowKey() {
			return row;
		}

		/**
		 * Devuelve la clave de columna de la celda.
		 *
		 * @return Clave de columna de la celda
		 */
		@Override
		public C getColumnKey() {
			return column;
		}

		/**
		 * Devuelve el valor de la celda.
		 *
		 * @return Valor de la celda
		 */
		@Override
		public V getValue() {
			return value;
		}

		/**
		 * Establece el valor de la celda.
		 *
		 * @param value Nuevo valor de la celda
		 * @return Valor antiguo de la celda
		 */
		@Override
		public V setValue(V value) {
			// Guarda el valor anterior.
			V oldValue = this.value;
			// Establece el nuevo valor para la celda.
			this.value = value;
			// Devuelve el valor anterior.
			return oldValue;
		}

		/**
		 * Compara el objeto especificado con esta celda para verificar si son iguales.
		 *
		 * @param o Objeto a ser comparado con esta celda
		 * @return true si el objeto especificado es igual a esta celda
		 */
		@Override
		public boolean equals(Object o) {
			// Verifica si el objeto es la misma instancia.
			if (this == o) return true;
			// Verifica si el objeto es nulo o no es una instancia de CellImpl.
			if (o == null || getClass() != o.getClass()) return false;
			// Convierte el objeto a una instancia de CellImpl para comparar.
			CellImpl<?, ?, ?> cell = (CellImpl<?, ?, ?>) o;
			// Compara las claves de fila, columna y valor de las celdas.
			return Objects.equals(row, cell.row) &&
					Objects.equals(column, cell.column) &&
					Objects.equals(value, cell.value);
		}


		/**
		 * Devuelve el hash code de esta celda. El hash code se calcula en base a las claves de fila y columna y al valor de la celda.
		 *
		 * @return Hash code de esta celda
		 */
		@Override
		// Calcula y devuelve el hash code de la celda.
		public int hashCode() {
			// Combina los hash codes de las claves de fila, columna y valor.
			return Objects.hash(row, column, value);
		}
	}
}