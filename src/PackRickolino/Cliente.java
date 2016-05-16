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
import java.net.Socket;

/**
 *
 * @author Estudiante
 */
public class Cliente {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Socket cliente = new Socket("localhost", 8000);
        
        InputStream entrada = cliente.getInputStream();
        OutputStream salida = cliente.getOutputStream();
        //Decorador modo caracter
        BufferedReader entradaCaracter = new BufferedReader(new InputStreamReader(entrada));
        PrintWriter salidaCaracter = new PrintWriter(salida, true);
        
        BufferedReader lecturaTeclado = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("¿Qué desea enviar al servidor?");
            String enviar = lecturaTeclado.readLine();
            salidaCaracter.println(enviar);
            String recibi = entradaCaracter.readLine();
            System.out.println(recibi);
        }
    }
    
}
