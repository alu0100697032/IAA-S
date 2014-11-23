package Dibujables;

import java.awt.Color;
import java.awt.Dimension;
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
	private int width = screenSize.width - 100;
	private int height = screenSize.height - 100;
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
		//entornoFrame.setResizable(false);
		entornoFrame.setBounds(0, 0, width, height);
		entornoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		entornoFrame
				.add(setPanelBotones(new DibujaPanelBotones(width, height)));
		entorno.addObserver(this);
		entornoFrame.setVisible(true);
	}

	public void RellenarEntorno () {
		if (entorno.getAnchoEntorno() != 0 && entorno.getAltoEntorno() != 0) {
			entornoFrame.add(setMatriz(new DibujaMatriz(panelBotones
					.getAltoPanelBotones(), entorno.getAnchoEntorno(), entorno
					.getAltoEntorno(), width, height)));
			entornoFrame.repaint();
			entornoFrame.setVisible(true);
		}
		// System.out.println(getMatriz().getComponent(getEntorno().getPosicionEnLaMatrizRobot()).getClass().getName());
	}

	public void BorrarEntorno () {
		if (getMatriz() != null && getEntorno().getAltoEntorno() == 0
				&& getEntorno().getAnchoEntorno() == 0) {
			entornoFrame.remove(getMatriz());
			entornoFrame.repaint();
		}
	}
	
	public void RepintarRobot(){
		getMatriz().getComponent(getEntorno().getPosicionEnLaMatrizRobot()).setBackground(Color.RED);
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
	 * @param matriz
	 *            the matriz to set
	 */
	public DibujaMatriz setMatriz (DibujaMatriz matriz) {
		this.matriz = matriz;
		return matriz;
	}

}
