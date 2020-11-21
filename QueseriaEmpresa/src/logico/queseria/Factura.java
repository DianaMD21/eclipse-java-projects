package logico.queseria;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Factura {
	private Cliente cliente;
	private List <Queso> myQuesos;
	private String codigo;
	private Calendar fecha=new GregorianCalendar();
	
	public Factura(Cliente cliente, Calendar fecha) {
		super();
		this.cliente = cliente;
		this.myQuesos = new ArrayList<>();
		this.fecha = fecha;
	}
	public Factura() {
		super();
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Queso> getMyQuesos() {
		return myQuesos;
	}

	public void setMyQuesos(List<Queso> myQuesos) {
		this.myQuesos = myQuesos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public void addQueso(Queso queso) {
		this.myQuesos.add(queso);
	}
	public float calcularFactura() {
		float total=0;
		for(Queso queso: myQuesos) {
			total+=queso.calcularPrecio();
		}
		return total;
	}
	public EsferaQueso getEsfericoMayor() {
		float mayor=0;
		EsferaQueso aux = null;
		for(Queso q: myQuesos) {
			if(q instanceof EsferaQueso) {
				if(q.getVolumen()>mayor) {
					mayor=q.getVolumen();
					aux=(EsferaQueso) q;
				}
			}
		}
		return aux;
	}
	
}
