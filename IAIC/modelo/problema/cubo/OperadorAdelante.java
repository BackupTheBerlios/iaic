package modelo.problema.cubo;
import modelo.problema.cubo.EstadoCubo;

public class OperadorAdelante extends OperadorCubo  {
	public OperadorAdelante(EstadoCubo inicial) {
		super(inicial);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Cruzamos la puerta de adelante";
	}
	
	@Override
	protected void transitar() {
		EstadoCubo c = (EstadoCubo)getInicial();//Aqui estoy
		int num = c.getNumHabitacion();
		//EstadoFinal = new EstadoCubo(aux,c.getLO(),aux,c.getCO());
		EstadoFinal =  new EstadoCubo(c.getCubo(),num+1,c.abrirPuerta(num+2000));
	
	}
}
