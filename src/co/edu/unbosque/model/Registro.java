package co.edu.unbosque.model;

public class Registro {
	
	private Object object;
	private int cantidad;
	private double porcentaje;
	
	public Registro(Object object, int cantidad, double porcentaje) {
		super();
		this.object = object;
		this.cantidad = cantidad;
		this.porcentaje = porcentaje;
	}

	public Object getObject() {
		return object;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	@Override
	public String toString() {
		return "Registro [object=" + object + ", cantidad=" + cantidad + ", porcentaje=" + porcentaje + "%]";
	}
	
	
	
	

}
