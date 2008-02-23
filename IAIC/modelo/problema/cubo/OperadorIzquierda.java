package modelo.problema.cubo;
import modelo.problema.cubo.EstadoCubo;

public class OperadorIzquierda extends OperadorCubo {
	public OperadorIzquierda(EstadoCubo inicial) {
		super(inicial);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Cruzamos la puerta de atras";
	}

	@Override
	protected void transitar() {
		EstadoCubo c = (EstadoCubo)getInicial();//Aqui estoy
		int num = c.getNumHabitacion();
		EstadoFinal =  new EstadoCubo(num+10,c.abrirPuerta(num+1000));

	}
}
