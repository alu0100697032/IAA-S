package Dibujables;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class DibujaCelda extends JLabel{
	
	private int posicionCeldaX;
	private int posicionCeldaY;
	
	public DibujaCelda(Color color, int x, int y){
		setPosicionCeldaX(x);
		setPosicionCeldaY(y);
		setOpaque(true);
		setBackground(color);
		setVisible(true);
	}

	/**
	 * @return the posicionCeldaY
	 */
	public int getPosicionCeldaY () {
		return posicionCeldaY;
	}

	/**
	 * @param posicionCeldaY the posicionCeldaY to set
	 */
	public void setPosicionCeldaY (int posicionCeldaY) {
		this.posicionCeldaY = posicionCeldaY;
	}

	/**
	 * @return the posicionCeldaX
	 */
	public int getPosicionCeldaX () {
		return posicionCeldaX;
	}

	/**
	 * @param posicionCeldaX the posicionCeldaX to set
	 */
	public void setPosicionCeldaX (int posicionCeldaX) {
		this.posicionCeldaX = posicionCeldaX;
	}
}
