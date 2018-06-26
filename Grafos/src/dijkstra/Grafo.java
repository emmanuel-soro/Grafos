package dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Grafo {

	private Set<Nodo> nodos = new HashSet<>();

	public void agregarNodo(Nodo nodo) {
		nodos.add(nodo);
	}

	public Set<Nodo> getNodos() {
		return nodos;
	}

}
