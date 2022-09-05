package co.edu.unbosque.model.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CreateTxt {

	public void generarVariosTxt(int i) {
		
		File directorio = new File("Apellidos1_Apellidos2/Numeros");
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
				String ruta = "Apellidos1_Apellidos2/Numeros/"+numeroArchivo+".txt";

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
