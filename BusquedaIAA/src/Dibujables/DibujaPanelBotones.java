/**
 * 
 * AUTOR: VÍCTOR HERNÁNDEZ PÉREZ ASIGNATURA: PROGRAMACIÓN DE APLICACIONES
 * INTERACTIVAS E-MAIL: alu0100697032@ull.edu.es 20/11/2014
 * DibujaPanelBotones.java BusquedaIAA
 */
package Dibujables;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author Victor
 * 
 */
@SuppressWarnings("serial")
public class DibujaPanelBotones extends JPanel {

	/*
	 * ATRIBUTOS
	 */
	private int altoPanelBotones = 100;
	private int margenInferior = 0;
	private int margenSuperior = 0;

	private JButton crearEntorno;
	private JButton reset;
	private JButton moverRobot;
	private JButton modoAleatorio;
	private JButton modoSeleccion;
	private JButton generarObjetos;
	private JButton salir;

	private JLabel anchoEntorno;
	private JLabel altoEntorno;
	private JLabel numeroObjetos;

	private JTextField insertarAnchoEntorno;
	private JTextField insertarAltoEntorno;
	private JTextField insertarXDestino;
	private JTextField insertarYDestino;
	private JTextField insertarNumeroObjetos;

	private JRadioButton robotRadioButton;
	private JRadioButton objetosRadioButton;
	private JRadioButton escaladaRadioButton;
	private JRadioButton aestrellaRadioButton;

	private ButtonGroup robotObjetosButtonGroup;
	private ButtonGroup escaladaAEstrellaButtonGroup;

	public DibujaPanelBotones(int ancho, int alto) {
		setBounds(0, alto - altoPanelBotones, ancho, altoPanelBotones);
		setLayout(new GridLayout(2, 0));

		setRobotObjetosButtonGroup(new ButtonGroup());
		setEscaladaAEstrellaButtonGroup(new ButtonGroup());
		setEscaladaRadioButton(new JRadioButton("Escalada"));
		setAestrellaRadioButton(new JRadioButton("A*"));
		setRobotRadioButton(new JRadioButton("Robot"));
		setObjetosRadioButton(new JRadioButton("Objetos"));
		
		add(setCrearEntorno(new JButton("Crear Entorno")));
		add(setModoAleatorio(new JButton("Modo aleatorio")));
		add(setModoSeleccion(new JButton("Modo seleccion")));
		/*
		 * FORMAR GRUPO DE BOTONES ROBOT/OBJETOS
		 */
		robotObjetosButtonGroup.add(objetosRadioButton);
		robotObjetosButtonGroup.add(robotRadioButton);
		add(robotRadioButton);
		add(objetosRadioButton);
		add(setMoverRobot(new JButton("Mover Robot a:")));
		add(setInsertarXDestino(new JTextField("1")));
		add(setInsertarYDestino(new JTextField("1")));
	
		/*
		 * BOTON RESET
		 */
		add(setReset(new JButton("Reset")));
		/*
		 * CARACTERÍSTICAS DEL ENTORNO ANCHO/ALTO
		 */
		add(setAnchoEntorno(new JLabel("Ancho")));
		add(setInsertarAnchoEntorno(new JTextField("10")));
		add(setAltoEntorno(new JLabel("Alto")));
		add(setInsertarAltoEntorno(new JTextField("10")));
		/*
		 * OBJETOS DEL ENTORNO
		 */
		add(setNumeroObjetos(new JLabel("Objetos")));
		add(setInsertarNumeroObjetos(new JTextField("10")));
		/*
		 * GRUPO DE BOTONES DE ALGORITMO DE BUSQUEDA
		 */
		escaladaAEstrellaButtonGroup.add(escaladaRadioButton);
		escaladaAEstrellaButtonGroup.add(aestrellaRadioButton);
		add(escaladaRadioButton);
		add(aestrellaRadioButton);
		/*
		 * BOTON SALIR
		 */
		add(setSalir(new JButton("Salir")));
		setVisible(true);
	}

	/*
	 * LISTENERS
	 */
	public void addCrearEntornoListener (ActionListener a) {
		crearEntorno.addActionListener(a);
	}

	public void addResetListener (ActionListener a) {
		reset.addActionListener(a);
	}

	public void addSalirListener (ActionListener a) {
		salir.addActionListener(a);
	}

	public void addMoverRobotListener (ActionListener a) {
		moverRobot.addActionListener(a);
	}

	public void addModoSeleccion (ActionListener a) {
		modoSeleccion.addActionListener(a);
	}

	public void addModoAleatorio (ActionListener a) {
		modoAleatorio.addActionListener(a);
	}

	public void addGenerarObjetos (ActionListener a) {
		generarObjetos.addActionListener(a);
	}

	/*
	 * METODOS DE ACCESO A ATRIBUTOS
	 */
	/**
	 * @return the crearEntorno
	 */
	public JButton getCrearEntorno () {
		return crearEntorno;
	}

