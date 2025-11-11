package models;

public class Asignatura {
	
	private String nombre; //(PRG, BDA, EDE...)
	private String curso; //(1DAM, 1DAMi, 2DAM, 2DAMi...)
	private int matriculados;
	private int numSuspensos;
	
	//Getters
	public String getNombre() {
		return nombre;
	}
	public String getCurso() {
		return curso;
	}
	public int getMatriculados() {
		return matriculados;
	}
	public int getNumSuspensos() {
		return numSuspensos;
	}
	
	//Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public void setMatriculados(int matriculados) {
		this.matriculados = matriculados;
	}
	public void setNumSuspensos(int numSuspensos) {
		this.numSuspensos = numSuspensos;
	}

	//Constructor obligatorio
	public Asignatura(String nombre, String curso){
		this.nombre = nombre;
		this.curso = curso;
	}

	//Constructor opcional (completo)
	public Asignatura(String nombre, String curso, int matriculados, int numSuspensos){
		this.nombre = nombre;
		this.curso = curso;
		this.matriculados = matriculados;
		this.numSuspensos = numSuspensos;
	}
	
	//Metodo especial para calcular el porcentaje de aprobados
	public float porcentajeAprobados(){
		int aprobados = matriculados - numSuspensos;
		float porcentaje = (aprobados * 100) / matriculados;
		return porcentaje;
	}

	//Metodo para obtener el número de aprobados
	public int obtenerNumeroAprobados(){
		int aprobados = matriculados - numSuspensos;
		return aprobados;
	}
	
	//Metodo toString
	@Override
	public String toString() {
		return "Nombre asignatura: " + nombre + ", Curso: " + curso + ", Matriculados: " + matriculados
				+ ", Número de Suspensos: " + numSuspensos +"";
	}
	
	
	
	

}
