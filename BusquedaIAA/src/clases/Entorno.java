package clases;

import java.awt.Point;
import java.util.Observable;

public class Entorno extends Observable implements Runnable {
	/*
	 * ATRIBUTOS
	 */
	private int anchoEntorno;
	private int altoEntorno;
	private int numeroObjetos;
	private int numeroObjetosColocados;
	private int numeroCasillas;
	private int[][] DibujoEntorno;
	private Robot robot1;
	private int posicionUltimoObjetoPintado;
	private boolean movimiento;// FALSE ESCALADA/TRUE AESTRELLA
	private boolean robotColocado = false;

	/*
	 * CONSTRUCTOR
	 */
	public Entorno() {
		robot1 = new Robot();
	}

	public void cambiarDimensionesEntorno(int alto, int ancho, int numeroObjetos) {
		setAltoEntorno(alto);
		setAnchoEntorno(ancho);
		setNumeroObjetos(numeroObjetos);
		setNumeroObjetosColocados(0);
		setNumeroCasillas(ancho * alto);
		DibujoEntorno = new int[ancho][alto];
		for (int i = 0; i < ancho; i++)
			for (int j = 0; j < alto; j++)
				DibujoEntorno[i][j] = 0;
		setChanged();
		notifyObservers();
	}

	/*
	 * OBSTACULOS
	 */
	public void generarObstaculosAleatorio() {
		int randomAncho;
		int randomAlto;
		for (int i = 0; i < numeroObjetos; i++) {
			randomAncho = (int) Math.floor(Math.random() * (anchoEntorno - 1));
			randomAlto = (int) Math.floor(Math.random() * (altoEntorno - 1));
			if (DibujoEntorno[randomAncho][randomAlto] == 1
					|| DibujoEntorno[randomAncho][randomAlto] == 2)
				numeroObjetos++;
			else
				DibujoEntorno[randomAncho][randomAlto] = 1;
		}
	}

	public void colocarObstaculo(Point puntoObstaculo) {
		setPosicionUltimoObjetoPintado(puntoObstaculo.x * anchoEntorno
				+ (puntoObstaculo.y));
		DibujoEntorno[puntoObstaculo.x][puntoObstaculo.y] = 1;
		numeroObjetosColocados++;
		setChanged();
		notifyObservers();
	}

	/*
	 * ROBOT
	 */
	public void colocarRobotAleatorio() {
		getRobot1().setPuntoActual(
				new Point((int) Math.floor(Math.random() * (anchoEntorno - 1)),
						(int) Math.floor(Math.random() * (altoEntorno - 1))));
		getRobot1().setPuntoAnterior(null);
		DibujoEntorno[(int) getRobot1().getPuntoActual().getX()][(int) getRobot1()
				.getPuntoActual().getY()] = 2;
		setRobotColocado(true);
	}

	public int getPosicionActualRobot() {
		return (int) (getRobot1().getPuntoActual().getX() * anchoEntorno + getRobot1()
				.getPuntoActual().y);
	}

	public int getPosicionAnteriorRobot() {
		if(getRobot1().getPuntoAnterior()!=null)
			return (int) (getRobot1().getPuntoAnterior().getX() * anchoEntorno + getRobot1()
				.getPuntoAnterior().getY());
		else 
			return -1;
	}

	public void setPosicionRobotNulo() {
		robot1.setPuntoActual(null);
		robot1.setPuntoAnterior(null);
		setRobotColocado(false);
	}

	public void setPosicionDestinoRobot(Point puntoDestino) {
		robot1.setPuntoDestino(puntoDestino);
	}

