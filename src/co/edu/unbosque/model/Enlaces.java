package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ReadTxt;

public class Enlaces {

	private ReadTxt readTxt;
	private CalculoDelitos calculoDelitos;

	
	public Enlaces () {
		readTxt = new ReadTxt();
		calculoDelitos = new CalculoDelitos();
		
	}


	public ReadTxt getReadTxt() {
		return readTxt;
	}


	public CalculoDelitos getCalculoDelitos() {
		return calculoDelitos;
	}
	
	
	
	
}
