package explotacion;

import conexion.Conexion;

public class BorradoHuellas {

	public BorradoHuellas() {
		// TODO Auto-generated constructor stub
	}

	public boolean borraHuellas(Conexion con, String usuario) {
		// TODO Auto-generated method stub
		boolean resultado=false;		
		String procedimiento="borra_huellas";
		resultado=con.ejecutaProcedimiento(procedimiento,usuario);		
		return resultado;		
	}

}
