package dfsi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    private List<Nodo> recorrido = new ArrayList<Nodo>();

    public void dfs(Nodo nodo) {

	Stack<Nodo> pila = new Stack<Nodo>();

	pila.add(nodo);
	nodo.setVisitado(true);

	while (!pila.isEmpty()) {
	    Nodo nodoActual = pila.pop();

	    // System.out.print(nodoActual.data + " ");
	    recorrido.add(nodoActual);

	    List<Nodo> listaAdyacencia = nodoActual.getListaAdyacencia();

	    for (int i = 0; i < listaAdyacencia.size(); i++) {
		Nodo nodoAdyacente = listaAdyacencia.get(i);

		if (nodoAdyacente != null && !nodoAdyacente.isVisitado()) {
		    pila.add(nodoAdyacente);
		    nodoAdyacente.setVisitado(true);
		}

	    }
	}
    }

    public static void main(String arg[]) {

	Nodo node40 = new Nodo(40);
	Nodo node10 = new Nodo(10);
	Nodo node20 = new Nodo(20);
	Nodo node30 = new Nodo(30);
	Nodo node60 = new Nodo(60);
	Nodo node50 = new Nodo(50);
	Nodo node70 = new Nodo(70);

	node40.agregarAdyacencia(node10);
	node40.agregarAdyacencia(node20);
	node10.agregarAdyacencia(node30);
	node20.agregarAdyacencia(node10);
	node20.agregarAdyacencia(node30);
	node20.agregarAdyacencia(node60);
	node20.agregarAdyacencia(node50);
	node30.agregarAdyacencia(node60);
	node60.agregarAdyacencia(node70);
	node50.agregarAdyacencia(node70);

	DepthFirstSearch depthFirstSearch = new DepthFirstSearch();

	System.out.println("The DFS traversal of the graph using stack ");
	depthFirstSearch.dfs(node40);

	for (Nodo nodo : depthFirstSearch.getRecorrido()) {
	    System.out.print(nodo.getNombre() + " ");
	}
    }

    public List<Nodo> getRecorrido() {
	return recorrido;
    }

}