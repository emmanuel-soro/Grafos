package dijkstra.modelo1;

public class Main {

	public static void main(String[] args) {
		Nodo nodoA = new Nodo("A");
		Nodo nodoB = new Nodo("B");
		Nodo nodoC = new Nodo("C");
		Nodo nodoD = new Nodo("D");
		Nodo nodoE = new Nodo("E");
		Nodo nodoF = new Nodo("F");

		nodoA.agregarDestino(nodoB, 10);
		nodoA.agregarDestino(nodoC, 15);

		nodoB.agregarDestino(nodoD, 12);
		nodoB.agregarDestino(nodoF, 15);

		nodoC.agregarDestino(nodoE, 10);

		nodoD.agregarDestino(nodoE, 2);
		nodoD.agregarDestino(nodoF, 1);

		nodoF.agregarDestino(nodoE, 5);

		Grafo grafo = new Grafo();

		grafo.agregarNodo(nodoA);
		grafo.agregarNodo(nodoB);
		grafo.agregarNodo(nodoC);
		grafo.agregarNodo(nodoD);
		grafo.agregarNodo(nodoE);
		grafo.agregarNodo(nodoF);

		Grafo grafo2 = Dijkstra.calcularRutaMasCortaDesdeOrigen(grafo, nodoA);

		for (Nodo nodo : grafo.getNodos()) {
			System.out.println("NODOA a NODO" + nodo.getNombre() +" COSTO TOTAL: "+ nodo.getDistancia());
			
			for (Nodo n : nodo.getCaminoMasCorto()) {
				System.out.print(n.getNombre() + "(Costo acumulado: "+n.getDistancia()+") ");
				
			}
			System.out.println();
			System.out.println();
		}

	}

}
