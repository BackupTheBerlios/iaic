package modelo.problema.jarras;


public class JarrasOperadorVaciarGrande extends JarrasOperador {

	public JarrasOperadorVaciarGrande(JarrasEstado inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		JarrasEstado	j	=	(JarrasEstado)getInicial();
		EstadoFinal	=	new	JarrasEstado(0,j.getMenor());
	}

	public String getNombre() {
		return "Vaciar la jarra mayor\n";
	}

}
