package co.edu.unbosque.controller;

import co.edu.unbosque.model.CalculoDelitos;
import co.edu.unbosque.model.ReadTxt;

public class Controller {

	public Controller() {
		 ReadTxt rt = new ReadTxt();
		 CalculoDelitos cd = new CalculoDelitos();  
		 cd.calcularCantidad(rt.readFile(),"genero");
		 System.out.println();
		 
		 
		 
	}
}
