package vista;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 * @author  Diego
 */
class DialogoNuevo extends JDialog {

	private static final long serialVersionUID = -4880828098010150796L;
	private JPanel dialogoContentPane = null;
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;
	private JPanel habitacionesPanel = null;
	private JLabel habitacionesLabel = null;
	private JPanel botonesPanel = null;
	private JSlider habitacionesSlider = null;
	private JLabel numHabLabel = null;
	private JPanel puertasPanel = null;
	private JLabel puertasLabel = null;
	private JSlider puertasSlider = null;
	private JLabel numPuertLabel = null;
	private JPanel ventanasPanel = null;
	private JLabel ventanasLabel = null;
	private JSlider ventanasSlider = null;
	private JLabel numVentLabel = null;
	/** This is the default constructor	 */
	public DialogoNuevo() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 300);
		this.setModal(true);
		this.setTitle("Nuevo Laberinto");
		this.setContentPane(getJContentPane());
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				aceptado	=	false;
				setVisible(false);
				setEnabled(false);
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (dialogoContentPane == null) {
			dialogoContentPane = new JPanel();
			dialogoContentPane.setLayout(new BoxLayout(getJContentPane(), BoxLayout.Y_AXIS));
			dialogoContentPane.add(getHabitacionesPanel(), null);
			dialogoContentPane.add(getPuertasPanel(), null);
			dialogoContentPane.add(getVentanasPanel(), null);
			dialogoContentPane.add(getSalidasPanel(), null);
			dialogoContentPane.add(getBotonesPanel(), null);
		}
		return dialogoContentPane;
	}

	/**
	 * This method initializes aceptarButton	
	 * @return  javax.swing.JButton
	 * @uml.property  name="aceptarButton"
	 */
	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setText("Aceptar");
			aceptarButton.addActionListener(new java.awt.event.ActionListener() {   
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					aceptado	=	true;
					setVisible(false);
					setEnabled(false);
				}
			});
		}
		return aceptarButton;
	}

	/**
	 * This method initializes habitacionesPanel	
	 * @return  javax.swing.JPanel
	 * @uml.property  name="habitacionesPanel"
	 */
	private JPanel getHabitacionesPanel() {
		if (habitacionesPanel == null) {
			numHabLabel = new JLabel();
			numHabLabel.setText("11");
			numHabLabel.setFont(new java.awt.Font("Garamond", java.awt.Font.PLAIN, 19));
			habitacionesLabel = new JLabel();
			habitacionesLabel.setText("Habitaciones");
			habitacionesLabel.setFont(new java.awt.Font("Garamond", java.awt.Font.PLAIN, 19));
			habitacionesPanel = new JPanel();
			habitacionesPanel.setLayout(new FlowLayout());
			habitacionesPanel.add(habitacionesLabel, null);
			habitacionesPanel.add(getHabitacionesSlider(), null);
			habitacionesPanel.add(numHabLabel, null);
		}
		return habitacionesPanel;
	}

	/**
	 * This method initializes botonesPanel	
	 * @return  javax.swing.JPanel
	 * @uml.property  name="botonesPanel"
	 */
	private JPanel getBotonesPanel() {
		if (botonesPanel == null) {
			botonesPanel = new JPanel();
			botonesPanel.add(getAceptarButton(), null);
			botonesPanel.add(getCancelarButton(), null);
		}
		return botonesPanel;
	}

	/**
	 * This method initializes cancelarButton	
	 * @return  javax.swing.JButton
	 * @uml.property  name="cancelarButton"
	 */
	private JButton getCancelarButton() {
		if (cancelarButton == null) {
			cancelarButton = new JButton();
			cancelarButton.setText("Cancelar");
			cancelarButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					aceptado	=	false;
					setVisible(false);
					setEnabled(false);
				}
			});
		}
		return cancelarButton;
	}

	/**
	 * This method initializes habitacionesSlider	
	 * @return  javax.swing.JSlider
	 * @uml.property  name="habitacionesSlider"
	 */
	private JSlider getHabitacionesSlider() {
		if (habitacionesSlider == null) {
			habitacionesSlider = new JSlider();
			habitacionesSlider.setMaximum(19);
			habitacionesSlider.setMinorTickSpacing(1);
			habitacionesSlider.setPaintTicks(true);
			habitacionesSlider.setPaintLabels(true);
			habitacionesSlider.setMajorTickSpacing(4);
			habitacionesSlider.setValue(11);
			habitacionesSlider.setMinimum(1);
			habitacionesSlider.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					/* El máximo de puertas posible sigue la formula del numero maximo de aristas
					 * en un grafo no dirigido de "nod" nodos y el numero maximo de ventanas le
					 * hemos puesto el doble del numero de nodos */
					int nod = habitacionesSlider.getValue();
					numHabLabel.setText(Integer.toString(nod));					
					puertasSlider.setMaximum( (nod * (nod-1)) / 2);
					ventanasSlider.setMaximum(2*nod);
					salidasSlider.setMaximum(nod);
				}
			});
		}
		return habitacionesSlider;
	}

	/**
	 * This method initializes puertasPanel	
	 * @return  javax.swing.JPanel
	 * @uml.property  name="puertasPanel"
	 */
	private JPanel getPuertasPanel() {
		if (puertasPanel == null) {
			numPuertLabel = new JLabel();
			numPuertLabel.setText("55");
			numPuertLabel.setFont(new java.awt.Font("Garamond", java.awt.Font.PLAIN, 19));
			puertasLabel = new JLabel();
			puertasLabel.setText("Puertas");
			puertasLabel.setFont(new java.awt.Font("Garamond", java.awt.Font.PLAIN, 19));
			puertasPanel = new JPanel();
			puertasPanel.add(puertasLabel, null);
			puertasPanel.add(getPuertasSlider(), null);
			puertasPanel.add(numPuertLabel, null);
		}
		return puertasPanel;
	}

	/**
	 * This method initializes puertasSlider	
	 * @return  javax.swing.JSlider
	 * @uml.property  name="puertasSlider"
	 */
	private JSlider getPuertasSlider() {
		if (puertasSlider == null) {
			puertasSlider = new JSlider();
			puertasSlider.setMajorTickSpacing(20);
			puertasSlider.setPaintLabels(true);
			puertasSlider.setPaintTicks(true);
			puertasSlider.setMaximum(55);
			puertasSlider.setMinorTickSpacing(1);
			puertasSlider.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					numPuertLabel.setText(Integer.toString(puertasSlider.getValue()));
				}
			});
		}
		return puertasSlider;
	}

	/**
	 * This method initializes ventanasPanel	
	 * @return  javax.swing.JPanel
	 * @uml.property  name="ventanasPanel"
	 */
	private JPanel getVentanasPanel() {
		if (ventanasPanel == null) {
			numVentLabel = new JLabel();
			numVentLabel.setText("22");
			numVentLabel.setFont(new java.awt.Font("Garamond", java.awt.Font.PLAIN, 19));
			ventanasLabel = new JLabel();
			ventanasLabel.setText("Ventanas");
			ventanasLabel.setFont(new java.awt.Font("Garamond", java.awt.Font.PLAIN, 19));
			ventanasPanel = new JPanel();
			ventanasPanel.add(ventanasLabel, null);
			ventanasPanel.add(getVentanasSlider(), null);
			ventanasPanel.add(numVentLabel, null);
		}
		return ventanasPanel;
	}

	/**
	 * This method initializes ventanasSlider	
	 * @return  javax.swing.JSlider
	 * @uml.property  name="ventanasSlider"
	 */
	private JSlider getVentanasSlider() {
		if (ventanasSlider == null) {
			ventanasSlider = new JSlider();
			ventanasSlider.setMaximum(22);
			ventanasSlider.setMinorTickSpacing(1);
			ventanasSlider.setPaintLabels(true);
			ventanasSlider.setPaintTicks(true);
			ventanasSlider.setMajorTickSpacing(5);
			ventanasSlider.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					numVentLabel.setText(Integer.toString(ventanasSlider.getValue()));
				}
			});
		}
		return ventanasSlider;
	}
	
	public	int	getNumeroHabitaciones(){
		return habitacionesSlider.getValue();
	}
	
	public	int	getNumeroPuertas(){
		return puertasSlider.getValue();
	}
	
	public	int	getNumeroVentanas(){
		return ventanasSlider.getValue();
	}
	
	public	int	getNumeroSalidas(){
		return	salidasSlider.getValue();
	}
	
	private boolean aceptado;
	private JPanel salidasPanel = null;
	private JLabel salidasLabel = null;
	private JSlider salidasSlider = null;
	private JLabel numSalLabel = null;
	
	/**
	 * @return  the aceptado
	 * @uml.property  name="aceptado"
	 */
	public boolean isAceptado() {
		return aceptado;
	}

	/**
	 * This method initializes salidasPanel	
	 * @return  javax.swing.JPanel
	 * @uml.property  name="salidasPanel"
	 */
	private JPanel getSalidasPanel() {
		if (salidasPanel == null) {
			numSalLabel = new JLabel();
			numSalLabel.setText("3");
			numSalLabel.setFont(new Font("Garamond", Font.PLAIN, 18));
			salidasLabel = new JLabel();
			salidasLabel.setText("Salidas");
			salidasLabel.setFont(new Font("Garamond", Font.PLAIN, 18));
			salidasPanel = new JPanel();
			salidasPanel.setLayout(new FlowLayout());
			salidasPanel.add(salidasLabel, null);
			salidasPanel.add(getSalidasSlider(), null);
			salidasPanel.add(numSalLabel, null);
		}
		return salidasPanel;
	}

	/**
	 * This method initializes salidasSlider	
	 * @return  javax.swing.JSlider
	 * @uml.property  name="salidasSlider"
	 */
	private JSlider getSalidasSlider() {
		if (salidasSlider == null) {
			salidasSlider = new JSlider();
			salidasSlider.setMajorTickSpacing(5);
			salidasSlider.setMinorTickSpacing(1);
			salidasSlider.setPaintLabels(true);
			salidasSlider.setPaintTicks(true);
			salidasSlider.setSnapToTicks(true);
			salidasSlider.setValue(3);
			salidasSlider.setMaximum(11);
			salidasSlider.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					numSalLabel.setText(Integer.toString(salidasSlider.getValue()));
				}
			});
		}
		return salidasSlider;
	}

}  //  @jve:decl-index=0:visual-constraint="-22,-34"
