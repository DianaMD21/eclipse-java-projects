package logico.queseria;

public class QuesoCilindroHueco extends CilindroQueso{
	private float radioInterno;
	
	public QuesoCilindroHueco(float precioBase, float precioUnitario, float radioC, float longitud,float radioInterno,Long id) {
		super(precioBase, precioUnitario, radioC, longitud,id);
		this.radioInterno=radioInterno;
		// TODO Auto-generated constructor stub
	}
	public QuesoCilindroHueco() {
		super();
	}

	public float getRadioInterno() {
		return radioInterno;
	}

	public void setRadioInterno(float radioInterno) {
		this.radioInterno = radioInterno;
	}
	public float areaBase() {
		float area=0;
		area= (float)(Math.PI*Math.pow(radioC-radioInterno, 2));
		return area;
	}
	
}
