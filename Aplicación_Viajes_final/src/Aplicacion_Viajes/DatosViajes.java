package Aplicacion_Viajes;

import java.util.Date;
//Esta clase se usa para guardar los viajes en el array
public class DatosViajes {
	//Atributos DatosViajes
	protected Usuario usuario;
	protected String localidad;
	protected String comunidad;
	protected String FechaVuelta;
	protected String FechaIda;
	protected Date hora;

	public DatosViajes() {//Constructor de la clase sin atributos
		
	}
	//Constructor de la clase con atributos
	public DatosViajes(Usuario usuario2, String comunidad, String localidad, String FechaIda, String FechaVuelta, Date hora) {
		this.usuario = usuario2;
		this.comunidad = comunidad;
		this.localidad = localidad;
		this.FechaIda = FechaIda;
		this.FechaVuelta = FechaVuelta;
		this.hora = hora;
		
	}
	
	

	

}
