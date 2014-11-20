/**
 * 
 * AUTOR: VÍCTOR HERNÁNDEZ PÉREZ ASIGNATURA: PROGRAMACIÓN DE APLICACIONES
 * INTERACTIVAS E-MAIL: alu0100697032@ull.edu.es 20/11/2014 DibujaMatriz.java
 * BusquedaIAA
 */
package Dibujables;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * @author Victor
 * 
 */
@SuppressWarnings("serial")
public class DibujaMatriz extends JPanel {

	public DibujaMatriz(int anchoPanelBotones, int anchoEntorno,
			int altoEntorno, int anchoVentana, int altoVentana) {

		setLayout(new GridLayout(anchoEntorno, altoEntorno, 5, 5));
		setBackground(Color.BLACK);
		setBounds(0, 0, anchoVentana, altoVentana - 100);
		for (int i = 0; i < anchoEntorno * altoEntorno; i++) {
			if(i == 0)
				add(new DibujaRobot());
			else
				add(new DibujaCelda());
		}
	}
}
