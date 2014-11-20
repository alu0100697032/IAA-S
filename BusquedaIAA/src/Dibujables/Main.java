package Dibujables;

import javax.swing.JFrame;

import clases.Entorno;

public class Main extends JFrame{

	/*
	 * ATRIBUTOS
	 */
	private DibujaEntorno dibujaEntorno;
	private Entorno entorno; 
	
	public static void main(String args[]){
		Main frame = new Main();
		frame.setVisible(true);
	}

	public Main() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(0, 0, 800, 600);
		entorno = new Entorno(10, 10, 0);
		dibujaEntorno = new DibujaEntorno(entorno);
		dibujaEntorno.RellenarEntorno();
		add(dibujaEntorno);
	}
}
