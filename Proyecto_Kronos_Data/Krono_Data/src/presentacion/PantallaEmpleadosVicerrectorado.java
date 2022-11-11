package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import persistencia.CursoPropioDAO;

public class PantallaEmpleadosVicerrectorado extends JFrame{
	private static  TableModel Tabla = null;
	private JPanel contentPane;
	private JScrollPane rollo;
	private JTable tablaCursos;
	List<CursoPropio> cursos = CursoPropioDAO.obtenerCursosPorTipo(CursoPropioDAO.obtenerCursos(), EstadoCurso.PROPUESTO);
	public PantallaEmpleadosVicerrectorado() throws ClassNotFoundException, Exception {
		setTitle("Evaluar Cursos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String cabecera[]= {"Id","Nombre","ETCS","Fecha Inicio","Fecha Fin","Tasa Matricula","Edicion","Estado","Tipo","Centro","Director","Secretario"};
		Tabla= new DefaultTableModel(null,cabecera);
		 tablaCursos = new JTable(Tabla);
		 rollo = new JScrollPane(tablaCursos);
		add(rollo);
		rollo.setBounds(6,200,1270,400);
		DefaultTableModel tabla= (DefaultTableModel) tablaCursos.getModel();
		JButton BEvaluar = new JButton("Evaluar");
		BEvaluar.setBounds(1120, 120, 120, 35);
		contentPane.add(BEvaluar);
		BEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					evaluarCurso(cursos.get(tablaCursos.getSelectedRow()));

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		String[] c = new String[cabecera.length];
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<cursos.size();i++) {
			CursoPropio curso=cursos.get(i);
			c[0]=curso.getId();
			c[1]=curso.getNombre();
			c[2]=String.valueOf(curso.getECTS());
			c[3]=fecha.format(curso.getFechaInicio());
			c[4]=fecha.format(curso.getFechaFin());
			c[5]=String.valueOf(curso.getTasaMatricula());
			c[6]=String.valueOf(curso.getEdicion());
			c[7]=curso.getTipo().toString();
			c[8]=curso.getEstado().toString();
			c[9]=curso.getCentro().getNombre();
			c[10]=curso.getDirector().getDNI();
			c[11]=curso.getSecretario().getDNI();
			
			tabla.addRow(c);
			
				
			}
		}
		
		
		
	

	public void evaluarCurso(CursoPropio curso) {
	
	}

}