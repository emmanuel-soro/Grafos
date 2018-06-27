package floyd;

public class Main {

	public static void main(String[] args) {
		Floyd floyd = new Floyd(3);
		
		
		floyd.agregarArista(1, 2, 8);
		floyd.agregarArista(1, 3, 5);
		floyd.agregarArista(2, 1, 3);
		floyd.agregarArista(3, 2, 2);
		
		floyd.resolver();
		
	}

}
