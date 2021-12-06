package Frame;
import Clases.*;//llama todas las clases de la carpeta Clases
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Principal extends javax.swing.JFrame {

    /** creado nuevo formulario Principal */
    public static int errores;//esta variable cuenta cuantas veces el usuario selecciono una casilla distinta a la de una letra de una palabra buscada
    public static Color colorcelda;//esta variable indica el color de letra de las celda del sopa de letras
    public static int nfilas;//indica el numero de filas
    public static int ncolumnas;//indica el numero de columnas
    public static int npalabras;//indica la cantidad de palabra que hay en el sopa de letras
    public static int palabrastachadas;//esta variable indica cuantas palabras han sido tachadas
    public static boolean estaJugando;//esta variable indica si el usuario esta o no jugando
    public static boolean gano;//esta variable indica que resolvio o no el sopa de letra
    public static boolean configuracionesvisible;//indica si el panel de configuraciones es visible, esto sirve para que no se habra dos o mas veces
    public static boolean puntajealto;//indica si la ventana de puntajes altos es visible, esto sirve para que no se habra dos o mas veces
    public static Celda celda[][];//matriz que almacena las celda del sopa de letras
    public static String palabras[];//En este arreglo se guardan las palabras pero en String
    public static Palabra palabra[];//En este arreglo se guardan las palabras
    Timer timer;//variable para el tiempo
    public static int hor, min, seg, cseg;//requerido para indicar la hora,minuto,segundo y sentesimas de segundo del cronometro
    int color=0;//requerido para el timer
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        configuracionesvisible=false;  
        puntajealto=false;
        nfilas=15;
        ncolumnas=15;
        palabras=new String[20];
        timer = new Timer(10, tiempo);//inicia la variable timer 
        buscarPalabras();
        cargar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        Escritorio = new javax.swing.JDesktopPane();
        PanelPalabras = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JLerrores = new javax.swing.JLabel();
        JPsopaletra = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLtiempo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jLabel2.setBackground(new java.awt.Color(240, 240, 0));
        jLabel2.setText("jLabel1");
        jLabel2.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png")));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PanelPalabras.setLayout(new java.awt.GridLayout(10, 2, 10, 10));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("SOPA DE LETRAS");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("PALABRAS");

        jButton1.setBackground(new java.awt.Color(0, 102, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 0, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Finalizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Errores");

        JLerrores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLerrores.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLerrores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel1)
                    .addComponent(JLerrores)))
        );

        JPsopaletra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPsopaletra.setLayout(new java.awt.GridLayout(15, 15));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("TIEMPO");

        jLtiempo.setFont(new java.awt.Font("Castellar", 1, 11)); // NOI18N
        jLtiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLtiempo.setText("00:00:00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLtiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLtiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Escritorio.setLayer(PanelPalabras, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(JPsopaletra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EscritorioLayout.createSequentialGroup()
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EscritorioLayout.createSequentialGroup()
                        .addComponent(JPsopaletra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanelPalabras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, 0))
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EscritorioLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(EscritorioLayout.createSequentialGroup()
                        .addComponent(PanelPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE))
                    .addComponent(JPsopaletra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        jMenu1.setText("Menu");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/resolver.png"))); // NOI18N
        jMenuItem2.setText("Resolver");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/trofeo.png"))); // NOI18N
        jMenuItem3.setText("Puntajes alto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jMenuItem4.setText("Salir");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuracion.png"))); // NOI18N
        jMenu2.setText("Configuraciones");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        abrirPanelConfiguraciones();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         System.out.println("guardo");
        guardarPalabras();//Guarda las palabras que estan el panel
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (!estaJugando) {//verifica si el usuario no esta jugando
        reiniciarCronometro();
        gano=false;
        errores=0;
        JLerrores.setText("0");
        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas; j++) {
                celda[i][j].setName("");
                celda[i][j].setText("");
                celda[i][j].setSeleccionada(false);
                celda[i][j].fondoBlanco();
            }
        }
        for (int i = 0; i < 20; i++) {//recorre todas la 20 pabras y verifica cual esta llena y si esta llena es porque esta en el panel y la coloca en el sopa de letras
            if (!"".equals(palabra[i].getText())) {
                if (palabra[i].isTachada()){
                    palabra[i].destachar();
                    Principal.palabra[i].setLongitudencontrada(0);
                }               
                palabra[i].colocarpalabra();
            }
        }        
        palabrastachadas=0;
        timer.start();//Iniciar cronometro
        Principal.estaJugando=true;
        
        this.llenarEspaciosVacios();
     }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    if (estaJugando&&JOptionPane.showConfirmDialog(null, "Realmente dese finalir el juego","Finalizar juego",JOptionPane.YES_NO_OPTION)==0) {//verifica que el usuario si esta jugando y si esta jugando pregunta si realmente desea finalizar el juego
        timer.stop();//pausa el cronometro
        reiniciarCronometro();
        JOptionPane.showMessageDialog(null, "Juego finalizado");//envia un mensaje al usuario para que sepa que finalizo el juego
    }    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // resolver
        if (estaJugando) {
            for (int i = 0; i < nfilas; i++) {
                for (int j = 0; j < ncolumnas; j++) {
                    if (!celda[i][j].getName().equals("")&&celda[i][j].getBackground().equals(Color.WHITE)) {
                        celda[i][j].clic(false);
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (!puntajealto) {
            Puntajealto puntajealto=new Puntajealto(Escritorio);            
            Escritorio.add(puntajealto);
            puntajealto.show();
            puntajealto.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        guardarPalabras();//cuado se cierra la ventana se guardan las palabras
    }//GEN-LAST:event_formWindowClosing
    //metodo para cargar las variables del juego
    public boolean cargar()
    {
        Principal.palabra=new Palabra[20];
        for (int i = 0; i < 20; i++) {
            Principal.palabra[i]=new Palabra(i);
            Principal.palabra[i].cambiarTexto(palabras[i]);
            if (i<npalabras) {
               PanelPalabras.add(this.palabra[i]); 
            }
        }        
        this.celda=new Celda[this.nfilas][this.ncolumnas];//define la catidad de filas y columnas de la matriz del sopa de letra
        this.JPsopaletra.setLayout(new java.awt.GridLayout(nfilas,ncolumnas));//
        boolean cargo=true;//Variable que indica si cargo correctamente el juego
        for (int i = 0; i < this.nfilas; i++) {
            for (int j = 0; j < ncolumnas; j++) {
                this.celda[i][j]=new Celda(i,j);
                this.JPsopaletra.add(celda[i][j]);
            }
        }    
        return cargo;
    }
    public void llenarEspaciosVacios() 
    {
        //este arreglo ayuda a poner las letras del avecedario
        String abc[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        Random random=new Random();
        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas; j++) {
                if (celda[i][j].getText().equals("")) {//si la casilla esta vacia pongale una letra del arreglo abc
                    celda[i][j].setText(abc[(int)(random.nextDouble()*abc.length-1)]);//aqui pone la letra
                }
            }
        }
    }
    public void abrirPanelConfiguraciones(){
        if (!this.estaJugando&&!this.configuracionesvisible) {
            JInternalFrame panelConfiguraciones=new Configuracion(Escritorio);
            this.Escritorio.add(panelConfiguraciones);
            panelConfiguraciones.show();
            panelConfiguraciones.setVisible(true);
        }else if(this.estaJugando){
            if (JOptionPane.showConfirmDialog(null, "Debe finalizar el juego para realizar las configuraciones ¿finalizar el juego ahora?","Información",JOptionPane.YES_NO_OPTION)==0) {
                Principal.estaJugando=false;
                timer.stop();
                abrirPanelConfiguraciones();
            } 
        }      
    }
    /**
     * @param args the command line arguments
     */
    //Metodo para poner a la escucha el cronometro
     private ActionListener tiempo=new ActionListener() {
        public void actionPerformed (ActionEvent ae ) {
            cronometro();
        }
    };
     public void cronometro(){//este metodo se encarga de hace avanzar el cronometro
         if (estaJugando) {
            timer.start();
            cseg++;            
            if (cseg == 60) {
                cseg = 0;
                seg++;
            }
            if (seg == 60) {
                seg = 0;
                min++;
                color=min;
            }
            if (min == 60) {
                min = 0;
                hor++;                
            }
            //Aqui se asigna el tiempo al label jLtiempo
            jLtiempo.setText((hor > 9 ? "" : "0") + hor + ":" + (min > 9 ? "" : "0") + min + ":" + (seg >9 ? "" : "0") + seg);
         }
     }
     public void reiniciarCronometro(){
          Principal.estaJugando=false;//indica que ya finalizo el juego
            hor=0;
            min=0;
            seg=0;
            cseg=0;
    }
    public void buscarPalabras(){
        try{
            // Abrimos el archivo
            FileInputStream fstream = new FileInputStream("palabras.txt");
            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            // Leer el archivo linea por linea
            for (int i = 0; i < 20; i++) {
                if ((strLinea = buffer.readLine()) != null) {
                    npalabras++;
                    palabras[i]=strLinea;
                    if (palabras[i].length()>10) {
                        JOptionPane.showMessageDialog(rootPane, "La palabra "+palabras[i]+" Supera la 10 letras, por favor corrija el archivo palabras.txt", "Error", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }else{
                        if (palabras[i].length()<1) {
                            JOptionPane.showMessageDialog(rootPane, "La palabra Nº "+i+" no cumple el minimo de 1 letra, por favor corrija el archivo palabras.txt", "Error", JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                        }
                    }
                }else{
                    palabras[i]="";
                }
            }
            // Cerramos el archivo
            entrada.close();
        }catch (Exception e){ //Catch de excepciones
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
    }
    public void guardarPalabras() {
        File ficheroAntiguo=new File("palabras.txt");
        /*Obtengo un numero aleatorio*/  
        Random numaleatorio= new Random(3816L);   
        /*Creo un nombre para el nuevo fichero apartir del 
         *numero aleatorio*/  
        String nombreFicheroNuevo=ficheroAntiguo.getParent()+"/auxiliar"+String.valueOf(Math.abs(numaleatorio.nextInt()))+".txt";  
        /*Crea un objeto File para el fichero nuevo*/  
        File FficheroNuevo=new File(nombreFicheroNuevo);  
        try {   
                for (int i = 0; i < palabras.length; i++) {
                    if (!palabras[i].equals("")) {
                        BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FficheroNuevo,true), "utf-8"));  
                        /*Escribe en el fichero la cadena que recibe la función.  
                         *el string "\r\n" significa salto de linea*/  
                        Fescribe.write(palabras[i] + "\r\n");  
                        //Cierra el flujo de escritura  
                        Fescribe.close();
                    }
                }                          
                /*Obtengo el nombre del fichero inicial*/  
                File nombreAntiguo=new File(" "+ficheroAntiguo.getName()); 
                /*Borro el fichero inicial*/  
                ficheroAntiguo.delete();
                /*renombro el nuevo fichero con el nombre del  fichero inicial*/  
                FficheroNuevo.renameTo(nombreAntiguo);    
        } catch (Exception ex) {  
            /*Captura un posible error y le imprime en pantalla*/   
             System.out.println(ex.getMessage());  
        }  
    }
    public void EcribirFichero(File Ffichero,String SCadena){  
        try {  
                //Si no Existe el fichero lo crea  
                 if(!Ffichero.exists()){  
                     Ffichero.createNewFile();  
                 }  
                /*Abre un Flujo de escritura,sobre el fichero con codificacion utf-8.  
                 *Además  en el pedazo de sentencia "FileOutputStream(Ffichero,true)", 
                 *true es por si existe el fichero seguir añadiendo texto y no borrar lo que tenia*/  
                BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero,true), "utf-8"));  
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
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Escritorio;
    public static javax.swing.JLabel JLerrores;
    public static javax.swing.JPanel JPsopaletra;
    public static javax.swing.JPanel PanelPalabras;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLtiempo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
