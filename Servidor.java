import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Servidor{
    public static void main(String[] args){
        int puerto = 8081;
        try{
            ServerSocket ss = new ServerSocket(puerto);
            System.out.println("Servidor escuchando en el puerto: "+ puerto +"...");

            Socket ch = ss.accept();

            PrintWriter out = new PrintWriter(ch.getOutputStream(),true);

            BufferedReader in = new BufferedReader(new InputStreamReader(ch.getInputStream()));

            out.println("HOLA");
            out.println("mundo");
            out.println("desde el servidor de Jasiel Zavaleta");
            

            System.out.println("Escribe mensajes para el cliente");
            Scanner scanner = new Scanner(System.in);

            String message;
            while (!(message = scanner.nextLine()).equals("Adios")) {
                out.println(message);
            }

            out.println("Adios");

            System.out.println("Cliente: " + in.readLine());

            out.close();
            in.close();
            ch.close();
            ss.close();
        }catch(IOException ex){
            System.err.println(ex);        
         
        } 
        
    }
}