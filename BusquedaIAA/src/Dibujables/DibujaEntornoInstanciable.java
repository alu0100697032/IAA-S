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
		getPanelBotones().addSalirListener(new SalirListener());
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
			
			getPanelBotones().getCrearEntorno().setEnabled(false);
			getPanelBotones().getReset().setEnabled(true);
			getPanelBotones().getModoAleatorio().setEnabled(true);
			getPanelBotones().getModoSeleccion().setEnabled(true);
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
		}
	}
	/*
	 * RESETEA EL ENTORNO
	 */
	class ResetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getEntorno().setPosicionRobotCero();
			getEntorno().setNumeroObjetosColocados(0);
			getEntorno().cambiarDimensionesEntorno(0, 0, 0);
			
			getPanelBotones().getCrearEntorno().setEnabled(true);
			getPanelBotones().getMoverRobot().setEnabled(false);
			getPanelBotones().getModoAleatorio().setEnabled(false);
			getPanelBotones().getModoSeleccion().setEnabled(false);
			getPanelBotones().getRobotRadioButton().setEnabled(false);
			getPanelBotones().getObjetosRadioButton().setEnabled(false);
			getPanelBotones().getEscaladaRadioButton().setEnabled(false);
			getPanelBotones().getAestrellaRadioButton().setEnabled(false);
		}
	}
	/*
	 * SALE DEL PROGRAMA
	 */
	class SalirListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	/*
	 * EL ROBOT SE MUEVE DEPENDIENDO DEL ALGORITMO DE BÚSQUEDA SELECCIONADO
	 */
	class MoverRobotListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (getPanelBotones().getEscaladaRadioButton().isSelected() == true) {
				//FIJAR LA BUSQUEDA EN ESCALADA
				getEntorno().setMovimiento(false);
				/*
				 * QUITAR FOCUS A LA SELECCION DE ALGORITMO
				 */
				getPanelBotones().getMoverRobot().setEnabled(false);
				getPanelBotones().getEscaladaRadioButton().setEnabled(false);
				getPanelBotones().getAestrellaRadioButton().setEnabled(false);
				getPanelBotones().getEscaladaRadioButton().setBackground(getPanelBotones().getBackground());
				getPanelBotones().getAestrellaRadioButton().setBackground(getPanelBotones().getBackground());
				//FIJAR POSICION DE DESTINO
				getEntorno().setPosicionDestinoRobot(
						new Point(Integer.parseInt(getPanelBotones()
								.getInsertarXDestino().getText()), Integer
								.parseInt(getPanelBotones()
										.getInsertarYDestino().getText())));
				try {
					// getEntorno().mostrarMatrizVirtual();
					getEntorno().moverRobot();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (getPanelBotones().getAestrellaRadioButton().isSelected() == true) {
				//FIJAR LA BUSQUEDA EN A*
				getEntorno().setMovimiento(true);
				/*
				 * QUITAR FOCUS A LA SELECCION DE ALGORITMO
				 */
				getPanelBotones().getMoverRobot().setEnabled(false);
				getPanelBotones().getEscaladaRadioButton().setEnabled(false);
				getPanelBotones().getAestrellaRadioButton().setEnabled(false);
				getPanelBotones().getEscaladaRadioButton().setBackground(getPanelBotones().getBackground());
				getPanelBotones().getAestrellaRadioButton().setBackground(getPanelBotones().getBackground());
				//FIJAR POSICION DE DESTINO
				getEntorno().setPosicionDestinoRobot(
						new Point(Integer.parseInt(getPanelBotones()
								.getInsertarXDestino().getText()), Integer
								.parseInt(getPanelBotones()
										.getInsertarYDestino().getText())));
				try {
					// getEntorno().mostrarMatrizVirtual();
					getEntorno().moverRobot();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	/*
	 * EL PROGRAMA CREA ALEATORIAMENTE EL ENTORNO
	 */
	class ModoAleatorioListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getPanelBotones().getModoAleatorio().setEnabled(false);
			getPanelBotones().getModoSeleccion().setEnabled(false);
			getPanelBotones().getMoverRobot().setEnabled(true);
			getPanelBotones().getEscaladaRadioButton().setEnabled(true);
			getPanelBotones().getAestrellaRadioButton().setEnabled(true);
			/*
			 * FOCUSEAR SELECCION DE ALGORITMOS
			 */
			getPanelBotones().getEscaladaRadioButton().setBackground(Color.RED);
			getPanelBotones().getAestrellaRadioButton().setBackground(Color.RED);
			
			getEntorno().colocarRobotAleatorio();
			getEntorno().generarObstaculosAleatorio();
			getMatriz().DibujaObstaculos(getEntorno());
			//getEntorno().mostrarMatrizVirtual();
		}
	}
	/*
	 * EL PROGRAMA ENTRA EN MODO SELECCION, EL USUARIO CREA EL ENTORNO 
	 */
	class ModoSeleccionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getPanelBotones().getModoAleatorio().setEnabled(false);
			getPanelBotones().getModoSeleccion().setEnabled(false);
			getPanelBotones().getRobotRadioButton().setEnabled(true);
			getPanelBotones().getObjetosRadioButton().setEnabled(true);
			getMatriz().addSituarRobot(new SituarRobotListener());
			// getEntorno().mostrarMatrizVirtual();
		}
	}

	/*
	 * PERMITE SITUAR AL ROBOT Y A LOS OBSTACULOS HACIENDO CLICK EN LA PANTALLA
	 */
	class SituarRobotListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

			// SI EL RADIOBUTTON DEL ROBOT ESTA SELECCIONADO Y LO QUE SE CLICA
			// ES UNA CELDA...
			if (getPanelBotones().getRobotRadioButton().isSelected() == true
					&& getMatriz().getComponentAt(
							MouseInfo.getPointerInfo().getLocation())
							.getClass() == DibujaCelda.class) {

				getEntorno().getRobot1().setPuntoAnterior(
						getEntorno().getRobot1().getPuntoActual());
				getEntorno().getRobot1().setPuntoActual(
						new Point(((DibujaCelda) getMatriz().getComponentAt(
								MouseInfo.getPointerInfo().getLocation()))
								.getPosicionCeldaX(),
								((DibujaCelda) getMatriz().getComponentAt(
										MouseInfo.getPointerInfo()
												.getLocation()))
										.getPosicionCeldaY()));

				// SI EL RADIOBUTTON DE LOS OBJETOS ESTA SELECCIONADO, NO SE HAN
				// COLOCADO TODOS LOS OBJETOS Y LO QUE SE CLICA ES UNA CELDA...
			} else if (getPanelBotones().getObjetosRadioButton().isSelected() == true
					&& getEntorno().getNumeroObjetos() > getEntorno()
							.getNumeroObjetosColocados()
					&& getMatriz().getComponentAt(
							MouseInfo.getPointerInfo().getLocation())
							.getClass() == DibujaCelda.class) {

				getEntorno().colocarObstaculo(
						new Point(((DibujaCelda) getMatriz().getComponentAt(
								MouseInfo.getPointerInfo().getLocation()))
								.getPosicionCeldaX(),
								((DibujaCelda) getMatriz().getComponentAt(
										MouseInfo.getPointerInfo()
												.getLocation()))
										.getPosicionCeldaY()));
				RepintarObjetos();
			} else {
				getPanelBotones().getRobotRadioButton().setEnabled(false);
				getPanelBotones().getObjetosRadioButton().setEnabled(false);
				getPanelBotones().getMoverRobot().setEnabled(true);
				getPanelBotones().getEscaladaRadioButton().setEnabled(true);
				getPanelBotones().getAestrellaRadioButton().setEnabled(true);
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
