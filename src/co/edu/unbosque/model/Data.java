package co.edu.unbosque.model;

import java.util.ArrayList;

public class Data {

	private ArrayList<Delito> listaDelitos;
	
	public Data() {
		listaDelitos = new ArrayList<Delito>();
	}

	public ArrayList<Delito> getListaDelitos() {
		return listaDelitos;
	}

	public void setListaDelitos(ArrayList<Delito> listaDelitos) {
		this.listaDelitos = listaDelitos;
	}
	
	
}
