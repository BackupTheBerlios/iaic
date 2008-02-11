package modelo.problema.jarras;


public class JarrasOperadorLlenaGrande extends JarrasOperador {

	protected void calculaFinal() {
		JarrasEstado	j	=	(JarrasEstado)getInicial();
		EstadoFinal	=	new	JarrasEstado(5,j.getMenor());	
	}

	public String getNombre() {
		return "Llenar la jarra grande\n";
	}

	/**
	 * @param inicial
	 */
	public JarrasOperadorLlenaGrande(JarrasEstado inicial) {
		super(inicial);
	}

}
