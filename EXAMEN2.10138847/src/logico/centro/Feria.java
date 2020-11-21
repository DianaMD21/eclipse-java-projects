package logico.centro;

public class Feria {
	private Producto product;
	private float precioVenta;
	private int cantDias;
	
	public Feria(Producto product,  int cantDias) {
		super();
		this.product = product;
		this.precioVenta = calcularPrecioVenta();
		this.cantDias = cantDias;
	}
	public Producto getProduct() {
		return product;
	}
	public void setProduct(Producto product) {
		this.product = product;
	}
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	public int getCantDias() {
		return cantDias;
	}
	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}
	public float calcularPrecioVenta() {
		//System.out.println("dias"+cantDias+ " precio "+product.getPrecioCompra()+" hey " +product.getIndice());
		float total= (cantDias/2)*product.getPrecioCompra()+product.getIndice();
		//System.out.println("TOTAL "+total );
		return total;
	}
}
