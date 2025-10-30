package principal;
import models.Persona;

public class Eliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona[] personas = new Persona[3];
		personas[0] = new Persona("Pedro", 19, "123");
		personas[1] = new Persona("Maroto", 33, "456");
		personas[2] = new Persona("Aitziber", 20, "678");
		int contador = personas.length;
		boolean encontrado = false;

		for(int i = 0; i < contador; i++) {
				System.out.println(personas[i]);
			}

		do{

			int opcion = 0;

			while(opcion < 1 || opcion > 4){
				System.out.println("\n=============MENU=============\n"
						+"\n1.- Eliminar persona del array."
						+"\n2.- Salir del programa."
						+"\n3.- Ordenar de manera ascendente segun edad."
						+"\n4.- Ordenar de manera descendente segun edad."
						+"\n==============================\n");

				opcion = Util.leerInt();

				if (opcion < 1 || opcion > 4) {
					System.out.println("Introduce una opción válida.");
				}
			}
			switch(opcion) {
				case 1:
					System.out.println("Introduce el nombre de la persona a eliminar:");
					String nombreEliminar = Util.introducirCadena();

					if(contador == 0){
						System.out.println("No quedan personas en el array.");
						break;
					} else{
						for(int i = 0; i < contador; i++) {
							if(personas[i].getNombre().equalsIgnoreCase(nombreEliminar)) {
								for(int j = i; j < contador - 1; j++) {
									personas[j] = personas[j + 1];
								}
								personas[contador - 1] = null; // Elimina la referencia al último elemento
								contador--;
								encontrado = true;
								System.out.println("Persona eliminada.");
								break;
							}
						}
						if(!encontrado) {
							System.out.println("Persona no encontrada.");
						}
					}

					System.out.println("Asi queda el array tras eliminar el nombre " +nombreEliminar +":");
					for(int k = 0; k < contador; k++) {
						System.out.println(personas[k]);
					}
					break;
				
				case 2:
					System.out.println("Saliendo del programa...");
					return;
				
				case 3:
					System.out.println("\nAqui tienes el array ordenado de manera ascendente segun la edad:");
					for(int i = 0; i < contador -1; i++) {
						for(int j = 0; j < contador -1 -i; j++) {
							if(personas[j].getEdad() > personas[j + 1].getEdad()) {
								Persona aux = personas[j];
								personas[j] = personas[j + 1];
								personas[j + 1] = aux;
							}
						}
					}
					for(int k = 0; k < contador; k++) {
						System.out.println(personas[k]);
					}
					break;
				
				case 4:
					System.out.println("\nAqui tienes el array ordenado de manera descendente segun la edad:");
					for(int i = 0; i < contador -1; i++) {
						for(int j = 0; j < contador -1 -i; j++) {
							if(personas[j].getEdad() < personas[j + 1].getEdad()) {
								Persona aux = personas[j];
								personas[j] = personas[j + 1];
								personas[j + 1] = aux;
							}
						}
					}
					for(int k = 0; k < contador; k++) {
						System.out.println(personas[k]);
					}
					break;
			}
		}while(true);
	}

}
