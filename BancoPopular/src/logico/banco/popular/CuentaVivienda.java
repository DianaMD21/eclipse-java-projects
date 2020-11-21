package logico.banco.popular;

public class CuentaVivienda extends Cuenta{
	private int tiempo;
	private float montoMensual;
	
	public CuentaVivienda(Cliente client, float montoTotal, String codigo, int tiempo, int montoMensual) {
		super(client, montoTotal, codigo);
		this.setTiempo(tiempo);
		this.montoMensual=montoMensual;
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getInteres() {
		// TODO Auto-generated method stub
		return (float) (0.03*montoMensual*super.mesesAbierta());
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public float getMontoMensual() {
		return montoMensual;
	}

	public void setMontoMensual(float montoMensual) {
		this.montoMensual = montoMensual;
	}

}
