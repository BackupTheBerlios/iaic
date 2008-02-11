package modelo.problema.jarras;


public class JarrasOperadorLlenarPequena extends JarrasOperador {

	public JarrasOperadorLlenarPequena(JarrasEstado inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		JarrasEstado	j	=	(JarrasEstado)getInicial();
		EstadoFinal	=	new	JarrasEstado(j.getMayor(),3);	
	}
	
	public String getNombre() {
		return "Llenar la jarra pequeña\n";
	}
	
}
