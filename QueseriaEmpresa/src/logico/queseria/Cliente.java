package logico.queseria;

public class Cliente {
	private String cedula;
	private String nombre;
	private String numero;
	private String direccion;
	
	public Cliente(String cedula, String nombre, String numero, String direccion) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.numero = numero;
		this.direccion = direccion;
	}
	public Cliente() {
		super();
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
