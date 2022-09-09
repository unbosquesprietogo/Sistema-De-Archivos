package co.edu.unbosque.model.persistence;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class FileTxt {

	private File file;

	public FileTxt() {
		File directory = new File("src/resources");
		File[] files = directory.listFiles();
		Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
		File lastFile = files[0];
		this.file = lastFile;
	}
	
	public String borrarArchivo(String ruta) {
		File tempFile = new File(ruta);
		
		if(tempFile.delete()) {
		return "eliminado";
		}else {
			return "no se ha eliminado";
		}
		
	}

	public void cambiarNombreFechaActual() {
		

		LocalDateTime fechaActual = LocalDateTime.now();
		String nombre = "delito-" + String.valueOf(fechaActual.getDayOfMonth()) + "-"
				+ String.valueOf(fechaActual.getMonth()) + "-" + String.valueOf(fechaActual.getYear());
		File nuevoNombre = new File("src/resources/" + nombre + ".txt");
		file.renameTo(nuevoNombre);
		file = nuevoNombre;
		
	}
	
	public double tamanioArchivo(String ruta, String tipo) {
	
		File archivo = new File(ruta);
		double peso = archivo.length();
		
		if(tipo.equals("kb")) {
			peso /= 1024;
		}
		else if(tipo.equals("mb")) {
			peso /= 1024;
			peso /= 1024;
		}
		
		return Math.round(peso*100.0)/100.0;
	}
	
	public String porcentajeTamanioArchivos(String ruta) {
		
		String resultado="";
		
		File[] listaArchivos = archivosCarpeta(ruta);
		
	
		double tamanioTotalArchivo=0.0;
		
		for (File file : listaArchivos) {
			
			tamanioTotalArchivo += tamanioArchivo(file.toString(),"b");
		}
		
		for (File file : listaArchivos) {

			double porcentaje = ((tamanioArchivo(file.toString(), "b"))*100)/tamanioTotalArchivo;
			porcentaje = Math.round(porcentaje*100.0)/100.0;
			resultado += file.getName()+" - porcentaje = "+porcentaje+ "%\n"; 
		}
		
		
		return resultado;
		
	}
	
	public File[] archivosCarpeta(String ruta) {
		
		File directory = new File(ruta);
		return directory.listFiles();
		
		
	}

	public File getFile() {
		return file;
	}

}
