package Dibujables;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.Observer;

import javax.swing.JFrame;

import clases.Entorno;

abstract class DibujaEntorno implements Observer {

	/*
	 * ATRIBUTOS
	 */
	private Entorno entorno;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = screenSize.width;
	private int height = screenSize.height-50;
	private int margenFrame = 25;
	private JFrame entornoFrame;
	private DibujaPanelBotones panelBotones;
	private DibujaMatriz matriz;
	private Boolean MatrizRellena;
	static GraphicsDevice device = GraphicsEnvironment
			.getLocalGraphicsEnvironment().getScreenDevices()[0];

	/*
	 * CONSTRUCTOR
	 */
	public DibujaEntorno(Entorno ent) {
		setEntorno(ent);
		MatrizRellena = false;
		entornoFrame = new JFrame("Entorno");
		entornoFrame.setLayout(null);
		entornoFrame.setResizable(false);
		entornoFrame.setUndecorated(true);
		entornoFrame.setBounds(0, 0, width, height);
		//device.setFullScreenWindow(entornoFrame);
		entornoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		entornoFrame
				.add(setPanelBotones(new DibujaPanelBotones(width, height)));
		entorno.addObserver(this);
		entorno.getRobot1().addObserver(this);
		entornoFrame.setVisible(true);
	}

	public void RellenarEntorno () {
		if (entorno.getAnchoEntorno() != 0 && entorno.getAltoEntorno() != 0
				&& entorno.getDibujoEntorno().length != 0
				&& MatrizRellena == false) {
			entornoFrame.add(setMatriz(new DibujaMatriz(panelBotones
					.getAltoPanelBotones(), entorno, width, height)));
			entornoFrame.repaint();
			entornoFrame.setVisible(true);
			MatrizRellena = true;
		}
	}

	public void BorrarEntorno () {
		if (entorno.getDibujoEntorno().length == 0
				&& getEntorno().getAltoEntorno() == 0
				&& getEntorno().getAnchoEntorno() == 0) {
			entornoFrame.remove(getMatriz());
			entornoFrame.repaint();
			MatrizRellena = false;
		}
	}

	public void RepintarRobot () {
		if (getEntorno().getPosicionAnteriorRobot() != getEntorno()
				.getPosicionActualRobot()) {
			getMatriz().getComponent(getEntorno().getPosicionAnteriorRobot())
					.setBackground(Color.WHITE);
			getMatriz().getComponent(getEntorno().getPosicionActualRobot())
					.setBackground(Color.RED);
			getMatriz().repaint();
			getMatriz().setVisible(true);
		}
	}

	public void RepintarObjetos () {
		getMatriz().getComponent(getEntorno().getPosicionUltimoObjetoPintado())
				.setBackground(Color.GREEN);
	}

	/*
	 * METODO DE ACCESO A LOS ATRIBUTOS
	 */
	public Entorno getEntorno () {
		return entorno;
	}

	public void setEntorno (Entorno entorno) {
		this.entorno = entorno;
	}

	/**
	 * @return the panelBotones
	 */
	public DibujaPanelBotones getPanelBotones () {
		return panelBotones;
	}

	/**
	 * @param panelBotones
	 *            the panelBotones to set
	 */
	public DibujaPanelBotones setPanelBotones (DibujaPanelBotones panelBotones) {
		this.panelBotones = panelBotones;
		return panelBotones;
	}

	/**
	 * @return the matriz
	 */
	public DibujaMatriz getMatriz () {
		return matriz;
	}

	/**
	 * @param matriz
	 *            the matriz to set
	 */
	public DibujaMatriz setMatriz (DibujaMatriz matriz) {
		this.matriz = matriz;
		return matriz;
	}

	public Boolean getMatrizRellena () {
		return MatrizRellena;
	}

	public void setMatrizRellena (Boolean matrizRellena) {
		MatrizRellena = matrizRellena;
	}

	/**
	 * @return the margenFrame
	 */
	public int getMargenFrame () {
		return margenFrame;
	}

	/**
	 * @param margenFrame
	 *            the margenFrame to set
	 */
	public void setMargenFrame (int margenFrame) {
		this.margenFrame = margenFrame;
	}

	/**
	 * @return the entornoFrame
	 */
	public JFrame getEntornoFrame () {
		return entornoFrame;
	}

	/**
	 * @param entornoFrame
	 *            the entornoFrame to set
	 */
	public void setEntornoFrame (JFrame entornoFrame) {
		this.entornoFrame = entornoFrame;
	}

	/**
	 * @return the height
	 */
	public int getHeight () {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight (int height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public int getWidth () {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth (int width) {
		this.width = width;
	}

}
