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

	/*
	 * CONSTRUCTOR
	 */
	public Entorno() {
		robot1 = new Robot();
	}

	public void cambiarDimensionesEntorno (int alto, int ancho,
			int numeroObjetos) {
		setAltoEntorno(alto);
		setAnchoEntorno(ancho);
		setNumeroObjetos(numeroObjetos);
		setNumeroObjetosColocados(0);
		setNumeroCasillas(ancho * alto);
		DibujoEntorno = new int[ancho][alto];
		for (int i = 0; i < ancho; i++)
			for (int j = 0; j < alto; j++)
				DibujoEntorno[i][j] = 0;
		if (DibujoEntorno.length != 0)
			DibujoEntorno[(int) robot1.getPuntoActual().getX()][(int) robot1
					.getPuntoActual().getY()] = 2;
		setChanged();
		notifyObservers();
	}

	/*
	 * OBSTACULOS
	 */
	public void generarObstaculosAleatorio () {
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

	public void colocarObstaculo (Point puntoObstaculo) {
		setPosicionUltimoObjetoPintado(puntoObstaculo.x + (puntoObstaculo.y * altoEntorno));
		DibujoEntorno[puntoObstaculo.x][puntoObstaculo.y] = 1;
		numeroObjetosColocados++;
		setChanged();
		notifyObservers();
	}

	/*
	 * ROBOT
	 */
	public void colocarRobotAleatorio () {
		getRobot1().setPuntoActual(
				new Point((int) Math.floor(Math.random() * (altoEntorno - 1)),
						(int) Math.floor(Math.random() * (anchoEntorno - 1))));
		DibujoEntorno[getRobot1().getPuntoActual().x][getRobot1().getPuntoActual().y] = 2;
		getRobot1().setPuntoAnterior(getRobot1().getPuntoActual());
	}

	public int getPosicionActualRobot () {
		return (int) (getRobot1().getPuntoActual().getX() + getRobot1()
				.getPuntoActual().getY() * altoEntorno);
	}

	public int getPosicionAnteriorRobot () {
		return (int) (getRobot1().getPuntoAnterior().getX() + getRobot1()
				.getPuntoAnterior().getY() * altoEntorno);
	}

	public void setPosicionRobotCero () {
		robot1.setPuntoActual(new Point(0, 0));
		robot1.setPuntoAnterior(new Point(0, 0));
	}

	public void setPosicionDestinoRobot (Point puntoDestino) {
		robot1.setPuntoDestino(puntoDestino);
	}

	/*
	 * MOVIMIENTO
	 */
	public void moverRobot () throws InterruptedException {
		new Thread(this).start();
	}

	public void Moverse () {
		getRobot1().setAnchoMapa(getAltoEntorno());
		getRobot1().setAltoMapa(getAnchoEntorno());
		getRobot1().setMapa(new boolean[getAnchoEntorno()][getAltoEntorno()]);
		while (robot1.getPuntoActual().equals(robot1.getPuntoDestino()) == false) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//robot1.actualizarMapa();
			robot1.setPuntoAnterior(robot1.getPuntoActual());
			DibujoEntorno[(int) robot1.getPuntoAnterior().getY()][(int) robot1
					.getPuntoAnterior().getX()] = 0;
			actualizarSensores();
			robot1.seleccionMovimiento();
			DibujoEntorno[(int) robot1.getPuntoActual().getY()][(int) robot1
					.getPuntoActual().getX()] = 2;
		}
	}

	public void actualizarSensores () {
		if ((int) robot1.getPuntoActual().getY() - 1 < 0
				|| DibujoEntorno[(int) robot1.getPuntoActual().getY() - 1][(int) robot1
						.getPuntoActual().getX()] == 1)
			robot1.setSensorArriba(true);
		else {
			robot1.setSensorArriba(false);
		}
		if ((int) robot1.getPuntoActual().getY() + 1 > altoEntorno
				|| DibujoEntorno[(int) robot1.getPuntoActual().getY() + 1][(int) robot1
						.getPuntoActual().getX()] == 1)
			robot1.setSensorAbajo(true);
		else {
			robot1.setSensorAbajo(false);
		}
		if ((int) robot1.getPuntoActual().getX() - 1 < 0
				|| DibujoEntorno[(int) robot1.getPuntoActual().getY()][(int) robot1
						.getPuntoActual().getX() - 1] == 1)
			robot1.setSensorIzquierda(true);
		else {
			robot1.setSensorIzquierda(false);
		}
		if ((int) robot1.getPuntoActual().getX() + 1 > anchoEntorno
				|| DibujoEntorno[(int) robot1.getPuntoActual().getY()][(int) robot1
						.getPuntoActual().getX() + 1] == 1)
			robot1.setSensorDerecha(true);
		else {
			robot1.setSensorDerecha(false);
		}
	}

	@Override
	public void run () {
		// TODO Auto-generated method stub
		Moverse();
	}

	/*
	 * METODOS DE ACCESO A LOS ATRIBUTOS
	 */
	public int getAnchoEntorno () {
		return anchoEntorno;
	}

	public void setAnchoEntorno (int anchoEntorno) {
		this.anchoEntorno = anchoEntorno;
	}

	public int[][] getDibujoEntorno () {
		return DibujoEntorno;
	}

	public void setDibujoEntorno (int[][] dibujoEntorno) {
		DibujoEntorno = dibujoEntorno;
	}

	public Robot getRobot1 () {
		return robot1;
	}

	public void setRobot1 (Robot robot1) {
		this.robot1 = robot1;
	}

	public int getNumeroObjetos () {
		return numeroObjetos;
	}

	public void setNumeroObjetos (int numeroObjetos) {
		this.numeroObjetos = numeroObjetos;
	}

	public int getNumeroCasillas () {
		return numeroCasillas;
	}

	public void setNumeroCasillas (int numeroCasillas) {
		this.numeroCasillas = numeroCasillas;
	}

	/**
	 * @return the altoEntorno
	 */
	public int getAltoEntorno () {
		return altoEntorno;
	}

	/**
	 * @param altoEntorno
	 *            the altoEntorno to set
	 */
	public void setAltoEntorno (int altoEntorno) {
		this.altoEntorno = altoEntorno;
	}

	public int getNumeroObjetosColocados () {
		return numeroObjetosColocados;
	}

	public void setNumeroObjetosColocados (int numeroObjetosColocados) {
		this.numeroObjetosColocados = numeroObjetosColocados;
	}

	/**
	 * @return the posicionUltimoObjetoPintado
	 */
	public int getPosicionUltimoObjetoPintado () {
		return posicionUltimoObjetoPintado;
	}

	/**
	 * @param posicionUltimoObjetoPintado
	 *            the posicionUltimoObjetoPintado to set
	 */
	public void setPosicionUltimoObjetoPintado (int posicionUltimoObjetoPintado) {
		this.posicionUltimoObjetoPintado = posicionUltimoObjetoPintado;
	}
}

/*
 * public void mostrarMatrizVirtual () { for (int i = 0; i < anchoEntorno; i++)
 * { for (int j = 0; j < altoEntorno; j++)
 * System.out.print(DibujoEntorno[i][j]); System.out.println(); } }
 */