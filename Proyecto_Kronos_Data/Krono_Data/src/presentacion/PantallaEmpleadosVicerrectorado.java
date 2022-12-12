package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
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

import negocio.controllers.GestorPropuestasCursos;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import persistencia.CursoPropioDAO;

public class PantallaEmpleadosVicerrectorado extends JFrame {
	private static TableModel tabla = null;
	private JPanel contentPane;
	private JScrollPane rollo;
	private JTable tablaCursos;
	private JTextPane textPane;
	private JLabel label2;
	private JTextArea textFieldMotivo;
	List<CursoPropio> cursos = CursoPropioDAO.obtenerCursosPorTipo(CursoPropioDAO.obtenerCursos(),
			EstadoCurso.PROPUESTO);

	public PantallaEmpleadosVicerrectorado() throws Exception {
		setTitle("Evaluar Cursos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 1600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] cabecera = { "Id", "Nombre", "ETCS", "Fecha Inicio", "Fecha Fin", "Tasa Matricula", "Edicion",
				"Estado", "Tipo", "Centro", "Director", "Secretario" ,"Fecha Matricula","Ultima Modificacion","Motivo de Rechazo"};
		tabla = new DefaultTableModel(null, cabecera);
		tablaCursos = new JTable(tabla);
		rollo = new JScrollPane(tablaCursos);
		add(rollo);
		rollo.setBounds(6, 200, 1570, 400);
		DefaultTableModel tabla = (DefaultTableModel) tablaCursos.getModel();
		JButton bEvaluar = new JButton("Evaluar");
		bEvaluar.setBounds(1120, 30, 120, 35);
		contentPane.add(bEvaluar);

		final JButton bAceptar = new JButton("Aceptar");
		bAceptar.setBounds(1120, 80, 120, 35);
		contentPane.add(bAceptar);
		bAceptar.setVisible(false);

		final JButton bRechazar = new JButton("Rechazar");
		bRechazar.setBounds(1120, 130, 120, 35);
		contentPane.add(bRechazar);
		bRechazar.setVisible(false);

		bEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					evaluarCurso(cursos.get(tablaCursos.getSelectedRow()), bRechazar, bAceptar);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					textPane.setText("Por favor seleccione un curso para poder evaluar");

				}
			}
		});

		String[] c = new String[cabecera.length];
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < cursos.size(); i++) {
			CursoPropio curso = cursos.get(i);
			c[0] = curso.getId();
			System.out.println(c[0]);
			c[1] = curso.getNombre();
			c[2] = String.valueOf(curso.getEcts());
			c[3] = fecha.format(curso.getFechaInicio());
			c[4] = fecha.format(curso.getFechaFin());
			c[5] = String.valueOf(curso.getTasaMatricula());
			c[6] = String.valueOf(curso.getEdicion());
			c[7] = curso.getTipo().toString();
			c[8] = curso.getEstado().toString();
			c[9] = curso.getCentro().getNombre();
			c[10] = curso.getDirector().getDNI();
			c[11] = curso.getSecretario().getDNI();
			c[12]=fecha.format(curso.getFechaMatriculacion());
			c[13]=fecha.format(curso.getUltimaModificacion());
			c[14]=curso.getMotivoRechazo();

			
			

			tabla.addRow(c);

		}

		JLabel label1 = new JLabel("Estado");
		label1.setForeground(Color.RED);
		label1.setBounds(6, 10, 61, 16);
		contentPane.add(label1);

		textPane = new JTextPane();
		textPane.setToolTipText(
				"Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 40, 300, 150);
		contentPane.add(textPane);

		label2 = new JLabel("Descripcion");
		label2.setForeground(Color.RED);
		label2.setBounds(400, 10, 70, 16);
		contentPane.add(label2);
		label2.setVisible(false);

		textFieldMotivo = new JTextArea(7, 20);
		textFieldMotivo.setBounds(400, 40, 300, 150);
		contentPane.add(textFieldMotivo);
		textFieldMotivo.setVisible(false);

	}

	public void evaluarCurso(final CursoPropio curso, JButton bRechazar, JButton bAceptar) {

		textPane.setText("El curso " + curso.getNombre() + " ha sido seleccionado para \n poder ser evaluado");

		bRechazar.setVisible(true);
		final GestorPropuestasCursos gestor = new GestorPropuestasCursos();
		bRechazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JButton bEnvio = new JButton("Enviar motivo");
					bEnvio.setBounds(800, 130, 120, 35);
					contentPane.add(bEnvio);
					textPane.setText("El curso " + curso.getNombre()
							+ " ha sido rechazado\n Por favor describa el motivo del rechazo --->");
					label2.setVisible(true);
					textFieldMotivo.setVisible(true);
					bEnvio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {

								if (gestor.evaluarPropuesta(curso, EstadoCurso.PROPUESTA_RECHAZADA,textFieldMotivo.getText()) == 1) {
									textPane.setText("El curso " + curso.getNombre() + " ha sido rechazada");

								} else {
									textPane.setText("El curso " + curso.getNombre() + " no se ha podido rechazar");

								}

							} catch (Exception e) {
								// TODO Auto-generated catch block
								PantallaErrores err = new PantallaErrores(e.toString());
								err.setVisible(true);
							}
						}
					});

				} catch (Exception e) {
					// TODO Auto-generated catch block
					PantallaErrores err = new PantallaErrores(e.toString());
					err.setVisible(true);
				}
			}
		});

		bAceptar.setVisible(true);
		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					if (gestor.evaluarPropuesta(curso, EstadoCurso.VALIDADO,textFieldMotivo.getText()) == 1) {
						textPane.setText("El curso " + curso.getNombre() + " ha sido aceptado");

					} else {
						textPane.setText("El curso " + curso.getNombre() + " no se ha podido aceptar");

					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					PantallaErrores err = new PantallaErrores(e.toString());
					err.setVisible(true);
				}
			}
		});
	}

}
