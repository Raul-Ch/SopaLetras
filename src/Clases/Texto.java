package Clases;

import Frame.Principal;
import Frame.Configuracion;
import javax.swing.JTextField;


public class Texto extends JTextField
{
    private int id;
    private boolean lleno;//esta variable indica si el cuadro de texto tiene o no una palabra
    public Texto(int id){
        this.id=id;//asigana el id
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.setText(Principal.palabras[id]);
        this.lleno=!this.getText().equals("");//esto indica si el cuadro de texto tiene o no una palabra
        this.setHorizontalAlignment(javax.swing.JTextField.CENTER);        
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt){
                validarPalabra(evt);
            }
        });
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                pierdeFoco();
            }
        });
    }
    public void pierdeFoco(){
        this.setText(this.getText().toUpperCase());
        if (!lleno&&!this.getText().equals("")) {
            Principal.npalabras++;//incrementa el numero de palabras
            Principal.PanelPalabras.add(Principal.palabra[id]);
            lleno=true;
        }else if(lleno&&this.getText().equals("")){
            Principal.npalabras--;//disminuye el numero de palabras
            Principal.PanelPalabras.remove(Principal.palabra[id]);
            lleno=false;
        }
        Principal.palabra[id].cambiarTexto(this.getText());
        Configuracion.jLnpalabras.setText(""+Principal.npalabras);
        Principal.palabras[id]=this.getText();
        Principal.PanelPalabras.updateUI();
    }
    public void validarPalabra(java.awt.event.KeyEvent evt){          
        if(!Character.isLetter(evt.getKeyChar())||getText().length()>=10) {
            evt.consume();
        }   
    }        
}
