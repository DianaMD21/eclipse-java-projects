package logico.centro;
public abstract class Producto {
	protected String codigo;
	protected String nombre;
	protected float precioCompra;
	protected int cantiExistente;
	
	public Producto(String codigo, String nombre, float precioCompra, int cantiExistente) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.cantiExistente = cantiExistente;
	}
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public int getCantiExistente() {
		return cantiExistente;
	}

	public void setCantiExistente(int cantiExistente) {
		this.cantiExistente = cantiExistente;
	}
	public abstract float getIndice();
	
	public float calcularPrecioVenta(int dias) {
		float precio=0;
		precio=precioCompra*((int)dias/2)+getIndice();
		return precio;
	}
}
