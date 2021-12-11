package ControladorServ;

import vistaServ.Principal;
import java.awt.Color;
import java.util.Random;
import javax.swing.JLabel;


public final class Palabra extends JLabel{
    private String texto;//esta variable guarda la palabra esto es util para tachar y destachar la palabra
    private int x;//indica la posición inicial de X de la palabra
    private int y;//indica la posición inicial de Y de la palabra
    private final int id;//identificador de la palabra
    private int direccion;//indica a que direccion esta orientada la palabra  
    private int longitud;//indica la longitud de la palabra
    private int longitudencontrada;//indica cuantas letras de esta palabra ha sido encontrada
    private String[] letra;
    private boolean tachada;
    private Color colortachada;//esta variable indicara el color de celda que tendra esta celda al tacharse
    
    public int randompalabrax;
    public int randompalabray;
    public int randomdireccion;
    
    Random random;    
    public Palabra(int id) {
        this.id=id;
        this.texto=getText();
        this.letra=arreglo();
        this.longitud=letra.length;
        this.longitudencontrada=0;
        this.tachada=false;
        this.colortachada=new Color(random(255),random(255),random(255),50);
        this.setBackground(new java.awt.Color(0, 68, 204));
        this.setForeground(new java.awt.Color(255, 255, 255));
        this.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setOpaque(true);
        random=new Random();
    }
    
    public void cambiarTexto(String palabra){
        this.setText(palabra);
        this.texto=getText();
        this.letra=arreglo();
        this.longitud=letra.length;
        this.longitudencontrada=0;
    }
    
    public String[] arreglo()
    {
        String arreglo[]=new String[this.getText().length()];
        for (int i = 0; i < this.getText().length(); i++) {
            arreglo[i]=this.getText().substring(i, i+1);
        }
        return arreglo;
    }
    
    public void colocarpalabra(){
        elegirsitio();
        switch (this.direccion) {
            case 0:
                for (int i = y; i < longitud+y; i++) {
                    Principal.celda[x][i].setText(letra[i-y]);
                    Principal.celda[x][i].setName(Integer.toString(this.id));
                } 
                break;
            case 1:
                for (int i = y; i > y-longitud; i--) {
                    Principal.celda[x][i].setText(letra[y-i]);
                    Principal.celda[x][i].setName(Integer.toString(this.id));
                } 
                break;
            case 2:
                for (int i = x; i < longitud+x; i++) {
                    Principal.celda[i][y].setText(letra[i-x]);
                    Principal.celda[i][y].setName(Integer.toString(this.id));
                } 
                break;
            case 3:
                for (int i = x; i > x-longitud; i--) {
                    Principal.celda[i][y].setText(letra[x-i]);
                    Principal.celda[i][y].setName(Integer.toString(this.id));
                }                 
                break;
            case 4:
                for (int i = 0; i < longitud; i++) {
                    Principal.celda[i+x][i+y].setText(letra[i]);
                    Principal.celda[i+x][i+y].setName(Integer.toString(this.id));
                }
                break;
            case 5:
                for (int i = longitud-1; i >= 0; i--) {
                    Principal.celda[x-i][y-i].setText(letra[i]);
                    Principal.celda[x-i][y-i].setName(Integer.toString(this.id));                    
                }
                break;
            case 6:
                for (int i = 0; i <longitud; i++) {
                    Principal.celda[x+i][y-i].setText(letra[i]);
                    Principal.celda[x+i][y-i].setName(Integer.toString(this.id));
                }
                break;
            case 7:
                for (int i = 0; i <longitud; i++) {
                    Principal.celda[x-i][y+i].setText(letra[i]);
                    Principal.celda[x-i][y+i].setName(Integer.toString(this.id));
                }
                break;
        }
    }
    
    //Este metodo elige un sitio adecuado para vacio para colocar la palabra
    public boolean elegirsitio(){
        boolean r;//indica si ya eligio el sitio de la palabra
        do {            
            x=random(Principal.nfilas);
            y=random(Principal.ncolumnas);
            
            randompalabrax = x;
            randompalabray = y;
            
        } while (!"".equals(Principal.celda[x][y].getText()));
        r=elegirdireccion();
        return r;
    }
    
