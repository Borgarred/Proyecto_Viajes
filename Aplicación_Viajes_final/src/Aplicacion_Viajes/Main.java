package Aplicacion_Viajes;

import java.util.Scanner;

public abstract class Main {

	public static void main(String[] args) {

		menu_principal Menu1 = new menu_principal();
		Usuario usuario0 = new Usuario(); // quitados los argumentos
		menu_viajes viajes = new menu_viajes();

		int indice_usuario = 0;
		boolean salir = false, salir1 = false, salir2 = false, salir3 = false, salir4 = false;

		while (salir == false) {

			try {

				Menu1.MenuInicio();
				if (Menu1.opcion1 != 1 && Menu1.opcion1 != 2) {
					System.err.println("Elija una de las opcióne correctamente \n");
				}

				switch (Menu1.opcion1) {

				case 1: {

					usuario0.NuevoUsuario();
					break;

				}

				case 2: {

					indice_usuario = usuario0.IniciarSesion();

					if (indice_usuario == -1) {
						System.err.println("USUARIO NO REGISTRADO");
						System.out.println();
					} else {
						salir = true;
					}
				}
				}
			} catch (Exception e) {
				System.err.println("Introduce una opción válida, (1 o 2)");
				System.out.println();
			}
		}
		System.out.println();

		while (salir2 == false) {

			try {

				Menu1.opcion3 = 0;
				Menu1.MenuViajes(indice_usuario, usuario0);
				System.out.println();
				if (Menu1.opcion2 < 1 || Menu1.opcion2 > 4) {
					System.err.println("Introduzca una opción valida entre 1º y 4º");

				}
				switch (Menu1.opcion2) {

				case 1: {
					boolean resultado = false;

					while (resultado == false) {
						resultado = viajes.menuDestino();

						if (resultado == true)
							viajes.menuFecha();
					}
					break;
				}
				case 2: {
					viajes.menuRecomendaciones();
					break;
				}
				case 3: {
					viajes.menuSorteo();
					break;
				}

				case 4: {

					while (salir4 == false) {

						Menu1.MenuUsuario();

						switch (Menu1.opcion3) {

						case 1: {
							usuario0.DatosUsuario();
							break;
						}

						case 2: {
							usuario0.CambiarDatos();
							break;
						}

						case 3: {
							break;
						}

						case 4: {
							usuario0.EliminarUsuario();
							break;
						}

						case 5: {
							System.out.println();
							salir4 = true;
							break;
						}

						}
					}
					break;
				}
				case 5: {
					System.out.print("¡Gracias por visitarnos, hasta pronto!");
					salir2 = true;
					break;
				}

				}
			} catch (Exception e) {
				System.err.println("Introduce una opción válida");
				System.out.println();
			}
		}

	}

}
