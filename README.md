# AEDU4-1
# Proyecto de Matriz de Números Aleatorios

## Descripción
Este proyecto genera una matriz de números aleatorios positivos y negativos de tamaño 1000 x 1000. Una vez creada la matriz, se realizan las siguientes actividades:
1. Búsqueda de un número `x` y `-x`.
2. Ordenación de los elementos de la matriz utilizando varios métodos de ordenación.

## Estructura del Proyecto
El proyecto está dividido en dos paquetes principales:
- `modelo`: Contiene la lógica del programa.
- `controlador`: Contiene la clase `Main` encargada de ejecutar el programa.

## Funcionalidades
### Generación de Matriz
- Genera una matriz de números aleatorios entre -1000 y 1000.

### Búsqueda de Números
- Búsqueda secuencial de un número `x` y su opuesto `-x`.

### Métodos de Ordenación
- **Bubble Sort**: Ordenación por burbuja.
- **Insertion Sort**: Ordenación por inserción.
- **Merge Sort**: Ordenación por mezcla.
- **Shell Sort**: Ordenación por Shell.
- **Counting Sort**: Ordenación por conteo.
- **Radix Sort**: Ordenación por base.

## Complejidad de los Algoritmos de Búsqueda
1. **Búsqueda Secuencial**: O(n)
2. **Búsqueda Binaria**: O(log n)
3. **Búsqueda por Interpolación**: O(log log n) en el mejor caso, O(n) en el peor caso

## Complejidad de los Algoritmos de Ordenación
1. **Bubble Sort**: O(n^2)
2. **Insertion Sort**: O(n^2)
3. **Merge Sort**: O(n log n)
4. **Shell Sort**: O(n log n) en el mejor caso, O(n^2) en el peor caso
5. **Counting Sort**: O(n + k)
6. **Radix Sort**: O(nk)

## Ejecución del Proyecto
Para ejecutar el proyecto, sigue estos pasos:
1. Clona el repositorio.
2. Compila las clases en el paquete `modelo`.
3. Ejecuta la clase `Main` en el paquete `controlador`.

## Ejemplo de Uso
```java
package controlador;

import modelo.Matriz;

public class Main {
    public static void main(String[] args) {
        Matriz matriz = new Matriz(1000, 1000);
        matriz.buscarNumero(500); // Ejemplo de búsqueda de número 500 y -500

        // Llamadas a los métodos de ordenación
        matriz.bubbleSort();
        matriz.insertionSort();
        matriz.mergeSort();
        matriz.shellSort();
        matriz.countingSort();
        matriz.radixSort();
    }
}

