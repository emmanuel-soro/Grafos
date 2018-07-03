package floyd;

public class Floyd {

	private int[][] matrizAdyacencia;
	private int n;

	public Floyd(int cantidadNodos) {
		n = cantidadNodos;
		matrizAdyacencia = new int[cantidadNodos][cantidadNodos];

		for (int i = 0; i < cantidadNodos; i++) {
			for (int j = 0; j < cantidadNodos; j++) {
				matrizAdyacencia[i][j] = -1;
			}
		}

	}

	public void agregarArista(int origen, int destino, int costo) {
		matrizAdyacencia[origen - 1][destino - 1] = costo;
	}

	public void resolver() {

		for (int k = 0; k <= n - 1; k++) {
			for (int i = 0; i <= n - 1; i++) {
				for (int j = 0; j <= n - 1; j++)

					if (i == j) {
						matrizAdyacencia[i][j] = 0;

					} else if (matrizAdyacencia[i][k] != -1 && matrizAdyacencia[k][j] != -1) {

						matrizAdyacencia[i][j] = funcionfloyd(matrizAdyacencia[i][j], matrizAdyacencia[i][k] + matrizAdyacencia[k][j]);
					}
			}
		}

		System.out.println("Matriz de adyacencia correspondiente: ");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + matrizAdyacencia[i][j]);
			}
			System.out.println();
		}
	}

	private int funcionfloyd(int i, int j) {

		if (i == -1 && j == -1) {
			return -1;
		} else if (i == -1) {
			return j;
		} else if (j == -1) {
			return i;
		} else if (i > j) {
			return j;
		} else {
			return i;
		}
	}
}