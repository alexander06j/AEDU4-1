package controlador;

import modelo.Matriz;

public class Busqueda {

	public static void main(String[] args) {

		Matriz matriz = new Matriz(1000, 1000);
		matriz.buscarNumero(500); // Ejemplo de búsqueda de número 500 y -500

		// Aquí se llamarán los métodos de ordenación
		// Llamadas a los métodos de ordenación
		matriz.bubbleSort();
		matriz.insertionSort();
		matriz.mergeSort();
		matriz.shellSort();
		matriz.countingSort();
		matriz.radixSort();
	}

}
