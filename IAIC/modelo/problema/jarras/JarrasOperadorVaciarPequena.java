package modelo.problema.jarras;


public class JarrasOperadorVaciarPequena extends JarrasOperador {

	public JarrasOperadorVaciarPequena(JarrasEstado inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		JarrasEstado	j	=	(JarrasEstado)getInicial();
		EstadoFinal	=	new	JarrasEstado(j.getMayor(),0);	
	}

	public String getNombre() {
		return "Vaciar la jarra pequeña\n";
	}

}
