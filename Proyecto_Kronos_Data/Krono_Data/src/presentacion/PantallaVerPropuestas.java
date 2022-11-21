package presentacion;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import persistencia.CursoPropioDAO;

public class PantallaVerPropuestas extends javax.swing.JFrame {

	private static TableModel Tabla = null;
	private JPanel contentPane;
	private JScrollPane rollo;
	private JTable tablaCursos;
	private JTextPane textPane;
	private JLabel label_2;
	private JTextArea textFieldMotivo;
	List<CursoPropio> cursos = CursoPropioDAO.obtenerCursosPorTipo(CursoPropioDAO.obtenerCursos(), EstadoCurso.PROPUESTO);
	
	public PantallaVerPropuestas() throws Exception{
		
		setTitle("Cursos propuestos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		String cabecera[] = { "Id", "Nombre", "ETCS", "Fecha Inicio", "Fecha Fin", "Tasa Matricula", "Edicion",
				"Estado", "Tipo", "Centro", "Director", "Secretario" };
		Tabla = new DefaultTableModel(null, cabecera);
		tablaCursos = new JTable(Tabla);
		rollo = new JScrollPane(tablaCursos);
		add(rollo);
		rollo.setBounds(6, 200, 1270, 400);
		DefaultTableModel tabla = (DefaultTableModel) tablaCursos.getModel();
		
		String[] c = new String[cabecera.length];
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
		
		for (int i = 0; i < cursos.size(); i++) {
			CursoPropio curso = cursos.get(i);
			c[0] = curso.getId();
			c[1] = curso.getNombre();
			c[2] = String.valueOf(curso.getECTS());
			c[3] = fecha.format(curso.getFechaInicio());
			c[4] = fecha.format(curso.getFechaFin());
			c[5] = String.valueOf(curso.getTasaMatricula());
			c[6] = String.valueOf(curso.getEdicion());
			c[7] = curso.getTipo().toString();
			c[8] = curso.getEstado().toString();
			c[9] = curso.getCentro().getNombre();
			c[10] = curso.getDirector().getDNI();
			c[11] = curso.getSecretario().getDNI();

			tabla.addRow(c);

		}	
		
		
		
		
	
			
			
			
	}
		
}
	


