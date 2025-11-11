package principal;
import models.Asignatura;

public class Clase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Asignatura[] clase = new Asignatura[3];
		int opcion;

		do{
			System.out.println("\n==============MENU==============\n"
					+"\n1.- Introducir asignaruras."
					+"\n2.- Mostrar porcentaje de aprobados de cada asignatura."
					+"\n3.- Ordenar asignaturas por numero de aprobados."
					+"\n4.- Modificar datos de una asignatura."
					+"\n5.- Mostrar todas las asignaturas."
					+"\n6.- Salir."
					+"\n================================\n");
			do{
				opcion = Util.leerInt();

				if(opcion < 1 || opcion > 6){
					System.out.println("\nIntroduce una opcion válida.");
				}
			}while(opcion < 1 || opcion > 6);

			switch(opcion){
				case 1:

					añadirAsignaturas(clase);
					break;

				case 2:

					mostrarPorcentajeAprobados(clase);
					break;

				case 3:

					ordenarPorAprobados(clase);
					break;

				case 4:

					modificarAsignatura(clase);
					break;

				case 5:

					mostrarAsignaturas(clase);
					break;

				case 6:
					
					System.out.println("\nFinalizando programa...");
					return;
			}
		}while(true);
	}

	//Metodo para añadir asignaturas (Case 1)
	public static void añadirAsignaturas(Asignatura[] clase){
		String nombre, curso;
		int matriculados, numSuspensos;
		boolean existe = false;

		for(int i = 0; i < clase.length; i++){
			clase[i] = new Asignatura("", "");
			//Peticion y validaciín del nombre de la asignatura.
			do{
				System.out.println("\nIntroduce el nombre de la asignatura " +(i + 1) +":");
				nombre = Util.introducirCadena();

				for(int j = 0; j < i; j++){
					if(clase[i].getNombre().equalsIgnoreCase(nombre)){
						existe = true;
						System.out.println("\nLa asignatura ya existe. Introduce otra diferente.");
						break;
					} else{
						existe = false;
					}
				}

				if(!nombre.matches("[a-zA-Z]+")){
					System.out.println("\nIntroduce un caracter válido.");
				}

			}while(!nombre.matches("[a-zA-Z]+") || existe);

			//Petición y validación del curso.
			do { 
				System.out.println("\nIntroduce el curso de la asignatura " +(i + 1) +":");
				curso = Util.introducirCadena();

				if(!curso.matches("[a-zA-Z0-9]+")) {
					System.out.println("\nIntroduce un caracter válido.");
				}

			} while(!curso.matches("[a-zA-Z0-9]+"));

			//Petición y validación del número de matriculados.
			char opcion1;
			do { 
				System.out.println("\n¿Quieres introducir el número de matriculados? S/N");
				opcion1 = Util.leerChar();

				if(opcion1 != 'S' && opcion1 != 's' && opcion1 != 'N' && opcion1 != 'n'){
					System.out.println("\nIntroduce una opcion válida.");
				} else if(opcion1 == 'S' || opcion1 == 's'){
					System.out.println("\nIntroduce el número de matriculados:");
					matriculados = Util.leerInt();

					clase[i].setMatriculados(matriculados);
				} else{
					clase[i].setMatriculados(0);
				}
			} while(opcion1 != 'S' && opcion1 != 's' && opcion1 != 'N' && opcion1 != 'n');

			//Peticion y validación del número de suspensos.
			char opcion2;
			boolean suspensoInvalido = false;
			do{
				System.out.println("\n¿Quieres introducir el número de suspensos? S/N");
				opcion2 = Util.leerChar();

				if(opcion2 != 'S' && opcion2 != 's' && opcion2 != 'N' && opcion2 != 'n'){
					System.out.println("\nIntroduce una opcion válida.");
				} else if(opcion2 == 'S' || opcion2 == 's'){
					System.out.println("\nIntroduce el número de suspensos:");
					numSuspensos = Util.leerInt();

					//Validación para que el número de suspensos no sea mayor que el de matriculados.
					if(numSuspensos > clase[i].getMatriculados()){
						System.out.println("\nEl número de suspensos no puede ser mayor que el de matriculados.");
						suspensoInvalido = true;
					}

					clase[i].setNumSuspensos(numSuspensos);
				} else if(opcion2 == 'N' || opcion2 == 'n'){
					clase[i].setNumSuspensos(0);
				}
			}while(opcion2 != 'S' && opcion2 != 's' && opcion2 != 'N' && opcion2 != 'n' || suspensoInvalido);

			//Petición y validación a la opcion de seguir añadiendo asignaturas.
			char opcion3;
			do { 
				System.out.println("\n¿Quieres seguir introduciendo asignaturas? S/N");
				opcion3 = Util.leerChar();

				if(opcion3 != 'S' && opcion3 != 's' && opcion3 != 'N' && opcion3 != 'n'){
					System.out.println("\nIntroduce una opcion válida.");
				} else if(opcion3 == 'N' || opcion3 == 'n'){
					return;
				}
			} while(opcion3 != 'S' && opcion3 != 's' && opcion3 != 'N' && opcion3 != 'n');
		}
	}

	//Metodo para mostrar el porcentaje de aprobados de cada asignatura (Case 2)
	public static void mostrarPorcentajeAprobados(Asignatura[] clase){
		//Validación para comprobar que hay asignaturas en el array.
		for(int i = 0; i < clase.length; i++){
			if(clase[i] == null){
				System.out.println("\nNo hay asignaturas introducidas.");
				return; //Finaliza el método.
			}
		}

		for(int i = 0; i < clase.length; i++){
			System.out.println("\nLa asignatura " +clase[i].getNombre() +" tiene un porcentaje de aprobados del "
					+clase[i].porcentajeAprobados() +"%.");
		}
	}

	//Metodo para ordenar las asignaturas por el número de aprobados (Case 3)
	public static void ordenarPorAprobados(Asignatura[] clase){
		int contador = clase.length;
		Asignatura temp;

		//Validación para comprobar que hay asignaturas en el array.
		for(int i = 0; i < clase.length; i++){
			if(clase[i].getNombre() == null){
				System.out.println("\nNo hay asignaturas introducidas.");
				return; //Finaliza el método.
			}
		}

		for(int i = 0; i < contador -1; i++){
			for(int j = i + 1; j < contador; j++){
				if(clase[i].obtenerNumeroAprobados() > clase[j].obtenerNumeroAprobados()){
					temp = clase[i];
					clase[i] = clase[j];
					clase[j] = temp;
				}
			}
		}

		//Mostrar el array ordenado.
		System.out.println("\nAsignaturas ordenadas por número de aprobados:");
		for(int k = 0; k < clase.length; k++){
			System.out.println(clase[k].toString());
		}
	}

	//Método para modificar los datos de unas asignatura (Case 4)
	public static void modificarAsignatura(Asignatura[] clase){
		String buscar;
		int contador = clase.length;
		boolean encontrado = false;

		//Validación para comprobar que hay asignaturas en el array.
		for(int i = 0; i < clase.length; i++){
			if(clase[i].getNombre() == null){
				System.out.println("\nNo hay asignaturas introducidas.");
				return; //Finaliza el método.
			}
		}

		do { 
			System.out.println("\nIntroduce el nombre de la asignatura que quieres modificar:");
			buscar = Util.introducirCadena();

			if(!buscar.matches("[a-zA-Z]+")){
				System.out.println("\nIntroduce un caracter válido.");
			} else{
				for(int i = 0; i < contador; i++){
					if(clase[i].getNombre().equalsIgnoreCase(buscar)){
						encontrado = true;

						System.out.println(clase[i].toString());

						char opcion, opcion2, opcion3, opcion4;

						//Petición y validación del nuevo nombre.
						do{
							System.out.println("\n¿Quieres modificar el nombre de la asignatura? S/N");
							opcion = Util.leerChar();

							if(opcion != 'S' && opcion != 's' && opcion != 'N' && opcion != 'n'){
								System.out.println("\nIntroduce un caracter válido.");
							} else if(opcion == 'S' || opcion == 's'){
								String nuevoNombre;
								do { 
									System.out.println("\nIntroduce un nuevo nombre para la asignatura:");
									nuevoNombre = Util.introducirCadena();

									if(!nuevoNombre.matches("[a-zA-Z]+")){
										System.out.println("\nIntroduce un caracter válido.");
									} else{
										clase[i].setNombre(nuevoNombre);
										break;
									}
								} while(!nuevoNombre.matches("[a-zA-Z]+"));
							}
						}while(opcion != 'S' && opcion != 's' && opcion != 'N' && opcion != 'n');

						//Petición y validación del nuevo curso.
						do { 
							System.out.println("\n¿Quieres modificar el curso?");
							opcion2 = Util.leerChar();

							if(opcion2 != 'S' && opcion2 != 's' && opcion2 != 'N' && opcion2 != 'n'){
								System.out.println("\nIntroduce un caracter válido.");
							} else if(opcion2 == 'S' || opcion2 == 's'){
								String nuevoCurso;
								do { 
									System.out.println("\nIntroduce un nuevo curso para la asignatura:");
									nuevoCurso = Util.introducirCadena();

									if(!nuevoCurso.matches("[a-zA-Z0-9]+")){
										System.out.println("\nIntroduce un caracter válido.");
									} else{
										clase[i].setCurso(nuevoCurso);
										break;
									}
								} while(!nuevoCurso.matches("[a-zA-Z0-9]+"));
							}
						} while(opcion2 != 'S' && opcion2 != 's' && opcion2 != 'N' && opcion2 != 'n');

						//Petición y validación del nuevo número de matriculados.
						do { 
							System.out.println("\n¿Quieres modificar el número de matriculados?");
							opcion3 = Util.leerChar();

							if(opcion3 != 'S' && opcion3 != 's' && opcion3 != 'N' && opcion3 != 'n'){
								System.out.println("\nIntroduce una opción válida.");
							} else if(opcion3 == 'S' || opcion3 == 's'){
								int nuevoMatriculados;
								do{
									System.out.println("\nIntroduce el nuevo número de matriculados:");
									nuevoMatriculados = Util.leerInt();

									if(nuevoMatriculados < clase[i].getMatriculados()){
										System.out.println("\nIntroduce un valor válido.");
									} else{
										clase[i].setMatriculados(nuevoMatriculados);
										break;
									}
								}while(nuevoMatriculados < clase[i].getMatriculados());
							}
						} while(opcion3 != 'S' && opcion3 != 's' && opcion3 != 'N' && opcion3 != 'n');

						//Petición y validación del nuevo número de suspensos
						do { 
							System.out.println("\n¿Quieres modificar el número de suspensos?");
							opcion4 = Util.leerChar();

							if(opcion4 != 'S' && opcion4 != 's' && opcion4 != 'N' && opcion4 != 'n'){
								System.out.println("\nIntroduce una opción válida.");
							} else if(opcion4 == 'S' || opcion4 == 's'){
								int nuevoSuspensos;
								do { 
									System.out.println("\nIntroduce el nuevo valor");
									nuevoSuspensos = Util.leerInt();

									if(nuevoSuspensos < clase[i].getMatriculados()){
										System.out.println("\nEl nuevo número de suspensos no puede ser menor que el de matriculados.");
									} else{
										clase[i].setNumSuspensos(nuevoSuspensos);
										break;
									}
								} while(nuevoSuspensos < clase[i].getMatriculados());
							}
						} while(opcion4 != 'S' && opcion4 != 's' && opcion4 != 'N' && opcion4 != 'n');
					}
				}
			}
		} while(!buscar.matches("[a-zA-Z]+") || !encontrado);
	}

	//Metodo para mostrar el array
	public static void mostrarAsignaturas(Asignatura[] clase){
		//Validación para comprobar que hay asignaturas en el array.
		for(int i = 0; i < clase.length; i++){
			if(clase[i].getNombre() == null){
				System.out.println("\nNo hay asignaturas introducidas.");
				return; //Finaliza el método.
			}
		}

		//Mostrar el array si es que hay objetos
		for(int i = 0; i < clase.length; i++){
			System.out.println(clase[i].toString());
		}
	}

}
