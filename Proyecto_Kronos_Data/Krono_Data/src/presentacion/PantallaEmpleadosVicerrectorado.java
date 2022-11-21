package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import negocio.controllers.GestorPropuestasCursos;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import persistencia.CursoPropioDAO;

public class PantallaEmpleadosVicerrectorado extends JFrame {
	private static TableModel Tabla = null;
	private JPanel contentPane;
	private JScrollPane rollo;
	private JTable tablaCursos;
	private JTextPane textPane;
	private JLabel label_2;
	private JTextArea textFieldMotivo;
	List<CursoPropio> cursos = CursoPropioDAO.obtenerCursosPorTipo(CursoPropioDAO.obtenerCursos(),
			EstadoCurso.PROPUESTO);

	public PantallaEmpleadosVicerrectorado() throws ClassNotFoundException, Exception {
		setTitle("Evaluar Cursos");
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
		JButton BEvaluar = new JButton("Evaluar");
		BEvaluar.setBounds(1120, 30, 120, 35);
		contentPane.add(BEvaluar);

		final JButton BAceptar = new JButton("Aceptar");
		BAceptar.setBounds(1120, 80, 120, 35);
		contentPane.add(BAceptar);
		BAceptar.setVisible(false);

		final JButton BRechazar = new JButton("Rechazar");
		BRechazar.setBounds(1120, 130, 120, 35);
		contentPane.add(BRechazar);
		BRechazar.setVisible(false);

		BEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					evaluarCurso(cursos.get(tablaCursos.getSelectedRow()), BRechazar, BAceptar);

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
			System.out.println(c[0].toString());
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

		JLabel label_1 = new JLabel("Estado");
		label_1.setForeground(Color.RED);
		label_1.setBounds(6, 10, 61, 16);
		contentPane.add(label_1);

		textPane = new JTextPane();
		textPane.setToolTipText(
				"Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 40, 300, 150);
		contentPane.add(textPane);

		label_2 = new JLabel("Descripcion");
		label_2.setForeground(Color.RED);
		label_2.setBounds(400, 10, 70, 16);
		contentPane.add(label_2);
		label_2.setVisible(false);

		textFieldMotivo = new JTextArea(7, 20);
		textFieldMotivo.setBounds(400, 40, 300, 150);
		contentPane.add(textFieldMotivo);
		textFieldMotivo.setVisible(false);

	}

	public void evaluarCurso(final CursoPropio curso, JButton BRechazar, JButton BAceptar) {

		textPane.setText("El curso " + curso.getNombre() + " ha sido seleccionado para \n poder ser evaluado");

		BRechazar.setVisible(true);
		final GestorPropuestasCursos gestor = new GestorPropuestasCursos();
		BRechazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JButton BEnvio = new JButton("Enviar motivo");
					BEnvio.setBounds(800, 130, 120, 35);
					contentPane.add(BEnvio);
					textPane.setText("El curso " + curso.getNombre()
							+ " ha sido rechazado\n Por favor describa el motivo del rechazo --->");
					label_2.setVisible(true);
					textFieldMotivo.setVisible(true);
					BEnvio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {

								if (gestor.evaluarPropuesta(curso, EstadoCurso.PROPUESTA_RECHAZADA) == 1) {
									textPane.setText("El curso " + curso.getNombre() + " ha sido rechazada");

								} else {
									textPane.setText("El curso " + curso.getNombre() + " no se ha podido rechazar");

								}

							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		BAceptar.setVisible(true);
		BAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					if (gestor.evaluarPropuesta(curso, EstadoCurso.VALIDADO) == 1) {
						textPane.setText("El curso " + curso.getNombre() + " ha sido aceptado");

					} else {
						textPane.setText("El curso " + curso.getNombre() + " no se ha podido aceptar");

					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
