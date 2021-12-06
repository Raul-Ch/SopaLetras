package Clases;

import Frame.Gano;
import Frame.Principal;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;

//se crea la clase celda y hereda de la clase JButton
public final class Celda extends JButton {

    private final int x;//indica la posicion x de la matriz
    private final int y;//indica la posicion y de la matriz
    private boolean seleccionada;//indica si la celda esta seleccionada
    private final Color colorfondocelda;
    private final Color colorfondoceldaselecionada;

    public Celda(int x, int y) {
        seleccionada = false;
        this.x = x;
        this.y = y;
        this.setName("");//asigna un nombre vacio a la celda, esto es utili para saber que celda tiene alguna letra de una palabra buscada
        this.setText("");
        colorfondocelda = Color.WHITE;
        colorfondoceldaselecionada = Color.BLUE;
        this.setForeground(Principal.colorcelda);
        fondoBlanco();
        this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {//aqui se agrega el evento cuando el puntero del mouse esta encima de la celda
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                if (!seleccionada) {//verifica si no esta seleccionada
                    fondoVerde();
                }
            }
        });
        this.addMouseListener(new java.awt.event.MouseAdapter() {//aqui se agrega el evento cuando el puntero del mouse esta sale de la celda
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!seleccionada) {//verifica si no esta seleccionada
                    fondoBlanco();
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {//aqui se agrega el evento cuando sele da clic a la celda
                if (Principal.estaJugando) {//verifica si el usuario esta jugando
                    clic(true);
                }
            }
        });
    }

    //metodo para poner el color de fondo de la celda cuando el puntero del mouse esta encina
    public void fondoVerde() {
        this.setBackground(Color.green);
    }

    //metodo para poner el color de fondo de la celda
    public void fondoBlanco() {
        this.setBackground(Color.WHITE);
    }

    //este metodo realizara todas la funciones que ocurrira cuando se da clic en una celda, el parametro indicara si el clic fue dado por el usuario o por el programa
    public void clic(boolean valido) {
        if (!Principal.gano) {//verifica si no a ganado el juego
            if (!this.seleccionada)//verifica si la casilla no esta seleccionada
            {
                if (!"".equals(this.getName())) {//verifica si esta celda tiene alguna letra de las palabras buscadas
                    int aux = Integer.parseInt(this.getName());
                    Principal.palabra[aux].setLongitudencontrada(Principal.palabra[aux].getLongitudencontrada() + 1);
                    if (Principal.palabra[aux].getLongitudencontrada() == Principal.palabra[aux].getLongitud()) {
                        Principal.palabra[aux].tachar();
                        Principal.palabrastachadas++;
                        if (Principal.palabrastachadas == Principal.npalabras)//verifica si ya encontro todas las palabras
                        {
                            Principal.gano = true;//indica que ya el usuario resolvio el sopa de letras
                            Principal.estaJugando = false;
                            if (valido) {//verifica si fue el usuario quien resolvio el sopa de letras
                                int puntaje = 5000 * Principal.npalabras - Principal.errores * 100 - Principal.hor * 3600 - Principal.min * 60 - Principal.seg >= 0 ? 10000 - Principal.errores * 100 - Principal.hor - Principal.min - Principal.seg : 0;
                                guardarPuntajeAlto(puntaje);
                                Gano gano = new Gano(Principal.Escritorio);
                                Principal.Escritorio.add(gano);
                                gano.show();
                                gano.setVisible(true);
                                JOptionPane.showMessageDialog(null, "su puntaje es " + puntaje);
                            }
                        }
                    }
                }
                this.seleccionada = true;
                if (this.getName().equals("")) {
                    this.setBackground(colorfondoceldaselecionada);//pone la casilla del color colorfondoceldaselecionada
                    Principal.errores++;
                    Principal.JLerrores.setText("" + Principal.errores);//Asigna al label JLerrores la nueva cantidad de errores
                } else {
                    this.setBackground(Principal.palabra[Integer.parseInt(this.getName())].getColortachada());//pone la casilla del color designado para esa palabra
                }
            } else {
                if (!"".equals(this.getName())) {//verifica si esta celda tiene alguna letra de las palabras buscadas
                    int aux = Integer.parseInt(this.getName());//catura el nombre de la palabra
                    Principal.palabra[aux].setLongitudencontrada(Principal.palabra[aux].getLongitudencontrada() - 1);//disminuye la cantidad de letras encontradas de esta palabra
                    if (Principal.palabra[aux].getLongitudencontrada() < Principal.palabra[aux].getLongitud()) {//verifica si la longitud de letras encontrada es menor que la longitud de letras de la palabra
                        Principal.palabra[aux].destachar();
                        Principal.palabrastachadas--;//disminuye la cantidad de palabras encontradas
                    }
                }
                this.seleccionada = false;
                fondoBlanco();//pone de color blanco la celda
            }
        }
    }

    public boolean isSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;
    }

    public void guardarPuntajeAlto(int nuevalinea) {
        File ficheroAntiguo = new File("src/puntajesalto.txt");
        /*Obtengo un numero aleatorio*/
        Random numaleatorio = new Random(3816L);
        /*Creo un nombre para el nuevo fichero apartir del 
         *numero aleatorio*/
        String nombreFicheroNuevo = ficheroAntiguo.getParent() + "/auxiliar" + String.valueOf(Math.abs(numaleatorio.nextInt())) + ".txt";
        /*Crea un objeto File para el fichero nuevo*/
        File FficheroNuevo = new File(nombreFicheroNuevo);
        try {
            /*Si existe el fichero inical*/
            if (ficheroAntiguo.exists()) {
                /*Abro un flujo de lectura*/
                BufferedReader Flee = new BufferedReader(new FileReader(ficheroAntiguo));
                String Slinea;
                boolean modifico = false;//esta variable indica si ya se ha puesto el puntaje
                /*Recorro el fichero de texto linea a linea*/
                while ((Slinea = Flee.readLine()) != null) {
                    /*para modificar*/
                    if (!modifico && Integer.parseInt(Slinea) < nuevalinea) {
                        /*Escribo la nueva linea en vez de la que tenia*/
                        EcribirFichero(FficheroNuevo, "" + nuevalinea);
                        modifico = true;
                    } else {
                        /*Escribo la linea antigua*/
                        EcribirFichero(FficheroNuevo, Slinea);
                    }
                }
                /*Obtengo el nombre del fichero inicial*/
                File nombreAntiguo = new File("src/" + ficheroAntiguo.getName());
                /*Cierro el flujo de lectura*/
                Flee.close();
                /*Borro el fichero inicial*/
                ficheroAntiguo.delete();
                /*renombro el nuevo fichero con el nombre del  fichero inicial*/
                FficheroNuevo.renameTo(nombreAntiguo);
            } else {
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/
            System.out.println(ex.getMessage());
        }
    }

    public void EcribirFichero(File Ffichero, String SCadena) {
        try {
            //Si no Existe el fichero lo crea  
            if (!Ffichero.exists()) {
                Ffichero.createNewFile();
            }
            /*Abre un Flujo de escritura,sobre el fichero con codificacion utf-8.  
             *Además  en el pedazo de sentencia "FileOutputStream(Ffichero,true)", 
             *true es por si existe el fichero seguir añadiendo texto y no borrar lo que tenia*/
            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero, true), "utf-8"));
            /*Escribe en el fichero la cadena que recibe la función.  
             *el string "\r\n" significa salto de linea*/
            Fescribe.write(SCadena + "\r\n");
            //Cierra el flujo de escritura  
            Fescribe.close();
        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla   
            System.out.println(ex.getMessage());
        }
    }
}
