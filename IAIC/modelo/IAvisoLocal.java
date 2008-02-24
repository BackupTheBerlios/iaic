package modelo;

public interface IAvisoLocal {

	public abstract void iniciarEjecucionLocal(int codigoProblema,boolean resoluble);
	public abstract boolean getFinEjecucionLocal(); 

}