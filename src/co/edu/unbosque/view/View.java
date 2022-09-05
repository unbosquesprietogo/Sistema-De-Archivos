package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {

	
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public String leerDato (String dato) {
		return JOptionPane.showInputDialog(dato);
	}
	public int leerDato (int dato) {
		return Integer.parseInt(JOptionPane.showInputDialog(dato));
	}
	
	public double leerDato (double dato) {
		return Double.parseDouble(JOptionPane.showInputDialog(dato));
	}
	
	
	
}