	/**
	 * @param crearEntorno
	 *            the crearEntorno to set
	 */
	public JButton setCrearEntorno (JButton crearEntorno) {
		this.crearEntorno = crearEntorno;
		this.crearEntorno.setBackground(Color.LIGHT_GRAY);
		return crearEntorno;
	}

	/**
	 * @return the reset
	 */
	public JButton getReset () {
		return reset;
	}

	/**
	 * @param reset
	 *            the reset to set
	 */
	public JButton setReset (JButton reset) {
		this.reset = reset;
		this.reset.setBackground(Color.LIGHT_GRAY);
		this.reset.setEnabled(false);
		return reset;
	}
	
	/**
	 * @return the salir
	 */
	public JButton getSalir () {
		return salir;
	}

	/**
	 * @param salir
	 *            the salir to set
	 */
	public JButton setSalir (JButton salir) {
		this.salir = salir;
		this.salir.setBackground(Color.LIGHT_GRAY);
		return salir;
	}
	
	public JButton getModoSeleccion () {
		return modoSeleccion;
	}

	public JButton setModoSeleccion (JButton moverSeleccion) {
		this.modoSeleccion = moverSeleccion;
		this.modoSeleccion.setBackground(Color.LIGHT_GRAY);
		this.modoSeleccion.setEnabled(false);
		return moverSeleccion;
	}

	public JButton getModoAleatorio () {
		return modoAleatorio;
	}

	public JButton setModoAleatorio (JButton modoAleatorio) {
		this.modoAleatorio = modoAleatorio;
		this.modoAleatorio.setBackground(Color.LIGHT_GRAY);
		this.modoAleatorio.setEnabled(false);
		return modoAleatorio;
	}
	
	/**
	 * @return the moverRobot
	 */
	public JButton getMoverRobot () {
		return moverRobot;
	}

	/**
	 * @param moverRobot
	 *            the moverRobot to set
	 */
	public JButton setMoverRobot (JButton moverRobot) {
		this.moverRobot = moverRobot;
		this.moverRobot.setBackground(Color.LIGHT_GRAY);
		this.moverRobot.setEnabled(false);
		return moverRobot;
	}
	/**
	 * @return the insertarAnchoEntorno
	 */
	public JTextField getInsertarAnchoEntorno () {
		return insertarAnchoEntorno;
	}

	/**
	 * @param insertarAnchoEntorno
	 *            the insertarAnchoEntorno to set
	 */
	public JTextField setInsertarAnchoEntorno (JTextField insertarAnchoEntorno) {
		this.insertarAnchoEntorno = insertarAnchoEntorno;
		this.insertarAnchoEntorno.setHorizontalAlignment(SwingConstants.CENTER);
		return insertarAnchoEntorno;
	}

	/**
	 * @return the insertarAltoEntorno
	 */
	public JTextField getInsertarAltoEntorno () {
		return insertarAltoEntorno;
	}

	/**
	 * @param insertarAltoEntorno
	 *            the insertarAltoEntorno to set
	 */
	public JTextField setInsertarAltoEntorno (JTextField insertarAltoEntorno) {
		this.insertarAltoEntorno = insertarAltoEntorno;
		this.insertarAltoEntorno.setHorizontalAlignment(SwingConstants.CENTER);
		return insertarAltoEntorno;
	}

	/**
	 * @return the altoPanelBotones
	 */
	public int getAltoPanelBotones () {
		return altoPanelBotones;
	}

	/**
	 * @return the altoEntorno
	 */
	public JLabel getAltoEntorno () {
		return altoEntorno;
	}

	/**
	 * @param altoEntorno
	 *            the altoEntorno to set
	 */
	public JLabel setAltoEntorno (JLabel altoEntorno) {
		this.altoEntorno = altoEntorno;
		this.altoEntorno.setOpaque(true);
		this.altoEntorno.setHorizontalAlignment(SwingConstants.CENTER);
		this.altoEntorno.setBackground(Color.CYAN);
		return altoEntorno;
	}

	/**
	 * @return the anchoEntorno
	 */
	public JLabel getAnchoEntorno () {
		return anchoEntorno;
	}

	/**
	 * @param anchoEntorno
	 *            the anchoEntorno to set
	 */
	public JLabel setAnchoEntorno (JLabel anchoEntorno) {
		this.anchoEntorno = anchoEntorno;
		this.anchoEntorno.setOpaque(true);
		this.anchoEntorno.setHorizontalAlignment(SwingConstants.CENTER);
		this.anchoEntorno.setBackground(Color.CYAN);
		return anchoEntorno;
	}

	/**
	 * @return the margenInferior
	 */
	public int getMargenInferior () {
		return margenInferior;
	}

