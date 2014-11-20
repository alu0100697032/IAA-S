package Dibujables;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observer;

import clases.*;

import javax.swing.JFrame;

abstract class DibujaEntorno implements Observer {

	/*
	 * ATRIBUTOS
	 */
	private Entorno entorno;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = screenSize.width;
	private int height = screenSize.height;
	private JFrame entornoFrame;
	private DibujaPanelBotones panelBotones;
	private DibujaMatriz matriz;

	/*
	 * CONSTRUCTOR
	 */
	public DibujaEntorno(Entorno ent) {
		setEntorno(ent);
		entornoFrame = new JFrame("Entorno");
		entornoFrame.setLayout(null);
		entornoFrame.setBounds(0, 0, width, height);
		entornoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		entornoFrame
				.add(setPanelBotones(new DibujaPanelBotones(width, height)));
		entorno.addObserver(this);
		entornoFrame.setVisible(true);
	}

	public void RellenarEntorno () {
		entornoFrame.add(
				setMatriz(new DibujaMatriz(panelBotones.getAltoPanelBotones(),
						entorno.getAnchoEntorno(), entorno.getAltoEntorno(),
				width, height)));
		entornoFrame.repaint();
		entornoFrame.setVisible(true);
	}

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
	 * @param matriz the matriz to set
	 */
	public DibujaMatriz setMatriz (DibujaMatriz matriz) {
		this.matriz = matriz;
		return matriz;
	}

}
