package clases;


public class Robot{

	/*
	 * ATRIBUTOS 
	 */
	private int posicionX;
	private int posicionY;
	/*
	 * CONSTRUCTOR
	 */
	public Robot(){
		setPosicionX(0);
		setPosicionY(0);
	}
	
	public void Moverse(){
		for(int i = 0; i < 10; i++){
			setPosicionX(getPosicionX()+1);
		}	
	}
	
	/**
	 * @return the posicionX
	 */
	public int getPosicionX () {
		return posicionX;
	}
	/**
	 * @param posicionX the posicionX to set
	 */
	public void setPosicionX (int posicionX) {
		this.posicionX = posicionX;
	}
	/**
	 * @return the posicionY
	 */
	public int getPosicionY () {
		return posicionY;
	}
	/**
	 * @param posicionY the posicionY to set
	 */
	public void setPosicionY (int posicionY) {
		this.posicionY = posicionY;
	}
	
}
