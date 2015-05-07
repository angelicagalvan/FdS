import java.io.*;
import java.net.*;


public class Cliente01{
    public static void main(String[] args) {
      String servidor = "127.0.0.1";
      int puerto = 5000;
      String solicitud;
      String datos;
      try{
        Socket socket= new Socket (servidor,puerto);
	BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
	PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        DataInputStream	ent = new DataInputStream(socket.getInputStream());
        
	do{

<<<<<<< HEAD
	System.out.println("Hola, qué información necesitas? ");
=======
	System.out.println("Hola, quÃ© informaciÃ³n necesitas? ");
>>>>>>> 31064393bf9b997b3e467b6b5d3af64addf0fb6c
	solicitud = in.readLine();
	out.println(solicitud);
	
	if ((solicitud.trim()).equals("maquina")){
                datos = "maquina";
            } 
		else if ((solicitud.trim()).equals("mac")){
                	datos = "mac";                    
            	} else if ((solicitud.trim()).equals("fecha")){
                	datos = "fecha";
            	} else if ((solicitud.trim()).equals("usuario")){
                	datos = "usuario";
            	}
	System.out.println("Es: "+ent.readUTF()); 
	}while(!(solicitud.trim().equals("exit")));
	
	socket.close();
	in.close();
	out.close();

      } catch (IOException e)
      {
<<<<<<< HEAD
       		System.out.println("Error en conexión!!!");
=======
       		System.out.println("Error en conexiÃ³n!!!");
>>>>>>> 31064393bf9b997b3e467b6b5d3af64addf0fb6c
      }
      

    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 31064393bf9b997b3e467b6b5d3af64addf0fb6c
