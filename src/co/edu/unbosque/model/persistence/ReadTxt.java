package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.unbosque.model.Delito;

public class ReadTxt {

	private FileTxt fileTxt;

	public ReadTxt() {
		fileTxt = new FileTxt();
	}

	public ArrayList<Delito> readFile() {

		ArrayList<Delito> listaDelitos = new ArrayList<>();
		String linea;
		try {

			BufferedReader br = new BufferedReader(
					new FileReader(String.valueOf(fileTxt.getFile()), StandardCharsets.UTF_8));
			br.readLine();
			linea = br.readLine();
			while (linea != null) {
				String[] dataLine = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

				try {

					String departamento = dataLine[0];
					String municipio = dataLine[1];
					Date fecha = new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(dataLine[2]);
					String barrio = dataLine[3];
					String descripcion = dataLine[4];
					String modalidad = dataLine[5];
					String sitio = dataLine[6];
					String zona = dataLine[7];
					String genero = dataLine[8];
					String pais = dataLine[9];
					String cargo = dataLine[10];
					int edad = Integer.parseInt(dataLine[11]);
					int c2020 = Integer.parseInt(dataLine[12]);
					;

					listaDelitos.add(new Delito(departamento, municipio, fecha, barrio, descripcion, modalidad, sitio,
							zona, genero, pais, cargo, edad, c2020));

					linea = br.readLine();

				} catch (Exception e) {
					linea = br.readLine();
				}

			}
			br.close();
		} catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}

		return listaDelitos;
	}

	public void eliminarRegistroPorModalidad(String modalidad) {

		List<String> listaDelitos = new ArrayList<>();
		String ruta = String.valueOf(fileTxt.getFile());
		String linea;
		try {

			BufferedReader br = new BufferedReader(new FileReader(ruta, StandardCharsets.UTF_8));
			linea = br.readLine();
			while (linea != null) {
				String[] dataLine = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

				try {

					if (modalidad.equals(dataLine[5]))
						;

					else {
						listaDelitos.add(linea);
					}

					linea = br.readLine();

				} catch (Exception e) {
					linea = br.readLine();
				}
			}
			br.close();
		} catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}

		if (fileTxt.getFile().delete())
			;

		try (FileWriter fw = new FileWriter(ruta, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			for (String data : listaDelitos) {
				out.println(data);
			}
			fw.close();
			bw.close();
			out.close();
		} catch (IOException e) {
			// exception handling left as an exercise for the reader
		}

	}

	public List<String> listaData(String rutaEntrada) {

		List<String> listaDelitos = new ArrayList<>();

		String linea;
		try {

			BufferedReader br = new BufferedReader(new FileReader(rutaEntrada, StandardCharsets.UTF_8));
			linea = br.readLine();
			while (linea != null) {
				try {
					listaDelitos.add(linea);
					linea = br.readLine();

				} catch (Exception e) {
					linea = br.readLine();
				}
			}
			br.close();
		} catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}

		return listaDelitos;
	}

	public void llenarTxt() {

		for (int i = 1; i <= 20; i++) {
			String ruta = "MarinArevalo_PrietoGonzalez/Numeros/";

			if (i < 10) {
				ruta += "0" + i + ".txt";
			} else {
				ruta += String.valueOf(i) + ".txt";
			}

			sobreescibirTxt(i, ruta, listaData(String.valueOf(fileTxt.getFile())));
		}

	}

	public void sobreescibirTxt(int i, String ruta, List<String> list) {
		try (FileWriter fw = new FileWriter(ruta, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			for (int j = 0; j < i; j++) {
				out.println(list.get(i));
			}

		} catch (IOException e) {
			System.err.print(e.getMessage());
		}

	}

	public String listarContenido(String ruta) {

		String contenido = "Archivos en la ruta: " + ruta + "\n\n";

		for (File file : fileTxt.archivosCarpeta(ruta)) {

			String nombreArchivo =file.getName();
			contenido +=  "\t\n"+nombreArchivo+ "\n";

			if (nombreArchivo.contains(".txt")) {
				contenido += "\t\t\nEl archivo " +nombreArchivo+" contiene :\n\n";
				List<String> listData = listaData(ruta+nombreArchivo);
				for (String data :listData ) {
					contenido += data+"\n";
					;
				}
			}

			else if (!nombreArchivo.contains(".")) {
				contenido += "\t\t\nLa carpeta " +nombreArchivo+" contiene :\n\n";
				File[] listaArchivos = fileTxt.archivosCarpeta(ruta+nombreArchivo);
 				for (File file1 : listaArchivos) {
					contenido += file1.getName()+"\n";
				}				
			}
		}

		return contenido;
	}

	public FileTxt getFileTxt() {
		return fileTxt;
	}

}
