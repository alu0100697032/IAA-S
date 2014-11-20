/**
 * 
 * AUTOR: VÍCTOR HERNÁNDEZ PÉREZ ASIGNATURA: PROGRAMACIÓN DE APLICACIONES
 * INTERACTIVAS E-MAIL: alu0100697032@ull.edu.es 20/11/2014
 * DibujaEntornoInstanciable.java BusquedaIAA
 */
package Dibujables;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import clases.Entorno;

/**
 * @author Victor
 * 
 */
public class DibujaEntornoInstanciable extends DibujaEntorno {

	public DibujaEntornoInstanciable(Entorno ent) {
		super(ent);
		// TODO Auto-generated constructor stub
		getPanelBotones().addCrearEntornoListener(new CrearEntornoListener());
	}

	@Override
	public void update (Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		RellenarEntorno();
	}

	class CrearEntornoListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			getPanelBotones().getCrearEntorno().setEnabled(false);// DESABILITAMOS
																	// EL BOTON
			/*
			 * MODIFICAMOS NUESTRO OBJETO ENTORNO CON LOS VALORES DE LOS CAMPOS
			 * DE TEXTO
			 */
			getEntorno().cambiarDimensionesEntorno(
					Integer.parseInt(getPanelBotones()
							.getInsertarAnchoEntorno().getText()),
					Integer.parseInt(getPanelBotones().getInsertarAltoEntorno()
							.getText()));
		}
	}
}
