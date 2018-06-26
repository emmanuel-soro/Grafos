package dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra {

	public static Grafo calcularRutaMasCortaDesdeOrigen(Grafo grafo, Nodo nodoOrigen) {
		
		nodoOrigen.setDistancia(0);

		Set<Nodo> nodosVisitados = new HashSet<>();
		Set<Nodo> nodosNoVisitados = new HashSet<>();

		nodosNoVisitados.add(nodoOrigen);

		while (nodosNoVisitados.size() != 0) {

			Nodo nodoActual = obtenerNodoDistanciaMinima(nodosNoVisitados);

			nodosNoVisitados.remove(nodoActual);

			for (Entry<Nodo, Integer> adyacentesEntry : nodoActual.getNodosAdyacentes().entrySet()) {

				Nodo nodoAdyacente = adyacentesEntry.getKey();
				Integer costo = adyacentesEntry.getValue();

				if (!nodosVisitados.contains(nodoAdyacente)) {
					calcularDistanciaMinima(nodoAdyacente, costo, nodoActual);
					nodosNoVisitados.add(nodoAdyacente);
				}

			}
			nodosVisitados.add(nodoActual);
		}
		return grafo;
	}

	private static Nodo obtenerNodoDistanciaMinima(Set<Nodo> nodosNoVisitados) {

		Nodo nodoDistanciaMinima = null;
		int distanciaMinima = Integer.MAX_VALUE;

		for (Nodo nodo : nodosNoVisitados) {
			int nodoDistancia = nodo.getDistancia();
			if (nodoDistancia < distanciaMinima) {
				distanciaMinima = nodoDistancia;
				nodoDistanciaMinima = nodo;
			}
		}

		return nodoDistanciaMinima;
	}

	private static void calcularDistanciaMinima(Nodo nodo, Integer costo, Nodo nodoOrigen) {

		Integer distanciaOrigen = nodoOrigen.getDistancia();

		if (distanciaOrigen + costo < nodo.getDistancia()) {

			nodo.setDistancia(distanciaOrigen + costo);

			LinkedList<Nodo> caminoMasCorto = new LinkedList<>(nodoOrigen.getCaminoMasCorto());

			caminoMasCorto.add(nodoOrigen);
			nodo.setCaminoMasCorto(caminoMasCorto);
		}
	}

}
