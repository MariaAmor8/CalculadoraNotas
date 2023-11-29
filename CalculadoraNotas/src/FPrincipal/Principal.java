package FPrincipal;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Principal extends JFrame{
	JTextField txtNombre;
	JTextField txtNota1;
	JTextField txtNota2;
	JTextField txtNota3;
	
	public void ejecutar() {
		this.setPreferredSize(new Dimension(400,300));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		this.setLayout(new GridLayout(5,2));
		this.txtNombre = new JTextField();
		this.txtNota1 = new JTextField();
		this.txtNota2 = new JTextField();
		this.txtNota3 = new JTextField();
		
		this.add(new JLabel("Nombre"));
		this.add(this.txtNombre);
		this.add(new JLabel("Nota 1"));
		this.add(this.txtNota1);
		this.add(new JLabel("Nota 2"));
		this.add(this.txtNota2);
		this.add(new JLabel("Nota 3"));
		this.add(this.txtNota3);
		
		JButton bEnviar = new JButton("Calcular promedio");
		this.add(bEnviar);
		
		this.pack();
	}
	
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.ejecutar();

	}

}
