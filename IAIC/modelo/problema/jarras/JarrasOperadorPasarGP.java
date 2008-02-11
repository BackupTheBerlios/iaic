package modelo.problema.jarras;


public class JarrasOperadorPasarGP extends JarrasOperador {

	public JarrasOperadorPasarGP(JarrasEstado inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		JarrasEstado	j	=	(JarrasEstado)getInicial();
		int auxMayor = j.getMayor();
		int auxMenor = j.getMenor();
		int	newMayor	=	Math.max(auxMayor+auxMenor-3,0);
		int newMenor	=	Math.min(auxMayor+auxMenor,3);
		EstadoFinal	=	new	JarrasEstado(newMayor,newMenor);
	}

	public String getNombre() {
		return "Pasamos Jarra mayor --> Jarra Menor.\n";
	}
}
