package dijkstra.modelo1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra {

	public static Grafo calculateShortestPathFromSource(Grafo grafo, Nodo nodoOrigen) {
		nodoOrigen.setDistancia(0);

		Set<Nodo> nodosVisitados = new HashSet<>();
		Set<Nodo> nodosNoVisitados = new HashSet<>();

		nodosNoVisitados.add(nodoOrigen);

		while (nodosNoVisitados.size() != 0) {

			Nodo currentNodo = getLowestDistanceNode(nodosNoVisitados);

			nodosNoVisitados.remove(currentNodo);
			for (Entry<Nodo, Integer> adjacencyPair : currentNodo.getNodosAdyacentes().entrySet()) {
				Nodo nodoAdyacente = adjacencyPair.getKey();
				Integer edgeWeight = adjacencyPair.getValue();
				if (!nodosVisitados.contains(nodoAdyacente)) {
					calculateMinimumDistance(nodoAdyacente, edgeWeight, currentNodo);
					nodosNoVisitados.add(nodoAdyacente);
				}
			}
			nodosVisitados.add(currentNodo);
		}
		return grafo;
	}

	private static Nodo getLowestDistanceNode(Set<Nodo> unsettledNodes) {
		Nodo lowestDistanceNode = null;
		int lowestDistance = Integer.MAX_VALUE;
		for (Nodo node : unsettledNodes) {
			int nodeDistance = node.getDistancia();
			if (nodeDistance < lowestDistance) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
	}
	
	private static void calculateMinimumDistance(Nodo evaluationNode,
			  Integer edgeWeigh, Nodo sourceNode) {
			    Integer sourceDistance = sourceNode.getDistancia();
			    if (sourceDistance + edgeWeigh < evaluationNode.getDistancia()) {
			        evaluationNode.setDistancia(sourceDistance + edgeWeigh);
			        LinkedList<Nodo> shortestPath = new LinkedList<>(sourceNode.getCaminoMasCorto());
			        shortestPath.add(sourceNode);
			        evaluationNode.setCaminoMasCorto(shortestPath);
			    }
			}

}
