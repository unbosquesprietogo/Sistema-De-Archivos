package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReadTxt {
	
	
	public ArrayList<Delito> readFile() {
		
		ArrayList<Delito> listaDelitos = new ArrayList<>();
		String linea;
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/resources/archivo-1.txt",StandardCharsets.UTF_8));
			br.readLine();
			linea = br.readLine();
			while(linea !=null) {
				String[] dataLine = linea.split(",");
				
				try {
				
				String departamento = dataLine[0];
				String municipio = dataLine[1];   
				Date fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dataLine[2]);
				String barrio = dataLine[3];      
				String descripcion = dataLine[4]; 
				String modalidad = dataLine[5];  		
				String sitio = dataLine[6];       
				String zona= dataLine[7];        
				String genero= dataLine[8];      
				String pais= dataLine[9];        
				String cargo= dataLine[10];       
				int edad = Integer.parseInt(dataLine[11]);           
				int c2020 =Integer.parseInt(dataLine[12]);;  
				
				listaDelitos.add(new Delito( departamento,  municipio,  fecha,  barrio,  
						descripcion, modalidad,  sitio,  zona,  genero,  pais,  cargo,  edad, c2020));
							
				linea = br.readLine();
				
				}catch (Exception e) {
					linea = br.readLine();
				}
				
				
				
			}
		}catch(FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		}catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		return listaDelitos;
	}
	
	

}
	