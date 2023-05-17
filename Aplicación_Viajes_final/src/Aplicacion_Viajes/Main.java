package Aplicacion_Viajes;

import java.util.Scanner;

public abstract class Main {

	public static void main(String[] args) {

		menu_principal Menu1 = new menu_principal();
		Usuario usuario0 = new Usuario(); // quitados los argumentos
		menu_viajes viajes = new menu_viajes();

		int indice_usuario = 0;
		boolean salir = false;

		while (salir == false) {

			boolean salir3 = false;
			while (salir3 == false) {

				try {

					Menu1.MenuInicio();
					if (Menu1.opcion1 != 1 && Menu1.opcion1 != 2) {
						System.err.println("Introduce una opción válida, (1 o 2)\n");
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
							salir3 = true;
						}
					}

					}
				} catch (Exception e) {
					System.err.println("Introduce una opción válida, (1 o 2)");
					System.out.println();
				}
			}

			System.out.println();

			boolean salir1 = false;

			while (salir1 == false) {

				try {

					Menu1.MenuViajes(indice_usuario, usuario0);
					viajes.copiarArrayUsuarios(usuario0);

					if (Menu1.opcion2 < 1 || Menu1.opcion2 > 5) {
						System.err.println("Introduzca una opción valida entre 1 y 5\n");
					}

					switch (Menu1.opcion2) {

					case 1: {

						boolean resultado = false;

						while (resultado == false) {
							resultado = viajes.menuDestino();
						}
						viajes.menuFecha();
						viajes.GuardarViaje(usuario0);
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

						boolean salir2 = false;

						while (salir2 == false) {

							Menu1.MenuUsuario();
							System.out.println();

							if (Menu1.opcion3 < 1 || Menu1.opcion3 > 5) {
								System.err.println("Introduzca una opción valida entre 1º y 5º");
							}

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

								Scanner scEliminarUsuario = new Scanner(System.in);

								boolean salir4 = false;

								while (salir4 == false) {

									System.err.println("¿Desea eliminar su Usuario actual de forma definitiva?"
											+ "\nEscriba Si o No.");
									String opcionEliminar = scEliminarUsuario.nextLine();

									if (opcionEliminar.contentEquals("Si")) {
										usuario0.EliminarUsuario();
										salir2 = true;
										salir1 = true;
										salir4 = true;

									} else if (opcionEliminar.contentEquals("No")) {
										salir4 = true;

									} else {
										System.err.println("Introduzca correctamente (Si) o (No)\n");

									}
								}
								break;
							}

							case 4: {
								viajes.historialViajes();
								break;

							}

							case 5: {
								System.out.println("Volviendo al menú...\n");
								salir2 = true;
								break;
							}

							}
						}
						break;
					}

					case 5: {
						System.out.println("¡Gracias por visitarnos, hasta pronto!\n");
						salir1 = true;
						break;
					}

					}
				} catch (Exception e) {
					System.err.println("Introduce una opción válida");

				}

			}
		}

	}

}
