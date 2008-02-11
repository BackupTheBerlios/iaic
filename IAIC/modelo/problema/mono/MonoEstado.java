package modelo.problema.mono;

import java.util.LinkedList;
import java.util.List;

import modelo.problema.Estado;
import modelo.problema.Operador;

public class MonoEstado implements Estado {
	
	/**El estado va a ser una tupla de 4 enteros
	 * en la que posHor representa dónde está el mono.
	 * posVer representa dónde está el mono si encima
	 * de la caja antes de coger el plátano o en el suelo;
	 * posCaja representa la situación de la caja y platano
	 * indica si el mono ha cogido o no el platano */
	
	private int posHor;     /* 0->puerta; 1->centro; 2->ventana */
	private int posVer;     /* 0-> suelo; 1-> caja */
	private int posCaja;    /* 0->puerta; 1->centro; 2->ventana */
	private int platano;    /* 0->no tiene platano; 1->tiene platano */
	
	
	
	public MonoEstado(int posHor, int posVer, int posCaja, int platano) {
		super();
		this.posHor = posHor;
		this.posVer = posVer;
		this.posCaja = posCaja;
		this.platano = platano;
	}
	
	public int getPlatano() {
		return platano;
	}
	
	public void setPlatano(int platano) {
		this.platano = platano;
	}
	
	public int getPosCaja() {
		return posCaja;
	}
	
	public void setPosCaja(int posCaja) {
		this.posCaja = posCaja;
	}
	
	public int getPosHor() {
		return posHor;
	}
	
	public void setPosHor(int posHor) {
		this.posHor = posHor;
	}
	
	public int getPosVer() {
		return posVer;
	}
	
	public void setPosVer(int posVer) {
		this.posVer = posVer;
	}
	
	public String mostrarInfo() {
		String h = "";
		String v = "";
		String c = "";
		String p = "";
		
		int a = this.getPosHor();
		int b = this.getPosVer();
		int e = this.getPosCaja();
		int d = this.getPlatano();
		
		switch(a){
		case 0: h = "PUERTA";
		break;
		case 1: h = "CENTRO";
		break;
		case 2: h = "VENTANA";
		break;
		}
		switch(b){
		case 0: v = "SUELO";
		break;
		case 1: v = "CAJA";
		break;
		}
		
		switch(e){
		case 0: c = "PUERTA";
		break;
		case 1: c = "CENTRO";
		break;
		case 2: c = "VENTANA";
		break;
		}
		switch(d){
		case 0: p = "NO";
		break;
		case 1: p = "SI";
		break;
		}
		
		return "El Mono está en "+h+" y en "+v+"\n"+"La Caja está en "+c+"\n Platano tiene : "+p+"\n";
	}
	
	public List<Operador> getOperadoresAplicables() {
		List<Operador>	lista	=	new	LinkedList<Operador>();
		
		if ((getPosHor() >= 0)&&(getPosHor()< 2) && (getPosVer() == 0)){
			lista.add(new MonoOperadorAndaPC(this));
		}
		
		if ((getPosHor() >= 1)&&(getPosHor() < 3) && (getPosVer() == 0)){
			lista.add(new MonoOperadorAndaCV(this));
		}
		
		if ((getPosHor() >= 0)&&(getPosHor() < 2)&&(getPosCaja() == getPosHor()) &&(getPosVer() == 0)){
			lista.add(new MonoOperadorEmpujarCajaPC(this));
		}
		
		if ((getPosHor() >= 1)&&(getPosHor() < 3)&&(getPosCaja() == getPosHor()) &&(getPosVer() == 0)){
			lista.add(new MonoOperadorEmpujarCajaCV(this));
		}
		
		if ((getPosHor() == getPosCaja())){
			lista.add(new MonoOperadorSubirCaja(this));
		}
		
		if ((getPosVer() == 1)&&(getPosCaja() == 1) ){
			lista.add(new MonoOperadorCogerPlatano(this));
		}
		return lista;
	}
	

	public int getHeuristica() {
		return 0;
	}
	
	public boolean equals(Object e) {
		MonoEstado m = (MonoEstado) e;
		return (this.platano == m.platano)&&(this.posCaja == m.posCaja)&&(this.posHor == m.posHor)&&(this.posVer == m.posVer);
	}
	
}
