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

import clases.Entorno;

/**
 * @author Victor
 * 
 */
@SuppressWarnings("serial")
public class DibujaMatriz extends JPanel {

	public DibujaMatriz(int anchoPanelBotones, Entorno entorno,
			int anchoVentana, int altoVentana) {

		removeAll();
		setLayout(new GridLayout(entorno.getAnchoEntorno(), entorno.getAltoEntorno(), 1, 1));
		setBackground(Color.BLACK);
		setBounds(0, 0, anchoVentana, altoVentana - 100);
		for (int i = 0; i < entorno.getDibujoEntorno().length; i++) {
			if(entorno.getDibujoEntorno()[i] == 0)
				add(new DibujaCelda(Color.WHITE));
			else if(entorno.getDibujoEntorno()[i] == 1)
				add(new DibujaCelda(Color.GREEN));
		}
	}
}
