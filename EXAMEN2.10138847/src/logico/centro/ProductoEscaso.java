package logico.centro;
public class ProductoEscaso extends Producto{
	private int porciento;
	
	public ProductoEscaso(String codigo, String nombre, float precioCompra, int cantiExistente, int porciento) {
		super(codigo, nombre, precioCompra, cantiExistente);
		this.setPorciento(porciento);
	}
	public int getPorciento() {
		return porciento;
	}
	public void setPorciento(int porciento) {
		this.porciento = porciento;
	}
	
	public float getIndice() {
		return (porciento/100)*this.getPrecioCompra();
	}
	
}
