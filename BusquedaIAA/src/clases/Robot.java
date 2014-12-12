package clases;

import java.awt.Point;
import java.util.Observable;

public class Robot extends Observable {

	/*
	 * ATRIBUTOS
	 */
	private Point puntoActual;
	private Point puntoAnterior;
	private Point puntoDestino;

	private boolean sensorArriba;
	private boolean sensorAbajo;
	private boolean sensorDerecha;
	private boolean sensorIzquierda;
	private boolean pararMovimiento;

	private double[] vectorCostes;
	private int[][] mapaDistancias;
	private boolean[][] mapa;
	private boolean[] vectorSensores;

	private int anchoMapa;
	private int altoMapa;
	private static int numeroSensores = 4;

	private static int valorAlto = 9999999;

	/*
	 * CONSTRUCTOR
	 */
	public Robot() {
		setVectorSensores(new boolean[4]);
		setPuntoActual(null);
		setPuntoAnterior(null);
		vectorCostes = new double[4];
	}

	public void inicializarMapa (int ancho, int alto) {
		setAnchoMapa(ancho);
		setAltoMapa(alto);

		setMapa(new boolean[anchoMapa][altoMapa]);
		for (int i = 0; i < anchoMapa; i++)
			for (int j = 0; j < altoMapa; j++)
				mapa[i][j] = true;
	}

	/***********************************************************************
	 ************************** MOVIMIENTO AESTRELLA**************************
	 ***********************************************************************/
	public void inicializarMapaDistancias (int[][] mapaEntorno, int ancho,
			int alto) {
		setAnchoMapa(ancho);
		setAltoMapa(alto);

		if(mapaEntorno[puntoDestino.x][puntoDestino.y] == 1){
			setPararMovimiento(true);
			System.out.println("El punto de destino tiene un obstaculo");
		}
		
		
		setMapaDistancias(new int[anchoMapa][altoMapa]);
		// FIJAMOS LOS OBSTACULOS COMO UN COSTE MUY ALTO
		for (int i = 0; i < anchoMapa; i++)
			for (int j = 0; j < altoMapa; j++)
				// if (mapaEntorno[i][j] == 1) {
				mapaDistancias[i][j] = valorAlto;
		// }
		// FIJAMOS EL PUNTO DE DESTINO COMO COSTE 0
		mapaDistancias[(int) puntoDestino.x][(int) puntoDestino.y] = 0;
		// AUMENTAMOS COSTES DE CASILLAS ADYACENTES AL PUNTO DE DESTINO
		for (int k = 0; k < anchoMapa * altoMapa; k++) {
			for (int i = 0; i < anchoMapa; i++) {
				for (int j = 0; j < altoMapa; j++) {
					if (mapaDistancias[i][j] == k) {
						if (i + 1 < anchoMapa
								&& mapaDistancias[i + 1][j] > k + 1
								&& mapaEntorno[i + 1][j] != 1)
							mapaDistancias[i + 1][j] = k + 1;
						if (i - 1 >= 0 && mapaDistancias[i - 1][j] > k + 1
								&& mapaEntorno[i - 1][j] != 1)
							mapaDistancias[i - 1][j] = k + 1;
						if (j + 1 < altoMapa
								&& mapaDistancias[i][j + 1] > k + 1
								&& mapaEntorno[i][j + 1] != 1)
							mapaDistancias[i][j + 1] = k + 1;
						if (j - 1 >= 0 && mapaDistancias[i][j - 1] > k + 1
								&& mapaEntorno[i][j - 1] != 1)
							mapaDistancias[i][j - 1] = k + 1;
					}
				}
			}
		}
		//mostrarMapaDistancias();
	}

