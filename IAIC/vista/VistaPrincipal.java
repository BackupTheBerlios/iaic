package vista;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;


public class VistaPrincipal extends JFrame implements	Visualizable{

	private static final long serialVersionUID = 441754492724484437L;
	private JPanel principalContentPane = null;
	private JMenuBar menu = null;
	private JMenu cuboMenu = null;
	private JMenuItem nuevoMenuItem = null;
	private JMenuItem cargarMenuItem = null;
	private JMenuItem salirMenuItem = null;
	private JMenuItem guardarMenuItem = null;
	private JLabel cuboDatosLabel = null;
	private JTextArea datosCuboTextArea = null;
	private JFileChooser archivoFileChooser = null;
	private JLabel busquedaGlobalLabel = null;
	private JTextArea busquedaGlobalTextArea = null;
	private JLabel busquedaLocalLabel = null;
	private JTextArea busquedaLocalTextArea = null;
	private JPanel controlLocalPanel = null;
	private JButton pasoLocalButton = null;
	private JPanel controlGlobalPanel = null;
	private JButton pasoGlobalButton = null;
	private JSlider globalSlider = null;
	private JScrollPane globalScrollPane = null;
	private JScrollPane cuboScrollPane = null;
	private JScrollPane localScrollPane = null;
	private JSlider localSlider = null;
	private DialogoNuevo dialogoNuevo = null;
	/**
	 * This is the default constructor
	 */
	public VistaPrincipal() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		estado	=	new	EstadoVista();
		this.setSize(600, 600);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setJMenuBar(getMenu());
		this.setContentPane(getPrincipalContentPane());
		this.setTitle("Inteligencia Artificial - Micromundo cúbico");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				estado.ponSinCubo();
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 * @return  javax.swing.JPanel
	 * @uml.property  name="principalContentPane"
	 */
	private JPanel getPrincipalContentPane() {
		if (principalContentPane == null) {
			busquedaGlobalLabel = new JLabel();
			busquedaGlobalLabel.setText("Búsqueda Global");
			busquedaGlobalLabel.setFont(new java.awt.Font("Garamond", java.awt.Font.BOLD, 24)); // | java.awt.Font.ITALIC
			busquedaLocalLabel = new JLabel();
			busquedaLocalLabel.setText("Búsqueda Local");
			busquedaLocalLabel.setFont(new java.awt.Font("Garamond", java.awt.Font.BOLD, 24));
			cuboDatosLabel = new JLabel();
			cuboDatosLabel.setText("Datos del Cubo");
			cuboDatosLabel.setFont(new java.awt.Font("Garamond", java.awt.Font.BOLD, 24)); // | java.awt.Font.ITALIC
			principalContentPane = new JPanel();
			principalContentPane.setLayout(new BoxLayout(getPrincipalContentPane(), BoxLayout.Y_AXIS));
			principalContentPane.add(getCuboPanel(), null);
			principalContentPane.add(getGlobalPanel(), null);
			principalContentPane.add(getLocalPanel(), null);
		}
		return principalContentPane;
	}

	/**
	 * This method initializes menuBar	
	 * @return  javax.swing.JMenuBar
	 * @uml.property  name="menu"
	 */
	private JMenuBar getMenu() {
		if (menu == null) {
			menu = new JMenuBar();
			menu.add(getCuboMenu());
			menu.add(getEjecucionMenu());
		}
		return menu;
	}

	/**
	 * This method initializes laberintoMenu	
	 * @return  javax.swing.JMenu
	 * @uml.property  name="laberintoMenu"
	 */
	private JMenu getCuboMenu() {
		if (cuboMenu == null) {
			cuboMenu = new JMenu();
			cuboMenu.setText("Cubo");
			cuboMenu.add(getNuevoMenuItem());
			cuboMenu.add(getGuardarMenuItem());
			cuboMenu.add(getCargarMenuItem());
			cuboMenu.add(getAbrirTextoMenuItem());
			cuboMenu.add(getGuardarTextoMenuItem());
			cuboMenu.add(getCerrarMenuItem());
			cuboMenu.add(getSalirMenuItem());
		}
		return cuboMenu;
	}

