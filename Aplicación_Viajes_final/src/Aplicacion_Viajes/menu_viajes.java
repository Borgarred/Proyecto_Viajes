package Aplicacion_Viajes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Date;

public class menu_viajes extends Usuario {

	protected Usuario usuario;
	protected int tipo;
	String nombreHotel;
	String localidad;
	int fecha;
	String comunidad;
	int destino;
	int playa;
	public int numeroRegalo;
	int hora;

	public menu_viajes() {
	}

	public boolean menuDestino() {

		Scanner escaner1 = new Scanner(System.in);

		boolean resultado = false;
		boolean salirMenuViajes = false;

		while (salirMenuViajes == false) {

			System.out.print(
					"---ORGANIZA TU VIAJE--- \n¿En que parte de España quieres viajar? (Comunidad Autonoma)\nNuestros destinos: Andalucía, Canarias, Madrid, Extremadura\nDestino: ");
			this.comunidad = escaner1.nextLine();

			if (comunidad.contentEquals("Andalucía") || comunidad.contentEquals("Canarias")
					|| comunidad.contentEquals("Extremadura") || comunidad.contentEquals("Madrid")) {

				boolean salirOpciones = false;
				while (salirOpciones == false) {

					if (this.comunidad.equals("Andalucía")) {
						System.out.print("\n--OPCIONES PARA VIAJAR EN ANDALUCIA--"
								+ "\nPara el destino Andalucía tenemos viajes a Cadiz o Córdoba"
								+ "\n¿Qué destino prefieres? \n(1)Cadiz \n(2)Córdoba \nOpción: ");
						destino = escaner1.nextInt();

						if (destino == 1 || destino == 2) {
							resultado = true;
							salirMenuViajes = true;
							salirOpciones = true;
						}

						else {
							System.err.println("Elige una opción correcta");
						}

					} else if (comunidad.equals("Canarias")) {
						System.out.print("\n--OPCIONES PARA VIAJAR EN CANARIAS--"
								+ "\nPara el destino Canarias tenemos viajes a Tenerife o La Palma"
								+ "\n¿Qué destino prefieres? \n(1)Tenerife \n(2)La Palma \nOpción: ");
						destino = escaner1.nextInt();

						if (destino == 1 || destino == 2) {
							resultado = true;
							salirMenuViajes = true;
							salirOpciones = true;
						}

						else {
							System.err.println("Elige una opción correcta");
						}

					} else if (comunidad.equals("Madrid")) {
						System.out.print("\n--OPCIONES PARA VIAJAR EN MADRID--"
								+ "Para el destino Madrid tenemos viajes a Madrid Capital o Getafe"
								+ "\n¿Qué destino prefieres? \n(1)Madrid Capital \n(2)Getafe \nOpción: ");
						destino = escaner1.nextInt();

						if (destino == 1 || destino == 2) {
							resultado = true;
							salirMenuViajes = true;
							salirOpciones = true;
						}

						else {
							System.err.println("Elige una opción correcta");
						}

					} else if (comunidad.equals("Extremadura")) {
						System.out.print("\n--OPCIONES PARA VIAJAR EN EXTREMADURA--"
								+ "\nPara el destino Extremadura tenemos viajes a Cáceres o Badajoz"
								+ "\n¿Qué destino prefieres? \n(1)Cáceres \n(2)Badajoz \nOpción: ");
						destino = escaner1.nextInt();

						if (destino == 1 || destino == 2) {
							resultado = true;
							salirMenuViajes = true;
							salirOpciones = true;
						}

						else {
							System.err.println("Elige una opción correcta");
						}
					}
				}
			} else
				System.err.println("Lo sentimos no hay viajes en " + comunidad + " disponibles...\n");
		}
		return resultado;
	}

