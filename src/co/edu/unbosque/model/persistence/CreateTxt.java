package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateTxt {

	public String crearCarpeta(String ruta) {
		
		String result="";
		
		File directorio = new File("MarinArevalo_PrietoGonzalez");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
  
            	try {
                    File inFile = new File(ruta);
                    String nombreArchivo = "delito"+"-"+ruta.split("-")[1]+"-"+ruta.split("-")[2]+"-"+ruta.split("-")[3];
                    File outFile = new File("MarinArevalo_PrietoGonzalez/"+nombreArchivo);

                    FileInputStream in = new FileInputStream(inFile);
                    FileOutputStream out = new FileOutputStream(outFile);

                    int c;
                    while( (c = in.read() ) != -1)
                        out.write(c);

                    in.close();
                    out.close();
                } catch(IOException e) {
                    System.err.println("Hubo un error de entrada/salida!!!");
                }
            	
                result = "creado";
            } else {
                result="Error al crear directorio";
            }
        }
        return result;
	}
	
	public void generarVariosTxt(int i, String rutaFile) {
		
		File directorioRaiz = new File("MarinArevalo_PrietoGonzalez");
        
		if (!directorioRaiz.exists()) {
            crearCarpeta(rutaFile);
        }
		
		File directorio = new File("MarinArevalo_PrietoGonzalez/Numeros");
        if (!directorio.exists()) {
        	directorio.mkdirs();
        }

		for (int j = 1; j <= i; j++) {
			try {
				String numeroArchivo = "";
				if(j < 10) {
					numeroArchivo = "0"+j;
				}else {
					numeroArchivo = String.valueOf(j);
				}
				String ruta = "MarinArevalo_PrietoGonzalez/Numeros/"+numeroArchivo+".txt";

				File file = new File(ruta);

				if (!file.exists()) {
					file.createNewFile();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
