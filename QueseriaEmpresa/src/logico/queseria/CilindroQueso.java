package logico.queseria;

public class CilindroQueso extends Queso{
	protected float radioC;
	protected float longitud;
	
	public CilindroQueso(float precioBase, float precioUnitario,float radioC, float longitud, Long id) {
		super(precioBase, precioUnitario);
		this.radioC=radioC;
		this.longitud=longitud;
		// TODO Auto-generated constructor stub
	}
	
	public CilindroQueso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public float getRadioC() {
		return radioC;
	}

	public void setRadioC(float radioC) {
		this.radioC = radioC;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	
	public float areaBase() {
		float area=0;
		area= (float)(Math.PI*Math.pow(radioC, 2));
		return area;
	}

	@Override
	public float getVolumen() {
		// TODO Auto-generated method stub
		return longitud *areaBase();
	}

}
