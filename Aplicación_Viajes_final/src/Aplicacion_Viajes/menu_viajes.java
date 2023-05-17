package Aplicacion_Viajes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Date;

//Herencia, menu_viajes hereda de Usuario
public class menu_viajes extends Usuario {
	// Atributos de menu_viajes
	protected Usuario usuario;
	protected String comunidad;
	protected String localidad;
	protected int playa;
	protected int numeroRegalo;
	protected String FechaVuelta;
	protected String FechaIda;
	protected Date hora;
	
	int numeroViajes = 0;
	
	DatosViajes arrayViajes[] = new DatosViajes[100];// Array en el que se guardaran los viajes realizados

	public menu_viajes() {
	}

	public void copiarArrayUsuarios(Usuario user) {

		System.arraycopy(user.arrayUsuarios, 0, this.arrayUsuarios, 0, user.arrayUsuarios.length);
		this.email = user.email;
		this.contraseña = user.contraseña;
	}

	public void GuardarViaje(Usuario user) {

		if (this.arrayViajes[numeroViajes] == null) {
			this.arrayViajes[numeroViajes] = new DatosViajes(user, this.comunidad, this.localidad, this.FechaIda,
					this.FechaVuelta, this.hora);
			numeroViajes = numeroViajes + 1;
		}
	}

	public void historialViajes() {

		System.out.println("Historial de viajes:");

		for (int i = 0; i <= numeroViajes; i++) {
			if (this.arrayViajes[i] != null) {
				if (this.email.contentEquals(arrayViajes[i].usuario.email)
						&& this.contraseña.contentEquals(arrayViajes[i].usuario.contraseña)) {
					System.out.println(
							"COMUNIDAD: " + arrayViajes[i].comunidad + " LOCALIDAD: " + arrayViajes[i].localidad
									+ " FECHA DE IDA: " + arrayViajes[i].FechaIda + " FECHA DE VUELTA: "
									+ arrayViajes[i].FechaVuelta + " DÍA DE CREACIÓN: " + arrayViajes[i].hora);
				}
			}
		}
	}
	 
