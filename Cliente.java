import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;


public class Cliente {
    public static void main(String[] args){
        int puerto = 8081;
        try{
            Socket cs = new Socket("localhost", puerto);

            PrintWriter out = new PrintWriter(cs.getOutputStream(),true);

            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            String lineaRecibida;
            while(!(lineaRecibida = in.readLine()).equalsIgnoreCase("Adios")){
                System.out.println("Servidor:" + lineaRecibida);
            }

            out.println("Recepción de datos correcta...");

            out.close();
            in.close();
            cs.close();
        }catch(IOException ex){
            System.err.println(ex);
        }
    }

}