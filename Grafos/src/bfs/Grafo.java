package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Grafo NO dirigido
 */
class Grafo {
    private int cantNodos;
    private List<List<Integer>> listaAdyacencia;

    public Grafo(int cantidadNodos) {
	cantNodos = cantidadNodos;
	listaAdyacencia = new ArrayList<List<Integer>>(cantidadNodos);
	for (int i = 0; i < cantidadNodos; ++i) {
	    listaAdyacencia.add(new ArrayList<Integer>());
	}
    }

    public void agregarArista(int nodoOrigen, int nodoDestino) {
	listaAdyacencia.get(nodoOrigen).add(nodoDestino);
	listaAdyacencia.get(nodoDestino).add(nodoOrigen);// eliminar para convertir en dirigido
    }

    public void BFS(int nodoInicial) {

	// marco todos como no visitados
	int visitados[] = new int[cantNodos];
	Arrays.fill(visitados, -1);

	Queue<Integer> cola = new LinkedList<Integer>();

	// señalo el inicial con salto 0 y encolo
	int saltos = 0;
	visitados[nodoInicial] = saltos;
	cola.add(nodoInicial);

	while (cola.size() != 0) {
	    // saco de cola
	    nodoInicial = cola.poll();

	    saltos++;
	    // recorro todos los nodos adyacentes, guardando salto correspondiente
	    Iterator<Integer> i = listaAdyacencia.get(nodoInicial).listIterator();

	    while (i.hasNext()) {
		int n = i.next();
		if (visitados[n] == -1) {
		    visitados[n] = saltos;
		    cola.add(n);
		}
	    }
	}
	for (int i = 0; i < visitados.length; i++) {
	    System.out.println("nodo: " + i + " salto: " + visitados[i]);
	}
    }

    // ***************ADAPTACION A MEDIO TERMINAR
    /*
     * void DFS(int nodoInicial) {
     * 
     * // marco todos como no visitados boolean visitados[] = new
     * boolean[cantNodos];
     * 
     * Stack<Integer> pila = new Stack<Integer>();
     * 
     * // señalo el inicial con salto 0 y encolo visitados[nodoInicial] = true;
     * pila.add(nodoInicial);
     * 
     * while (pila.size() != 0) { // saco de pila nodoInicial = pila.pop();
     * System.out.println("nodo: " + nodoInicial);
     * 
     * Iterator<Integer> i = listaAdyacencia.get(nodoInicial).listIterator();
     * 
     * while (i.hasNext()) { int n = i.next(); if (!visitados[n]) { visitados[n] =
     * true; pila.add(n); } } } }
     */

    // Driver method to
    public static void main(String args[]) {
	Grafo g = new Grafo(6);

	g.agregarArista(0, 1);
	g.agregarArista(0, 3);
	g.agregarArista(0, 4);
	g.agregarArista(0, 5);
	g.agregarArista(1, 2);
	g.agregarArista(1, 3);
	g.agregarArista(2, 3);
	g.agregarArista(3, 4);
	g.agregarArista(4, 5);

	g.BFS(0);
    }
}
// This code is contributed by Aakash Hasija
