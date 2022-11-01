package presentacion;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import negocio.entities.Estudiante;

public class PantallaMatriculacion extends JFrame{
	
	private JPanel contentPane;
	private JTextPane textPane;

public PantallaMatriculacion(Estudiante estudiante){
	setTitle("Matriculacion");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 485, 285);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel label_1 = new JLabel("Estado");
	label_1.setForeground(Color.RED);
	label_1.setBounds(6, 120, 61, 16);
	contentPane.add(label_1);
	
	textPane = new JTextPane();
	textPane.setToolTipText("Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
	textPane.setEditable(false);
	textPane.setBounds(6, 168, 400, 75);
	contentPane.add(textPane);
	textPane.setText(estudiante.toString());
}
	public void realizarMatriculacion() {
		
		

	}

	

	

}