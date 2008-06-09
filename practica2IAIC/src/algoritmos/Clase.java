package algoritmos;

public class Clase {
	int claseID; //TODO: falta por hacer getters y setters e
				//inicializarlo al principio
	Float[] centro;
	Float[][] muestras;
	int numMuestras = 0;
	
	public Clase(int muestras,int atributos) {
		this.centro = new Float[atributos];
		this.muestras = new Float[muestras][atributos];
	}
	
	public Clase(Float[] centro, Float[][] muestras) {
		super();
		this.centro = centro;
		this.muestras = muestras;
	}
	
	public Float[] getCentro() {
		return centro;
	}
	public void setCentro(Float[] centro) {
		this.centro = centro;
	}
	public Float[][] getMuestras() {
		return muestras;
	}
	public void setMuestras(Float[][] muestras) {
		this.muestras = muestras;
	}
	
	public void addMuestra(Float[] muestraNueva){
		this.muestras[numMuestras] = muestraNueva;
		this.numMuestras = this.numMuestras + 1;
	}

	public int getNumMuestras() {
		return numMuestras;
	}

	public void setNumMuestras(int numMuestras) {
		this.numMuestras = numMuestras;
	}

}
