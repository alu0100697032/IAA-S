package Global;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Dibujables.DibujaEntornoInstanciable;
import clases.Entorno;

public class Main{

	public static void main(String args[]){
		
		Entorno entorno = new Entorno(10, 10, 0);
		DibujaEntornoInstanciable dibujaEntorno = new DibujaEntornoInstanciable(entorno);	
		
	}

}
