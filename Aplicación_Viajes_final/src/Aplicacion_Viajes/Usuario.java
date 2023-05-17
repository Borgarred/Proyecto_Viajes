package Aplicacion_Viajes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Usuario {

	DatosUsuario arrayUsuarios[] = new DatosUsuario[20];

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

	public void NuevoUsuario() {

		Scanner scNuevoUsuario = new Scanner(System.in);

		int indice = 0;

		// Indice del último registro existente
		for (int i = 19; i >= 0; i--) {
			if (this.arrayUsuarios[i] == null) {
				indice = i;
			}
		}

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

		this.arrayUsuarios[indice] = new DatosUsuario(email, contraseña, nombre, apellidos, DNI, edad);
		InsertarDatos(indice);
		numeroUsuarios = numeroUsuarios + 1;
	}

	public void ListaUsuarios() {

		int i = 0;

		System.out.println("--------Lista de usuarios:--------");
		while (i < numeroUsuarios) {
			System.out.println(i + 1 + "º. " + arrayUsuarios[i].nombre + " " + arrayUsuarios[i].apellidos);
			i = i + 1;
		}
	}

	public int IniciarSesion() {

		Scanner scInicioUsuario = new Scanner(System.in);

		int indice = 0;

		System.out.print("Introduzca su email: ");
		String email = scInicioUsuario.nextLine();

		System.out.print("Introduzca sus contraseña: ");
		String contraseña = scInicioUsuario.nextLine();

		boolean salir = false;

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
		return indice;
	}

	public void DatosUsuario() {

		System.out.println("Tus Datos: \n-Nombre: " + this.nombre + " " + this.apellidos + "\n-Email: " + this.email
				+ "\n-DNI: " + this.DNI + "\n-Edad: " + this.edad);
	}

	public void CambiarDatos() {

		Scanner scOpcionCambiarDatos = new Scanner(System.in);
		Scanner scCambiarDatos = new Scanner(System.in);

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

					case 3: {

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

	public DatosUsuario[] eliminarObjetoArray(DatosUsuario[] arrayUsuarios, int i) {

		DatosUsuario[] nuevoArray = new DatosUsuario[arrayUsuarios.length];

		if (i > 0) {
			System.arraycopy(arrayUsuarios, 0, nuevoArray, 0, i);
		}

		if (nuevoArray.length > i) {
			System.arraycopy(arrayUsuarios, i + 1, nuevoArray, i, nuevoArray.length - i - 1);
		}

		return nuevoArray;
	}

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
