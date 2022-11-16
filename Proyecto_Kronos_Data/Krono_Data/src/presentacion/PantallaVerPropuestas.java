package presentacion;
import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.Profesor;
import persistencia.*;

public class PantallaVerPropuestas extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextPane textPane;
	
	public PantallaVerPropuestas() throws Exception{
		
		CursoPropioDAO c = new CursoPropioDAO();
		EstadoCurso EstadoCurso = c.ComparacionEstadoCurso("PROPUESTO");
		List<CursoPropio> cursos = CursoPropioDAO.obtenerCursos();
		List<CursoPropio> CursosPropuestos = CursoPropioDAO.obtenerCursosPorTipo(cursos, EstadoCurso);

		String[] a = new String[CursosPropuestos.size()];
		int i=0;
		for (CursoPropio cp : CursosPropuestos) {
			a[i]=CursosPropuestos.get(i++).getNombre();
		}
		Pantalla(a);
	}
	private void Pantalla(String[] a) {
		setTitle("Ver Propuestas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel label_1 = new JLabel("Estado");
		label_1.setForeground(Color.RED);
		label_1.setBounds(6, 140, 61, 16);
		contentPane.add(label_1);
		JLabel label_2 = new JLabel("Listado de cursos propuestos:");
		label_2.setBounds(10,20,190,30);
		contentPane.add(label_2);
		
		
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 168, 400, 75);
		contentPane.add(textPane);
		
		int e=40;
		JLabel label = new JLabel("- " + a[0]);
		label.setBounds(125, e, 115, 30);
		contentPane.add(label);
		
//		for(int i = 0; i <= a.length; i++) {
//			JLabel label = new JLabel("- " + a[i]);
//			label.setBounds(125, e, 115, 30);
//			contentPane.add(label);
//			e+=30;
//		}
		
	}
	
}

