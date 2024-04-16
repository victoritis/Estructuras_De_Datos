package es.ubu.inf.edat.p02_2324;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColaMixta<E> extends AbstractQueue<E> {

	protected class NodoMixto extends AbstractQueue<E> {

		private List<E> contenido;
		private NodoMixto siguiente;

		public NodoMixto() {
			contenido = new ArrayList<>(tamañoNodo);
			siguiente = null;
		}

		@Override
		public Iterator<E> iterator() {
			return contenido.iterator();
		}

		@Override
		public int size() {
			return contenido.size();
		}

		@Override
		public boolean offer(E e) {
			if (estaLleno()) {
				return false;
			}
			contenido.add(e);
			return true;
		}

		@Override
		public E poll() {
			if (contenido.isEmpty()) {
				return null;
			}
			return contenido.remove(0);
		}

		@Override
		public E peek() {
			if (contenido.isEmpty()) {
				return null;
			}
			return contenido.get(0);
		}

		public boolean estaLleno() {
			return contenido.size() >= tamañoNodo;
		}
	}

	private NodoMixto inicio;
	private NodoMixto fin;
	private int tamañoNodo;
	private int tamañoLista;

	public ColaMixta(int tamañoNodo) {
		this.tamañoNodo = tamañoNodo;
		inicio = null;
		fin = null;
		tamañoLista = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteradorMixto();
	}

	@Override
	public int size() {
		return tamañoLista;
	}

	@Override
	public boolean offer(E e) {
		if (inicio == null) {
			inicio = new NodoMixto();
			fin = inicio;
		} else if (fin.estaLleno()) {
			fin.siguiente = new NodoMixto();
			fin = fin.siguiente;
		}
		if (fin.offer(e)) {
			tamañoLista++;
			return true;
		}
		return false;
	}

	@Override
	public E poll() {
		if (inicio == null) {
			return null;
		}
		E e = inicio.poll();
		if (inicio.size() == 0 && inicio != fin) {
			inicio = inicio.siguiente;
		}
		if (e != null) {
			tamañoLista--;
		}
		return e;
	}

	@Override
	public E peek() {
		if (inicio == null) {
			return null;
		}
		return inicio.peek();
	}

	public E peek(int index) {
		if (index >= tamañoLista) {
			throw new IndexOutOfBoundsException();
		}
		NodoMixto temp = inicio;
		while (index >= tamañoNodo) {
			temp = temp.siguiente;
			index -= tamañoNodo;
		}
		return temp.contenido.get(index);
	}

	private class IteradorMixto implements Iterator<E> {

		private NodoMixto current = inicio;
		private int index = 0;

		@Override
		public boolean hasNext() {
			return current != null && index < tamañoLista;
		}

		@Override
		public E next() {
			E e = current.contenido.get(index % tamañoNodo);
			index++;
			if (index % tamañoNodo == 0) {
				current = current.siguiente;
			}
			return e;
		}
	}
}