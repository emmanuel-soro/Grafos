package dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Nodo {

	private String nombre;

	private List<Nodo> caminoMasCorto = new LinkedList<>();

	private Integer distancia = Integer.MAX_VALUE;

	Map<Nodo, Integer> nodosAdyacentes = new HashMap<>();

	public Nodo(String nombre) {
		this.nombre = nombre;
	}

	public void agregarDestino(Nodo destino, int distancia) {
		nodosAdyacentes.put(destino, distancia);
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Nodo> getCaminoMasCorto() {
		return caminoMasCorto;
	}

	public Map<Nodo, Integer> getNodosAdyacentes() {
		return nodosAdyacentes;
	}

	public void setCaminoMasCorto(List<Nodo> caminoMasCorto) {
		this.caminoMasCorto = caminoMasCorto;
	}

	
}
