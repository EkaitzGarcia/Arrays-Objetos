package models;

public class Coche {
	private String marca;
	private String modelo;
	private String matricula;
	private String color;
	private int cilindrada; //cm3
	private int potencia; //cv
	private float precio;
	
	//Getters
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public String getColor() {
		return color;
	}
	
	public int getCilindrada() {
		return cilindrada;
	}
	
	public int getPotencia() {
		return potencia;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	
	//Setters
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public void setMaricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public Coche(String marca, String modelo, String matricula, String color, int cilindrada, int potencia, float precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		
	}
	
	@Override
	public String toString() {
		return "Marca: " + marca + ", Modelo: " + modelo + ", Matricula: " + matricula + ", Color: " + color
				+ ", Cilindrada: " + cilindrada + ", Potencia: " + potencia + ", Precio: " + precio + "]";
	}

}
