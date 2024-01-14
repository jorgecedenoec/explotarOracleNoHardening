package utilerias;

import java.io.*; 

public class pantalla {

	public pantalla() {
		// TODO Auto-generated constructor stub
	}
	
	public void limpiaPantalla()
	{
		//Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) 
	    {
	    	System.out.println("Error al limpiar la pantalla: "+ex); 
	    }
	}

}
