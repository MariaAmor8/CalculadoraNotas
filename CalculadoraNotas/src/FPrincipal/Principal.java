package FPrincipal;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		
		bEnviar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					calcularPromedio();
				} catch (MiExcepcion e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				txtNombre.setText("");
				txtNota1.setText("");
				txtNota2.setText("");
				txtNota3.setText("");
			}
			
		});
		
		this.pack();
	}
	

	protected void calcularPromedio() throws MiExcepcion{
		try {
		double nota1 = Double.parseDouble(this.txtNota1.getText());
		double nota2 = Double.parseDouble(this.txtNota2.getText());
		double nota3 = Double.parseDouble(this.txtNota3.getText());
		double promedio = (nota1 + nota2 + nota3)/3;
		if(promedio > 5) {
			throw new MiExcepcion("El promedio no puede ser mayor a 5");
		}
		else if(nota1 < 0 || nota2 < 0 || nota3 <0 ) {
			throw new MiExcepcion("No puede ingresar valores negativos");
		}
		else {
		JOptionPane.showMessageDialog(this, "El promedio de "+ this.txtNombre.getText()+" es: \n"+promedio);
		}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "solo puede ingresar valores numericos");
		}
		
	}

	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.ejecutar();

	}

}
