package models;

public class Persona {
	private String Nombre;
	private int Edad;
	private int DNI;
	
	//Todos los getters
	public String getNombre() {
		return Nombre;
	}
	public int getEdad() {
		return Edad;
	}
	public int getDNI() {
		return DNI;
	}
	
	//Todos los setters
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	
	public static void Elimino(String Nombre, int Edad, int DNI) {
		
	}
}
