package logico.banco.popular;

import java.util.ArrayList;
import java.util.List;

public class BancoPopular {
	List<Cliente> myClients;
	List<Cuenta>myCuentas;
	
	public BancoPopular() {
		super();
		this.myClients=new ArrayList<>();
		this.myCuentas=new ArrayList<>();
	}

	public List<Cliente> getMyClients() {
		return myClients;
	}

	public void setMyClients(List<Cliente> myClients) {
		this.myClients = myClients;
	}

	public List<Cuenta> getMyCuentas() {
		return myCuentas;
	}

	public void setMyCuentas(List<Cuenta> myCuentas) {
		this.myCuentas = myCuentas;
	}
	
	public void addCuenta(Cuenta cuenta) {
		this.myCuentas.add(cuenta);
	}
	
	public void addCliente(Cliente cliente) {
		this.myClients.add(cliente);
	}
	
	public boolean retirarDinero(String cedula, String cod, float cantidad) {
		int indexCliente=buscarCliente(cedula);
		if(indexCliente!=-1) {
			int indexCuenta=myClients.get(indexCliente).buscarCuenta(cod);
			if(indexCuenta!=-1) {
				float montoTotal=myClients.get(indexCliente).getMyCuentas().get(indexCuenta).getMontoTotal();
				
			}	
		}
		return false;
	}
	
	public boolean depositarDinero(String cedula, String cod, float cantidad) {
		int indexCliente=buscarCliente(cedula);
		if(indexCliente!=-1) {
			int indexCuenta=myClients.get(indexCliente).buscarCuenta(cod);
			if(indexCuenta!=-1) {
				float montoTotal=myClients.get(indexCliente).getMyCuentas().get(indexCuenta).getMontoTotal();
				myClients.get(indexCliente).getMyCuentas().get(indexCuenta).setMontoTotal(cantidad+montoTotal);
				updateBanco(cantidad+montoTotal,cod);
				return true;
			}	
		}
		return false;
	}

	private void updateBanco(float f, String cod) {
		// TODO Auto-generated method stub
		int index=buscarCuenta(cod);
		if(index!=-1) {
			myCuentas.get(index).setMontoTotal(f);
		}
	}

	private int buscarCuenta(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int buscarCliente(String cedula) {
		// TODO Auto-generated method stub
		return 0;
	}
}
