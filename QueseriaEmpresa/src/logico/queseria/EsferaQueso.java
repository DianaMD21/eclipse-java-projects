package logico.queseria;

public class EsferaQueso extends Queso{
	private float radioE;
	public EsferaQueso(float precioBase, float precioUnitario, float radioE,Long id) {
		super(precioBase, precioUnitario);
		this.radioE=radioE;
		// TODO Auto-generated constructor stub
	}
	public EsferaQueso() {
		super();
	}
	public float getRadioE() {
		return radioE;
	}

	public void setRadioE(float radioE) {
		this.radioE = radioE;
	}

	@Override
	public float getVolumen() {
		// TODO Auto-generated method stub
		float volumen=0;
		volumen=(float)((4/3)*Math.PI * Math.pow(radioE, 3));
		return volumen;
	}

}
