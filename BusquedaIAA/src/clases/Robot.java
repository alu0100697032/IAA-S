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
	private double[] vectorCostes;
	private static double valorAlto = 9999999;

	/*
	 * CONSTRUCTOR
	 */
	public Robot() {
		setPuntoActual(new Point());
		setPuntoAnterior(getPuntoActual());
		vectorCostes = new double[4];
	}

	public void seleccionMovimiento () {
		double costeMinimo = valorAlto;
		if (moverseDerechaPosible() == true)
			vectorCostes[0] = costeMoverseDerecha();
		else
			vectorCostes[0] = valorAlto;
		if (moverseIzquierdaPosible() == true)
			vectorCostes[1] = costeMoverseIzquierda();
		else
			vectorCostes[1] = valorAlto;
		if (moverseArribaPosible() == true)
			vectorCostes[2] = costeMoverseArriba();
		else
			vectorCostes[2] = valorAlto;
		if (moverseAbajoPosible() == true)
			vectorCostes[3] = costeMoverseAbajo();
		else
			vectorCostes[3] = valorAlto;
		for (int i = 0; i < vectorCostes.length; i++) {
			if (costeMinimo > vectorCostes[i])
				costeMinimo = vectorCostes[i];
		}
		if (costeMinimo == vectorCostes[0] && moverseDerechaPosible() == true)
			moverseDerecha();
		else if (costeMinimo == vectorCostes[1] && moverseIzquierdaPosible() == true){
			moverseIzquierda();
		}
		else if (costeMinimo == vectorCostes[2] && moverseArribaPosible() == true)
			moverseArriba();
		else if (costeMinimo == vectorCostes[3] && moverseAbajoPosible() == true)
			moverseAbajo();
	}

	/*
	 * COMPROBAR QUE SE PUEDE MOVER
	 */
	public boolean moverseDerechaPosible () {
		if (sensorDerecha == false)
			return true;
		else
			return false;
	}

	public boolean moverseIzquierdaPosible () {
		if (sensorIzquierda == false)
			return true;
		else
			return false;
	}

	public boolean moverseArribaPosible () {
		if (sensorArriba == false)
			return true;
		else
			return false;
	}

	public boolean moverseAbajoPosible () {
		if (sensorAbajo == false)
			return true;
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

}