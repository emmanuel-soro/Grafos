package prim;

import java.util.*;

public class Prim {

	public static List<Arista> resolverPrim(List<List<Arista>> grafo) {

		if (grafo.isEmpty()) {
			throw new NullPointerException("The Graph is empty");
		}

		List<Arista> arbolCostoMinimo = new ArrayList<Arista>();

		PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>(new Comparator<Arista>() {

			@Override
			public int compare(Arista o1, Arista o2) {
				Arista first = o1;
				Arista second = o2;

				if (first.getPeso() < second.getPeso())
					return -1;
				else if (first.getPeso() > second.getPeso())
					return 1;
				else
					return 0;
			}
		});

		for (Arista e : grafo.get(0)) {
			colaPrioridad.add(e);
		}

		boolean[] visitado = new boolean[grafo.size()];
		visitado[0] = true;

		while (!colaPrioridad.isEmpty()) {
			Arista e = colaPrioridad.peek();

			colaPrioridad.poll();

			if (visitado[e.getNodoOrigen()] && visitado[e.getNodoDestino()]) {
				continue;
			}
			
			visitado[e.getNodoOrigen()] = true;
			
			for (Arista arista : grafo.get(e.getNodoDestino())) {
				if (!visitado[arista.getNodoDestino()]) {
					colaPrioridad.add(arista);
				}
			}
			
			visitado[e.getNodoDestino()] = true;
			
			arbolCostoMinimo.add(e);

		}
		return arbolCostoMinimo;
	}

	public static List<List<Arista>> crearGrafo(Arista[] aristas) {

		List<List<Arista>> grafo = new ArrayList<>();

		int length = aristas.length * 2;

		for (int i = 0; i < length; ++i) {
			grafo.add(new ArrayList<>());
		}

		for (Arista unaArista : aristas) {
			Arista other = new Arista(unaArista.getNodoDestino(), unaArista.getNodoOrigen(), unaArista.getPeso());
			grafo.get(unaArista.getNodoOrigen()).add(unaArista);
			grafo.get(unaArista.getNodoDestino()).add(other);
			System.out.println("Agregado nodo [" + unaArista.getNodoOrigen() + ", " + unaArista.getNodoDestino() + " : "
					+ unaArista.getPeso() + "] " + "[" + unaArista.getNodoDestino() + ", " + unaArista.getNodoOrigen() + " : "
					+ unaArista.getPeso() + "]");
		}

		return grafo;
	}

	public static void main(String[] args) {
		Arista[] aristas = new Arista[16];

		aristas[0] = new Arista(0, 7, 16);
		aristas[1] = new Arista(2, 3, 17);
		aristas[2] = new Arista(1, 7, 19);
		aristas[3] = new Arista(0, 2, 26);

		aristas[4] = new Arista(5, 7, 28);
		aristas[5] = new Arista(1, 3, 29);
		aristas[6] = new Arista(1, 5, 32);
		aristas[7] = new Arista(2, 7, 34);

		aristas[8] = new Arista(4, 5, 35);
		aristas[9] = new Arista(1, 2, 36);
		aristas[10] = new Arista(4, 7, 37);
		aristas[11] = new Arista(0, 4, 38);

		aristas[12] = new Arista(6, 2, 40);
		aristas[13] = new Arista(3, 6, 52);
		aristas[14] = new Arista(6, 0, 58);
		aristas[15] = new Arista(6, 4, 93);

		List<List<Arista>> grafo = crearGrafo(aristas);
		List<Arista> arbolCostoMinimo = resolverPrim(grafo);

		System.out.println("Arbol abarcador de costo minimo: ");
		for (Arista e : arbolCostoMinimo) {
			System.out.println(e.getNodoOrigen() + " - " + e.getNodoDestino() + " : " + e.getPeso());
		}
	}
}