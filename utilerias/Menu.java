package utilerias;

import java.io.Console;
import java.util.Vector;

public class Menu {

	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	public void presentaMenuPrincipal()
	{		
        try
        {
        	System.out.println("Menu Principal\n\n"); 
        	//System.out.println("1 Validar Posibilidad de explotar escenarios"); 
        	System.out.println("1 Ejecucion remota de comandos"); 
        	System.out.println("2 Movimiento Lateral"); 
        	System.out.println("3 Borrado de Huellas");
        	System.out.println("4 Salir\n");          	  
        }
        catch(Throwable exc)
        {
        	System.out.println("Error al mostrar menu: "+exc.getMessage());          	
        }       
	}

	public String solicitaOpcion(String mensaje) {
		// TODO Auto-generated method stub
		String resultado=null;
		Console cnsl = System.console(); 
        if (cnsl == null) 
        { 
            System.out.println("Consola No Disponible"); 
            return resultado; 
        } 
        try
        {        	
	        resultado=cnsl.readLine(mensaje); 	         
        }
        catch(Throwable exc)
        {
        	System.out.println("Error al solicitar opcion: "+exc.getMessage());          	
        }       
		return resultado;
	}

	public void mostrarItems(String titulo,Vector listaItems) {
		// TODO Auto-generated method stub
		try
        {		
			System.out.println(titulo);
			for(int i=0;i<listaItems.size();i++)
		    {
				Vector fila=(Vector)listaItems.get(i);
				for(int x=0;x<fila.size();x++)
			    {
			    	String item=(String)fila.get(x);	
			    	System.out.println(item);
			    }					    
		    }        	       	  
        }
        catch(Throwable exc)
        {
        	System.out.println("Error al mostrar DBLinks: "+exc.getMessage());          	
        }       
	}

}
