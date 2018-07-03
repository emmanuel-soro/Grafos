package coloreo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// This class represents an undirected graph using adjacency list
public class Grafo {
	private int numeroNodos; // No. of vertices
	//private LinkedList<Integer> listaAdyacencias[];
	private List<List<Integer>> listaAdyacencias;// Adjacency List

	// Constructor
	public Grafo(int v) {
		numeroNodos = v;
		listaAdyacencias = new ArrayList<List<Integer>>(v);

		for (int i = 0; i < v; ++i) {
			listaAdyacencias.add(new ArrayList<Integer>());
		}
	}

	// Function to add an edge into the graph
	void agregarArista(int nodoOrigen, int nodoDestino) {
		listaAdyacencias.get(nodoOrigen).add(nodoDestino);
		listaAdyacencias.get(nodoDestino).add(nodoOrigen);
//		listaAdyacencias[nodoOrigen].add(nodoDestino);
//		listaAdyacencias[nodoDestino].add(nodoOrigen); // Graph is undirected
	}

	// Assigns colors (starting from 0) to all vertices and
	// prints the assignment of colors
	void colorear() {
		int nodos[] = new int[numeroNodos];

		// Initialize all vertices as unassigned
		Arrays.fill(nodos, -1);

		// Assign the first color to first vertex
		nodos[0] = 0;

		// A temporary array to store the available colors. False
		// value of available[cr] would mean that the color cr is
		// assigned to one of its adjacent vertices
		boolean disponible[] = new boolean[numeroNodos];

		// Initially, all colors are available
		Arrays.fill(disponible, true);

		// Assign colors to remaining V-1 vertices
		for (int u = 1; u < numeroNodos; u++) {
			// Process all adjacent vertices and flag their colors
			// as unavailable
			Iterator<Integer> it = listaAdyacencias.get(u).iterator();

			while (it.hasNext()) {
				int i = it.next();
				if (nodos[i] != -1) {
					disponible[nodos[i]] = false;
				}
			}

			// Find the first available color
			int color;
			for (color = 0; color < numeroNodos; color++) {
				if (disponible[color]) {
					break;
				}
			}

			nodos[u] = color; // Assign the found color

			// Reset the values back to true for the next iteration
			Arrays.fill(disponible, true);
		}

		// print the result
		for (int numeroNodo = 0; numeroNodo < numeroNodos; numeroNodo++) {
			System.out.println("Nodo " + numeroNodo + " --->  Color " + nodos[numeroNodo]);
		}
	}

	// Driver method
	public static void main(String args[]) {

		Grafo g1 = new Grafo(5);
		g1.agregarArista(0, 1);
		g1.agregarArista(0, 2);
		g1.agregarArista(1, 2);
		g1.agregarArista(1, 3);
		g1.agregarArista(2, 3);
		g1.agregarArista(3, 4);
		System.out.println("Coloring of graph 1");
		g1.colorear();

		System.out.println();
		Grafo g2 = new Grafo(5);
		g2.agregarArista(0, 1);
		g2.agregarArista(0, 2);
		g2.agregarArista(1, 2);
		g2.agregarArista(1, 4);
		g2.agregarArista(2, 4);
		g2.agregarArista(4, 3);
		System.out.println("Coloring of graph 2 ");
		g2.colorear();
	}
}