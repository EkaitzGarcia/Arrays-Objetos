package principal;
import java.time.LocalDate;
import models.NaveEspacial;

public class EjercicioExamen2024 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NaveEspacial[] mision = new NaveEspacial[50];
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
					
					ordenarPorAnioLanzamiento(mision);
					break;					
					
				case 4:
					
					modificarCapacidadTotal(mision);
					break;
					
				case 5:
					
					mostrarNavesRegistradas(mision);
					break;
					
				case 6:
					
					eliminarNaveEspacial(mision);
					break;
					
				case 7:
					
					System.out.println("Finalizando programa...");
					return; //Finaliza el programa.
			}
		
		}while(true);
		
	}
	
	//Metodo para añadir nueva nave. (Case 1)
	public static void añadirNave(NaveEspacial[] mision) {
		for(int i = 0; i < mision.length; i++) {
			String nuevoNombre;
			int nuevoAniocrea, nuevoAniolanza, nuevoTotcap, nuevoTripu;
			mision[i] = new NaveEspacial();
			boolean exixte = false;
			
			//Petición y validación del nombre de la nave.
			do {
				System.out.println("\nIntroduce el nombre de la nave " +(i + 1) +":");
				nuevoNombre = Util.introducirCadena();

				for(int j = 0; j < i; j++) {
					if(mision[j].getNombre().equalsIgnoreCase(nuevoNombre)) {
						System.out.println("\nEsa nave ya existe. Introduce otro nombre.");
						exixte = true;
						break;
					} else {
						exixte = false;
					}
				}
				
				if(!nuevoNombre.matches("[a-zA-Z]+")) {
					System.out.println("\nIntroduce un caracter vállido.");
				} else {
					mision[i].setNombre(nuevoNombre);
				}
				
			}while(!nuevoNombre.matches("[a-zA-Z]+") || exixte);
			
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
				
				if(nuevoTotcap < 0) {
					System.out.println("\nIntroduce un valor válido.");
				} else {
					mision[i].setTotcap(nuevoTotcap);
				}
				
			}while(nuevoTotcap < 0);
			
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
	
	//Metodo para mostrar naves de antigüedad superior a X. (Case 2)
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

	//Metodo para ordenar naves por año de lanzamiento. (Case 3)
	public static void ordenarPorAnioLanzamiento(NaveEspacial[] mision) {
		int contador = mision.length;

		NaveEspacial temp;

		for(int i = 0; i < contador - 1; i++) {
			for(int j = i + 1; j < contador; j++) {
				if(mision[i].getAniolanza() > mision[j].getAniolanza()) {
					temp = mision[i];
					mision[i] = mision[j];
					mision[j] = temp;
				}
			}
		}

		//Mostrar el array ordenado.
		System.out.println("\nNaves ordenadas por año de lanzamiento:\n");
		for(int i = 0; i < contador; i++) {
			System.out.println(mision[i].toString());
		}
	}

		//Metodo para modificar la capacidad total de las naves que admiten pasajeros. (Case 4)
	public static void modificarCapacidadTotal(NaveEspacial[] mision) {
		int contador = mision.length;
		int nuevaCapacidad = 0;
		char opcion;

		for(int i = 0; i < contador; i++){
			if(mision[i].admitePasajeros()){
				System.out.println("\nLa anve " +mision[i].getNombre() +" admite " +mision[i].getTotcap() +" pasajeros.");
				do{
					System.out.println("\n¿Quieres modificar la capacidad total de la nave? S/N");
					opcion = Util.leerChar();

					if(opcion != 'S' && opcion != 's' && opcion != 'N' && opcion != 'n'){
						System.out.println("\nIntroduce un caracter válido.");
					}

				}while(opcion != 'S' && opcion != 's' && opcion != 'N' && opcion != 'n');

				if(opcion == 'S' || opcion == 's'){
					do { 
						System.out.println("\nIntroduce la nueva capacidad total de la nave:");
						nuevaCapacidad = Util.leerInt();

						if(nuevaCapacidad < mision[i].getTotcap()){
							System.out.println("\nLa nueva capacidad no puede ser inferior a la actual.");
						}
					} while (nuevaCapacidad < mision[i].getTotcap());

					mision[i].setTotcap(nuevaCapacidad);
					System.out.println("\nCapacidad total modificada. Nueva info de la nave:\n"
							+mision[i].toString() );
				} else if(opcion == 'N' || opcion == 'n'){
					System.out.println("\nNo se ha modificado la capacidad de la nave.");
				}
			} else{
				System.out.println("\nLa nave " +mision[i].getNombre() +" no admite pasajeros, no se podrá modificar su capacidad.");
			}
		}
	}

	//Metodo para mostrar todas las naves registradas. (Case 5)
	public static void mostrarNavesRegistradas(NaveEspacial[] mision){
		int contador = mision.length;

		System.out.println("\nNaves registradas:\n");
		for(int i = 0; i < contador; i++){
			System.out.println(mision[i].toString());
		}
	}

	//Metodo para eliminar nave espacial. (Case 6)
	public static void eliminarNaveEspacial(NaveEspacial[] mision){
		int contador = mision.length;
		String eliminar;
		boolean encontrado = false;

		do { 
			System.out.println("\nIntroduce el nombre de la nave que quieres eliminar:");
			eliminar = Util.introducirCadena();

			if(!eliminar.matches("[a-zA-Z]+")) {
				System.out.println("\nIntroduce un caracter válido.");
			} 

		} while (!eliminar.matches("[a-zA-Z]+"));

		for(int i = 0; i < contador; i++){
			if(mision[i].getNombre().equalsIgnoreCase(eliminar)){
				encontrado = true;
				mision[i] = null;
				System.out.println("\nLa nave " +eliminar +" ha sido eliminada.");
			}
		}
		if(!encontrado){
			System.out.println("\nLa nave " +eliminar +" no se ha encontrado.");
		} else{
			System.out.println("\nNaves restantes:\n");
			for(int i = 0; i < contador; i++){
				if(mision[i] != null){
					System.out.println(mision[i].toString());
				}
			}
		}
	}

}

