/**
 * 
 * AUTOR: VÍCTOR HERNÁNDEZ PÉREZ ASIGNATURA: PROGRAMACIÓN DE APLICACIONES
 * INTERACTIVAS E-MAIL: alu0100697032@ull.edu.es 20/11/2014
 * DibujaEntornoInstanciable.java BusquedaIAA
 */
package Dibujables;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		getPanelBotones().addResetListener(new ResetListener());
		getPanelBotones().addMoverRobotListener(new MoverRobotListener());
		getPanelBotones().addModoAleatorio(new ModoAleatorioListener());
		getPanelBotones().addModoSeleccion(new ModoSeleccionListener());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		RellenarEntorno();
		BorrarEntorno();
		RepintarRobot();
	}

	class CrearEntornoListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getPanelBotones().getCrearEntorno().setEnabled(false);// DESABILITAMOS
																	// EL BOTON
			getPanelBotones().getMoverRobot().setEnabled(true);// HABILITAMOS EL
																// BOTON DE
																// MOVIMIENTO
			/*
			 * MODIFICAMOS NUESTRO OBJETO ENTORNO CON LOS VALORES DE LOS CAMPOS
			 * DE TEXTO
			 */
			getEntorno().cambiarDimensionesEntorno(
					Integer.parseInt(getPanelBotones()
							.getInsertarAnchoEntorno().getText()),
					Integer.parseInt(getPanelBotones().getInsertarAltoEntorno()
							.getText()),
					Integer.parseInt(getPanelBotones()
							.getInsertarNumeroObjetos().getText()));
			// getEntorno().mostrarMatrizVirtual();
			getPanelBotones().getReset().setEnabled(true);
			getPanelBotones().getModoAleatorio().setEnabled(true);
			getPanelBotones().getModoSeleccion().setEnabled(true);
		}
	}

	class ResetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getEntorno().setPosicionRobotCero();
			getEntorno().cambiarDimensionesEntorno(0, 0, 0);
			getPanelBotones().getCrearEntorno().setEnabled(true);
			getPanelBotones().getMoverRobot().setEnabled(false);
		}
	}

	class MoverRobotListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getPanelBotones().getMoverRobot().setEnabled(false);
			getEntorno().setPosicionDestinoRobot(
					new Point(Integer.parseInt(getPanelBotones()
							.getInsertarXDestino().getText()), Integer
							.parseInt(getPanelBotones().getInsertarYDestino()
									.getText())));
			try {
				getEntorno().moverRobot();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class ModoAleatorioListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getPanelBotones().getModoAleatorio().setEnabled(false);
			getPanelBotones().getModoSeleccion().setEnabled(false);
			getMatriz().DibujaObstaculos(getEntorno());
		}
	}

	/*
	 * MOUSE LISTENERS
	 */
	class ModoSeleccionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getPanelBotones().getModoAleatorio().setEnabled(false);
			getPanelBotones().getModoSeleccion().setEnabled(false);
			getPanelBotones().getRobotRadioButton().setEnabled(true);
			getPanelBotones().getObjetosRadioButton().setEnabled(true);
			getMatriz().addSituarRobot(new SituarRobotListener());
		}
	}

	class SituarRobotListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (getPanelBotones().getRobotRadioButton().isSelected() == true) {
				/*
				 * getMatriz().getComponentAt(
				 * MouseInfo.getPointerInfo().getLocation())
				 * .setBackground(Color.RED);
				 */
				getEntorno().getRobot1().setPuntoActual(
						new Point(getMatriz().getComponentAt(
								MouseInfo.getPointerInfo().getLocation())
								.getX(), getMatriz().getComponentAt(
								MouseInfo.getPointerInfo().getLocation())
								.getY()));
			} else if (getPanelBotones().getObjetosRadioButton().isSelected() == true
					&& getEntorno().getNumeroObjetos() >= getEntorno()
							.getNumeroObjetosColocados()) {
				getMatriz().getComponentAt(
						MouseInfo.getPointerInfo().getLocation())
						.setBackground(Color.GREEN);
				getEntorno().setNumeroObjetosColocados(
						getEntorno().getNumeroObjetosColocados() + 1);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}
}
