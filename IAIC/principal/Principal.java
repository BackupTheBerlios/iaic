package principal;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import controlador.Controlador;
import modelo.FachadaModelo;
import vista.VistaPrincipal;

public class Principal {
	
	public static void main(String[] args) {
		VistaPrincipal	vista	=	new	VistaPrincipal();
		FachadaModelo	modelo	=	new	FachadaModelo();
		Controlador		control	=	new	Controlador();
		
		control.setModelo(modelo);
		control.setVista(vista);
		modelo.setOyente(control);
		vista.setModelo(control);

		vista.setVisible(true);
		vista.setEnabled(true);

	}

}
