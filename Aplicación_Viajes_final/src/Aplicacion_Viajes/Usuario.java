package Aplicacion_Viajes;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Usuario {

	DatosUsuario arrayUsuarios[] = new DatosUsuario[20];

	Scanner sc = new Scanner(System.in);
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

		int indice = 0;

		// Indice del último registro existente
		for (int i = 19; i >= 0; i--) {
			if (this.arrayUsuarios[i] == null) {
				indice = i;
			}
		}

		System.out.print("Introduzca un email: ");
        String email = sc.nextLine();

        System.out.print("Inserte una contraseña: ");
        String contraseña = sc.nextLine();

        System.out.print("Introduzca su nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduzca sus apellidos: ");
        String apellidos = sc.nextLine();

        System.out.print("Introduzca su DNI: ");
        String DNI = sc.nextLine();

        System.out.print("Introduzca su edad: ");
        int edad = sc.nextInt();

        sc.nextLine();

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

		int indice = 0;

		System.out.print("Introduzca su email: ");
		String email = sc.nextLine();

		System.out.print("Introduzca sus contraseña: ");
		String contraseña = sc.nextLine();

		boolean salir = false;

		for (int i = 0; i < arrayUsuarios.length; i++) {
			if (arrayUsuarios[i] != null) {
				if (arrayUsuarios[i].email.equals(email) && arrayUsuarios[i].contraseña.equals(contraseña)) {
					this.email = email;
					this.contraseña = contraseña;
					System.out.println("¡Has iniciado sesión con " + arrayUsuarios[i].nombre + " " + arrayUsuarios[i].apellidos + "!");
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
	
	public void MenuUsuario() {
		System.out.println("--------Menú Usuario-------"
				+ "\n(1)-Datos Usuario \n(2)-Cambiar Datos Usuario \n(3)-Ver Historial Viajes \n(4)-Eliminar Usuario");
	}
	
	public void DatosUsuario() {
		
	}
	
	
	public void InsertarDatos(int indice) {

		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter("C:\\Users\\garramiola.rebor\\Desktop\\SesionesRegistradas.txt"));

			for (int i = 0; i <= indice; i++) {
				out.write("EMAIL:" + arrayUsuarios[i].getEmail() + " CONSTRASEÑA:" + arrayUsuarios[i].getContraseña() + " NOMBRE:" + arrayUsuarios[i].getNombre() + " APELLIDOS:" + arrayUsuarios[i].getApellido() 
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