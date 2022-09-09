package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculoDelitos {

	public Registro[] calcularCantidad(ArrayList<Delito> listaDelitos, String condicion) {

		List<String> tempList = new ArrayList<>();
		int lim = listaDelitos.size();

		if (condicion == "genero") {
			for (int i = 0; i < lim; i++) {
				tempList.add(listaDelitos.get(i).getGenero());
			}
		}else if(condicion == "zona") {
			for (int i = 0; i < lim; i++) {
				tempList.add(listaDelitos.get(i).getZona());
			}
		}else if(condicion == "mes") {
			for (int i = 0; i < lim; i++) {
				tempList.add(String.valueOf(listaDelitos.get(i).getFecha().getMonth()));
			}
		}else if(condicion == "departamento") {
			for (int i = 0; i < lim; i++) {
				tempList.add(listaDelitos.get(i).getDepartamento());
			}
		}else if(condicion == "edad") {
			for (int i = 0; i < lim; i++) {
				tempList.add(String.valueOf(listaDelitos.get(i).getEdad()));
			}
		}

		Set<String> filtro = new HashSet<String>(tempList);
		Registro[] listaRegistros = new Registro[filtro.size()];
		int i = 0;
		for (String s : filtro) { 

			double cantidasLista = tempList.size();
			int cantidad =Collections.frequency(tempList, s);
			double porcentaje = (cantidad * 100.0) / cantidasLista;;
			listaRegistros[i] = new Registro(s,cantidad ,Math.round(porcentaje*1000.0)/1000.0);
			System.out.println(listaRegistros[i].toString());
			i++;
		}

		return listaRegistros;

	}
	
	public ArrayList<Delito> eliminaRegistroPorModalidad (String modalidad,  ArrayList<Delito> listaDelitos) {
		
		ArrayList<Delito> listaModificada = listaDelitos;
		
		for (int i = 0; i < listaModificada.size(); i++) {
			
			if (listaModificada.get(i).getModalidad().equals(modalidad)){
				listaModificada.remove(i);
			}
		}
		
		return listaModificada;
		
	}

}
