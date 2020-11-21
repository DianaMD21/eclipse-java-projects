package logico.banco.popular;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private List<Cuenta> myCuentas;
	
	public Cliente(String cedula, String nombre, String apellido, String direccion, String telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.myCuentas=new ArrayList<>();
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Cuenta> getMyCuentas() {
		return myCuentas;
	}

	public void setMyCuentas(List<Cuenta> myCuentas) {
		this.myCuentas = myCuentas;
	}
	
	public void addCuenta(Cuenta cuenta) {
		this.myCuentas.add(cuenta);
	}
	
	public int buscarCuenta(String cod) {
		for(int a=0;a<myCuentas.size();a++)
		{
			if(myCuentas.get(a).getCodigo().equalsIgnoreCase(cod))
				return a;
		}
		return -1;
	}
	
}
