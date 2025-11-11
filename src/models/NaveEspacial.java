package models;

public class NaveEspacial {
	
	private String nombre;
	private int aniocrea;
	private int aniolanza;
	private int totcap;
	private int tripu;
	
	//Getters
	public String getNombre() {
		return nombre;
	}
	public int getAniocrea() {
		return aniocrea;
	}
	public int getAniolanza() {
		return aniolanza;
	}	
	public int getTotcap() {
		return totcap;
	}
	public int getTripu() {
		return tripu;
	}
	
	//Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setAniocrea(int aniocrea) {
		this.aniocrea = aniocrea;
	}
	public void setAniolanza(int aniolanza) {
		this.aniolanza = aniolanza;
	}
	public void setTotcap(int totcap) {
		this.totcap = totcap;
	}
	public void setTripu(int tripu) {
		this.tripu = tripu;
	}
	
	public NaveEspacial() {
		
	}
	
	public NaveEspacial(String nombre, int aniocrea, int aniolanza, int totcap, int tripu) {
		this.nombre = nombre;
		this.aniocrea = aniocrea;
		this.aniolanza = aniolanza;
		this.totcap = totcap;
		this.tripu = tripu;
	}
	
	public boolean admitePasajeros() {
		if(this.getTotcap() <= 0)
			return false;
				return true;
	}
	
	
	@Override
	public String toString() {
		return "\nNombre: " + nombre + ", Año Creación: " + aniocrea + ", Año Lanzamiento: " + aniolanza + ", Capacidad Total: "
				+ totcap + ", Tripulación Mínima: " + tripu + "]";
	}
	
	

}
