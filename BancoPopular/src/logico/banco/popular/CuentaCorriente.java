package logico.banco.popular;

public class CuentaCorriente extends Cuenta{
	private float cantMax;

	public CuentaCorriente(Cliente client, float montoTotal, String codigo, float cantMax) {
		super(client, montoTotal, codigo);
		this.cantMax=cantMax;
		// TODO Auto-generated constructor stub
	}

	public float getCantMax() {
		return cantMax;
	}

	public void setCantMax(float cantMax) {
		this.cantMax = cantMax;
	}

	@Override
	public float getInteres() {
		// TODO Auto-generated method stub
		return (float) (0.01*cantMax* super.mesesAbierta());
	}
	
}
