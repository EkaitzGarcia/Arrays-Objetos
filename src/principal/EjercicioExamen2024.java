package principal;
import models.NaveEspacial;

import java.time.LocalDate;
import java.time.LocalTime;

public class EjercicioExamen2024 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NaveEspacial nave1 = new NaveEspacial("Starship", 2022, 2023, 8, 5);
		NaveEspacial nave2 = new NaveEspacial("Apolo 11", 1950, 1960, 7, 4);
		NaveEspacial[] mision = new NaveEspacial[4];
		int opcion;
		
		do {
			System.out.println("\n=============MENU=============\n"
					+ "\n1.- Añadir naves espaciales."
					+ "\n2.- Mostrar naves de X antigüedad."
					+ "\n3.- Ordenar naves por año de lanzamiento."
					+ "\n4.- Modificar capacidad total de las naves."
					+ "\n5.- Mostrar todas las naves especiales registradas."
					+ "\n6.- Eliminar nave espacial."
					+ "\n7.- Salir del programa.\n"
					+ "\n==============================\n");
			do {
				opcion = Util.leerInt();
			
				if(opcion < 1 || opcion > 7) {
					System.out.println("Introduce un valor válido.");
				}
			}while(opcion < 1 || opcion > 7);
			
			switch(opcion) {
				case 1:
					
					añadirNave(mision);
					break;
					
				case 2:
					
					mostrarPorAntiguedad(mision);
					break;
					
				case 3:
					
					
					
					
				case 4:
					
					
					
					
				case 5:
					
					
					
					
				case 6:
					
					
					
					
				case 7:
					
					System.out.println("Finalizando programa...");
					return; //Finaliza el programa.
			}
		
		}while(true);
		
	}
	
	//Metodo para calcular la antigüedad
	public static void calcularAntiguedad(int añoactu, NaveEspacial nave1, NaveEspacial nave2) {
		
		//Petición y validación del año actual
		do {
			
		System.out.println("\nAño actual: ");
		añoactu = Util.leerInt();
		
		if(añoactu < 2025) {
			System.out.println("\nIntroduce un valor válido.");
		}
		
		}while(añoactu < 2025);
		
		//Petición y validación de la nave a verificar.
		String eleccion;
		do {
		
		System.out.println("\n¿Que nave quieres revisar? " +nave1.getNombre() +" / " +nave2.getNombre());
		eleccion = Util.introducirCadena();
		
		if(!eleccion.equalsIgnoreCase(nave1.getNombre()) && !eleccion.equalsIgnoreCase(nave2.getNombre())) {
			System.out.println("\nIntroduce una opción válida.");
		}
		
		}while(!eleccion.equalsIgnoreCase(nave1.getNombre()) && !eleccion.equalsIgnoreCase(nave2.getNombre()));
		
		if(eleccion.equalsIgnoreCase(nave1.getNombre())) {
			int antiguedad = añoactu - nave1.getAniocrea();
			
			System.out.println("\nLa nave " +nave1.getNombre() +" tiene una antigüedad de " +antiguedad +" años.");
			
		} else if(eleccion.equalsIgnoreCase(nave2.getNombre())) {
			int antiguedad2 = añoactu - nave2.getAniocrea();
			
			System.out.println("\nLa nave " +nave2.getNombre() +" tiene una antigüedad de " +antiguedad2 +" años.");
		
		}
		
	}
	
	//Metodo para añadir nueva nave.
	public static void añadirNave(NaveEspacial[] mision) {
		for(int i = 0; i < mision.length; i++) {
			String nuevoNombre;
			int nuevoAniocrea, nuevoAniolanza, nuevoTotcap, nuevoTripu;
			mision[i] = new NaveEspacial();
			
			//Petición y validación del nombre de la nave.
			do {
				System.out.println("\nIntroduce el nombre de la nave " +(i + 1) +":");
				nuevoNombre = Util.introducirCadena();
				
				if(!nuevoNombre.matches("[a-zA-Z]+")) {
					System.out.println("\nIntroduce un caracter vállido.");
				} else {
					mision[i].setNombre(nuevoNombre);
				}
				
			}while(!nuevoNombre.matches("[a-zA-Z]+"));
			
			//Petición y validación del año de creación de la nave.
			do {
				System.out.println("\nIntroduce el año de creación de la nave " +(i + 1) +":");
				nuevoAniocrea = Util.leerInt();
				
				if(nuevoAniocrea < 1) {
					System.out.println("\nIntroduce un valor válido.");
				} else {
					mision[i].setAniocrea(nuevoAniocrea);
				}
				
			}while(nuevoAniocrea < 1);
			
			//Petición y validación del año de lanzamiento de la nave
			do {
				System.out.println("\nIntroduce el año de lanzamiento de la nave " +(i + 1) +":");
				nuevoAniolanza = Util.leerInt();
				
				if(nuevoAniolanza < nuevoAniocrea) {
					System.out.println("\nEl año de lanzamiento no puede ser inferior al de creación.");
				} else {
					mision[i].setAniolanza(nuevoAniolanza);
				}
				
			}while(nuevoAniolanza < nuevoAniocrea);
			
			//Petición y validación de la cantidad máxima de tripulantes de la nave
			do {
				System.out.println("\nIntroduce la capacidad máxima de la nave:");
				nuevoTotcap = Util.leerInt();
				
				if(nuevoTotcap < 1) {
					System.out.println("\nIntroduce un valor válido.");
				} else {
					mision[i].setTotcap(nuevoTotcap);
				}
				
			}while(nuevoTotcap < 1);
			
			//Petición y validación de la tripulación mínima de la nave
			do {
				System.out.println("\nIntroduce la tripulación mínima para operar la nave:");
				nuevoTripu = Util.leerInt();
				
				if(nuevoTripu > nuevoTotcap) {
					System.out.println("\nLa tripulación mínima no puede ser superior a la máxima.");
				} else if(nuevoTripu < 0) {
					System.out.println("\nIntroduce un valor válido.");
				} else {
					mision[i].setTripu(nuevoTripu);
				}
				
			}while(nuevoTripu > nuevoTotcap || nuevoTripu < 0);
			
			//Muestra del objeto
			System.out.println("\nInfo de la nave " +(i + 1) +"\n"
					+mision[i].toString());
			
			//Petición y validación a la opcion de seguir introduciendo naves.
			char opcion;
			do {
				System.out.println("\n¿Quieres seguir introduciendo naves? S/N");
				opcion = Util.leerChar();
				
				if(opcion == 'S' || opcion == 's') {
					System.out.println("\nContinuemos con la siguiente nave...");
					break;
				} else if(opcion == 'N' || opcion == 'n') {
					return; //Finaliza el método
				} else {
					System.out.println("\nIntroduce un caracter válido.");
				}
			}while(opcion != 'N' && opcion != 'n' && opcion != 'S' && opcion != 's');
		}
	}
	
	//Metodo para mostrar naves de antigüedad superior a X.
	public static void mostrarPorAntiguedad(NaveEspacial[] mision) {
		LocalDate fecha = LocalDate.now();
		int años;
		
		do {
			System.out.println("\nDe que antigüedad quieres mostrar las naves");
			años = Util.leerInt();
		
			if(años < 0) {
				System.out.println("\nIntroduce un valor válido.");
			}
			
		}while(años < 0);
		
		for(int i = 0; i < mision.length; i++) {
			if(LocalDate.now().getYear() - mision[i].getAniocrea() <= años) {
				System.out.println(mision[i].toString());
			}
		}
	}


}
