package logico.centro;
import java.util.ArrayList;
import java.util.List;

public class Centro {
	private List<Producto> misProductos;
	private List<Feria> feriaProductos;
	
	public Centro() {
		super();
		this.misProductos = new ArrayList<>();
		this.feriaProductos = new ArrayList<>();
	}

	public List<Producto> getMisProductos() {
		return misProductos;
	}

	public void setMisProductos(List<Producto> misProductos) {
		this.misProductos = misProductos;
	}

	public List<Feria> getFeriaProductos() {
		return feriaProductos;
	}

	public void setFeriaProductos(List<Feria> feriaProductos) {
		this.feriaProductos = feriaProductos;
	}
	
	public void addProducto(Producto producto) {
		this.misProductos.add(producto);
	}
	public void addProductoFeria(Feria feria) {		//agrega un producto a la lista de la feria, con su precio de venta
		this.feriaProductos.add(feria);
	}

	public int productoExiste(String codigo) {	//devuelve el indice donde se encuentra un producto, si existe
		for(int a=0;a<misProductos.size();a++) {
			if(misProductos.get(a).getCodigo().equalsIgnoreCase(codigo))
				return a;
		}
		return -1;
	}
	
	public List<String> getProductosMayorVenta(){	//lista de nombres con productos que generan mayor venta
		List<String> nombresProductos=new ArrayList<>();
		float mayor =getMayorVenta();
		for(int a=0;a<feriaProductos.size();a++) {
			
			if(feriaProductos.get(a).getPrecioVenta()-feriaProductos.get(a).getProduct().getPrecioCompra()==mayor) {
				nombresProductos.add(feriaProductos.get(a).getProduct().getNombre());
			}
		}
		return nombresProductos;
	}

	public float getMayorVenta() {		//devuelve la mayor venta de la feria
		float mayor=0,precioCompra=0;
		for(int a=0;a<feriaProductos.size();a++) {
			precioCompra=feriaProductos.get(a).getProduct().getPrecioCompra();
			if(feriaProductos.get(a).calcularPrecioVenta()-precioCompra>=mayor) {
				mayor=feriaProductos.get(a).calcularPrecioVenta()-precioCompra;
			}
		}
		return mayor;
	}

	public int cantProductosEscasos() {			//cantidad de productos Escasos
		int cant=0;
		for(int a=0;a<misProductos.size();a++) {
			if(misProductos.get(a) instanceof ProductoEscaso)
				cant+=misProductos.get(a).getCantiExistente();
		}
		return cant;
	}
	public float dineroGanadoFeria() {		//dinero total ganado en la feria
		float dineroGanado=0;
		for(int a=0;a<feriaProductos.size();a++) {
			dineroGanado+=feriaProductos.get(a).calcularPrecioVenta();
		}
		return dineroGanado;
	}
	
}
