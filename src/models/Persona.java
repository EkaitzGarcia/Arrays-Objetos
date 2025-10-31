package models;

public class Almacen {
	
	private String articulo;
	private int unidad;
	boolean estado = true;
	
	//Getters
	public String getArticulo() {
		return articulo;
	}
	
	public int getUnidades() {
		return unidad;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	//Setters
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	
	public void setUnidades(int unidad) {
		this.unidad = unidad;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public Almacen(String articulo, int unidades, boolean estado) {
		this.articulo = articulo;
		this.unidad = unidades;
		this.estado = estado;
	}
	

	@Override
	public String toString() {
		if(estado == false) {
		return "Almacen [Articulo = " + articulo + ", Unidades = " + unidad + ", Estado: Inactivo";
		} else {
			return "Almacen [Articulo = " + articulo + ", Unidades = " + unidad + ", Estado: Activo";
		}
	}
	
	
}
