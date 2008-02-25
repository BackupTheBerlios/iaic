package modelo;

/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */

import modelo.problema.cubo.EstadoCubo;
import modelo.problema.cubo.OperadorCubo;
import modelo.problema.cubo.Puerta;

public interface IAvisoLocal {

//	public abstract void iniciarEjecucionLocal(int codigoProblema,boolean resoluble);
//	public abstract void lanzarEjecucionLocal(int codigoProblema,boolean resoluble);
	public abstract void lanzarEjecucionLocal(Puerta puerta);
//	public abstract boolean getFinEjecucionLocal();
//	public abstract void ejecutarLocal(Puerta puerta, EstadoCubo estado, OperadorCubo op);
	

}