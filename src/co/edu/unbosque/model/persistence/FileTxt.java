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

	public void cambiarNombreFechaActual() {

		LocalDateTime fechaActual = LocalDateTime.now();
		String nombre = "delito-" + String.valueOf(fechaActual.getDayOfMonth()) + "-"
				+ String.valueOf(fechaActual.getMonth()) + "-" + String.valueOf(fechaActual.getYear());
		File nuevoNombre = new File("src/resources/" + nombre + ".txt");
		file.renameTo(nuevoNombre);
		file = nuevoNombre;
	}

	public File getFile() {
		return file;
	}

}
