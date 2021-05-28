/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

/*Zona de imports*/
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author jorge
 */
public class AppCalculadora implements ActionListener {

    /*Zona de variables*/
    int c; //C es para diferenciar el operador 
    Double n; //N para mostrar el resultado
    String s1, s2, s3, s4, s5; //Con estos String podemos almacenar los numeros

    /*Zona de objetos*/
    Frame f; //Nuestro objeto Frame
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b16, b17, b18, b19, b20, b21; //Botones de la calculadora
    Button bad, bai; //Botones para activar la derecha y la izquierda
    Panel pc, pd, pi, pa; //Los diferentes paneles que tendrá nuestro frame
    TextField tf; //El cuadro de texto donde se escribirán los numeros y resultados
    BorderLayout miBorderLayout; //layout que ubica los componentes en cualquiera de sus 5 regiones
    GridLayout num, gd, gi; //Los GridLayout que usaremos para los paneles
    CardLayout cardLayout; //CardLayout para el panel de abajo
    Dimension dim; //La dimension para que las pestañas de los lados sean iguales
    Menu pest1, pest2, pest3, pest4, pest5, pest7; //Las diferentes pestañas que tendrá el menú
    MenuItem item1, item2, item3, item4, item5, item6, item7; //Los items de las diferentes pestañas
    MenuBar barramenu; //La barra donde colocaremos los menús y sus items

