import java.awt.Color;
import javax.swing.*;



import java.awt.event.*;

public class Palabras extends JFrame implements ActionListener{
    private JLabel ingreso, palindromo, longitud, inversa, repetido;
    private JButton botonVerificar;
    private JTextField cajaPalabra, resultadoPalindromo, resultadoLongitud, resultadoInverso, resultadoRepetido;
    
    public Palabras(){
        super();
		configurarVentana();
		crearComponentes();
    }

    private void configurarVentana(){
		this.setTitle("Palabras");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.getContentPane().setBackground(new java.awt.Color(240,232,104));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
    }
    
    private void crearComponentes(){
        
        ingreso = new JLabel("Ingrese la palabra:");
		ingreso.setBounds(60, 0, 200, 60);
		ingreso.setForeground(Color.black);
        this.add(ingreso);
        
		botonVerificar = new JButton("Verificar");
		botonVerificar.setBounds(250, 50, 150, 30);
		botonVerificar.setForeground(Color.black);
		botonVerificar.addActionListener(this);
		botonVerificar.setBackground(new java.awt.Color(248,142,78));
        this.add(botonVerificar);
        
        palindromo = new JLabel("Palindromo: ");
		palindromo.setBounds(60, 100, 200, 60);
		palindromo.setForeground(Color.black);
        this.add(palindromo);
        
        longitud = new JLabel("Longitud: ");
		longitud.setBounds(60, 150, 200, 60);
		longitud.setForeground(Color.black);
        this.add(longitud);
        
        inversa = new JLabel("Inversa: ");
		inversa.setBounds(60, 200, 200, 60);
		inversa.setForeground(Color.black);
        this.add(inversa);
        
        repetido = new JLabel("Letra repetida: ");
		repetido.setBounds(60, 250, 200, 60);
		repetido.setForeground(Color.black);
		this.add(repetido);
        
        resultadoPalindromo = new JTextField();
		resultadoPalindromo.setBounds(225, 115, 200, 30);
        this.add(resultadoPalindromo);
        
        resultadoLongitud = new JTextField();
		resultadoLongitud.setBounds(225, 165, 200, 30);
        this.add(resultadoLongitud);
        
        resultadoInverso = new JTextField();
        resultadoInverso.setBounds(225, 215, 200, 30);
        this.add( resultadoInverso);
        
        resultadoRepetido = new JTextField();
        resultadoRepetido.setBounds(225, 265, 200, 30);
		this.add(resultadoRepetido);
        
		
		cajaPalabra = new JTextField();
		cajaPalabra.setBounds(225,15,200,30);
		this.add(cajaPalabra);
		
		
    }
    @Override 
    public void actionPerformed(ActionEvent e) {
        String palabra = cajaPalabra.getText().toLowerCase().replace(" ", "");
        
        int longitud = palabra.length();
        String longitud1 = String.valueOf(longitud);
        String palabraInversa= "";
        resultadoLongitud.setText(longitud1);

        

        for (int i = palabra.length() -1; i >= 0; i--) {
            palabraInversa += Character.toString(palabra.charAt(i));
        }

        resultadoInverso.setText(palabraInversa);

        if (palabra.equals(palabraInversa)) {
            resultadoPalindromo.setText("Si");
        }else{
            resultadoPalindromo.setText("No");
        }

        char [] letras;
        int mayorRepeticion = 0;
        char letraMasRepetida;

        letras = palabra.toCharArray();

        for(int i=0; i<palabra.length(); i++){
            char letraActual = letras[i];
            int contador = 0;
            for (int j =0; j<letras.length; j++){
                if (letras[j] == letraActual)
                    contador++;
            }

            if(mayorRepeticion < contador)
            {
                mayorRepeticion = contador;
                letraMasRepetida = letraActual;
                String letra = Character.toString(letraMasRepetida);
                resultadoRepetido.setText(letra);
            }
        }
	}
    public static void main(String[] args) {
        Palabras ventana = new Palabras();
        ventana.setVisible(true);
    }
    
}
