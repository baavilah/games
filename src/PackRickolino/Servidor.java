/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackRickolino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Estudiante
 */
public class Servidor {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        ServerSocket servidor = new ServerSocket(8000);
        Socket cliente = servidor.accept();
        InputStream entrada = cliente.getInputStream();
        OutputStream salida = cliente.getOutputStream();
        //Decorador modo caracter
        BufferedReader entradaCaracter = new BufferedReader(new InputStreamReader(entrada));
        PrintWriter salidaCaracter = new PrintWriter(salida, true);
        //Enviar y Recibir
        while(true){
            String recibi = entradaCaracter.readLine();
            salidaCaracter.println(recibi);
        }
        
        
    }
    
}
