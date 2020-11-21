package logico.centro;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Centro centro=new Centro();
		
		Producto producto1=new ProductoAltaGama(String.valueOf(centro.getMisProductos().size()),"Pizza",(float) 150.25,5,6);
		centro.addProducto(producto1);
		
		Producto producto2=new ProductoAltaGama(String.valueOf(centro.getMisProductos().size()),"Pan",(float) 70.25,5,2);
		centro.addProducto(producto2);
		
		Producto producto3=new ProductoEscaso(String.valueOf(centro.getMisProductos().size()),"Hamburguesa",(float) 200.25,5,5);
		centro.addProducto(producto3);
		
		Producto producto4=new ProductoEscaso(String.valueOf(centro.getMisProductos().size()),"Chocolate",(float) 30.25,5,6);
		centro.addProducto(producto4);
		
		System.out.println("Precio de compra producto 1: "+producto1.getPrecioCompra());
		System.out.println("Precio de compra producto 2: "+producto2.getPrecioCompra());
		System.out.println("Precio de compra producto 3: "+producto3.getPrecioCompra());
		System.out.println("Precio de compra producto 4: "+producto4.getPrecioCompra());
		
		Feria feria1=new Feria(producto1,3);
		Feria feria2=new Feria(producto2,5);
		Feria feria3=new Feria(producto3,10);
		Feria feria4=new Feria(producto4,2);
		
		centro.addProductoFeria(feria1);
		centro.addProductoFeria(feria2);
		centro.addProductoFeria(feria3);
		centro.addProductoFeria(feria4);
		
		for(int a=0;a<centro.getFeriaProductos().size();a++) {
			System.out.println("Precio de venta en la feria del producto No. "+a+": "+centro.getFeriaProductos().get(a).getPrecioVenta());
		}
		
		System.out.println("Venta total de la feria: "+centro.dineroGanadoFeria());
		
		List<String>nombreMayorVenta=centro.getProductosMayorVenta();
		
		System.out.println("Ventaa: "+centro.getMayorVenta());
		
		for(int a=0;a<nombreMayorVenta.size();a++) {
			System.out.println("Nombre/s mayor venta en la feria: "+nombreMayorVenta.get(a)+" con un total de "+centro.getMayorVenta());
		}
		
	}

}
