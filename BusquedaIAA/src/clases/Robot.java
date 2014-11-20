package clases;

public class Robot {

	/*
	 * ATRIBUTOS 
	 */
	private int posicionX;
	private int posicionY;
	public Robot(){
		setPosicionX(0);
		setPosicionY(0);
	}
	public int getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	public int getPosicionY() {
		return posicionY;
	}
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
}