	/*
	 * MOVIMIENTO
	 */

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Moverse();
	}

	public void moverRobot() throws InterruptedException {
		new Thread(this).start();
	}

	public void Moverse() {
		if (movimiento == false) {
			// ESCALADA
			getRobot1().inicializarMapa(getAnchoEntorno(), getAltoEntorno());
			while (robot1.getPuntoActual().equals(robot1.getPuntoDestino()) == false
					&& robot1.getPararMovimiento() == false) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				robot1.setPuntoAnterior(robot1.getPuntoActual());
				DibujoEntorno[(int) robot1.getPuntoAnterior().getX()][(int) robot1
						.getPuntoAnterior().getY()] = 0;

				actualizarSensores();
				robot1.seleccionMovimiento();

				DibujoEntorno[(int) robot1.getPuntoActual().getX()][(int) robot1
						.getPuntoActual().getY()] = 2;
			}
		} else {
			// AESTRELLA
			getRobot1().inicializarMapaDistancias(DibujoEntorno, getAnchoEntorno(), getAltoEntorno());
			while (robot1.getPuntoActual().equals(robot1.getPuntoDestino()) == false
					&& robot1.getPararMovimiento() == false) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				robot1.setPuntoAnterior(robot1.getPuntoActual());
				DibujoEntorno[(int) robot1.getPuntoAnterior().getX()][(int) robot1
						.getPuntoAnterior().getY()] = 0;
				//METODOS DEL ALGORITMO AESTRELLA
				getRobot1().aEstrella();
				
				DibujoEntorno[(int) robot1.getPuntoActual().getX()][(int) robot1
						.getPuntoActual().getY()] = 2;
			}
		}
		// System.out.println("Robot parado");
	}

	// TRUE SE PUEDE MOVER FALSE NO SE PUEDE MOVER
	public void actualizarSensores() {
		if ((int) robot1.getPuntoActual().getY() - 1 < 0)
			robot1.setSensorArriba(false);
		else if (DibujoEntorno[(int) robot1.getPuntoActual().getX()][(int) robot1
				.getPuntoActual().getY() - 1] == 1)
			robot1.setSensorArriba(false);
		else
			robot1.setSensorArriba(true);
		if ((int) robot1.getPuntoActual().getY() + 1 > altoEntorno - 1)
			robot1.setSensorAbajo(false);
		else if (DibujoEntorno[(int) robot1.getPuntoActual().getX()][(int) robot1
				.getPuntoActual().getY() + 1] == 1)
			robot1.setSensorAbajo(false);
		else
			robot1.setSensorAbajo(true);
		if ((int) robot1.getPuntoActual().getX() - 1 < 0)
			robot1.setSensorIzquierda(false);
		else if (DibujoEntorno[(int) robot1.getPuntoActual().getX() - 1][(int) robot1
				.getPuntoActual().getY()] == 1) {
			robot1.setSensorIzquierda(false);
		} else
			robot1.setSensorIzquierda(true);
		if ((int) robot1.getPuntoActual().getX() + 1 > anchoEntorno - 1)
			robot1.setSensorDerecha(false);
		else if (DibujoEntorno[(int) robot1.getPuntoActual().getX() + 1][(int) robot1
				.getPuntoActual().getY()] == 1)
			robot1.setSensorDerecha(false);
		else
			robot1.setSensorDerecha(true);
	}

	public void mostrarMatrizVirtual() {
		for (int i = 0; i < anchoEntorno; i++) {
			for (int j = 0; j < altoEntorno; j++)
				System.out.print(DibujoEntorno[i][j]);
			System.out.println();
		}
		System.out.println();
	}
	/*
	 * METODOS DE ACCESO A LOS ATRIBUTOS
	 */
	public int getAnchoEntorno() {
		return anchoEntorno;
	}

	public void setAnchoEntorno(int anchoEntorno) {
		this.anchoEntorno = anchoEntorno;
	}

	public int[][] getDibujoEntorno() {
		return DibujoEntorno;
	}

	public void setDibujoEntorno(int[][] dibujoEntorno) {
		DibujoEntorno = dibujoEntorno;
	}

	public Robot getRobot1() {
		return robot1;
	}

	public void setRobot1(Robot robot1) {
		this.robot1 = robot1;
	}

	public int getNumeroObjetos() {
		return numeroObjetos;
	}

	public void setNumeroObjetos(int numeroObjetos) {
		this.numeroObjetos = numeroObjetos;
	}

	public int getNumeroCasillas() {
		return numeroCasillas;
	}

	public void setNumeroCasillas(int numeroCasillas) {
		this.numeroCasillas = numeroCasillas;
	}

	/**
	 * @return the altoEntorno
	 */
	public int getAltoEntorno() {
		return altoEntorno;
	}

	/**
	 * @param altoEntorno
	 *            the altoEntorno to set
	 */
	public void setAltoEntorno(int altoEntorno) {
		this.altoEntorno = altoEntorno;
	}

	public int getNumeroObjetosColocados() {
		return numeroObjetosColocados;
	}

	public void setNumeroObjetosColocados(int numeroObjetosColocados) {
		this.numeroObjetosColocados = numeroObjetosColocados;
	}

	/**
	 * @return the posicionUltimoObjetoPintado
	 */
	public int getPosicionUltimoObjetoPintado() {
		return posicionUltimoObjetoPintado;
	}

	/**
	 * @param posicionUltimoObjetoPintado
	 *            the posicionUltimoObjetoPintado to set
	 */
	public void setPosicionUltimoObjetoPintado(int posicionUltimoObjetoPintado) {
		this.posicionUltimoObjetoPintado = posicionUltimoObjetoPintado;
	}

	public boolean isMovimiento() {
		return movimiento;
	}

	public void setMovimiento(boolean movimiento) {
		this.movimiento = movimiento;
	}

	public boolean isRobotColocado() {
		return robotColocado;
	}

	public void setRobotColocado(boolean robotColocado) {
		this.robotColocado = robotColocado;
	}
}