	/**
	 * This method initializes nuevoMenuItem	
	 * @return  javax.swing.JMenuItem
	 * @uml.property  name="nuevoMenuItem"
	 */
	private JMenuItem getNuevoMenuItem() {
		if (nuevoMenuItem == null) {
			nuevoMenuItem = new JMenuItem();
			nuevoMenuItem.setText("Nuevo Cubo");
			nuevoMenuItem.setMnemonic(java.awt.event.KeyEvent.VK_N);
			nuevoMenuItem.addActionListener(new java.awt.event.ActionListener() {   
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getDialogoNuevo().setEnabled(true);
					getDialogoNuevo().setVisible(true);
					if (getDialogoNuevo().isAceptado()){
						nuevoCubo();
					}
				}
			});
		}
		return nuevoMenuItem;
	}
	protected void nuevoCubo() {
		int dim = dialogoNuevo.getDimensionCubo();
		int puertas = dialogoNuevo.getNumeroPuertas();
		modelo.nuevoCubo(dim,puertas);				
	}

	/**
	 * This method initializes cargarMenuItem	
	 * @return  javax.swing.JMenuItem
	 * @uml.property  name="cargarMenuItem"
	 */
	private JMenuItem getCargarMenuItem() {
		if (cargarMenuItem == null) {
			cargarMenuItem = new JMenuItem();
			cargarMenuItem.setText("Abrir Cubo");
			cargarMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cargarBinarioArchivo();
				}
			});
		}
		return cargarMenuItem;
	}

	protected void cargarBinarioArchivo() {
		File file;
		try{
			int val = getArchivoFileChooser().showOpenDialog(VistaPrincipal.this);
			if (val == JFileChooser.APPROVE_OPTION){
				file = getArchivoFileChooser().getSelectedFile();
				ObjectInputStream input = 
					new	ObjectInputStream(
							new FileInputStream (file)
					);
				modelo.cargarBinario(input);
				input.close();
			}				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					VistaPrincipal.this,
					e, 
					"Error Entrada salida",
					JOptionPane.ERROR_MESSAGE
			);
		}
	}

	/**
	 * This method initializes salirMenuItem	
	 * @return  javax.swing.JMenuItem
	 * @uml.property  name="salirMenuItem"
	 */
	private JMenuItem getSalirMenuItem() {
		if (salirMenuItem == null) {
			salirMenuItem = new JMenuItem();
			salirMenuItem.setText("Salir");
			salirMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					VistaPrincipal.this.dispose();
				}
			});
		}
		return salirMenuItem;
	}

	/**
	 * This method initializes guardarMenuItem	
	 * @return  javax.swing.JMenuItem
	 * @uml.property  name="guardarMenuItem"
	 */
	private JMenuItem getGuardarMenuItem() {
		if (guardarMenuItem == null) {
			guardarMenuItem = new JMenuItem();
			guardarMenuItem.setText("Guardar Cubo");
			guardarMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					guardarBinarioArchivo();
				}
			});
		}
		return guardarMenuItem;
	}

	protected void guardarBinarioArchivo() {
		try{
			int val = getArchivoFileChooser().showSaveDialog(VistaPrincipal.this);
			if (val == JFileChooser.APPROVE_OPTION){
				File file = getArchivoFileChooser().getSelectedFile();
				ObjectOutputStream output = 
					new	ObjectOutputStream(
							new FileOutputStream (file)
					);
				modelo.guardarBinario(output);
				output.close();
			}				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					VistaPrincipal.this,
					e, 
					"Error Entrada salida",
					JOptionPane.ERROR_MESSAGE
			);
		}
		
	}

	/**
	 * This method initializes datosLaberintoTextArea	
	 * @return  javax.swing.JTextArea
	 * @uml.property  name="datosLaberintoTextArea"
	 */
	private JTextArea getDatosCuboTextArea() {
		if (datosCuboTextArea == null) {
			datosCuboTextArea = new JTextArea();
			datosCuboTextArea.setEditable(false);
		}
		return datosCuboTextArea;
	}

	/**
	 * This method initializes archivoFileChooser	
	 * @return  javax.swing.JFileChooser
	 * @uml.property  name="archivoFileChooser"
	 */
	private JFileChooser getArchivoFileChooser() {
		if (archivoFileChooser == null) {
			archivoFileChooser = new JFileChooser();
		}
		return archivoFileChooser;
	}

	/**
	 * This method initializes jTextArea	
	 * @return  javax.swing.JTextArea
	 * @uml.property  name="busquedaGlobalTextArea"
	 */
	private JTextArea getBusquedaGlobalTextArea() {
		if (busquedaGlobalTextArea == null) {
			busquedaGlobalTextArea = new JTextArea();
			busquedaGlobalTextArea.setEditable(false);
		}
		return busquedaGlobalTextArea;
	}

	/**
	 * This method initializes busquedaLocalTextArea	
	 * @return  javax.swing.JTextArea
	 * @uml.property  name="busquedaLocalTextArea"
	 */
	private JTextArea getBusquedaLocalTextArea() {
		if (busquedaLocalTextArea == null) {
			busquedaLocalTextArea = new JTextArea();
			busquedaLocalTextArea.setEditable(false);
			busquedaLocalTextArea.setText("");
		}
		return busquedaLocalTextArea;
	}

	/**
	 * This method initializes controlLocalPanel	
	 * @return  javax.swing.JPanel
	 * @uml.property  name="controlLocalPanel"
	 */
	private JPanel getControlLocalPanel() {
		if (controlLocalPanel == null) {
			controlLocalPanel = new JPanel();
			controlLocalPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			controlLocalPanel.add(getPasoLocalButton(), null);
			controlLocalPanel.add(getLocalSlider(), null);
			controlLocalPanel.add(getOkLocalButton(), null);
		}
		return controlLocalPanel;
	}

	/**
	 * This method initializes pasoLocalButton	
	 * @return  javax.swing.JButton
	 * @uml.property  name="pasoLocalButton"
	 */
	private JButton getPasoLocalButton() {
		if (pasoLocalButton == null) {
			pasoLocalButton = new JButton();
			pasoLocalButton.setText("Ejecuta un paso");
			pasoLocalButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int i = 0;
					int n = getLocalSlider().getValue() ;
					while (i < n && estado.miEstado!= Estado.TermLoc) { 
						modelo.ejecutaPasoLocal();
						i++;
					}
				}
			});
		}
		return pasoLocalButton;
	}

	/**
	 * This method initializes controlGlobalPanel	
	 * @return  javax.swing.JPanel
	 * @uml.property  name="controlGlobalPanel"
	 */
	private JPanel getControlGlobalPanel() {
		if (controlGlobalPanel == null) {
			controlGlobalPanel = new JPanel();
			controlGlobalPanel.add(getPasoGlobalButton(), null);
			controlGlobalPanel.add(getGlobalSlider(), null);
			controlGlobalPanel.add(getOcultaLocalCheckBox(), null);
			controlGlobalPanel.add(getOkGlobalButton(), null);
		}
		return controlGlobalPanel;
	}

	/**
	 * This method initializes pasoGlobalButton	
	 * @return  javax.swing.JButton
	 * @uml.property  name="pasoGlobalButton"
	 */
	private JButton getPasoGlobalButton() {
		if (pasoGlobalButton == null) {
			pasoGlobalButton = new JButton();
			pasoGlobalButton.setText("Ejecuta un paso");
			pasoGlobalButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int i = 0;
					while (i < getGlobalSlider().getValue() && estado.miEstado == Estado.ExecGlob) { 
						modelo.ejecutaPasoGlobal();
						i++;
					}
				}
			});
		}
		return pasoGlobalButton;
	}

	/**
	 * This method initializes globalSlider	
	 * @return  javax.swing.JSlider
	 * @uml.property  name="globalSlider"
	 */
	private JSlider getGlobalSlider() {
		if (globalSlider == null) {
			globalSlider = new JSlider();
			globalSlider.setMajorTickSpacing(1);
			globalSlider.setMinorTickSpacing(1);
			globalSlider.setPaintLabels(true);
			globalSlider.setPaintTicks(true);
			globalSlider.setMaximum(10);
			globalSlider.setSnapToTicks(true);
			globalSlider.setValue(1);
			globalSlider.setToolTipText("Numero pasos");
			globalSlider.setOrientation(javax.swing.JSlider.HORIZONTAL);
			globalSlider.setMinimum(1);
		}
		return globalSlider;
	}

	/**
	 * This method initializes globalScrollPane	
	 * @return  javax.swing.JScrollPane
	 * @uml.property  name="globalScrollPane"
	 */
	private JScrollPane getGlobalScrollPane() {
		if (globalScrollPane == null) {
			globalScrollPane = new JScrollPane();
			globalScrollPane.setViewportView(getBusquedaGlobalTextArea());
		}
		return globalScrollPane;
	}

	/**
	 * This method initializes laberintoScrollPane	
	 * @return  javax.swing.JScrollPane
	 * @uml.property  name="laberintoScrollPane"
	 */
	private JScrollPane getLaberintoScrollPane() {
		if (cuboScrollPane == null) {
			cuboScrollPane = new JScrollPane();
			cuboScrollPane.setViewportView(getDatosCuboTextArea());
		}
		return cuboScrollPane;
	}

	/**
	 * This method initializes localScrollPane	
	 * @return  javax.swing.JScrollPane
	 * @uml.property  name="localScrollPane"
	 */
	private JScrollPane getLocalScrollPane() {
		if (localScrollPane == null) {
			localScrollPane = new JScrollPane();
			localScrollPane.setViewportView(getBusquedaLocalTextArea());
		}
		return localScrollPane;
	}

	/**
	 * This method initializes localSlider	
	 * @return  javax.swing.JSlider
	 * @uml.property  name="localSlider"
	 */
	private JSlider getLocalSlider() {
		if (localSlider == null) {
			localSlider = new JSlider();
			localSlider.setMaximum(10);
			localSlider.setMinorTickSpacing(1);
			localSlider.setPaintTicks(true);
			localSlider.setSnapToTicks(true);
			localSlider.setValue(1);
			localSlider.setPaintTrack(true);
			localSlider.setMajorTickSpacing(1);
			localSlider.setPaintLabels(true);
			localSlider.setMinimum(1);
		}
		return localSlider;
	}

	/**
	 * This method initializes dialogoNuevo	
	 * @return  vista.DialogoNuevo
	 * @uml.property  name="dialogoNuevo"
	 */
	private DialogoNuevo getDialogoNuevo() {
		if (dialogoNuevo == null) {
			dialogoNuevo = new DialogoNuevo();
		}
		return dialogoNuevo;
	}
	
	private	OyenteVista	modelo; 
	private JMenuItem abrirTextoMenuItem = null;
	private JMenuItem guardarTextoMenuItem = null;
	/**
	 * @return  the modelo
	 * @uml.property  name="modelo"
	 */
	public OyenteVista getModelo() {
		return modelo;
	}

	/**
	 * @param modelo  the modelo to set
	 * @uml.property  name="modelo"
	 */
	public void setModelo(OyenteVista modelo) {
		this.modelo = modelo;
	}

	/**
	 * This method initializes abrirTextoMenuItem	
	 * @return  javax.swing.JMenuItem
	 * @uml.property  name="abrirTextoMenuItem"
	 */
	private JMenuItem getAbrirTextoMenuItem() {
		if (abrirTextoMenuItem == null) {
			abrirTextoMenuItem = new JMenuItem();
			abrirTextoMenuItem.setText("Cargar de Texto");
			abrirTextoMenuItem.addActionListener(new java.awt.event.ActionListener() {   
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					cargarTextoArchivo();
				}			
			});
		}
		return abrirTextoMenuItem;
	}

	protected void cargarTextoArchivo() {
		try{
			int val = getArchivoFileChooser().showOpenDialog(VistaPrincipal.this);
			if (val == JFileChooser.APPROVE_OPTION){
				File file = getArchivoFileChooser().getSelectedFile();
				FileReader input	=	new	FileReader(file);
				modelo.cargarTexto(input);
				input.close();
			}				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					VistaPrincipal.this,
					e, 
					"Error Entrada salida",
					JOptionPane.ERROR_MESSAGE
			);
		}		
	}

	/**
	 * This method initializes guardarTextoMenuItem	
	 * @return  javax.swing.JMenuItem
	 * @uml.property  name="guardarTextoMenuItem"
	 */
	private JMenuItem getGuardarTextoMenuItem() {
		if (guardarTextoMenuItem == null) {
			guardarTextoMenuItem = new JMenuItem();
			guardarTextoMenuItem.setText("Guardar en texto");
			guardarTextoMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					guardarTextoArchivo();
				}
			});
		}
		return guardarTextoMenuItem;
	}
	
	protected void guardarTextoArchivo() {
		try{
			int val = getArchivoFileChooser().showSaveDialog(VistaPrincipal.this);
			if (val == JFileChooser.APPROVE_OPTION){
				File f = getArchivoFileChooser().getSelectedFile();
				FileWriter	fil	=	new	FileWriter(f);
				modelo.guardarTexto(fil);
				fil.close();
			}				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					VistaPrincipal.this,
					e, 
					"Error Entrada salida",
					JOptionPane.ERROR_MESSAGE
			);
		}
		
	}

	private	EstadoVista	estado; 
	private JMenu ejecucionMenu = null;
	private JMenuItem iniciarMenuItem = null;
	private JMenuItem terminarMenuItem = null;
	private JMenuItem cerrarMenuItem = null;
	private DialogoAlgoritmo dialogoAlgoritmo = null;
	private JPanel cuboPanel = null;
	private JPanel globalPanel = null;
	private JPanel localPanel = null;
	private JMenuItem algoritmoMenuItem = null;
	private JButton okGlobalButton = null;
	private JButton okLocalButton = null;
	private JCheckBox ocultaLocalCheckBox = null;

	private	enum Estado{Sin,Con, ExecGlob, ExecLoc,TermGlob,TermLoc};
	
	private	class EstadoVista{
		/** Cuando no hay laberinto, no ves ningún panel y el meú de 
		 * ejecución está desactivado, así como las opciones cerrar, guardar de Archivo.*/
		public	Estado	miEstado;
		
		public void	ponSinCubo(){
			miEstado	=	Estado.Sin;
			mostrarMenus(false, false);
			ponPaneles(false,false,false,false,false);
		}
		
		/** Cuando hay un laberinto pero no hay ejecución, solo se ve el panel de laberinto.
		 * Todas las opciones de Archivo están activadas y solo está desactivado Ejecución ->Terminar.*/
		public void	ponConCubo(){
			miEstado	=	Estado.Con;
			mostrarMenus(true, false);
			ponPaneles(true,false,false,false,false);
		}
		
		public void	ponEjecutandoGlobal(){
			miEstado	=	Estado.ExecGlob;
			getCuboMenu().setEnabled(false);
			mostrarMenus(true, true);
			ponPaneles(true,true,true,false,false);
			
			ponActivoGlobal(true);
		}
		
		/**Cuando una búsqueda global ha terminado, yo veo el laberinto, 
		 * botones inactivos exceptio Ok*/
		public	void	ponTerminadaGlobal(){
			miEstado	=	Estado.TermGlob;
			mostrarMenus(true, true);
			ponPaneles(true,true,true,false,false);
			ponActivoGlobal(false);
		}

		/** Cuando se está ejecutando la búsqueda local se ve el laberinto,
		 * la información de la búsqueda global -no el control-, 
		 * y la información y control locales, */
		public	void	ponEjecutandoLocal(){
			miEstado	=	Estado.ExecLoc;
			mostrarMenus(true, true);
			ponPaneles(true,true,false,true,true);
			ponActivoLocal(true);
		}

		private void ponActivoLocal(boolean b) {
			getPasoLocalButton().setEnabled(b);
			getLocalSlider().setEnabled(b);
			getOkLocalButton().setVisible(!b);
		}

		private void ponActivoGlobal(boolean b) {
			getPasoGlobalButton().setEnabled(b);
			getGlobalSlider().setEnabled(b);
			getOkGlobalButton().setVisible(!b);
		}

		public	void	ponTerminadaLocal(){
			miEstado	=	Estado.TermLoc;
			mostrarMenus(true, true);
			ponPaneles(true,true,false,true,true);
			ponActivoLocal(false);
		}
		
		private void ponPaneles(boolean lab, boolean glo, boolean conglo, boolean loc, boolean conloc){
			getCuboPanel().setVisible(lab);
			getGlobalPanel().setVisible(glo);
			getControlGlobalPanel().setVisible(conglo);
			getLocalPanel().setVisible(loc);
			getControlLocalPanel().setVisible(conloc);
		}
		
		private	void	mostrarMenus(boolean arch, boolean term){
			getCerrarMenuItem().setEnabled(arch);
			getGuardarMenuItem().setEnabled(arch);
			getGuardarTextoMenuItem().setEnabled(arch);
			getEjecucionMenu().setEnabled(arch);
			
			getNuevoMenuItem().setEnabled(! arch);
			getAbrirTextoMenuItem().setEnabled(!arch);
			getCargarMenuItem().setEnabled(! arch);

			getIniciarMenuItem().setEnabled(!term);
			getCuboMenu().setEnabled(! term);
			getTerminarMenuItem().setEnabled(term);
			

		}
	}

	/**
	 * This method initializes ejecucionMenu	
	 * @return  javax.swing.JMenu
	 * @uml.property  name="ejecucionMenu"
	 */
	private JMenu getEjecucionMenu() {
		if (ejecucionMenu == null) {
			ejecucionMenu = new JMenu();
			ejecucionMenu.setText("Ejecución");
			ejecucionMenu.add(getIniciarMenuItem());
			ejecucionMenu.add(getTerminarMenuItem());
			ejecucionMenu.add(getAlgoritmoMenuItem());
		}
		return ejecucionMenu;
	}

	/**
	 * This method initializes iniciarMenuItem	
	 * @return  javax.swing.JMenuItem
	 * @uml.property  name="iniciarMenuItem"
	 */
	private JMenuItem getIniciarMenuItem() {
		if (iniciarMenuItem == null) {
			iniciarMenuItem = new JMenuItem();
			iniciarMenuItem.setText("Iniciar");
			iniciarMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modelo.iniciarEjecucionGlobal();
				}
			});
		}
		return iniciarMenuItem;
	}

	/**
	 * This method initializes terminarMenuItem	
	 * @return  javax.swing.JMenuItem
	 * @uml.property  name="terminarMenuItem"
	 */
	private JMenuItem getTerminarMenuItem() {
		if (terminarMenuItem == null) {
			terminarMenuItem = new JMenuItem();
			terminarMenuItem.setText("Terminar");
			terminarMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modelo.cierraGlobal();
				}
			});
		}
		return terminarMenuItem;
	}

	/**
	 * This method initializes cerrarMenuItem	
	 * @return  javax.swing.JMenuItem
	 * @uml.property  name="cerrarMenuItem"
	 */
	private JMenuItem getCerrarMenuItem() {
		if (cerrarMenuItem == null) {
			cerrarMenuItem = new JMenuItem();
			cerrarMenuItem.setText("Cerrar");
			cerrarMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modelo.cerrarCubo();
				}
			});
		}
		return cerrarMenuItem;
	}

	/**
	 * This method initializes dialogoAlgoritmo	
	 * @return  vista.DialogoAlgoritmo
	 * @uml.property  name="dialogoAlgoritmo"
	 */
	private DialogoAlgoritmo getDialogoAlgoritmo() {
		if (dialogoAlgoritmo == null) {
			dialogoAlgoritmo = new DialogoAlgoritmo(this, modelo.getListaAlgoritmos());
		}
		return dialogoAlgoritmo;
	}

	public Object escogeAlgoritmo() {
		return getDialogoAlgoritmo().devuelveSeleccion();
	}

	/**
	 * This method initializes laberintoPanel	
	 * @return  javax.swing.JPanel
	 * @uml.property  name="laberintoPanel"
	 */
	private JPanel getCuboPanel() {
		if (cuboPanel == null) {
			cuboPanel = new JPanel();
			cuboPanel.setLayout(new BoxLayout(getCuboPanel(), BoxLayout.Y_AXIS));
			cuboPanel.setBorder(BorderFactory.createLineBorder(Color.red, 5));
			cuboPanel.add(cuboDatosLabel, null);
			cuboPanel.add(getLaberintoScrollPane(), null);
		}
		return cuboPanel;
	}

	/**
	 * This method initializes globalPanel	
	 * @return  javax.swing.JPanel
	 * @uml.property  name="globalPanel"
	 */
	private JPanel getGlobalPanel() {
		if (globalPanel == null) {
			globalPanel = new JPanel();
			globalPanel.setLayout(new BoxLayout(getGlobalPanel(), BoxLayout.Y_AXIS));
			globalPanel.setBorder(BorderFactory.createLineBorder(Color.green, 5));
			globalPanel.add(busquedaGlobalLabel, null);
			globalPanel.add(getGlobalScrollPane(), null);
			globalPanel.add(getControlGlobalPanel(), null);
		}
		return globalPanel;
	}

	/**
	 * This method initializes localPanel	
	 * @return  javax.swing.JPanel
	 * @uml.property  name="localPanel"
	 */
	private JPanel getLocalPanel() {
		if (localPanel == null) {
			localPanel = new JPanel();
			localPanel.setLayout(new BoxLayout(getLocalPanel(), BoxLayout.Y_AXIS));
			localPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.blue));
			localPanel.add(busquedaLocalLabel, null);
			localPanel.add(getLocalScrollPane(), null);
			localPanel.add(getControlLocalPanel(), null);
		}
		return localPanel;
	}

	/**
	 * This method initializes algoritmoMenuItem	
	 * @return  javax.swing.JMenuItem
	 * @uml.property  name="algoritmoMenuItem"
	 */
	private JMenuItem getAlgoritmoMenuItem() {
		if (algoritmoMenuItem == null) {
			algoritmoMenuItem = new JMenuItem();
			algoritmoMenuItem.setText("Algoritmos...");
			algoritmoMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getDialogoAlgoritmo().setVisible(true);
				}
			});
		}
		return algoritmoMenuItem;
	}

	/**
	 * This method initializes okGlobalButton	
	 * @return  javax.swing.JButton
	 * @uml.property  name="okGlobalButton"
	 */
	private JButton getOkGlobalButton() {
		if (okGlobalButton == null) {
			okGlobalButton = new JButton();
			okGlobalButton.setText("Ok");
			okGlobalButton.setVisible(false);
			okGlobalButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modelo.cierraGlobal();
				}
			});
		}
		return okGlobalButton;
	}

	/**
	 * This method initializes okLocalButton	
	 * @return  javax.swing.JButton
	 * @uml.property  name="okLocalButton"
	 */
	private JButton getOkLocalButton() {
		if (okLocalButton == null) {
			okLocalButton = new JButton();
			okLocalButton.setText("Ok");
			okLocalButton.setVisible(false);
			okLocalButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modelo.iniciarEjecucionLocalActual();
				}
			});
		}
		return okLocalButton;
	}
	
	public void muestraCubo(String infoLab) {
		getDatosCuboTextArea().setText(infoLab);
	}

	public void muestraGlobal(String infoGlob) {
		getBusquedaGlobalTextArea().setText(infoGlob);
	}

	public void muestraLocal(String infoLoc) {
		getBusquedaLocalTextArea().setText(infoLoc);
	}
	
	public void atiendeEjecutandoGlobal() {
		estado.ponEjecutandoGlobal();
	}

	public void atiendeFinGlobal() {
		estado.ponTerminadaGlobal();
	}

	public void atiendeEjecutandoLocal() {
		if (ocultaLocalCheckBox.isSelected()){
			modelo.cierraLocal();
		} else{
			estado.ponEjecutandoLocal();
		}
	}
	
	public void atiendeFinLocal() {
		estado.ponTerminadaLocal();
	}

	public void atiendeConCubo() {
		estado.ponConCubo();		
	}

	public void atiendeSinCubo() {
		estado.ponSinCubo();
	}


	/**
	 * This method initializes ocultaLocalCheckBox	
	 * @return  javax.swing.JCheckBox
	 * @uml.property  name="ocultaLocalCheckBox"
	 */
	private JCheckBox getOcultaLocalCheckBox() {
		if (ocultaLocalCheckBox == null) {
			ocultaLocalCheckBox = new JCheckBox();
			ocultaLocalCheckBox.setText("Ocultar la búsqueda local");
		}
		return ocultaLocalCheckBox;
	}
	
	
	public	void dispose() {
		getDialogoNuevo().dispose();
		getDialogoAlgoritmo().dispose();
		super.dispose();
	}
} 