package Aplicacion_Viajes;

//Esta clase se usa para rellenar el array
public class DatosUsuario {
	// Atributos de DatosUsuario
	protected String email;
	protected String contraseña;
	protected String nombre;
	protected String apellidos;
	protected String DNI;
	protected int edad;

	public DatosUsuario() {// Constructor de la clase sin atributos

	}

	// Constructor de la clase con atributos
	public DatosUsuario(String email, String contraseña, String nombre, String apellidos, String DNI, int edad) {
		this.email = email;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = DNI;
		this.edad = edad;
	}

	public String getNombre() {// Funcion para obtener el nombre
		return this.nombre;// Devolver el nombre
	}

	public String getApellido() {// Funcion para obtener el apellido
		return this.apellidos;// Devolver el apellido
	}

	public String getEmail() {// Funcion para obtener el email
		return this.email;// Devolver el email
	}

	public String getContraseña() {// Funcion para obtener el contraseña
		return this.contraseña;// Devolver el contraseña
	}

	public String getDNI() {// Funcion para obtener el DNI
		return this.DNI;// Devolver el DNI
	}

	public int getEdad() {// Funcion para obtener el edad
		return this.edad;// Devolver el edad
	}
}
