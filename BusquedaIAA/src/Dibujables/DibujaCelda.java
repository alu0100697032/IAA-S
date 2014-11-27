package Dibujables;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class DibujaCelda extends JLabel{
	
	public DibujaCelda(Color color){
		setOpaque(true);
		setBackground(color);
		setVisible(true);
	}
}
