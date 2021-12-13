/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloClin;

import ControladorServ.Palabra;
import controladorClin.ControladorCliente;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;
import java.util.Arrays;
import java.util.stream.Stream;
import static jdk.nashorn.internal.objects.ArrayBufferView.buffer;
import vistaClin.Principal;

/**
 *
 * @author raulr
 */
public class Cliente extends Thread{
    ControladorCliente controlador;
    //puerto de nuestro servidor
    final int Puerto = 7012;
    final String Host = "localhost"; //or "192.168.0.3 or 192.168.0.2"
    public static Socket socket;
    BufferedReader br;
    ArrayList<String> al;
    public static String palabras[];//En este arreglo se guardan las palabras pero en String
    public static Palabra palabra[];//En este arreglo se guardan las palabras
    public static int npalabras;//indica la cantidad de palabra que hay en el sopa de letras
    
    public int opc = 0;
    
    
    public void setControlador(ControladorCliente controlador){
        this.controlador = controlador;
    }
    
    public void conectarConElServidor() throws InterruptedException{
        try {
            socket = new Socket(Host, Puerto);

            
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            controlador.textoencaja("Error" + ex);
            controlador.textoencaja("Cierre en 3,2,1 ...");
            Thread.sleep(5000);
            System.exit(0);
        }
    }

    
    public int Puerto (){
        return Puerto;
    }
    
    public void crearFlujos(){
        
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        try {

            InputStream is = socket.getInputStream();

            ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
               
            
            InputStreamReader isr = new InputStreamReader(is);
            
            //ObjectOutputStream  oos = new ObjectOutputStream (os);
            br = new BufferedReader(isr);
            //bo = new StringBuffer((CharSequence) os);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }



public String recibirMensaje(){
    
        try {
            String mensaje_string = br.readLine();
            return mensaje_string;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
}
 
    
    @Override
    public void run(){
        opc++;
        //String nombreFichero = "palabrascliente.txt";
        //buscarPalabras();
        //"E:/NetBeans/JavaProjects/Eq3_SopaLetras/palabrascliente.txt"
        boolean bucle;
        while(bucle = true){          

         switch(opc){
             case 1: 
                //ArrayList<String> Mensaje = new ArrayList<String>();
                String mensaje = recibirMensaje();
               //controlador.textoencaja("_______________________________________");
                //recibirMensaje();
                controlador.textoencaja("Recibiendo Palabras -> "+mensaje+" <- del cliente...");
                mensaje = mensaje.replaceAll("[\\[\\]]", "");
                //mensaje = mensaje.trim();
                ArrayList<String> Mensaje = new ArrayList<String>(Arrays.asList(mensaje.split(",")));

                try {FileWriter writer = new FileWriter("palabrascliente.txt"); 

                //try {FileWriter writer = new FileWriter("E:/NetBeans/JavaProjects/Eq3_SopaLetras/palabrascliente.txt"); 
                    for(String str: Mensaje) {
                      writer.write(str.trim() + System.lineSeparator());
                    }               
                    writer.close();
                    opc++;
                } catch (IOException e) {
                }
                 break;
                 
             case 2:
                 String mensaje2 = recibirMensaje();
                controlador.textoencaja("Recibiendo X -> "+mensaje2+" <- del cliente...");
                mensaje2 = mensaje2.replaceAll("[\\[\\]]", "");
                //mensaje = mensaje.trim();
                ArrayList<String> MensajeX = new ArrayList<String>(Arrays.asList(mensaje2.split(",")));

                try {FileWriter writer = new FileWriter("X.txt"); 

                //try {FileWriter writer = new FileWriter("E:/NetBeans/JavaProjects/Eq3_SopaLetras/palabrascliente.txt"); 
                    for(String str: MensajeX) {
                      writer.write(str.trim() + System.lineSeparator());
                    }               
                    writer.close();
                    opc++;
                } catch (IOException e) {
                }
                 break;        
 
             case 3:
                 String mensaje3 = recibirMensaje();
                controlador.textoencaja("Recibiendo Y -> "+mensaje3+" <- del cliente...");
                mensaje3 = mensaje3.replaceAll("[\\[\\]]", "");
                //mensaje = mensaje.trim();
                ArrayList<String> MensajeY = new ArrayList<String>(Arrays.asList(mensaje3.split(",")));

                try {FileWriter writer = new FileWriter("Y.txt"); 

                //try {FileWriter writer = new FileWriter("E:/NetBeans/JavaProjects/Eq3_SopaLetras/palabrascliente.txt"); 
                    for(String str: MensajeY) {
                      writer.write(str.trim() + System.lineSeparator());
                    }               
                    writer.close();
                    opc++;
                } catch (IOException e) {
                }
                 break;                   

             case 4:
                 String mensaje4 = recibirMensaje();
                controlador.textoencaja("Recibiendo Direccion -> "+mensaje4+" <- del cliente...");
                mensaje4 = mensaje4.replaceAll("[\\[\\]]", "");
                //mensaje = mensaje.trim();
                ArrayList<String> MensajeDireccion = new ArrayList<String>(Arrays.asList(mensaje4.split(",")));

                try {FileWriter writer = new FileWriter("Direccion.txt"); 

                //try {FileWriter writer = new FileWriter("E:/NetBeans/JavaProjects/Eq3_SopaLetras/palabrascliente.txt"); 
                    for(String str: MensajeDireccion) {
                      writer.write(str.trim() + System.lineSeparator());
                    }               
                    writer.close();
                    opc = 1;
                } catch (IOException e) {
                }
                 break;  
                 
         } 


            controlador.activarboton();
            

            
            if(bucle!=true){
                try {
                   controlador.textoencaja("Cliente cerrando socket .... termina la aplicacion..");
                    br.close();
                    socket.close();              
                    System.exit(0);
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //String mensaje_paquete = recibirMensaje_paquete();

        }

    }
    
    
}