	/**
	 * @param margenInferior
	 *            the margenInferior to set
	 */
	public void setMargenInferior (int margenInferior) {
		this.margenInferior = margenInferior;
	}

	/**
	 * @return the margenSuperior
	 */
	public int getMargenSuperior () {
		return margenSuperior;
	}

	/**
	 * @param margenSuperior
	 *            the margenSuperior to set
	 */
	public void setMargenSuperior (int margenSuperior) {
		this.margenSuperior = margenSuperior;
	}

	/**
	 * @return the insertarXDestino
	 */
	public JTextField getInsertarXDestino () {
		return insertarXDestino;
	}

	/**
	 * @param insertarXDestino
	 *            the insertarXDestino to set
	 */
	public JTextField setInsertarXDestino (JTextField insertarXDestino) {
		this.insertarXDestino = insertarXDestino;
		this.insertarXDestino.setHorizontalAlignment(SwingConstants.CENTER);
		return insertarXDestino;
	}

	/**
	 * @return the insertarYDestino
	 */
	public JTextField getInsertarYDestino () {
		return insertarYDestino;
	}

	/**
	 * @param insertarYDestino
	 *            the insertarYDestino to set
	 */
	public JTextField setInsertarYDestino (JTextField insertarYDestino) {
		this.insertarYDestino = insertarYDestino;
		this.insertarYDestino.setHorizontalAlignment(SwingConstants.CENTER);
		return insertarYDestino;
	}

	/**
	 * @return the numeroObjetos
	 */
	public JLabel getNumeroObjetos () {
		return numeroObjetos;
	}

	/**
	 * @param numeroObjetos
	 *            the numeroObjetos to set
	 */
	public JLabel setNumeroObjetos (JLabel numeroObjetos) {
		this.numeroObjetos = numeroObjetos;
		this.numeroObjetos.setOpaque(true);
		this.numeroObjetos.setHorizontalAlignment(SwingConstants.CENTER);
		this.numeroObjetos.setBackground(Color.CYAN);
		return numeroObjetos;
	}

	/**
	 * @return the insertarNumeroObjetos
	 */
	public JTextField getInsertarNumeroObjetos () {
		return insertarNumeroObjetos;
	}

	/**
	 * @param insertarNumeroObjetos
	 *            the insertarNumeroObjetos to set
	 */
	public JTextField setInsertarNumeroObjetos (JTextField insertarNumeroObjetos) {
		this.insertarNumeroObjetos = insertarNumeroObjetos;
		this.insertarNumeroObjetos
				.setHorizontalAlignment(SwingConstants.CENTER);
		return insertarNumeroObjetos;
	}

	public JRadioButton getRobotRadioButton () {
		return robotRadioButton;
	}

	public JRadioButton setRobotRadioButton (JRadioButton robotRadioButton) {
		this.robotRadioButton = robotRadioButton;
		//this.robotRadioButton.setForeground(Color.WHITE);
		//this.robotRadioButton.setBackground(Color.RED);
		this.robotRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		this.robotRadioButton.setEnabled(false);
		return robotRadioButton;
	}

	public JRadioButton getObjetosRadioButton () {
		return objetosRadioButton;
	}

	public JRadioButton setObjetosRadioButton (JRadioButton objetosRadioButton) {
		this.objetosRadioButton = objetosRadioButton;
		//this.objetosRadioButton.setForeground(Color.WHITE);
		//this.objetosRadioButton.setBackground(Color.GREEN);
		this.objetosRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		this.objetosRadioButton.setEnabled(false);
		return objetosRadioButton;
	}

	public ButtonGroup getRobotObjetosButtonGroup () {
		return robotObjetosButtonGroup;
	}

	public ButtonGroup setRobotObjetosButtonGroup (
			ButtonGroup robotObjetosButtonGroup) {
		this.robotObjetosButtonGroup = robotObjetosButtonGroup;
		return this.robotObjetosButtonGroup;
	}

	public ButtonGroup getEscaladaAEstrellaButtonGroup() {
		return escaladaAEstrellaButtonGroup;
	}

	public void setEscaladaAEstrellaButtonGroup(
			ButtonGroup escaladaAEstrellaButtonGroup) {
		this.escaladaAEstrellaButtonGroup = escaladaAEstrellaButtonGroup;
	}

	public JRadioButton getEscaladaRadioButton() {
		return escaladaRadioButton;
	}

	public void setEscaladaRadioButton(JRadioButton escaladaRadioButton) {
		this.escaladaRadioButton = escaladaRadioButton;
		this.escaladaRadioButton.setEnabled(false);
		this.escaladaRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public JRadioButton getAestrellaRadioButton() {
		return aestrellaRadioButton;
	}

	public void setAestrellaRadioButton(JRadioButton aestrellaRadioButton) {
		this.aestrellaRadioButton = aestrellaRadioButton;
		this.aestrellaRadioButton.setEnabled(false);
		this.aestrellaRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
