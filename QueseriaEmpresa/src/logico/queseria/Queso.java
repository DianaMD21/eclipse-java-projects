package logico.queseria;

public abstract class Queso {
	
	protected float precioBase;
	protected float precioUnitario;
	protected Long idCod;
	
	public Queso(float precioBase, float precioUnitario) {
		super();
		this.precioBase = precioBase;
		this.precioUnitario = precioUnitario;
		
	}
	public Queso() {
		super();
		
	}
	
	public float getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}
	public Long getIdCod() {
		return idCod;
	}
	public void setIdCod(Long idCod) {
		this.idCod = idCod;
	}
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public abstract float getVolumen();
	public float calcularPrecio() {
		return precioBase+precioUnitario*getVolumen();
	}
	
}
