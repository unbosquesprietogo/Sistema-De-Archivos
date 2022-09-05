package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.CreateTxt;
import co.edu.unbosque.model.persistence.ReadTxt;

public class Enlaces {

	private ReadTxt readTxt;
	private CalculoDelitos calculoDelitos;
	private CreateTxt createTxt;

	
	public Enlaces () {
		readTxt = new ReadTxt();
		calculoDelitos = new CalculoDelitos();
		createTxt = new CreateTxt();
		
	}


	public ReadTxt getReadTxt() {
		return readTxt;
	}


	public CalculoDelitos getCalculoDelitos() {
		return calculoDelitos;
	}


	public CreateTxt getCreateTxt() {
		return createTxt;
	}
	
	
	
	
	
}
