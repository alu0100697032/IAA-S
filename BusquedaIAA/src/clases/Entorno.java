package clases;
import java.util.ArrayList;
import java.util.Observable;


public class Entorno extends Observable{
	/*
	 * ATRIBUTOS
	 */
	private int anchoEntorno;
	private int altoEntorno;
	private int numeroObjetos;
	private int numeroCasillas;
	private ArrayList<Integer> DibujoEntorno;
	private Robot robot1;
	
	public Entorno(){
		robot1 = new Robot();
	}

	public void cambiarDimensionesEntorno(int ancho, int alto){
		setAltoEntorno(alto);
		setAnchoEntorno(ancho);
		setNumeroCasillas(ancho*alto);
		DibujoEntorno = new ArrayList<Integer>(ancho*alto);
		setChanged();
		notifyObservers();
	}
	
	public int getPosicionEnLaMatrizRobot(){
		return getRobot1().getPosicionX()+getRobot1().getPosicionY()*10;
	}
	public void moverRobot(){
		robot1.Moverse();
		setChanged();
		notifyObservers();
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

	public ArrayList<Integer> getDibujoEntorno() {
		return DibujoEntorno;
	}

	public void setDibujoEntorno(ArrayList<Integer> dibujoEntorno) {
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
	public int getAltoEntorno () {
		return altoEntorno;
	}


	/**
	 * @param altoEntorno the altoEntorno to set
	 */
	public void setAltoEntorno (int altoEntorno) {
		this.altoEntorno = altoEntorno;
	}
}
