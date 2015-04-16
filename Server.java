import java.net.InetAddress;
import java.text.SimpleDateFormat;
import javax.swing.*;
//import javax.swing.filechooser.FileSystemView;
import java.util.*;
import java.net.*;
import java.io.*;
import java.lang.management.*;
public class Server{

	public static void main(String args[]){
		InetAddress equipo;

		try {

			int puerto = 5000;

			


			ServerSocket s = new ServerSocket(puerto);
			String comandoSalir = "Exit";
			String entrada = "";
			System.out.println("Servidor iniciado en el puerto " + puerto + "...");
			SimpleDateFormat formato1 = new SimpleDateFormat("dd-MM-yyyy");
    			SimpleDateFormat formato2 = new SimpleDateFormat("hh:mm:ss");
			while(true){
				Socket s1 = s.accept();        
				System.out.println("Aceptando conexion...");
				PrintWriter out = new PrintWriter(s1.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(s1.getInputStream()));

				while ((entrada = in.readLine()) != null) {					
				    System.out.println(entrada);
			    	    String pathDesktop = System.getProperty("user.home") + "\\Desktop\\";
					 Date fechaSalida = new Date();            
            				 String cadenaFecha = formato1.format(fechaSalida);
            				 String cadenaHora = formato2.format(fechaSalida);
				    out.println("Hola! -> " + pathDesktop);

				    equipo = InetAddress.getLocalHost();  // Creamos el objeto equipo de la clase InetAddress
					//String nombre_equipo = equipo;
					String usuario = equipo.getHostName();
					String conexion = equipo.getCanonicalHostName();

					out.println("Equipo: "+equipo);
					
					out.println("Usuario: "+usuario);
					out.println("Conexión de equipo: "+conexion);
				    	out.println ("Fecha y hora: "+cadenaFecha+" "+cadenaHora);
				    if (entrada.trim().equals(comandoSalir))
				        return;
				} 
				s1.close();
				   
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}


}