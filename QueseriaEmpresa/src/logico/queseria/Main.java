package logico.queseria;

import java.util.Date;
import java.util.List;

public class Main {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queseria fabrica=new Queseria();
		Cliente client1=new Cliente("000000", "Diana Monegro", "8297664032", "Gurabo");
		Cliente client2=new Cliente("111111", "Juan Perez", "8096124033", "Gurabo");
		
		Queso quesoEsferico1=new EsferaQueso(100,50,5);
		Queso quesoEsferico2=new EsferaQueso(120,45,3);
		Queso quesoCilindro1=new CilindroQueso(150,100,6,10);
		Queso quesoCilHueco1=new QuesoCilindroHueco(70,50,5,7,8);
		
		Date fecha= new Date();
		Factura factura1=new Factura(client1,"hola1",fecha);
		
		factura1.addQueso(quesoCilHueco1);
		factura1.addQueso(quesoCilindro1);
		factura1.addQueso(quesoEsferico2);
		factura1.addQueso(quesoEsferico1);
		
		fabrica.addCliente(client1);
		fabrica.addCliente(client2);
		fabrica.addQueso(quesoCilHueco1);
		fabrica.addQueso(quesoCilindro1);
		fabrica.addQueso(quesoEsferico2);
		fabrica.addQueso(quesoEsferico1);
		fabrica.addFactura(factura1);
		
		float esfe= fabrica.quesoEsferaMayor("hola1"); //precio del queso esfera de mayor volumen
		
		System.out.println("ESFERA 1: "+quesoEsferico1.getVolumen());
		System.out.println("ESFERA 2: "+quesoEsferico2.getVolumen());
		
		System.out.println(esfe+" RESULTAD");
		
		int[] array= fabrica.cantQuesosTipo(); //array con la cant de quesos de c/tipo
		System.out.println("Cantidad Esferico: " + array[0]);
		System.out.println("Cantidad Cilindrico: " + array[1]);
		System.out.println("Cantidad Cilindrico Hueco: " + array[2]);
		
		List<EsferaQueso> esferaList=fabrica.quesosEsferaTotal(); //lista todos quesos Esfera
		List<CilindroQueso> cilindroList=fabrica.quesosCilindroTotal(); //lista todos quesos Cilindro
		List<QuesoCilindroHueco> cilindroHuecoList=fabrica.quesosCilindroHuecoTotal(); //Lista quesos Huecos
		
		System.out.println("Esferico: " + esferaList.size()); //size de c/u
		System.out.println("Cilindrico: " + cilindroList.size());
		System.out.println("Cilindrico Hueco: " + cilindroHuecoList.size());
		
		//calcular precio total de la factura
		System.out.println("Precio total de la factura: "+fabrica.precioTotalFactura(factura1.getCodigo()));
	}*/

}
