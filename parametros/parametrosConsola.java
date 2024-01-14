package parametros;

import java.io.*; 

public class parametrosConsola {
	
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the puerto
	 */
	public String getPuerto() {
		return puerto;
	}

	/**
	 * @param puerto the puerto to set
	 */
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	/**
	 * @return the bd
	 */
	public String getBd() {
		return bd;
	}

	/**
	 * @param bd the bd to set
	 */
	public void setBd(String bd) {
		this.bd = bd;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	String ip="";
	String puerto="";
	String bd="";
	String usuario="";
	String password="";

	public parametrosConsola() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean getParametrosConsola() {
		// Create the console object 
        Console cnsl = System.console(); 
        if (cnsl == null) 
        { 
            System.out.println("Consola No Disponible"); 
            return false; 
        } 
        try
        {
        	System.out.println("Ingresar Parametros de Conexion de BD\n\n"); 
	        // Read lines 
	        ip=cnsl.readLine( "Ingrese la ip: "); 
	        puerto=cnsl.readLine( "Ingrese el puerto: "); 
	        bd=cnsl.readLine( "Ingrese la base de datos: "); 
	        usuario = cnsl.readLine( "Ingrese el usuario: ");    
	        char[] ch = cnsl.readPassword("Ingrese la contraseña : "); 	        
	        password=String.valueOf(ch);
	        //password=ch.toString();    
        }
        catch(Throwable exc)
        {
        	System.out.println("Error al solicitar parametros: "+exc.getMessage());  
        	return false; 
        }
        return true;
	}
	public void pausaConsola(String mensaje) {
		// Create the console object 
        Console cnsl = System.console(); 
        if (cnsl == null) 
        { 
            System.out.println("Consola No Disponible"); 
            return; 
        } 
        cnsl.readPassword(mensaje);         	
	}
}
