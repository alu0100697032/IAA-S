/**
 * 
 * AUTOR: VÍCTOR HERNÁNDEZ PÉREZ
 * ASIGNATURA: PROGRAMACIÓN DE APLICACIONES INTERACTIVAS
 * E-MAIL: alu0100697032@ull.edu.es
 * 20/11/2014
 * DibujaRobot.java
 * BusquedaIAA
 */
package Dibujables;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Victor
 *
 */
@SuppressWarnings("serial")
public class DibujaRobot extends JLabel{
	
	public DibujaRobot(){
		setOpaque(true);
		setBackground(Color.RED);
		setVisible(true);
	}
}
