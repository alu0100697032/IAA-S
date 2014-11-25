package clases;

import java.util.Observable;


public class Robot extends Observable implements Runnable{

	/*
	 * ATRIBUTOS 
	 */
	private int posicionXActual;
	private int posicionYActual;
	private int posicionXAnterior;
	private int posicionYAnterior;
	/*
	 * CONSTRUCTOR
	 */
	public Robot(){
		setPosicionXActual(0);
		setPosicionYActual(0);
		setPosicionXAnterior(0);
		setPosicionYAnterior(0);
	}
	
	public void Moverse(){
		for(int i = 0; i < 10; i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setPosicionXAnterior(getPosicionXActual());
			setPosicionXActual(getPosicionXActual()+1);
		}	
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.Moverse();
	}

	public int getPosicionXActual() {
		return posicionXActual;
	}

	public void setPosicionXActual(int posicionXActual) {
		this.posicionXActual = posicionXActual;
		setChanged();
		notifyObservers();
	}

	public int getPosicionYActual() {
		return posicionYActual;
	}

	public void setPosicionYActual(int posicionYActual) {
		this.posicionYActual = posicionYActual;
		setChanged();
		notifyObservers();
	}

	public int getPosicionYAnterior() {
		return posicionYAnterior;
	}

	public void setPosicionYAnterior(int posicionYAnterior) {
		this.posicionYAnterior = posicionYAnterior;
	}

	public int getPosicionXAnterior() {
		return posicionXAnterior;
	}

	public void setPosicionXAnterior(int posicionXAnterior) {
		this.posicionXAnterior = posicionXAnterior;
	}

}
