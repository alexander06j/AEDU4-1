package modelo;

import java.util.Random;

public class Matriz {
	private int[][] matriz;
	private int filas;
	private int columnas;

	// Constructor
	public Matriz(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.matriz = new int[filas][columnas];
		generarMatriz();
	}

	// metodos
	private void generarMatriz() {
		Random random = new Random();
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				matriz[i][j] = random.nextInt(2001) - 1000; // Números entre -1000 y 1000
			}
		}
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public void buscarNumero(int x) {
		boolean encontradoX = false;
		boolean encontradoNegX = false;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (matriz[i][j] == x) {
					encontradoX = true;
				}
				if (matriz[i][j] == -x) {
					encontradoNegX = true;
				}
			}
		}
		System.out.println("Número " + x + " encontrado: " + encontradoX);
		System.out.println("Número " + (-x) + " encontrado: " + encontradoNegX);
	}

	// Métodos de ordenación (bubble sort, insertion sort, etc.)
	public void bubbleSort() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas - 1; j++) {
				for (int k = 0; k < columnas - j - 1; k++) {
					if (matriz[i][k] > matriz[i][k + 1]) {
						int temp = matriz[i][k];
						matriz[i][k] = matriz[i][k + 1];
						matriz[i][k + 1] = temp;
					}
				}
			}
		}
	}

	public void insertionSort() {
		for (int i = 0; i < filas; i++) {
			for (int j = 1; j < columnas; j++) {
				int key = matriz[i][j];
				int k = j - 1;
				while (k >= 0 && matriz[i][k] > key) {
					matriz[i][k + 1] = matriz[i][k];
					k = k - 1;
				}
				matriz[i][k + 1] = key;
			}
		}
	}

	public void mergeSort() {
		for (int i = 0; i < filas; i++) {
			mergeSort(matriz[i], 0, columnas - 1);
		}
	}

	private void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}

	private void merge(int[] array, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = array[left + i];
		for (int j = 0; j < n2; ++j)
			R[j] = array[mid + 1 + j];

		int i = 0, j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}

	public void shellSort() {
		for (int i = 0; i < filas; i++) {
			int n = columnas;
			for (int gap = n / 2; gap > 0; gap /= 2) {
				for (int j = gap; j < n; j++) {
					int temp = matriz[i][j];
					int k;
					for (k = j; k >= gap && matriz[i][k - gap] > temp; k -= gap) {
						matriz[i][k] = matriz[i][k - gap];
					}
					matriz[i][k] = temp;
				}
			}
		}
	}

	public void countingSort() {
		for (int i = 0; i < filas; i++) {
			int max = getMax(matriz[i]);
			int min = getMin(matriz[i]);
			int range = max - min + 1;
			int[] count = new int[range];
			int[] output = new int[columnas];

			for (int j = 0; j < columnas; j++) {
				count[matriz[i][j] - min]++;
			}

			for (int j = 1; j < count.length; j++) {
				count[j] += count[j - 1];
			}

			for (int j = columnas - 1; j >= 0; j--) {
				output[count[matriz[i][j] - min] - 1] = matriz[i][j];
				count[matriz[i][j] - min]--;
			}

			for (int j = 0; j < columnas; j++) {
				matriz[i][j] = output[j];
			}
		}
	}

	private int getMax(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	private int getMin(int[] array) {
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	public void radixSort() {
		for (int i = 0; i < filas; i++) {
			int max = getMax(matriz[i]);
			for (int exp = 1; max / exp > 0; exp *= 10) {
				countSort(matriz[i], exp);
			}
		}
	}

	private void countSort(int[] array, int exp) {
		int n = array.length;
		int[] output = new int[n];
		int[] count = new int[10];

		for (int i = 0; i < n; i++) {
			count[(array[i] / exp) % 10]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			output[count[(array[i] / exp) % 10] - 1] = array[i];
			count[(array[i] / exp) % 10]--;
		}

		for (int i = 0; i < n; i++) {
			array[i] = output[i];
		}
	}

}
