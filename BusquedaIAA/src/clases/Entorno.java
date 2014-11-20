package clases;
import java.util.ArrayList;
import java.util.Observable;


public class Entorno extends Observable{
	/*
	 * ATRIBUTOS
	 */
	private int anchoEntorno;
	private int largoEntorno;
	private int numeroObjetos;
	private int numeroCasillas;
	private ArrayList<Integer> DibujoEntorno;
	private Robot robot1;
	
	public Entorno(int ancho, int largo, int objetos){
		robot1 = new Robot();
		setAnchoEntorno(ancho);
		setLargoEntorno(largo);
		setNumeroCasillas(ancho*largo);
		setNumeroObjetos(objetos);
		DibujoEntorno = new ArrayList<Integer>(ancho*largo);
		setChanged();
		notifyObservers();
	}

	
	public int getAnchoEntorno() {
		return anchoEntorno;
	}
	public void setAnchoEntorno(int anchoEntorno) {
		this.anchoEntorno = anchoEntorno;
	}
	public int getLargoEntorno() {
		return largoEntorno;
	}
	public void setLargoEntorno(int largoEntorno) {
		this.largoEntorno = largoEntorno;
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
}