    //Constructor que usaremos para iniciar la calculadora
    AppCalculadora() {

        /*Zona del frame*/
        f = new Frame("Calculadora JM"); //Nombre de la ventana
        f.setSize(400, 300); //Aplicamos el tamaño de la ventana con el metodo setSize
        f.setVisible(true); //Ponemos el frame visible
        f.setLocationRelativeTo(null); //Con este metodo conseguimos que la ventana se abra en el centro de la pantalla

        //Creamos los paneles
        pc = new Panel(); //Panel del centro
        pd = new Panel(); //Panel de la derecha
        pi = new Panel(); //Panel de la izquierda
        pa = new Panel(); //Panel de abajo

        //Añadimos los paneles al frame
        f.add(pc);
        f.add(pd);
        f.add(pi);
        f.add(pa);

        //Creamos los diferentes botones y elementos que habrá en la calculadora
        /*Botones de la calculadora y operadores*/
        b1 = new Button("0");
        b1.addActionListener(this);
        b2 = new Button("1");
        b2.addActionListener(this);
        b3 = new Button("2");
        b3.addActionListener(this);
        b4 = new Button("3");
        b4.addActionListener(this);
        b5 = new Button("4");
        b5.addActionListener(this);
        b6 = new Button("5");
        b6.addActionListener(this);
        b7 = new Button("6");
        b7.addActionListener(this);
        b8 = new Button("7");
        b8.addActionListener(this);
        b9 = new Button("8");
        b9.addActionListener(this);
        b10 = new Button("9");
        b10.addActionListener(this);
        b11 = new Button("+");
        b11.addActionListener(this);
        b12 = new Button("-");
        b12.addActionListener(this);
        b13 = new Button("*");
        b13.addActionListener(this);
        b14 = new Button("/");
        b14.addActionListener(this);
        b16 = new Button("=");
        b16.addActionListener(this);
        b17 = new Button("C");
        b17.addActionListener(this);
        b18 = new Button("√");
        b18.addActionListener(this);
        b19 = new Button("xº");
        b19.addActionListener(this);
        b20 = new Button("π");
        b20.addActionListener(this);
        b21 = new Button("log");
        b21.addActionListener(this);

        //Ponemos los botones del lado izquierdo ocultos 
        b18.setVisible(false);
        b19.setVisible(false);
        b20.setVisible(false);
        b21.setVisible(false);

        //Creamos los botones para activar o desactivar las funciones
        bad = new Button("Activar funciones basicas");
        bad.addActionListener(this);
        bai = new Button("Activar funciones complejas");
        bai.addActionListener(this);

        //Creamos el cuadro de texto para nuestra linea de operaciones
        tf = new TextField("");
        f.add(tf);

        //Establecemos las filas, columnas, espacio horizontal, espacio vertical
        num = new GridLayout(4, 3, 4, 4);
        gd = new GridLayout(4, 1, 4, 4);
        gi = new GridLayout(4, 1, 4, 4);
        cardLayout = new CardLayout();

        //Establecemos el layaout de los paneles con los valores dados
        pc.setLayout(num);
        pd.setLayout(gd);
        pi.setLayout(gi);
        pa.setLayout(cardLayout);

        //Hacemos que los paneles de izq y derech midan lo mismo
        dim = new Dimension(120, 0);
        pd.setPreferredSize(dim);
        pi.setPreferredSize(dim);

        //Creamos un BorderLayout para colocar los diferentes paneles en las 5 regiones
        miBorderLayout = new BorderLayout(5, 0);
        f.setLayout(miBorderLayout);

        f.add(tf, "North"); //Campo de texto arriba
        f.add(pc, "Center"); //Panel central en el centro
        f.add(pd, "East"); //Panel derecho en la derecha
        f.add(pi, "West"); //Panel izquierdo en la izquierda
        f.add(pa, "South"); //Panel abajo, abajo

        //Añadimos los botones a los diferentes paneles
            /*Panel central*/
        pc.add(b1);pc.add(b2);pc.add(b3);pc.add(b4);
        pc.add(b5);pc.add(b6);pc.add(b7);pc.add(b8);
        pc.add(b9);pc.add(b10);pc.add(b17);pc.add(b16);

            /*Panel derecho*/
        pd.add(b11);
        pd.add(b12);
        pd.add(b13);
        pd.add(b14);

            /*Panel izquierdo*/
        pi.add(b18);
        pi.add(b19);
        pi.add(b20);
        pi.add(b21);

            /*Panel abajo*/
        pa.add(bad);
        pa.add(bai);

        //Zona de menu
            /*Pestañas*/
        pest1 = new Menu("Calculadora");
        pest2 = new Menu("Creditos");
        pest3 = new Menu("Politica de privacidad");
        pest4 = new Menu("Autor");
        pest5 = new Menu("Vista");
        pest7 = new Menu("Color de fondo");

            /*Items*/
        item1 = new MenuItem("Sumar");
        item2 = new MenuItem("Restar");
        item3 = new MenuItem("Multiplicar");
        item4 = new MenuItem("Dividir");
        item5 = new MenuItem("Negro");
        item5.addActionListener(this);
        item6 = new MenuItem("Blanco");
        item6.addActionListener(this);
        item7 = new MenuItem("Jorge Moya");

            /*Añadimos cada item a su pestaña*/
        pest1.add(item1);
        pest1.add(item2);
        pest1.add(item3);
        pest1.add(item4);

        pest4.add(item7);
        pest2.add(pest4);

        pest7.add(item5);
        pest7.add(item6);
        
        pest5.add(pest7);

        barramenu = new MenuBar(); //Creamos la barra del menu
        //Le añadimos las pestañas
        barramenu.add(pest1);
        barramenu.add(pest2);
        barramenu.add(pest3);
        barramenu.add(pest5);

        //Establecemos esa barra como la de nuestro frame
        f.setMenuBar(barramenu);

        //Hacemos que la ventana se cierre al clicar en la cruz
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == b1) {
            s3 = tf.getText();
            s4 = "0";
            s5 = s3 + s4;
            tf.setText(s5);
        }
        if (e.getSource() == b2) {
            s3 = tf.getText();
            s4 = "1";
            s5 = s3 + s4;
            tf.setText(s5);
        }
        if (e.getSource() == b3) {
            s3 = tf.getText();
            s4 = "2";
            s5 = s3 + s4;
            tf.setText(s5);
        }
        if (e.getSource() == b4) {
            s3 = tf.getText();
            s4 = "3";
            s5 = s3 + s4;
            tf.setText(s5);
        }
        if (e.getSource() == b5) {
            s3 = tf.getText();
            s4 = "4";
            s5 = s3 + s4;
            tf.setText(s5);
        }
        if (e.getSource() == b6) {
            s3 = tf.getText();
            s4 = "5";
            s5 = s3 + s4;
            tf.setText(s5);
        }
        if (e.getSource() == b7) {
            s3 = tf.getText();
            s4 = "6";
            s5 = s3 + s4;
            tf.setText(s5);
        }
        if (e.getSource() == b8) {
            s3 = tf.getText();
            s4 = "7";
            s5 = s3 + s4;
            tf.setText(s5);
        }
        if (e.getSource() == b9) {
            s3 = tf.getText();
            s4 = "8";
            s5 = s3 + s4;
            tf.setText(s5);
        }
        if (e.getSource() == b10) {
            s3 = tf.getText();
            s4 = "9";
            s5 = s3 + s4;
            tf.setText(s5);
        }
        if (e.getSource() == b11) {
            s1 = tf.getText();
            tf.setText("");
            c = 1; //Operador de suma

        }
        if (e.getSource() == b12) {
            s1 = tf.getText();
            tf.setText("");
            c = 2; //Operador de resta

        }
        if (e.getSource() == b13) {
            s1 = tf.getText();
            tf.setText("");
            c = 3; //Operador de multiplicar

        }
        if (e.getSource() == b14) {
            s1 = tf.getText();
            tf.setText("");
            c = 4; //Operador de división

        }
        if (e.getSource() == b18) {
            s1 = tf.getText();
            tf.setText("");

            n = Math.sqrt(Double.parseDouble(s1));
            tf.setText(String.valueOf(n));

        }
        if (e.getSource() == b19) {
            s1 = tf.getText();
            tf.setText("");
            c = 5;
        }
        if (e.getSource() == b20) {
            s4 = "3.1415926";
            s5 = s4;
            tf.setText(s5);
        }
        if (e.getSource() == b21) {
            s1 = tf.getText();
            n = Math.log10(Double.parseDouble(s1));
            tf.setText(String.valueOf(n));

        }
        if (e.getSource()==item5) {
            f.setBackground(Color.black);
        }
        if (e.getSource()==item6) {
            f.setBackground(Color.white);
        }
        if (e.getSource() == bad) {
            b18.setVisible(false);
            b19.setVisible(false);
            b20.setVisible(false);
            b21.setVisible(false);

            b11.setVisible(true);
            b12.setVisible(true);
            b13.setVisible(true);
            b14.setVisible(true);

            cardLayout.next(pa);
        }
        if (e.getSource() == bai) {
            b18.setVisible(true);
            b19.setVisible(true);
            b20.setVisible(true);
            b21.setVisible(true);

            b11.setVisible(false);
            b12.setVisible(false);
            b13.setVisible(false);
            b14.setVisible(false);

            cardLayout.next(pa);
        }

