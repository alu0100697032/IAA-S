package Dibujables;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import clases.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DibujaEntorno extends JPanel implements Observer {

	/*
	 * ATRIBUTOS
	 */
	private Entorno entorno;

	public DibujaEntorno(Entorno ent) {
		setEntorno(ent);
		setLayout(new GridLayout(entorno.getLargoEntorno(),
				entorno.getAnchoEntorno(), 5, 5));
		setBackground(Color.BLACK);
		setVisible(true);
	}

	public void RellenarEntorno() {
		for (int i = 0; i < getEntorno().getNumeroCasillas(); i++) {
			add(new DibujaCelda());
		}
	}

	public Entorno getEntorno() {
		return entorno;
	}

	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
