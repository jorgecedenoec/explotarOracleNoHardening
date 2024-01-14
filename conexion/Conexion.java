package conexion;

import java.sql.*;
import java.util.*;

import parametros.*;

public class Conexion {

	Connection con;
	public Conexion() {
		// TODO Auto-generated constructor stub
	}
	
	public void estableceConexionBD(parametrosConsola params)
	{				
		String url="jdbc:oracle:thin:@//"+params.getIp()+":"+params.getPuerto()+"/"+params.getBd();
		 
		 try
		 {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 con= DriverManager.getConnection(url,params.getUsuario(),params.getPassword());			 
	  	  }
		  catch(Throwable e)
		  { 
			  e.printStackTrace();
			  //System.out.println(url+"--"+params.getUsuario()+"--"+params.getPassword());
			  params.pausaConsola("Error al tratar de Conectarse a BD");
		  }	 
		
	}
	
	//Ejecuta un procedimiento almacenado
		public boolean ejecutaProcedimiento(String StoreProcedure)
		{
			boolean resultado=false;			
			CallableStatement cst=null;
			 if(con!=null)
			 {
				 try
				 {
					 cst=con.prepareCall("{call "+StoreProcedure+" }");				 
					 cst.execute();
					 cst.close();					 
					 resultado=true;
				 }
				 catch(Throwable exc)
				 {
					 exc.printStackTrace();	
					 System.out.println("Error al ejecutar el Procedimiento"); 
				 }
			 }
			return resultado;		
		}
		
		//Ejecuta un procedimiento almacenado con parametros
				public boolean ejecutaProcedimiento(String StoreProcedure, String parametro)
				{
					boolean resultado=false;			
					CallableStatement cst=null;
					 if(con!=null)
					 {
						 try
						 {
							 /*
							  * cs = this.con.prepareCall("{call GET_SUPPLIER_OF_COFFEE(?, ?)}");
								cs.setString(1, coffeeNameArg);
								cs.registerOutParameter(2, Types.VARCHAR);
								cs.executeQuery();
							  */
							 //cst=con.prepareCall("{call "+StoreProcedure+" }");		
							 cst=con.prepareCall("{call "+StoreProcedure+"(?) }");	
							 cst.setString(1, parametro);
							 cst.execute();
							 cst.close();					 
							 resultado=true;
						 }
						 catch(Throwable exc)
						 {
							 exc.printStackTrace();	
							 System.out.println("Error al ejecutar el Procedimiento"); 
						 }
					 }
					return resultado;		
				}
		
		public Vector ejecutaSelect(String sql)
		 {
			 Vector resultado=null;			
			 if(con!=null)
			 {
				 try
				 {
					 Statement st = con.createStatement();
					 ResultSet rs = st.executeQuery(sql);
					 resultado=new Vector();
					 Vector fila=null;
					 while(rs.next())
					 {								
						fila=new Vector(); 
						ResultSetMetaData rsmd = rs.getMetaData();					     
					    int column_count = rsmd.getColumnCount();					    
					    for(int i=1;i<=column_count;i++)
					    {					    	
					    	fila.add(rs.getString(i));						    	
					    }
						resultado.add(fila);						
					 }
					 rs.close();
					 st.close();					 				
				 }
				 catch(Throwable exc)
				 {
					 exc.printStackTrace();
					 System.out.println("Error al ejecutar el Select");
				 }
			 }		
			 return resultado;
		 }
		 

	/**
	 * @return the con
	 */
	public Connection getCon() {
		return con;
	}

	/**
	 * @param con the con to set
	 */
	public void setCon(Connection con) {
		this.con = con;
	}

	public void cierraConexionBD() {
		// TODO Auto-generated method stub
		try
		{
			con.close();
		}
		catch(Throwable exc)
		 {
			 exc.printStackTrace();
			 System.out.println("Error al cerrar la Conexion de BD");
		 }
	}
	
	

}