	public void menuFecha() {

		Scanner escaner2 = new Scanner(System.in);

		System.out.print("\n¡Perfecto! Vamos a elegir fechas para tu estancia: \nIntroduce en que mes vas a viajar: ");
		String mes = escaner2.nextLine();

		System.out.print("Selecciona la fecha de entrada: ");
		int diaIda = escaner2.nextInt();

		System.out.print("Selecciona la fecha de salida: ");
		int diaVuelta = escaner2.nextInt();

		Date hora = new Date();
		System.out.println("\n¡Tu viaje ha sido completado! \nTienes un viaje en el mes de " + mes + ", desde el dia "
				+ diaIda + " hasta el dia " + diaVuelta);
		System.out.println("Creado el "+ hora + "\n");

	}

	public void menuRecomendaciones() {

		Scanner escaner3 = new Scanner(System.in);

		System.out.print("---RECOMENDACIONES---"
				+ "\nPara recomedarte el mejor destino para ti, necesitamos hacerte algunas preguntas"
				+ "¿Prefieres un destino con playa?\n(1)Si \n(2)No \nOpción: ");
		playa = escaner3.nextInt();
		System.out.print("\n¿Prefieres un destino en la peninsula?\n(1)Si \n(2)No \nOpción:");
		this.destino = escaner3.nextInt();
		System.out.println();

		if (playa == 1 && destino == 1) {
			System.out.println(
					"La mejor opcion para ti, es un viaje a Andalucía. \nPara organizar tu viaje pulsa la opcion Viajar\n");
		}

		else if (playa == 1 && destino == 2) {
			System.out.println(
					"La mejor opcion para ti, es un viaje a Canarias. \nPara organizar tu viaje pulsa la opcion Viajar\n");
		}

		else if (playa == 2 && destino == 1) {
			System.out.println("¿Prefieres un destino en la capital?\n(1)Si \n(2)No \nOpción: ");
			int peninsula = escaner3.nextInt();
			System.out.println();
			if (peninsula == 1) {
				System.out.println(
						"La mejor opcion para ti, es un viaje a Madrid. \nPara organizar tu viaje pulsa la opcion Viajar\n");
			} else if (peninsula == 2) {
				System.out.println(
						"La mejor opcion para ti, es un viaje a Extremadura. \nPara organizar tu viaje pulsa la opcion Viajar\n");
			}
		}

		else if (playa == 2 && destino == 2) {
			System.err.println("Lo sentimos no hay viajes disponibles sin playa y fuera de la peninsula...\n");

		} else {
			System.err.println("Por favor introduce una opción correcta");

		}
	}

	public void menuSorteo() {

		Scanner sc = new Scanner(System.in);

		Stack<String> pila = new Stack<>();

		// Agregar elementos a la pila
		pila.push("🎁");
		pila.push("🎁");
		pila.push("🎁");
		Queue<String> cola = new LinkedList<>();

		// Agregar elementos a la cola
		cola.add("🎁");
		cola.add("🎁");
		cola.add("🎁");

		// Imprimir la pila
		System.out.println("¡Estamos sorteando un viaje a Mallorca!");
		System.out.println("Para participar solo tienes que elegir un regalo, ¡Suerte!");
		System.out.println(pila);

		boolean resultado = false;

		while (resultado == false) {

			System.out.print("Elige un regalo del 1 al 3: ");
			int numeroRegalo = sc.nextInt();
			if (numeroRegalo == 1 || numeroRegalo == 2 || numeroRegalo == 3) {
				switch (numeroRegalo) {
				case 1: {
					// Eliminar un elemento de la pila
					String eliminado = pila.pop();
					System.out.println("¡FELICIDADES! \nERES EL GANADOR DEL VIAJE A MALLORCA");
					System.out.println("¡Perfecto, espera nuestra respuesta pronto!\n");
					resultado = true;
					break;
				}
				case 2: {
					String eliminado = pila.pop();
					System.out.println("Regalos del sorteo restantes " + pila);
					System.out.println("Lo sentimos ese regalo no tiene premio...\n");
					resultado = true;
					break;
				}
				case 3: {
					String eliminado = pila.pop();

					System.out.println("Regalos del sorteo restantes " + pila);
					System.out.println("Lo sentimos ese regalo no tiene premio...\n");
					resultado = true;
					break;
				}

				}
			} else {
				System.err.println("\nElige un regalo entre el 1 al 3");
				resultado = false;
			}
		}
	}

}
