package principal;

import models.Coche;

public class Concesionario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coche[] inventario = new Coche[3];

		do {
			System.out.println("\n====================MENU====================\n" 
					+ "\n1.- Introducir nuevo coche."
					+ "\n2.- Listado de coches." 
					+ "\n3.- Listar por MARCA." 
					+ "\n4.- Listar por COLOR."
					+ "\n5.- Mostrar media de Cilindrada." 
					+ "\n6.- Listar coches por potencia."// Orden descendente
					+ "\n7.- Sumar precio total de coches." 
					+ "\n8.- Modificar precio." // Buscar por matrícula
					+ "\n9.- Resumen por colores." // Mostrar cantidad de coches de un color
					+ "\n10.- SALIR.\n"
					+ "\n============================================\n");

			int opcion = Util.leerInt();
			
			switch(opcion) {
				case 1:
					
					
					
					
				case 2:
					
					
					
					
				case 3:
					
					
					
					
				case 4:
					
					
					
					
				case 5:
					
					
					
					
				case 6:
					
					
					
					
				case 7:
					
					
					
					
				case 8:
					
					
					
					
				case 9:
					
					
					
					
				case 10:
					
					System.out.println("Finalizando programa...");
					return;
			}

		} while (true);
	}
	
	//Metodo para introducir nuevo coche.
	public static void introducir(Coche[] inventario) {
		
		int contador = inventario.length;
		boolean encontrado = false;
		
		do {
		System.out.println("\nIntroduce la matrícula del nuevo coche.");
		String matricula = Util.introducirCadena();
		
		for(int i = 0; 1 < contador; i++) {
			if(inventario[i].getMatricula().equalsIgnoreCase(matricula)) {
				System.out.println("\nLa matrícula " +matricula +" ya está registrada.");
			}
		}
		
		}while(encontrado);
		
		for(int j = 0; j < contador; j++) {
			
		}
	}
	
	//Metodo para mostrar todos los coches.
	public static void mostrar(Coche[] inventario) {
		
	}
	
	//Metodo para filtrar por marca
	public static void marca(Coche[] inventario) {
		
	}
	
	//Metodo para filtrar por color
	public static void color(Coche[] inventario) {
		
	}
	
	//Metodo para mostrar por cilindrada
	public static void cilindrada(Coche[] inventario) {
		
	}
	
	//Metodo para mostrar por potencia
	public static void potencia(Coche[] inventario) {
		
	}
	
	//Metodo para sumar el precio total
	public static void total(Coche[] inventario) {
		
	}
	
	//Metodo para modificar precio de coche por matrícula
	public static void modPrecio(Coche[] inventario) {
		
	}
	
	//Metodo para resumir por colores
	public static void colores(Coche[] inventario) {
		
	}
}
