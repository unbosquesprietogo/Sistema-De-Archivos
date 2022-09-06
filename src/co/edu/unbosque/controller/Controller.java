package co.edu.unbosque.controller;

import co.edu.unbosque.model.Enlaces;


public class Controller {
	
	private Enlaces enlaces;

	public Controller() {
		enlaces = new Enlaces();
		funcionar();
		attachShutDownHook();
		
	}
	
	public void funcionar() {
		enlaces.getCreateTxt().generarVariosTxt(20);
		for (int i = 0; i < enlaces.getReadTxt().readFile().size(); i++) {
			System.out.println(i+". "+enlaces.getReadTxt().readFile().get(i).toString());
		}
	}
	
	public void attachShutDownHook(){
		  Runtime.getRuntime().addShutdownHook(new Thread() {
		    @Override
		    public void run() {
		    	Enlaces enlaces = new Enlaces();
		    	enlaces.getReadTxt().getFileTxt().cambiarNombreFechaActual();
		    }
		  } );



				
		}
}
