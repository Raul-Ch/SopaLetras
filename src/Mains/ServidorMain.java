
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mains;

import ControladorServ.ControladorServ;
import modeloServ.Servidor;
import vistaServ.Principal;
import vistaServ.VistaS;

 
public class ServidorMain {

    public static void main(String[] args) throws InterruptedException {
        VistaS vista = new Principal();
        Servidor modelo = new Servidor();
        
        ControladorServ controlador = new ControladorServ(vista, modelo);
        
        vista.setControlador(controlador);
        modelo.setControlador(controlador);
        
  
        controlador.arrancar();
    }
   
}