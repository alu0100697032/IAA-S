package clases;
import java.util.Observable;


public class Entorno extends Observable{
	/*
	 * ATRIBUTOS
	 */
	private int anchoEntorno;
	private int altoEntorno;
	private int numeroObjetos;
	private int numeroCasillas;
	private int[] DibujoEntorno;
	private Robot robot1;
	
	public Entorno(){
		robot1 = new Robot();
	}

	public void cambiarDimensionesEntorno(int ancho, int alto){
		setAltoEntorno(alto);
		setAnchoEntorno(ancho);
		setNumeroCasillas(ancho*alto);
		DibujoEntorno = new int[ancho*alto];
		for(int i = 0; i < ancho*alto; i++)
			DibujoEntorno[i] = 0;
		setChanged();
		notifyObservers();
	}
	
	public int getPosicionActualRobot(){
		return getRobot1().getPosicionXActual()+getRobot1().getPosicionYActual()*10;
	}
	
	public int getPosicionAnteriorRobot(){
		return getRobot1().getPosicionXAnterior()+getRobot1().getPosicionYAnterior()*10;
	}
	
	public void setPosicionRobotCero(){
		robot1 = new Robot();
	}
	public void moverRobot() throws InterruptedException{
		new Thread(robot1).start();
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

	public int[] getDibujoEntorno() {
		return DibujoEntorno;
	}

	public void setDibujoEntorno(int[] dibujoEntorno) {
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
