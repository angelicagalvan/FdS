import java.io.*;
import java.net.*;

public class Cliente{
    public static void main(String[] args) {
      String servidor = "127.0.0.1";
      int puerto = 5000;
      try{
        Socket socket= new Socket (servidor,puerto);
	PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
        

	String c = "Hola!!!";

        out.println(c);
	String line = "";
	while  ((line = in.readLine()) != null){
		System.out.println(line);
		System.out.println(line);
		System.out.println(line);
		System.out.println(line);
		System.out.println(line);
		break;
	}
	socket.close();
      } catch (IOException e)
      {
       		System.out.println("Error en conexi�n!!!");
      }
      

    }
}