
package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.WindowConstants;
import negocio.entities.ProfesorUCLM;


public class PantallaDireccionCursos extends JFrame {
	private JPanel contentPane;
	private JTextPane textPane;
	
	public PantallaDireccionCursos(final ProfesorUCLM profesor) {
		setTitle("Interfaz profesor");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Estado");
		label1.setForeground(Color.RED);
		label1.setBounds(6, 140, 61, 16);
		contentPane.add(label1);
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 168, 400, 75);
		contentPane.add(textPane);
		textPane.setText(profesor.toString());
		
		JLabel label2 = new JLabel("Como profesor puede: ");
		label2.setBounds(10,20,130,30);
		contentPane.add(label2);
		
		JButton bproponer = new JButton("Proponer/editar títulos o cursos");
		bproponer.setBounds(125, 72, 215, 30);
		contentPane.add(bproponer);
		bproponer.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				PantallaDireccionCursosEditarProponer frame;
				try {
					 frame = new PantallaDireccionCursosEditarProponer(profesor);
					 frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					PantallaErrores err = new PantallaErrores(e1.toString());
					err.setVisible(true);
				}
			}
		});
		JButton bver = new JButton("Ver las propuestas de cursos");
		bver.setBounds(125, 112, 215, 30);
		contentPane.add(bver);
		bver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				PantallaVerPropuestas frame;
				try {
					frame = new PantallaVerPropuestas();
					frame.setVisible(true);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					PantallaErrores err = new PantallaErrores(e1.toString());
					err.setVisible(true);
				}
			}
		});
		
		
	}
	public void altaCurso() {
		// TODO - implement PantallaDireccionCursos.altaCurso
		throw new UnsupportedOperationException();
	}

	public void edicionCurso() {
		// TODO - implement PantallaDireccionCursos.edicionCurso
		throw new UnsupportedOperationException();
	}

}
