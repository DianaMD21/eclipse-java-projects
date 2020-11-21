package logico.centro;
public class ProductoAltaGama extends Producto{
	private int calificador;
	
	public ProductoAltaGama(String codigo, String nombre, float precioCompra, int cantiExistente, int calificador) {
		super(codigo, nombre, precioCompra, cantiExistente);
		this.calificador=calificador;
	}
	public int getCalificador() {
		return calificador;
	}
	public void setCalificador(int calificador) {
		this.calificador = calificador;
	}
	
	public float getIndice() {
		return calificador*60;
	}
	
}
