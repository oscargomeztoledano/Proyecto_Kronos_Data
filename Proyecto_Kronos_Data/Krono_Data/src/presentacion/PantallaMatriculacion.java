package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.entities.Estudiante;

public class PantallaMatriculacion extends JFrame{
	
	private JPanel contentPane;

public PantallaMatriculacion(){
	setTitle("Matriculacion");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 485, 285);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
}
	public void realizarMatriculacion() {
		
		

	}

	

	

}