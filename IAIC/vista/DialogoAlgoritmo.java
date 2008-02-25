package vista;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import java.awt.Frame;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


class DialogoAlgoritmo extends JDialog {

	private static final long serialVersionUID = 1L;
	private Object[]	listaOpciones;
	private	Object	elegido;
	private JPanel principalContentPane = null;
	private JRadioButton aleatorioRadioButton = null;
	private JRadioButton siempreRadioButton = null;
	private JRadioButton preguntarRadioButton = null;
	private ButtonGroup buttonGroup = null;   //  @jve:decl-index=0:visual-constraint=""
	private JButton okButton = null;
	private JComboBox algoritmosComboBox = null;

	/**	 * @param owner	 */
	public DialogoAlgoritmo(Frame owner, Object[] lista) {
		super(owner);
		this.listaOpciones = lista;
		initialize();
	}
	/**	 * This method initializes this
	 * @return void	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setTitle("Selección de algoritmos de búsqueda");
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setModal(true);
		this.setContentPane(getPrincipalContentPane());
	}
	/**
	 * This method initializes principalContentPane
	 * @return  javax.swing.JPanel
	 * @uml.property  name="principalContentPane"
	 */
	private JPanel getPrincipalContentPane() {
		if (principalContentPane == null) {
			principalContentPane = new JPanel();
			principalContentPane.setLayout(new BoxLayout(getPrincipalContentPane(), BoxLayout.Y_AXIS));
			principalContentPane.add(getAleatorioRadioButton(), null);
			principalContentPane.add(getSiempreRadioButton(), null);
			principalContentPane.add(getPreguntarRadioButton(), null);
			principalContentPane.add(getAlgoritmosComboBox(), null);
			principalContentPane.add(getOkButton(), null);
		}
		return principalContentPane;
	}
	/**
	 * This method initializes aleatorioRadioButton	 	
	 * @return  javax.swing.JRadioButton
	 * @uml.property  name="aleatorioRadioButton"
	 */
	private JRadioButton getAleatorioRadioButton() {
		if (aleatorioRadioButton == null) {
			aleatorioRadioButton = new JRadioButton();
			aleatorioRadioButton.setText("Aleatorio");
			aleatorioRadioButton.setHorizontalTextPosition(SwingConstants.TRAILING);
			aleatorioRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
			aleatorioRadioButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					okButton.setEnabled(true);
					escogeAleatorio();
					algoritmosComboBox.setVisible(false);
				}
			});
			getButtonGroup().add(aleatorioRadioButton);
		}
		return aleatorioRadioButton;
	}
	protected void escogeAleatorio() {
		int	size	=	listaOpciones.length;
		Random a = new	Random();
		int	escoge	=	Math.abs(a.nextInt()) % size ;
		elegido	=	getAlgoritmosComboBox().getItemAt(escoge);
	}
	/**
	 * This method initializes siempreRadioButton	
	 * @return  javax.swing.JRadioButton
	 * @uml.property  name="siempreRadioButton"
	 */
	private JRadioButton getSiempreRadioButton() {
		if (siempreRadioButton == null) {
			siempreRadioButton = new JRadioButton();
			siempreRadioButton.setText("Usar Siempre");
			siempreRadioButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					okButton.setEnabled(true);
					algoritmosComboBox.setVisible(true);
					elegido	=	algoritmosComboBox.getSelectedItem();
				}
			});
			getButtonGroup().add(siempreRadioButton);
		}
		return siempreRadioButton;
	}
	/**
	 * This method initializes preguntarRadioButton	
	 * @return  javax.swing.JRadioButton
	 * @uml.property  name="preguntarRadioButton"
	 */
	private JRadioButton getPreguntarRadioButton() {
		if (preguntarRadioButton == null) {
			preguntarRadioButton = new JRadioButton();
			preguntarRadioButton.setText("Preguntar cada vez");
			preguntarRadioButton.setSelected(false);
			preguntarRadioButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					okButton.setEnabled(true);
					algoritmosComboBox.setVisible(true);
					elegido	=	algoritmosComboBox.getSelectedItem();
				}
			});
			getButtonGroup().add(preguntarRadioButton);
		}
		return preguntarRadioButton;
	}
	/**
	 * This method initializes buttonGroup	
	 * @return  javax.swing.ButtonGroup
	 * @uml.property  name="buttonGroup"
	 */
	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}
	/**
	 * This method initializes okButton		
	 * @return  javax.swing.JButton
	 * @uml.property  name="okButton"
	 */
	private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton();
			okButton.setText("Aceptar");
			okButton.setEnabled(false);
			okButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setEnabled(false);
					setVisible(false);
				}
			});
		}
		return okButton;
	}
	/**
	 * This method initializes algoritmosComboBox	
	 * @return  javax.swing.JComboBox
	 * @uml.property  name="algoritmosComboBox"
	 */
	private JComboBox getAlgoritmosComboBox() {
		if (algoritmosComboBox == null) {
			algoritmosComboBox = new JComboBox(listaOpciones);
			algoritmosComboBox.setVisible(true);
			algoritmosComboBox.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					elegido	=	algoritmosComboBox.getSelectedItem();
				}
			});
		}
		return algoritmosComboBox;
	}
	public Object devuelveSeleccion() {
		if (getPreguntarRadioButton().isSelected()){
			setVisible(true);
		} else if (getAleatorioRadioButton().isSelected()){
			escogeAleatorio();
		} else if (elegido == null){
			setVisible(true);
		}
		return	elegido;
	}
}
