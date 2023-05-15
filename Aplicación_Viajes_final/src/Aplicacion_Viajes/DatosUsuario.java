package Aplicacion_Viajes;
public class DatosUsuario {

	protected String email;
    protected String contraseña;
    protected String nombre;
    protected String apellidos;
    protected String DNI;
    protected int edad;
	
	public DatosUsuario() {
		
	}
	
	public DatosUsuario(String email, String contraseña, String nombre, String apellidos, String DNI, int edad) {
    	this.email = email;
    	this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.edad = edad;
    }
	
    public String getNombre() {
        return this.nombre;
    }
    
    public String getApellido() {
        return this.apellidos;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getContraseña() {
        return this.contraseña;
    }
    
    public String getDNI() {
        return this.DNI;
    }
    
    public int getEdad() {
        return this.edad;
    }

}