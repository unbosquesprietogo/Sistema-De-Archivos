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
		System.out.println(enlaces.getReadTxt().getFileTxt().porcentajeTamanioArchivos("MarinArevalo_PrietoGonzalez/Numeros"));
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