	public void aEstrella () {
		int caminoMinimoCoste = valorAlto - 1;
		if (puntoActual.x + 1 < anchoMapa
				&& mapaDistancias[puntoActual.x + 1][puntoActual.y] < caminoMinimoCoste)
			caminoMinimoCoste = mapaDistancias[puntoActual.x + 1][puntoActual.y];
		if (puntoActual.x - 1 >= 0
				&& mapaDistancias[puntoActual.x - 1][puntoActual.y] < caminoMinimoCoste)
			caminoMinimoCoste = mapaDistancias[puntoActual.x - 1][puntoActual.y];
		if (puntoActual.y + 1 < altoMapa
				&& mapaDistancias[puntoActual.x][puntoActual.y + 1] < caminoMinimoCoste)
			caminoMinimoCoste = mapaDistancias[puntoActual.x][puntoActual.y + 1];
		if (puntoActual.y - 1 >= 0
				&& mapaDistancias[puntoActual.x][puntoActual.y - 1] < caminoMinimoCoste)
			caminoMinimoCoste = mapaDistancias[puntoActual.x][puntoActual.y - 1];

		for (int i = 0; i < numeroSensores; i++) {
			if (puntoActual.x + 1 < anchoMapa
					&& mapaDistancias[puntoActual.x + 1][puntoActual.y] == caminoMinimoCoste)
				moverseDerecha();
			else if (puntoActual.x - 1 >= 0
					&& mapaDistancias[puntoActual.x - 1][puntoActual.y] == caminoMinimoCoste)
				moverseIzquierda();
			else if (puntoActual.y + 1 < altoMapa
					&& mapaDistancias[puntoActual.x][puntoActual.y + 1] == caminoMinimoCoste)
				moverseAbajo();
			else if (puntoActual.y - 1 >= 0
					&& mapaDistancias[puntoActual.x][puntoActual.y - 1] == caminoMinimoCoste)
				moverseArriba();
			else{
				setPararMovimiento(true);
				System.out.println("Destino inalcanzable");
				break;
			}
		}
	}

	public void mostrarMapaDistancias () {
		for (int i = 0; i < anchoMapa; i++) {
			for (int j = 0; j < altoMapa; j++)
				System.out.print(mapaDistancias[i][j] + " ");
			System.out.println();
		}
	}

	/***********************************************************************
	 ************************** MOVIMIENTO ESCALADA**************************
	 ***********************************************************************/
	public void seleccionMovimiento () {
		actualizarMapa();
		double costeMinimo = valorAlto;
		if (getCasillaDerecha() == true)
			vectorCostes[0] = costeMoverseDerecha();
		else
			vectorCostes[0] = valorAlto;
		if (getCasillaIzquierda() == true)
			vectorCostes[1] = costeMoverseIzquierda();
		else
			vectorCostes[1] = valorAlto;
		if (getCasillaArriba() == true)
			vectorCostes[2] = costeMoverseArriba();
		else
			vectorCostes[2] = valorAlto;
		if (getCasillaAbajo() == true)
			vectorCostes[3] = costeMoverseAbajo();
		else
			vectorCostes[3] = valorAlto;
		for (int i = 0; i < numeroSensores; i++) {
			if (costeMinimo > vectorCostes[i])
				costeMinimo = vectorCostes[i];
		}
		// PRIMERA PASADA COMPRUEBA QUE NO HAYAN CASILLAS SIN VISITAR
		// EN EL CASO DE QUE TODAS HAYAN SIDO VISITADAS SEGUNDA PASADA
		if (costeMinimo == vectorCostes[0] && getCasillaDerecha() == true)
			moverseDerecha();
		else if (costeMinimo == vectorCostes[1]
				&& getCasillaIzquierda() == true) {
			moverseIzquierda();
		} else if (costeMinimo == vectorCostes[2] && getCasillaArriba() == true)
			moverseArriba();
		else if (costeMinimo == vectorCostes[3] && getCasillaAbajo() == true)
			moverseAbajo();
		else {

			setPararMovimiento(true);
		}
		if(mapa[puntoDestino.x][puntoDestino.y] == false)
			setPararMovimiento(true);
	}

