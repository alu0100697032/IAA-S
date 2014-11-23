package Global;

import Dibujables.DibujaEntornoInstanciable;
import clases.Entorno;

public class Main{

	public static void main(String args[]){
		
		Entorno entorno = new Entorno();
		DibujaEntornoInstanciable dibujaEntorno = new DibujaEntornoInstanciable(entorno);	
		
	}

}