    public boolean elegirdireccion() {
        boolean r=false;//indica si ya se eligio la direccion de la palabra
        this.direccion=random(7);
        randomdireccion = direccion;
        
        for (int j = 0; j <= 8; j++) {
            if(j==8){
                elegirsitio();
            }else if (validar(direccion)) {
                r=true;
                break;
            }else{
                direccion=(direccion+1>7)? 1: direccion+1;
            }
        } 
        return r;
    }
    
    //Este metodo valida si se puede colocar la palabra
    public boolean validar(int direccion){
        boolean r=true;
        switch (direccion) {
            case 0://Horizontal ej: uña
                if (y+longitud<Principal.ncolumnas) {
                    for (int i = y; i < longitud+y; i++) {
                        if(!"".equals(Principal.celda[x][i].getText())){
                          r=false; 
                          break;
                        }
                    } 
                }else{
                    r=false;
                }
                break;
            case 1://horizontal al reves  ej: la palabra uña seria  añu
                if (y-longitud>=0) {
                    for (int i = y; i > y-longitud; i--) {
                        if(!("".equals(Principal.celda[x][i].getText()))){
                          r=false; 
                          break;
                        }
                    } 
                }else{
                    r=false;
                }
                break;
            case 2://vertical
                if (x+longitud<Principal.nfilas) {
                    for (int i = x; i < longitud+x; i++) {
                        if(!("".equals(Principal.celda[i][y].getText()))){//--Aqui hay un error
                          r=false; 
                          break;
                        }
                    } 
                }else{
                    r=false;
                }
                break;
            case 3://vertical al reves
                if (x-longitud>=0) {
                    for (int i = x; i > x-longitud; i--) {
                        if(!("".equals(Principal.celda[i][y].getText()))){
                          r=false; 
                          break;
                        }
                    } 
                }else{
                    r=false;
                }
                break;
            case 4:
                if (x+longitud<Principal.nfilas&&y+longitud<Principal.ncolumnas) {
                    for (int i = 0; i < longitud; i++) {
                        if(!("".equals(Principal.celda[i+x][i+y].getText()))){
                          r=false; 
                          break;
                        }
                    }
                } else {
                    r=false;
                }
                break;
            case 5:
                if (x-longitud>=0&&y-longitud>=0) {
                    for (int i = longitud-1; i >= 0; i--) {
                        if(!("".equals(Principal.celda[x-i][y-i].getText()))){
                          r=false; 
                          break;
                        }
                    }
                } else {
                    r=false;
                }
                break;
            case 6:
                if (x+longitud<Principal.nfilas&&y-longitud>=0) {
                    for (int i = 0; i <longitud; i++) {
                        if(!("".equals(Principal.celda[x+i][y-i].getText()))){
                          r=false; 
                          break;
                        }
                    }
                } else {
                    r=false;
                }
                break;
            case 7:
                if (x-longitud>=0&&y+longitud<Principal.ncolumnas) {
                    for (int i = 0; i <longitud; i++) {
                        if(!("".equals(Principal.celda[x-i][y+i].getText()))){
                          r=false; 
                          break;
                        }
                    }
                } else {
                    r=false;
                }
                break;
        }
        return r;
    }
    public void tachar() {
        tachada=true;
        this.setText("<html><body><s>"+this.getText()+"</s></body></html>");//tacha la palabra
    }
    public void destachar() {
        this.tachada=false;
        this.setText(texto);//destacha la palabra
    }
    public int random(int n){
        Random r=new Random();
        return (int)(r.nextDouble()*n-1);
    }
    public int getLongitudencontrada() {
        return longitudencontrada;
    }

    public void setLongitudencontrada(int longitudencontrada) {
        this.longitudencontrada = longitudencontrada;
    }
    public int getLongitud() {
        return longitud;
    }    
    public boolean isTachada() {
        return tachada;
    }
    public Color getColortachada() {
        return colortachada;
    }

}
