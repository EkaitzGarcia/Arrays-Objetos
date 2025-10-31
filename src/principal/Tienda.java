package principal;

import models.Almacen;

public class Tienda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Almacen[] inventario = { new Almacen("Bujía", 20, true), new Almacen("Catalizador", 3, true),
				new Almacen("Alternador", 1, true) };

		int contador = inventario.length;
		boolean encontrado = false;

		do {
			System.out.println("\n=================MENU=================\n" 
					+ "\n1.- Mostrar todos los productos.\n"
					+ "2.- Modificar un producto.\n" 
					+ "3.- Cambiar el orden de los productos.\n"
					+ "4.- Contar productos activos.\n" 
					+ "5.- Buscar producto.\n" 
					+ "6.- Comprar unidades.\n"
					+ "7.- Finializar programa.\n" 
					+ "\n=======================================\n");

			int opcion = Util.leerInt();

			switch (opcion) {

			case 1:

				Mostrar(inventario);
				break;

			case 2:

				Modificar(inventario);
				break;

			case 3:

				Ordenar(inventario);
				break;

			case 4:

				Activo(inventario);
				break;

			case 5:

				Buscar(inventario);
				break;

			case 6:

				Comprar(inventario);
				break;

			case 7:

				System.out.println("Finalizando programa...");
				return;

			}
		} while (true);

	}

	// Metodo para mostrar los artículos.
	private static void Mostrar(Almacen[] inventario) {

		int contador = inventario.length;

		System.out.println("Lista de productos:\n");
		for (int i = 0; i < contador; i++) {
			System.out.println(inventario[i].toString());
		}
	}

	// Metodo para modificar un producto.
	private static void Modificar(Almacen[] inventario) {
		
		int contador = inventario.length;
		String mod;
		
		System.out.println("\n¿Cual es el artículo que quieres modificar?");
		mod = Util.introducirCadena();
		
		for(int i = 0; i < contador; i++) {
			if(inventario[i].getArticulo().equalsIgnoreCase(mod)) {
				
				System.out.println("\n¿Quieres modificar el nombre? S/N");
				char eleccion = Util.leerChar();
				
				if(eleccion == 'S' || eleccion == 's') {
					System.out.println("\nIntroduce el nuevo nombre:");
					String nuevonom = Util.introducirCadena();
					inventario[i].setArticulo(nuevonom);
				} else if(eleccion == 'N' || eleccion == 'n') {
					System.out.println("\n¿Quieres cambiar las unidades? S/N");
					char eleccion2 = Util.leerChar();
					
					if(eleccion2 == 'S' || eleccion2 == 's') {
						System.out.println("\nIntroduce la nueva cantidad:");
						int nuevacant = Util.leerInt();
						inventario[i].setUnidades(nuevacant);
					} else if(eleccion2 == 'N' || eleccion2 == 'n') {
						System.out.println("\n¿Quieres cambiar el estado? S/N");
						char eleccion3 = Util.leerChar();
						
						if(eleccion3 == 'S' || eleccion2 == 's') {
							System.out.println("\nIntroduce el nuevo estado del artículo: A (Activo) / I (Inactivo)");
							char nuevoest = Util.leerChar();
							
							if(nuevoest == 'A' || nuevoest == 'a') {
								inventario[i].setEstado(true);
							} else if(nuevoest == 'I' || nuevoest == 'i') {
								inventario[i].setEstado(false);
							}
						}
					}
				}
			}
		}
		
	}

	// Metodo para ordenar productos.
	private static void Ordenar(Almacen[] inventario) {

	}

	// Metodo para ordenar por NOMBRE.
	private static void OrdenarNombre(Almacen[] inventario) {

	}

	// Metodo para ordenar por UNIDADES
	private static void OrdenarUnidades(Almacen[] inventario) {

	}

	// Metodo para contar productos ACTIVOS
	private static void Activo(Almacen[] inventario) {

	}

	// Metodo para buscar productos por NOMBRE
	private static void Buscar(Almacen[] inventario) {

	}

	// Metodo para comprar unidades.
	private static void Comprar(Almacen[] inventario) {

	}

}