	public boolean menuDestino() {//Este metodo abre el menú Viajar

		Scanner escaner1 = new Scanner(System.in);

		boolean resultado = false;
		boolean salirMenuViajes = false;
		
		while (salirMenuViajes == false) {//Bucle While para que entre a la opción viajar si la variable salirMenuViajes es false
			// Menu opcion Viajar
			System.out.print(
					"\n---ORGANIZA TU VIAJE--- \n¿En que parte de España quieres viajar? (Comunidad Autonoma)\nNuestros destinos: Andalucía, Canarias, Madrid, Extremadura\nDestino: ");
			this.comunidad = escaner1.nextLine();
			if (comunidad.contentEquals("Andalucía") || comunidad.contentEquals("Canarias")
					|| comunidad.contentEquals("Extremadura") || comunidad.contentEquals("Madrid")) {

				boolean salirOpciones = false;
				while (salirOpciones == false) {//Bucle while para que entre a las opciones de cada comunidad autonoma si salirOpciones es false

					if (this.comunidad.equals("Andalucía")) {
						System.out.print("\n--OPCIONES PARA VIAJAR EN ANDALUCIA--" // Submenu viajar Andalucia
								+ "\nPara el destino Andalucía tenemos viajes a Cádiz o Córdoba"
								+ "\n¿Qué destino prefieres? \n(1)Cádiz \n(2)Córdoba \nOpción: ");
						int opcionDestino = escaner1.nextInt();

						if (opcionDestino == 1 || opcionDestino == 2) {//Según la opcion introducida se guardara localidad con un destino diferente
							if (opcionDestino == 1) {
								this.localidad = "Cádiz";
							}

							else if (opcionDestino == 2) {
								this.localidad = "Córdoba";
							}
							resultado = true;
							salirMenuViajes = true; //Bucle While para que salga de la opción viajar si la variable salirMenuViajes es true
							salirOpciones = true;//Bucle while para que salga de las opciones de cada comunidad autonoma si salirOpciones es true
						}

						else {
							System.err.println("Elige una opción correcta");// Aviso error
						}

					} else if (comunidad.equals("Canarias")) {
						System.out.print("\n--OPCIONES PARA VIAJAR EN CANARIAS--" // Submenu viajar Canarias
								+ "\nPara el destino Canarias tenemos viajes a Tenerife o La Palma"
								+ "\n¿Qué destino prefieres? \n(1)Tenerife \n(2)La Palma \nOpción: ");
						int opcionDestino = escaner1.nextInt();

						if (opcionDestino == 1 || opcionDestino == 2) {//Según la opcion introducida se guardara localidad con un destino diferente
							if (opcionDestino == 1) {
								this.localidad = "Tenerife";
							}

							else if (opcionDestino == 2) {
								this.localidad = "La Palma";
							}
							resultado = true;
							salirMenuViajes = true;
							salirOpciones = true;
						}

						else {
							System.err.println("Elige una opción correcta");// Aviso error
						}

					} else if (comunidad.equals("Madrid")) {
						System.out.print("\n--OPCIONES PARA VIAJAR EN MADRID--"
								+ "Para el destino Madrid tenemos viajes a Madrid Capital o Getafe" // Submenu viajar
																									// Madrid
								+ "\n¿Qué destino prefieres? \n(1)Madrid Capital \n(2)Getafe \nOpción: ");
						int opcionDestino = escaner1.nextInt();

						if (opcionDestino == 1 || opcionDestino == 2) {//Según la opcion introducida se guardara localidad con un destino diferente
							if (opcionDestino == 1) {
								this.localidad = "Madrid capital";
							}

							else if (opcionDestino == 2) {
								this.localidad = "Getafe";
							}
							resultado = true;
							salirMenuViajes = true;
							salirOpciones = true;
						}

						else {
							System.err.println("Elige una opción correcta");//Aviso error
						}

					} else if (comunidad.equals("Extremadura")) {
						System.out.print("\n--OPCIONES PARA VIAJAR EN EXTREMADURA--" // Submenu viajar Extremadura
								+ "\nPara el destino Extremadura tenemos viajes a Cáceres o Badajoz"
								+ "\n¿Qué destino prefieres? \n(1)Cáceres \n(2)Badajoz \nOpción: ");
						int opcionDestino = escaner1.nextInt();

						if (opcionDestino == 1 || opcionDestino == 2) {//Según la opcion introducida se guardara localidad con un destino diferente
							if (opcionDestino == 1) {
								this.localidad = "Cáceres";
							}

							else if (opcionDestino == 2) {
								this.localidad = "Badajoz";
							}
							resultado = true;
							salirMenuViajes = true;
							salirOpciones = true;
						}

						else {// Aviso error
							System.err.println("Elige una opción correcta");//Aviso error
						}
					}
				}
			} else // Si escribe una comunidad erronea saldrá este aviso
				System.err.println("Lo sentimos no hay viajes en " + comunidad + " disponibles...\n");
		}
		return resultado;
	}

	
	public void menuFecha() {	// Metodo para elegir fechas despúes del destino elegido

		Scanner escaner2 = new Scanner(System.in);

		System.out.print("\n¡Perfecto! Vamos a elegir fechas para tu estancia \n");
		
		System.out.print("Selecciona la fecha de entrada: ");// Fecha de entrada EJEMPLO 8 de Junio
		this.FechaIda = escaner2.nextLine();
		
		System.out.print("Selecciona la fecha de salida: ");// Fecha de entrada EJEMPLO 10 de Junio
		this.FechaVuelta = escaner2.nextLine();

		this.hora = new Date();
		System.out.println("\n¡Tu viaje ha sido completado! \nTienes un viaje desde el dia " + this.FechaIda
				+ " hasta el dia " + this.FechaVuelta);
		System.out.println("Creado el " + this.hora + "\n");// Funcion de la hora y fecha actual

	}

	
	public void menuRecomendaciones() {// Este metodo abre el menú Recomendaciones

		Scanner escaner3 = new Scanner(System.in);

		System.out.print("---RECOMENDACIONES---"
				+ "\nPara recomedarte el mejor destino para ti, necesitamos hacerte algunas preguntas"
				+ "\n¿Prefieres un destino con playa?\n(1)Si \n(2)No \nOpción: ");
		playa = escaner3.nextInt();
		System.out.print("\n¿Prefieres un destino en la peninsula?\n(1)Si \n(2)No \nOpción: ");
		int opcionDestino = escaner3.nextInt();
		System.out.println();

		if (playa == 1 && opcionDestino == 1) {
			System.out.println(
					"La mejor opcion para ti, es un viaje a Andalucía. \nPara organizar tu viaje pulsa la opcion Viajar\n");
		}

		else if (playa == 1 && opcionDestino == 2) {
			System.out.println(
					"La mejor opcion para ti, es un viaje a Canarias. \nPara organizar tu viaje pulsa la opcion Viajar\n");
		}

		else if (playa == 2 && opcionDestino == 1) {
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

		else if (playa == 2 && opcionDestino == 2) {
			System.err.println("Lo sentimos no hay viajes disponibles sin playa y fuera de la peninsula...\n");

		} else {
			System.err.println("Por favor introduce una opción correcta");

		}
	}

	
	public void menuSorteo() {//Este metodo abre el menú sorteo
		// Pila y Cola
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

		System.out.println("\n¡Estamos sorteando un viaje a Madrid!");
		System.out.println("Para participar solo tienes que elegir un regalo, ¡Suerte!");
		System.out.println(pila);// Imprimir la pila

		boolean resultado = false;

		while (resultado == false) {//Bucle while para entrar si la opcion es correcta, si es así resultado esta en false

			System.out.print("Elige un regalo del 1 al 3: ");
			int numeroRegalo = sc.nextInt();
			if (numeroRegalo == 1 || numeroRegalo == 2 || numeroRegalo == 3) {// If para comprobar que el número del
																				// regalo es correcto
				switch (numeroRegalo) {// Según el regalo debe de pasar lo siguiente:
				case 1: {
					// Eliminar un elemento de la pila
					String eliminado = pila.pop();//Eliminar el regalo elegido de la pila
					System.out.println("¡FELICIDADES! \nERES EL GANADOR DEL VIAJE A MADRID");
					System.out.println("¡Perfecto, espera nuestra respuesta pronto!\n");
					resultado = true;//Salir del bucle sorteo
					break;
				}
				case 2: {
					String eliminado = pila.pop();//Eliminar el regalo elegido de la pila
					System.out.println("Regalos del sorteo restantes " + pila);// Imprimir pila actualizada
					System.out.println("Lo sentimos ese regalo no tiene premio...\n");
					resultado = true;//Salir del bucle sorteo
					break;
				}
				case 3: {
					String eliminado = pila.pop();//Eliminar el regalo elegido de la pila

					System.out.println("Regalos del sorteo restantes " + pila);// Imprimir pila actualizada
					System.out.println("Lo sentimos ese regalo no tiene premio...\n");
					resultado = true; //Salir del bucle sorteo
					break;
				}

				}
			} else {// Aviso de regalo incorrecto
				System.err.println("\nElige un regalo entre el 1 al 3");
				resultado = false;//Para que no salga del bucle sorteo, sino que se repita hasta que introduzca el correcto
			}
		}
	}

}
