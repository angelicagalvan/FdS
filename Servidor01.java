import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;
import java.net.*;
import java.io.*;
import java.lang.management.*;
public class Servidor01{

	public static void main(String args[]){
		InetAddress equipo;
		NetworkInterface dirmac; 
		File u[];

		try {

			int puerto = 5000;

			

			ServerSocket s = new ServerSocket(puerto);
			String comandoSalir = "exit";
			String nmaquina = "maquina";
			String dimac = "mac";
			String fec= "fecha";
			String user= "usuario";
			String unid= "";
			String entrada = "";

			System.out.println("Servidor iniciado en el puerto " + puerto + "...");
			SimpleDateFormat formato1 = new SimpleDateFormat("dd-MM-yyyy");
    			SimpleDateFormat formato2 = new SimpleDateFormat("hh:mm:ss");
			Socket s1 = s.accept();        
			System.out.println("Aceptando conexion...");
			BufferedReader in = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			DataOutputStream o = new DataOutputStream(s1.getOutputStream());
				
				do{
					entrada = in.readLine();

					if (entrada.trim().equals(nmaquina)){
					equipo = InetAddress.getLocalHost();  // Creamos el objeto equipo de la clase InetAddress
					String nom_equipo= equipo.getHostName();
					System.out.println("Máquina: " + nom_equipo);
                                    	o.writeUTF(nom_equipo);
					}
					else if (entrada.trim().equals(dimac)){
					
                                    	dirmac = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
                                    	byte[] dmac = dirmac.getHardwareAddress();
                                    	StringBuilder dm = new StringBuilder();
                                    	for (int i = 0; i < dmac.length; i++) {
                                         dm.append(String.format("%02X%s", dmac[i], (i < dmac.length - 1) ? "-" : ""));  
                                    	} 
                                    	System.out.println("MAC: " + dm.toString());
                                    	o.writeUTF(dm.toString());
					}
					else if (entrada.trim().equals(fec)){
					Date fechaSalida = new Date();            
            				String cadenaFecha = formato1.format(fechaSalida);
            				String cadenaHora = formato2.format(fechaSalida);
					System.out.println ("Fecha y hora: "+cadenaFecha+" "+cadenaHora);
					o.writeUTF("Fecha y hora: "+cadenaFecha+" "+cadenaHora); 
					}
					else if (entrada.trim().equals(user)){
					String nombre_usuario = System.getProperty("user.name");
                                    	System.out.println(nombre_usuario);
                                    	o.writeUTF(nombre_usuario); 
					}

					}while(!(entrada.trim().equals(comandoSalir)));
					in.close();//Cierro objetos
   					s1.close();
   					s.close();
				    if (entrada.trim().equals(comandoSalir))
				        return;
				
				//s1.close();
				   
			

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}


}