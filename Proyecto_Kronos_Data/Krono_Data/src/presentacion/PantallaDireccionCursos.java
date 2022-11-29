
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
import net.ucanaccess.util.Logger;


public class PantallaDireccionCursos extends JFrame {
	private JPanel contentPane;
	private JTextPane textPane;
	
	public PantallaDireccionCursos(final ProfesorUCLM profesor) {
		setTitle("Interfaz profesor");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("Estado");
		label_1.setForeground(Color.RED);
		label_1.setBounds(6, 140, 61, 16);
		contentPane.add(label_1);
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 168, 400, 75);
		contentPane.add(textPane);
		textPane.setText(profesor.toString());
		
		JLabel label_2 = new JLabel("Como profesor puede: ");
		label_2.setBounds(10,20,130,30);
		contentPane.add(label_2);
		
		JButton Bproponer = new JButton("Proponer/editar títulos o cursos");
		Bproponer.setBounds(125, 72, 215, 30);
		contentPane.add(Bproponer);
		Bproponer.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				PantallaDireccionCursosEditarProponer frame;
				try {
					 frame = new PantallaDireccionCursosEditarProponer(profesor);
					 frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					Logger.log("mensaje de error");
				}
			}
		});
		JButton Bver = new JButton("Ver las propuestas de cursos");
		Bver.setBounds(125, 112, 215, 30);
		contentPane.add(Bver);
		Bver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				PantallaDireccionCursosEditarProponer frame;
				try {
					frame = new PantallaDireccionCursosEditarProponer(profesor);
					frame.setVisible(true);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					Logger.log("mensaje de error");
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
