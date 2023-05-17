package Aplicacion_Viajes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Usuario {

	DatosUsuario arrayUsuarios[] = new DatosUsuario[20];// Array en el que se almacenan los datos de cada Usuario

	protected String email;
	protected String contraseña;
	protected String nombre;
	protected String apellidos;
	protected String DNI;
	protected int edad;

	int numeroUsuarios = 0;

	public Usuario() {

	}

	public Usuario(String email, String contraseña, String nombre, String apellidos, String DNI, int edad) {
		this.email = email;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = DNI;
		this.edad = edad;
	}
	
	/*Método que toma valores por teclado y los almacena en el registro vacío 
	que encuentre en el array de DatosUsuario*/
	public void NuevoUsuario() { 

		Scanner scNuevoUsuario = new Scanner(System.in);

		int indice = 0;

		// Indice que marca el primer registro del array que no contenga datos
		for (int i = 19; i >= 0; i--) {
			if (this.arrayUsuarios[i] == null) {
				indice = i;
			}
		}

		/*Obtiene por teclado los valores que usaremos para los atributos de
		 * DatosUsuarios
		 */
		System.out.print("Introduzca un email: ");
		String email = scNuevoUsuario.nextLine();

		System.out.print("Inserte una contraseña: ");
		String contraseña = scNuevoUsuario.nextLine();

		System.out.print("Introduzca su nombre: ");
		String nombre = scNuevoUsuario.nextLine();

		System.out.print("Introduzca sus apellidos: ");
		String apellidos = scNuevoUsuario.nextLine();

		System.out.print("Introduzca su DNI: ");
		String DNI = scNuevoUsuario.nextLine();

		System.out.print("Introduzca su edad: ");
		int edad = scNuevoUsuario.nextInt();

		scNuevoUsuario.nextLine();

		System.out.println();

		/*
		 * Almacena los datos que acabamos de obtener en el elemento del array marcado
		 * por índice, el cual es el primer registro del array que no contiene datos.
		 */
		this.arrayUsuarios[indice] = new DatosUsuario(email, contraseña, nombre, apellidos, DNI, edad);
		InsertarDatos(indice);
		numeroUsuarios = numeroUsuarios + 1;
	}

	/*Este método devuelve una lista de todos los usuarios almacenados en el array,
	en el código final no lo usamos pero nos ayudo al principio a ver que datos
	almacenaba el array */
	public void ListaUsuarios() {

		int i = 0;

		System.out.println("--------Lista de usuarios:--------");
		while (i < numeroUsuarios) {
			System.out.println(i + 1 + "º. " + arrayUsuarios[i].nombre + " " + arrayUsuarios[i].apellidos);
			i = i + 1;
		}
	}

	/*Este método iguala los atributos de Usuario a los atributos del registro del
	array con el que iniciamos sesión */
	public int IniciarSesion() {

		Scanner scInicioUsuario = new Scanner(System.in);

		int indice = 0;

		System.out.print("Introduzca su email: ");
		String email = scInicioUsuario.nextLine();

		System.out.print("Introduzca sus contraseña: ");
		String contraseña = scInicioUsuario.nextLine();

		boolean salir = false;

		/* Recorre el array, si el valor no es nulo y los atributos email y contraseña
		introducidos son iguales a los de algún registro del array inicia sesión con
		ese registro */
		for (int i = 0; i < arrayUsuarios.length; i++) {
			if (arrayUsuarios[i] != null) {
				if (arrayUsuarios[i].email.equals(email) && arrayUsuarios[i].contraseña.equals(contraseña)) {
					this.email = email;
					this.contraseña = contraseña;
					this.nombre = arrayUsuarios[i].nombre;
					this.apellidos = arrayUsuarios[i].apellidos;
					this.DNI = arrayUsuarios[i].DNI;
					this.edad = arrayUsuarios[i].edad;
					System.out.println("¡Has iniciado sesión con " + arrayUsuarios[i].nombre + " "
							+ arrayUsuarios[i].apellidos + "!");
					salir = true;
					indice = i;
				}
			}
		}

		if (salir == false) {
			indice = -1;
		}
		return indice; //Devuelve el valor índice del array para luego poder operar en otras funciones con este número
	}

	public void DatosUsuario() {

		System.out.println("Tus Datos: \n-Nombre: " + this.nombre + " " + this.apellidos + "\n-Email: " + this.email
				+ "\n-DNI: " + this.DNI + "\n-Edad: " + this.edad);
	}

	/*Esta función modifica los atributos de la clase Usuario y 
	del registro ArrayUsuarios con el que se esta operando*/
	public void CambiarDatos() {

		Scanner scOpcionCambiarDatos = new Scanner(System.in);
		Scanner scCambiarDatos = new Scanner(System.in);
	
		/* Recorre el array, si el valor no es nulo y los atributos email y contraseña
		introducidos son iguales a los de algún registro del array, cambia el atributo deseado*/
		for (int i = 0; i < arrayUsuarios.length - 1; i++) {
			if (arrayUsuarios[i] != null) {
				if (arrayUsuarios[i].email.equals(this.email) && arrayUsuarios[i].contraseña.equals(this.contraseña)) {

					System.out.print(
							"¿Qué dato desea cambiar?: \n(1)-Nombre y apellido \n(2)-Email \n(3)-Contraseña \n(4)-DNI \n(5)-Edad \nElija una opción: ");
					int opcioCambiarDatos = scOpcionCambiarDatos.nextInt();

					switch (opcioCambiarDatos) {

					case 1: {
						System.out.print("\nIntroduzca su nuevo nombre: ");
						this.nombre = scCambiarDatos.nextLine();
						arrayUsuarios[i].nombre = this.nombre;

						System.out.print("Introduzca sus nuevos apellidos: ");
						this.apellidos = scCambiarDatos.nextLine();
						arrayUsuarios[i].apellidos = this.apellidos;
						System.out.println("Nombre y apellidos cambiados...");
						break;
					}

					case 2: {
						System.out.print("\nIntroduzca su nuevo email: ");
						this.email = scCambiarDatos.nextLine();
						arrayUsuarios[i].email = this.email;
						System.out.println("Email cambiado...");
						break;
					}

					case 3: { //En caso de la contraseña, primero pide confirmar la contraseña antigua

						boolean salir = false;
						while (salir == false) {

							String contraseña;
							System.out.print("\nIntroduce su antigua contraseña: ");
							contraseña = scCambiarDatos.nextLine();

							if (contraseña.contentEquals(this.contraseña)) {
								System.out.print("Introduzca su nueva contraseña: ");
								this.contraseña = scCambiarDatos.nextLine();
								arrayUsuarios[i].contraseña = this.contraseña;
								System.out.println("\nContraseña cambiada...");
								salir = true;
							}

							else {
								System.err.println("CONTRASEÑA INCORRECTA");
							}
						}
						break;
					}

					case 4: {
						System.out.print("\nIntroduzca su nuevo DNI: ");
						this.DNI = scCambiarDatos.nextLine();
						arrayUsuarios[i].DNI = this.DNI;
						System.out.println("Cambiando DNI...");
						break;
					}

					case 5: {
						System.out.print("\nIntroduzca su nuevo edad: ");
						this.edad = scCambiarDatos.nextInt();
						arrayUsuarios[i].edad = this.edad;
						System.out.println("Cambiando edad...");
						break;
					}

					}
				}
			}
		}
	}

	/*Este método copia arrayUsuarios en un array nuevo, pero ignorando el registro que se quiere eliminar.
	 */
	public DatosUsuario[] eliminarObjetoArray(DatosUsuario[] arrayUsuarios, int i) {

		DatosUsuario[] nuevoArray = new DatosUsuario[arrayUsuarios.length];

		if (i > 0) {
			System.arraycopy(arrayUsuarios, 0, nuevoArray, 0, i); //Aqui se copia la primera parte de arrayUsuarios hasta el elemento seleccionado
		}
		
		/*Aqui se copia el resto de arrayUsuarios empezando por el registro después de l seleccionado, de esta 
		 * forma no se copia el elemento que queremos eliminar*/
		if (nuevoArray.length > i) {
			System.arraycopy(arrayUsuarios, i + 1, nuevoArray, i, nuevoArray.length - i - 1); 			
		}

		return nuevoArray;
	}

	/*Este método elimina el valor de los atributos de la clase Usuario y hace uso del método anterior para eliminar el registro actual del array*/
	public boolean EliminarUsuario() {

		DatosUsuario[] arrayResultante = new DatosUsuario[20];

		for (int i = 0; i < arrayUsuarios.length - 1; i++) {
			if (arrayUsuarios[i] != null) {
				if (arrayUsuarios[i].email.equals(this.email) && arrayUsuarios[i].contraseña.equals(this.contraseña)) {
					arrayResultante = eliminarObjetoArray(arrayUsuarios, i);
				}
			}
		}
		arrayUsuarios = arrayResultante;

		this.email = null;
		this.contraseña = null;
		this.nombre = null;
		this.apellidos = null;
		this.DNI = null;
		this.edad = 0;
		System.err.println("Usuario eliminado... \nCerrando sesión...\n");
		return true;
	}

	/*Este método toma los registro de arrayUsuarios y escribe los valores de cada registro en un archivo de texto*/
	public void InsertarDatos(int indice) {

		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter("C:\\Users\\borja\\Desktop\\SesionesRegistradas.txt"));

			for (int i = 0; i <= indice; i++) {
				out.write("EMAIL:" + arrayUsuarios[i].getEmail() + " CONSTRASEÑA:" + arrayUsuarios[i].getContraseña()
						+ " NOMBRE:" + arrayUsuarios[i].getNombre() + " APELLIDOS:" + arrayUsuarios[i].getApellido()
						+ " DNI:" + arrayUsuarios[i].getDNI() + " EDAD:" + arrayUsuarios[i].getEdad() + "\n");
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());

		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException ex) {
					System.out.println(ex);
				}
			}
		}
	}

}
