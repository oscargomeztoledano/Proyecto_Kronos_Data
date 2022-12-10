/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import negocio.controllers.GestorPropuestasCursos;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.Materia;
import negocio.entities.ProfesorUCLM;
import negocio.entities.TipoCurso;
import persistencia.CursoPropioDAO;

/**
 *
 * @author Daniel
 */
public class PantallaDireccionCursosEditarProponer extends javax.swing.JFrame {
	boolean cursoEditado = false;
	/**
	 * Creates new form PantallaDireccionCursosEditarProponer
	 * 
	 * @throws Exception
	 */
	public PantallaDireccionCursosEditarProponer(ProfesorUCLM profesor) throws Exception {

		String[] c = new String[TipoCurso.values().length];
		
		
		CursoPropio cursoAEditar = new CursoPropio("", "", 0, new Date(), new Date(), 0.0, 0, null, null, null, null, null, new Date(), new Date(), "", null);
		int i = 0;
		for (TipoCurso e : TipoCurso.values()) {
			c[i] = e.toString();
			i++;
		}

		initComponents(c, profesor, cursoAEditar);

	}

	private boolean SeleccionCursoAEditar(final CursoPropio curso) {
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
		
		jTextArea1.setText(curso.getMotivoRechazo());
		txtCentro.setText(curso.getCentro().getNombre());
		txtCreditos.setText(String.valueOf(curso.getEcts()));
		txtDniSecretario.setText(curso.getSecretario().getDNI());
		txtEdicionCurso.setText(String.valueOf(curso.getEdicion()));
		txtFechaFin.setText(fecha.format(curso.getFechaFin()));
		txtFechaInicio.setText(fecha.format(curso.getFechaInicio()));
		txtFechaMatr.setText(fecha.format(curso.getFechaMatriculacion()));
		txtNombreCurso.setText(curso.getNombre());
		txtTasaMatr.setText(String.valueOf(curso.getTasaMatricula()));

		return true;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents(final String[] c, final ProfesorUCLM profesor, final CursoPropio cursoAEditar)
			throws Exception {
		
		

		final Collection<Materia> materias = new ArrayList<Materia>();
		jFrame1 = new javax.swing.JFrame();
		jFrame2 = new javax.swing.JFrame();
		jButton3 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		txtNombreMateria = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		txtDniProfesorMateria = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		txtHorasMateria = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		txtFechaFinMateria = new javax.swing.JTextField();
		jLabel15 = new javax.swing.JLabel();
		txtFechaInicioMateria = new javax.swing.JTextField();
		jLabel16 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		txtDniSecretario = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		txtFechaInicio = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		txtCreditos = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtCentro = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		txtFechaFin = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		txtTasaMatr = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		txtEdicionCurso = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jLabel9 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox<>();
		jLabel10 = new javax.swing.JLabel();
		txtNombreCurso = new javax.swing.JTextField();
		jButton4 = new javax.swing.JButton();
		txtFechaMatr = new javax.swing.JTextField();
		jLabel17 = new javax.swing.JLabel();

		final List<CursoPropio> cursos = CursoPropioDAO.obtenerCursosPorTipo(CursoPropioDAO.obtenerCursos(),
				EstadoCurso.PROPUESTA_RECHAZADA);

		jButton3.setText("Insertar");

		jLabel11.setText("Nombre materia");

		jLabel12.setText("DNI Profesor");

		jLabel13.setText("Horas");

		jLabel15.setText("Fecha Fin");

		jLabel16.setText("Fecha Inicio");

		jButton5.setText("Editar");

		javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
		jFrame1.getContentPane().setLayout(jFrame1Layout);
		jFrame1Layout.setHorizontalGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jFrame1Layout.createSequentialGroup().addGroup(jFrame1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jFrame1Layout.createSequentialGroup().addGap(39, 39, 39).addGroup(jFrame1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel11)
								.addComponent(txtNombreMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel16)
								.addComponent(txtFechaInicioMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel13).addComponent(txtHorasMateria,
										javax.swing.GroupLayout.PREFERRED_SIZE, 97,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(49, 49, 49)
								.addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel12)
										.addComponent(txtDniProfesorMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel15).addComponent(txtFechaFinMateria,
												javax.swing.GroupLayout.PREFERRED_SIZE, 97,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(jFrame1Layout.createSequentialGroup().addGap(116, 116, 116).addComponent(jButton3,
								javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(52, Short.MAX_VALUE)));
		jFrame1Layout.setVerticalGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jFrame1Layout.createSequentialGroup().addGap(47, 47, 47)
								.addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(jFrame1Layout.createSequentialGroup()
												.addGroup(jFrame1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel11).addComponent(jLabel12))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jFrame1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(txtNombreMateria,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txtDniProfesorMateria,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(23, 23, 23).addComponent(jLabel16)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(
														txtFechaInicioMateria, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jFrame1Layout.createSequentialGroup().addComponent(jLabel15)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtFechaFinMateria,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(28, 28, 28).addComponent(jLabel13)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtHorasMateria, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(39, 39, 39).addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(40, Short.MAX_VALUE)));

		jLabel14.setText("Nombre materia");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("DNI Secretario");

		jLabel2.setText("Fecha inicio");

		jLabel3.setText("Créditos");

		jLabel4.setText("Centro");

		jLabel5.setText("Fecha finalización");

		jLabel6.setText("Tasa matrícula");

		jButton1.setText("Proponer");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				GestorPropuestasCursos gestor = new GestorPropuestasCursos();
				int resultado = 0;

				try {
					if (cursoEditado==true) {
						resultado = gestor.editarPropuestaCurso(cursoAEditar.getId(), txtNombreCurso.getText(),
								Integer.parseInt(txtCreditos.getText()), txtFechaInicio.getText(),
								txtFechaFin.getText(), Double.parseDouble(txtTasaMatr.getText()),
								Integer.parseInt(txtEdicionCurso.getText()), c[jComboBox1.getSelectedIndex()],
								txtCentro.getText(), profesor, txtDniSecretario.getText(), txtFechaMatr.getText(),
								materias);
						cursoEditado=false;
					} else {
						resultado = gestor.realizarPropuestaCurso(txtNombreCurso.getText(),
								Integer.parseInt(txtCreditos.getText()), txtFechaInicio.getText(),
								txtFechaFin.getText(), Double.parseDouble(txtTasaMatr.getText()),
								Integer.parseInt(txtEdicionCurso.getText()), c[jComboBox1.getSelectedIndex()],
								txtCentro.getText(), profesor, txtDniSecretario.getText(), txtFechaMatr.getText(),
								materias);
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (resultado == 1) {
					jTextArea1.setText("Propuesta enviada");
				} else
					jTextArea1.setText("Error en la propuesta");

			}
		});

		jButton2.setText("Editar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jFrame2.setSize(new java.awt.Dimension(1336, 459));

				String[] cabecera = { "Id", "Nombre", "ETCS", "Fecha Inicio", "Fecha Fin", "Tasa Matricula", "Edicion",
						"Estado", "Tipo", "Centro", "Director", "Secretario", "Fecha Matricula", "Ultima Modificacion",
						"Motivo de Rechazo" };

				DefaultTableModel tabla = new DefaultTableModel(null, cabecera);

				jTable1 = new JTable(tabla);
				jScrollPane2 = new JScrollPane(jTable1);
				add(jScrollPane2);

				String[] c = new String[cabecera.length];

				SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
				for (CursoPropio curso : cursos) {

					c[0] = curso.getId();
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
					c[12] = fecha.format(curso.getFechaMatriculacion());
					c[13] = fecha.format(curso.getUltimaModificacion());
					c[14] = curso.getMotivoRechazo();
					tabla.addRow(c);
				}

				javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
				jFrame2.getContentPane().setLayout(jFrame2Layout);
				jFrame2Layout
						.setHorizontalGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jFrame2Layout.createSequentialGroup().addGap(17, 17, 17)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1313,
												Short.MAX_VALUE)
										.addContainerGap())
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jFrame2Layout.createSequentialGroup()
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(23, 23, 23)));
				jFrame2Layout
						.setVerticalGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jFrame2Layout.createSequentialGroup().addContainerGap()
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59,
												Short.MAX_VALUE)
										.addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(21, 21, 21)));

				jFrame2.setVisible(true);
				jButton5.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						cursoAEditar.setId(cursos.get(jTable1.getSelectedRow()).getId());
						cursoEditado = SeleccionCursoAEditar(cursos.get(jTable1.getSelectedRow()));
						jFrame2.setVisible(false);
						
					}
				});
			}
		});

		jLabel7.setText("Edición del curso");

		jLabel8.setText("Tipo de curso");

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jLabel9.setForeground(java.awt.Color.red);
		jLabel9.setText("Estado");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(c));

		jLabel10.setText("Nombre del curso");

		jButton4.setText("Insertar materias");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jFrame1.setSize(new java.awt.Dimension(334, 343));
					jFrame1.setVisible(true);
					jButton3.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							Date fechaIn = null;
							Date fechaFinal = null;
							try {
								fechaIn = formatter.parse(txtFechaInicioMateria.getText());
								fechaFinal = formatter.parse(txtFechaFinMateria.getText());
							} catch (ParseException e) {
								e.printStackTrace();
							}
							Materia materia = new Materia(txtDniProfesorMateria.getText(), txtNombreMateria.getText(),
									Double.parseDouble(txtHorasMateria.getText()), fechaIn, fechaFinal);

							materias.add(materia);
						}
					});
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		});

		jLabel17.setText("Fecha de matriculación");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(74, 74, 74)
										.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(28, 28, 28).addComponent(jButton2,
												javax.swing.GroupLayout.PREFERRED_SIZE, 101,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(45, 45, 45).addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(
												jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(txtEdicionCurso,
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																txtCreditos, javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE, 111,
																Short.MAX_VALUE)
														.addComponent(txtFechaInicio,
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(txtDniSecretario,
																javax.swing.GroupLayout.Alignment.LEADING))
												.addComponent(jLabel9)
												.addComponent(txtNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE,
														109, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
														javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(54, 54, 54)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(txtCentro).addComponent(txtFechaFin)
														.addComponent(txtTasaMatr)
														.addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jComboBox1, 0,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(txtFechaMatr).addComponent(jLabel17,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)))))
								.addGroup(layout.createSequentialGroup().addGap(129, 129, 129).addComponent(jButton4)))
						.addContainerGap(54, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(28, 28, 28)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel17))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFechaMatr, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtDniSecretario, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCentro, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTasaMatr, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtEdicionCurso, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(27, 27, 27).addComponent(jLabel9)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(33, 33, 33)
						.addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(27, 27, 27)));

		
		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JTable jTable1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JFrame jFrame1;
	private javax.swing.JFrame jFrame2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField txtDniSecretario;
	private javax.swing.JTextField txtDniProfesorMateria;
	private javax.swing.JTextField txtHorasMateria;
	private javax.swing.JTextField txtFechaFinMateria;
	private javax.swing.JTextField txtFechaInicioMateria;
	private javax.swing.JTextField txtFechaMatr;
	private javax.swing.JTextField txtFechaInicio;
	private javax.swing.JTextField txtCreditos;
	private javax.swing.JTextField txtCentro;
	private javax.swing.JTextField txtFechaFin;
	private javax.swing.JTextField txtTasaMatr;
	private javax.swing.JTextField txtEdicionCurso;
	private javax.swing.JTextField txtNombreCurso;
	private javax.swing.JTextField txtNombreMateria;
	// End of variables declaration//GEN-END:variables
}