	/*
	 * ACTUALIZAR EL MAPA QUE VA APRENDIENDO EL ROBOT
	 */
	public void actualizarMapa () {
		if (getCasillaArriba() == true)
			vectorSensores[0] = sensorArriba;
		else
			vectorSensores[0] = false;
		if (getCasillaAbajo() == true)
			vectorSensores[1] = sensorAbajo;
		else
			vectorSensores[1] = false;
		if (getCasillaDerecha() == true)
			vectorSensores[2] = sensorDerecha;
		else
			vectorSensores[2] = false;
		if (getCasillaIzquierda() == true)
			vectorSensores[3] = sensorIzquierda;
		else
			vectorSensores[3] = false;

		if (puntoActual.x + 1 < anchoMapa
				&& mapa[puntoActual.x + 1][puntoActual.y] == true)
			mapa[puntoActual.x + 1][puntoActual.y] = vectorSensores[2];
		if (puntoActual.x - 1 > 0
				&& mapa[puntoActual.x - 1][puntoActual.y] == true)
			mapa[puntoActual.x + -1][puntoActual.y] = vectorSensores[3];
		if (puntoActual.y + 1 < altoMapa
				&& mapa[puntoActual.x][puntoActual.y + 1] == true)
			mapa[puntoActual.x][puntoActual.y + 1] = vectorSensores[1];
		if (puntoActual.y - 1 > 0
				&& mapa[puntoActual.x][puntoActual.y - 1] == true)
			mapa[puntoActual.x][puntoActual.y - 1] = vectorSensores[0];

		int contador = 0;

		for (int i = 0; i < vectorSensores.length; i++) {
			if (vectorSensores[i] == false)
				contador++;
		}
		if (contador >= 3) {
			mapa[puntoActual.x][puntoActual.y] = false;
		}
	}

	/*
	 * CASILLAS ADYACENTES
	 */
	public boolean getCasillaDerecha () {
		if (getPuntoActual().x + 1 < anchoMapa)
			return mapa[getPuntoActual().x + 1][getPuntoActual().y];
		else
			return false;
	}

	public boolean getCasillaIzquierda () {
		if (getPuntoActual().x - 1 >= 0)
			return mapa[getPuntoActual().x - 1][getPuntoActual().y];
		else
			return false;
	}

	public boolean getCasillaAbajo () {
		if (getPuntoActual().y + 1 < altoMapa)
			return mapa[getPuntoActual().x][getPuntoActual().y + 1];
		else
			return false;
	}

	public boolean getCasillaArriba () {
		if (getPuntoActual().y - 1 >= 0)
			return mapa[getPuntoActual().x][getPuntoActual().y - 1];
		else
			return false;
	}

	/*
	 * MOVIMIENTOS POSIBLES
	 */
	public void moverseDerecha () {
		setPuntoActual(new Point(puntoActual.x + 1, puntoActual.y));
	}

	public void moverseIzquierda () {
		setPuntoActual(new Point(puntoActual.x - 1, puntoActual.y));
	}

	public void moverseArriba () {
		setPuntoActual(new Point(puntoActual.x, puntoActual.y - 1));
	}

	public void moverseAbajo () {
		setPuntoActual(new Point(puntoActual.x, puntoActual.y + 1));
	}

	/*
	 * COSTE DE LOS MOVIMIENTOS DEL ROBOT
	 */
	public double costeMoverseDerecha () {
		return (new Point(puntoActual.x + 1, puntoActual.y)
				.distance(puntoDestino));
	}

	public double costeMoverseIzquierda () {
		return (new Point(puntoActual.x - 1, puntoActual.y)
				.distance(puntoDestino));
	}

	public double costeMoverseArriba () {
		return (new Point(puntoActual.x, puntoActual.y - 1)
				.distance(puntoDestino));
	}

	public double costeMoverseAbajo () {
		return (new Point(puntoActual.x, puntoActual.y + 1)
				.distance(puntoDestino));
	}

	/*
	 * METODOS DE ACCESO A LOS ATRIBUTOS
	 */

	/**
	 * @return the sensorArriba
	 */
	public boolean isSensorArriba () {
		return sensorArriba;
	}

	/**
	 * @param sensorArriba
	 *            the sensorArriba to set
	 */
	public void setSensorArriba (boolean sensorArriba) {
		this.sensorArriba = sensorArriba;
	}

	/**
	 * @return the sensorAbajo
	 */
	public boolean isSensorAbajo () {
		return sensorAbajo;
	}

