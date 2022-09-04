package co.edu.unbosque.model;

import java.util.Date;

public class Delito {
	
	private String departamento;
	private String municipio;   
	private Date fecha;         
	private String barrio;      
	private String descripcion;  
	private String modalidad;  
	private String sitio;            
	private String zona;            
	private String genero;            
	private String pais;           
	private String cargo;         
	private int edad;              
	private int c2020;             
	
	public Delito(String departamento, String municipio, Date fecha, String barrio, String descripcion,
			String modalidad, String sitio, String zona, String genero, String pais, String cargo, int edad,
			int c2020) {
		this.departamento = departamento;
		this.municipio = municipio;
		this.fecha = fecha;
		this.barrio = barrio;
		this.descripcion = descripcion;
		this.modalidad = modalidad;
		this.sitio = sitio;
		this.zona = zona;
		this.genero = genero;
		this.pais = pais;
		this.cargo = cargo;
		this.edad = edad;
		this.c2020 = c2020;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public String getSitio() {
		return sitio;
	}
	public void setSitio(String sitio) {
		this.sitio = sitio;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getC2020() {
		return c2020;
	}
	public void setC2020(int c2020) {
		this.c2020 = c2020;
	}

	@Override
	public String toString() {
		return "Delito [departamento=" + departamento + ", municipio=" + municipio + ", fecha=" + fecha + ", barrio="
				+ barrio + ", descripcion=" + descripcion + ", modalidad=" + modalidad + ", sitio=" + sitio + ", zona="
				+ zona + ", genero=" + genero + ", pais=" + pais + ", cargo=" + cargo + ", edad=" + edad + ", c2020="
				+ c2020 + "]";
	}
	
	

}
