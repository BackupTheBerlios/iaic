package modelo.problema.jarras;


public class JarrasOperadorPasarPG extends JarrasOperador {

	public JarrasOperadorPasarPG(JarrasEstado inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		JarrasEstado	j	=	(JarrasEstado)getInicial();
		int auxMayor = j.getMayor();
		int auxMenor = j.getMenor();
		int	newMenor	=	Math.max(auxMayor+auxMenor-5,0);
		int newMayor	=	Math.min(auxMayor+auxMenor,5);
		EstadoFinal	=	new	JarrasEstado(newMayor,newMenor);
	}

	public String getNombre() {
		return "Pasamos Jarra menor --> Jarra mayor.\n";
	}

}