	/**
	 * @param sensorAbajo
	 *            the sensorAbajo to set
	 */
	public void setSensorAbajo (boolean sensorAbajo) {
		this.sensorAbajo = sensorAbajo;
	}

	/**
	 * @return the sensorIzquierda
	 */
	public boolean isSensorIzquierda () {
		return sensorIzquierda;
	}

	/**
	 * @param sensorIzquierda
	 *            the sensorIzquierda to set
	 */
	public void setSensorIzquierda (boolean sensorIzquierda) {
		this.sensorIzquierda = sensorIzquierda;
	}

	/**
	 * @return the sensorDerecha
	 */
	public boolean isSensorDerecha () {
		return sensorDerecha;
	}

	/**
	 * @param sensorDerecha
	 *            the sensorDerecha to set
	 */
	public void setSensorDerecha (boolean sensorDerecha) {
		this.sensorDerecha = sensorDerecha;
	}

	/**
	 * @return the puntoActual
	 */
	public Point getPuntoActual () {
		return puntoActual;
	}

	/**
	 * @param puntoActual
	 *            the puntoActual to set
	 */
	public void setPuntoActual (Point puntoActual) {
		this.puntoActual = puntoActual;
		setChanged();
		notifyObservers();
	}

	/**
	 * @return the puntoAnterior
	 */
	public Point getPuntoAnterior () {
		return puntoAnterior;
	}

	/**
	 * @param puntoAnterior
	 *            the puntoAnterior to set
	 */
	public void setPuntoAnterior (Point puntoAnterior) {
		this.puntoAnterior = puntoAnterior;
	}

	/**
	 * @return the puntoDestino
	 */
	public Point getPuntoDestino () {
		return puntoDestino;
	}

	/**
	 * @param puntoDestino
	 *            the puntoDestino to set
	 */
	public void setPuntoDestino (Point puntoDestino) {
		this.puntoDestino = puntoDestino;
	}

	/**
	 * @return the mapa
	 */
	public boolean[][] getMapa () {
		return mapa;
	}

	/**
	 * @param mapa
	 *            the mapa to set
	 */
	public void setMapa (boolean[][] mapa) {
		this.mapa = mapa;
	}

	/**
	 * @return the altoMapa
	 */
	public int getAltoMapa () {
		return altoMapa;
	}

	/**
	 * @param altoMapa
	 *            the altoMapa to set
	 */
	public void setAltoMapa (int altoMapa) {
		this.altoMapa = altoMapa;
	}

	/**
	 * @return the anchoMapa
	 */
	public int getAnchoMapa () {
		return anchoMapa;
	}

	/**
	 * @param anchoMapa
	 *            the anchoMapa to set
	 */
	public void setAnchoMapa (int anchoMapa) {
		this.anchoMapa = anchoMapa;
	}

	/**
	 * @return the vectorSensores
	 */
	public boolean[] getVectorSensores () {
		return vectorSensores;
	}

	/**
	 * @param vectorSensores
	 *            the vectorSensores to set
	 */
	public void setVectorSensores (boolean[] vectorSensores) {
		this.vectorSensores = vectorSensores;
	}

	public boolean getPararMovimiento () {
		return pararMovimiento;
	}

	public void setPararMovimiento (boolean pararMovimiento) {
		this.pararMovimiento = pararMovimiento;
	}

	public int[][] getMapaDistancias () {
		return mapaDistancias;
	}

	public void setMapaDistancias (int[][] mapaDistancias) {
		this.mapaDistancias = mapaDistancias;
	}
}

/*
 * COMPROBAR QUE SE PUEDE MOVER
 */
/*
 * public boolean moverseDerechaPosible () { if (sensorDerecha == false) return
 * true; else return false; }
 * 
 * public boolean moverseIzquierdaPosible () { if (sensorIzquierda == false)
 * return true; else return false; }
 * 
 * public boolean moverseArribaPosible () { if (sensorArriba == false) return
 * true; else return false; }
 * 
 * public boolean moverseAbajoPosible () { if (sensorAbajo == false) return
 * true; else return false; }
 */