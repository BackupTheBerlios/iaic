package modelo.problema.mono;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import java.util.LinkedList;
import java.util.List;

import modelo.problema.Estado;
import modelo.problema.Operador;

public class EstadoMono implements Estado {
	
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
	
	
	
	public EstadoMono(int posHor, int posVer, int posCaja, int platano) {
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
		
		if (((posHor == 0)||(posHor == 1)) && 
				(posVer == 0))
			lista.add(new OperadorAndaPuertaCentro(this));
		
		if (((posHor == 1)||(posHor == 2)) && 
				(posVer == 0))
			lista.add(new OperadorAndaCentroVentana(this));
		
		if (((posHor == 0)||(posHor == 1)) &&
				(posCaja == posHor) &&
				(posVer == 0))
			lista.add(new OperadorEmpujarPuertaCentro(this));
		
		if (((posHor == 1)||(posHor == 2)) &&
				(posCaja == posHor) &&
				(posVer == 0))
			lista.add(new OperadorEmpujarCentroVentana(this));
		
		if ((posHor == posCaja) && (posHor == 1))
			lista.add(new OperadorSubir(this));
		
		if ((posVer == 1)&&(posCaja == 1))
			lista.add(new OperadorCogerPlatano(this));
		return lista;
	}
	

	public int getHeuristica() {
		return 0;
	}
	
	public boolean equals(Object e) {
		EstadoMono m = (EstadoMono) e;
		return (this.platano == m.platano)&&(this.posCaja == m.posCaja)&&(this.posHor == m.posHor)&&(this.posVer == m.posVer);
	}
	
}
