package logico.banco.popular;

public class FondoInversion extends Cuenta{
	private float interesFijo;
	
	public FondoInversion(Cliente client, float montoTotal, String codigo, float interesFijo) {
		super(client, montoTotal, codigo);
		this.interesFijo=interesFijo;
		// TODO Auto-generated constructor stub
	}

	public float getInteresFijo() {
		return interesFijo;
	}

	@Override
	public float getInteres() {
		// TODO Auto-generated method stub
		return interesFijo*super.mesesAbierta()*super.getMontoTotal();
	}
	
}
