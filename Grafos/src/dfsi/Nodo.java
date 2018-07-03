package dfsi;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private int nombre;
    private boolean visitado;
    private List<Nodo> listaAdyacencia;

    public Nodo(int nombre) {
	this.nombre = nombre;
	this.listaAdyacencia = new ArrayList<>();
    }

    public void agregarAdyacencia(Nodo nodoAdyacente) {
	this.listaAdyacencia.add(nodoAdyacente);
	nodoAdyacente.getListaAdyacencia().add(this);
    }

    public List<Nodo> getListaAdyacencia() {
	return listaAdyacencia;
    }

    public void setListaAdyacencia(List<Nodo> listaAdyacencia) {
	this.listaAdyacencia = listaAdyacencia;
    }

    public boolean isVisitado() {
	return visitado;
    }

    public void setVisitado(boolean visitado) {
	this.visitado = visitado;
    }

    public int getNombre() {
	return nombre;
    }

}