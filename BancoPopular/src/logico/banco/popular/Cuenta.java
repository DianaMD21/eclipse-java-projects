package logico.banco.popular;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Cuenta {
	protected Cliente client;
	protected float montoTotal;
	protected String codigo;
	protected int mesesAper;
	protected String estado;
	protected int puntos;
	protected Calendar fechaCreacion;
	protected int comision;
	
	public Cuenta(Cliente client, float montoTotal, String codigo) {
		super();
		this.client = client;
		this.montoTotal = montoTotal;
		this.estado="Habilitada";
		this.codigo=codigo;
		this.puntos=getPuntosTotales();
		this.fechaCreacion=new GregorianCalendar();
		this.fechaCreacion.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
		this.mesesAper=mesesAbierta();
	}
	private int getPuntosTotales() {
		// TODO Auto-generated method stub
		int puntos=0;
		puntos = (int) montoTotal/10;
		return puntos;
	}

	public Cliente getClient() {
		return client;
	}

	public void setClient(Cliente client) {
		this.client = client;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
		this.puntos=getPuntosTotales();
	}

	public String getCodigo() {
		return codigo;
	}

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public int getComision() {
		this.comision=3*mesesAbierta();
		return comision;
	}
	public int getMesesAper() {
		this.mesesAper=mesesAbierta();
		return mesesAper;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getPuntos() {
		return puntos;
	}
	public int mesesAbierta() {
		Calendar fin=new GregorianCalendar();
		fin.setTime(new Date());
		int yearsInBetween = fin.get(Calendar.YEAR) - this.fechaCreacion.get(Calendar.YEAR); 
		int monthsDiff = fin.get(Calendar.MONTH) - this.fechaCreacion.get(Calendar.MONTH); 
		long ageInMonths = yearsInBetween*12 + monthsDiff; 
		return (int) ageInMonths;
	}

	public abstract float getInteres();

}