        //Al pulsar el boton "igual" comprueba el operador gracias a C y realiza la operacion
        if (e.getSource() == b16) {
            s2 = tf.getText();
            if (c == 1) {
                n = Double.parseDouble(s1) + Double.parseDouble(s2);
                tf.setText(String.valueOf(n));
            } else if (c == 2) {
                n = Double.parseDouble(s1) - Double.parseDouble(s2);
                tf.setText(String.valueOf(n));
            } else if (c == 3) {
                n = Double.parseDouble(s1) * Double.parseDouble(s2);
                tf.setText(String.valueOf(n));
            } else if (c == 4) { //Para la division controlamos entre cero
                try {
                    double p = Double.parseDouble(s2);
                    if (p != 0.0) {
                        n = Double.parseDouble(s1) / Double.parseDouble(s2);
                        tf.setText(String.valueOf(n));
                    } else {
                        tf.setText("Infinito"); //Si introduce un 0 en la division salta el mensaje
                    }

                } catch (Exception i) {
                }
            } else if (c == 5) {
                int base, exponente;
                base = Integer.parseInt(s1);
                exponente = Integer.parseInt(s2);
                n = Math.pow(base, exponente);
                tf.setText(String.valueOf(n));
            }

        }
        if (e.getSource() == b17) {
            tf.setText("");
        }

    }

    public static void main(String[] args) {
        AppCalculadora v = new AppCalculadora();
        
    }
}
