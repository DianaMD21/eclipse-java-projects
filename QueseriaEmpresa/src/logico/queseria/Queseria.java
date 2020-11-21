package logico.queseria;

import java.util.ArrayList;
import java.util.List;

public class Queseria {
	private List <Queso> myQuesos;
	private List <Cliente> myClients;
	private List<Factura> myFacturas;
	public Queseria() {
		super();
		this.myClients=new ArrayList<>();
		this.myFacturas=new ArrayList<>();
		this.myQuesos=new ArrayList<>();
	}
	public List<Queso> getMyQuesos() {
		return myQuesos;
	}
	public void setMyQuesos(List<Queso> myQuesos) {
		this.myQuesos = myQuesos;
	}
	public List<Cliente> getMyClients() {
		return myClients;
	}
	public void setMyClients(List<Cliente> myClients) {
		this.myClients = myClients;
	}
	public List<Factura> getMyFacturas() {
		return myFacturas;
	}
	public void setMyFacturas(List<Factura> myFacturas) {
		this.myFacturas = myFacturas;
	}
	public void addCliente(Cliente client) {
		this.myClients.add(client);
	}
	public void addFactura(Factura factura) {
		factura.setCodigo(String.valueOf(myFacturas.size()));
		this.myFacturas.add(factura);
	}
	public void addQueso(Queso queso) {
		queso.setIdCod((long) myQuesos.size());
		this.myQuesos.add(queso);
	}
	public int[] cantQuesosTipo() {
		int[] aux=new int [3];
		for(Queso q: myQuesos) {
			if(q instanceof EsferaQueso)
				aux[0]++;
			if (q instanceof CilindroQueso & !(q instanceof QuesoCilindroHueco))
				aux[1]++;
			if (q instanceof QuesoCilindroHueco)
				aux[2]++;
		}
		return aux;
	}
	public List<Queso> quesosEsferaTotal() {
		List<Queso> aux=new ArrayList<>();
		for(Queso q: myQuesos) {
			if(q instanceof EsferaQueso)
				aux.add((EsferaQueso) q);
		}
		return aux;
	}
	public List<Queso> quesosCilindroTotal() {
		List<Queso> aux=new ArrayList<>();
		for(Queso q: myQuesos) {
			if(q instanceof CilindroQueso &!(q instanceof QuesoCilindroHueco))
				aux.add((CilindroQueso) q);
		}
		return aux;
	}
	public List<Queso> quesosCilindroHuecoTotal() {
		List<Queso> aux=new ArrayList<>();
		for(Queso q: myQuesos) {
			if(q instanceof QuesoCilindroHueco)
				aux.add((QuesoCilindroHueco) q);
		}
		return aux;
	}
	public float quesoEsferaMayor(String codigo) {
		for(int a=0; a<myFacturas.size();a++) {
			if(myFacturas.get(a).getCodigo().equalsIgnoreCase(codigo))
				return myFacturas.get(a).getEsfericoMayor().calcularPrecio();
		}
		return -1;
	}
	public float precioTotalFactura(String cod) {
		for(int a=0; a<myFacturas.size();a++) {
			if(myFacturas.get(a).getCodigo().equalsIgnoreCase(cod))
				return myFacturas.get(a).calcularFactura();
		}
		return -1;
	}
	public int buscarCliente(String cedula) {
		for(int a=0;a<myClients.size();a++)
		{
			if(myClients.get(a).getCedula().equalsIgnoreCase(cedula))
				return a;
		}
		return -1;
	}
	public int buscarQueso(Long id) {
		int index=-1;
		for(int a=0;a<myQuesos.size();a++) {
			if(myQuesos.get(a).getIdCod()==id)
				return a;
		}
		return index;
		
	}
}
