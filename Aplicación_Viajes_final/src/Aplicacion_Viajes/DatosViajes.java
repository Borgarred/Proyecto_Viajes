package Aplicacion_Viajes;

import java.util.Date;

public class DatosViajes {
	
	protected Usuario usuario;
	protected String localidad;
	protected String comunidad;
	protected String FechaVuelta;
	protected String FechaIda;
	protected Date hora;

	public DatosViajes() {
		
	}
	
	public DatosViajes(Usuario usuario2, String comunidad, String localidad, String FechaIda, String FechaVuelta, Date hora) {
		this.usuario = usuario2;
		this.comunidad = comunidad;
		this.localidad = localidad;
		this.FechaIda = FechaIda;
		this.FechaVuelta = FechaVuelta;
		this.hora = hora;
		
	}
	
	

	

}