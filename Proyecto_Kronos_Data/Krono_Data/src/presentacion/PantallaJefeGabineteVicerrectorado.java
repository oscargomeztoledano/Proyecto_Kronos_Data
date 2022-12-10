/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import negocio.controllers.GestorConsultas;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.Usuario;
import persistencia.CursoPropioDAO;

import java.awt.event.*;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author david
 * 
 *         NOTA: Cada vez que se edita la interfaz se sobreescribe todo de
 *         initComponets(), y pierdes tu codigo Hay que añadir al final, antes
 *         de la llamada a pack(), y llamar a la funcion buttons(), para que los
 *         botones funcionen
 * 
 *         Tambien, en la label lblUser, hay que poner en el setText(), la
 *         variable "String u"
 */
public class PantallaJefeGabineteVicerrectorado extends javax.swing.JFrame {

	/**
	 * Creates new form PantallaJefeGabineteVicerrectorado
	 */

	Usuario user;
	DefaultTableModel modelo = new DefaultTableModel();


	public PantallaJefeGabineteVicerrectorado(Usuario user) {
		initComponents(user);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(Usuario user) {

        ListarEdiciones = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        scrollPane2 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        consultarCursos = new javax.swing.JFrame();
        ConsultarIngresos = new javax.swing.JFrame();
        lblUserIngresos = new javax.swing.JLabel();
        lblSinTit = new javax.swing.JLabel();
        labelConTit = new javax.swing.JLabel();
        lblEnsProp = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        btnConsultarIngresos = new javax.swing.JButton();
        btnListarEdiciones = new javax.swing.JButton();
        btnConsultarCursos = new javax.swing.JButton();

        ListarEdiciones.setAutoRequestFocus(false);
        ListarEdiciones.setSize(new java.awt.Dimension(1200, 600));

        jLabel1.setText("Usuario: ");

        jLabel2.setText("Escriba la edicion a consultar: ");

        jButton2.setText("Mostrar resultados");

        jScrollPane1.setViewportView(jTable1);

        scrollPane2.add(jScrollPane1);

        javax.swing.GroupLayout listarEdicionesLayout = new javax.swing.GroupLayout(ListarEdiciones.getContentPane());
        ListarEdiciones.getContentPane().setLayout(listarEdicionesLayout);
        listarEdicionesLayout.setHorizontalGroup(
            listarEdicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listarEdicionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listarEdicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listarEdicionesLayout.createSequentialGroup()
                        .addGroup(listarEdicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(listarEdicionesLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2))
                        .addGap(0, 1080, Short.MAX_VALUE))
                    .addComponent(scrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        listarEdicionesLayout.setVerticalGroup(
            listarEdicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listarEdicionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(listarEdicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        ConsultarIngresos.setSize(new java.awt.Dimension(400, 400));

        lblUserIngresos.setText("Usuario: "+user.getDNI());

        javax.swing.GroupLayout consultarIngresosLayout = new javax.swing.GroupLayout(ConsultarIngresos.getContentPane());
        ConsultarIngresos.getContentPane().setLayout(consultarIngresosLayout);
        consultarIngresosLayout.setHorizontalGroup(
            consultarIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultarIngresosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(consultarIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserIngresos)
                    .addComponent(lblSinTit)
                    .addComponent(labelConTit)
                    .addComponent(lblEnsProp)
                    .addComponent(lblTotal))
                .addContainerGap(336, Short.MAX_VALUE))
        );
        consultarIngresosLayout.setVerticalGroup(
            consultarIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultarIngresosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserIngresos)
                .addGap(30, 30, 30)
                .addComponent(lblSinTit)
                .addGap(18, 18, 18)
                .addComponent(labelConTit)
                .addGap(18, 18, 18)
                .addComponent(lblEnsProp)
                .addGap(18, 18, 18)
                .addComponent(lblTotal)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setSize(new java.awt.Dimension(400, 400));

        lblUser.setText("Usuario: "+user.getDNI());

        btnConsultarIngresos.setText("Consultar Ingresos");

        btnListarEdiciones.setText("Listar Ediciones");

        btnConsultarCursos.setText("Consultar cursos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUser))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConsultarIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListarEdiciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultarCursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblUser)
                .addGap(18, 18, 18)
                .addComponent(btnConsultarIngresos)
                .addGap(27, 27, 27)
                .addComponent(btnListarEdiciones)
                .addGap(27, 27, 27)
                .addComponent(btnConsultarCursos)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        buttons(user);
        pack();
    }// </editor-fold>//GEN-END:initComponents

	public void buttons(final Usuario user) {

		btnConsultarIngresos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ConsultarIngresos.setVisible(true);
				lblUser.setText("Usuario :"+user.getDNI() );
				String[] ingresos;
				try {
					ingresos = GestorConsultas.obtenerIngresos();
					double sum = Double.parseDouble(ingresos[0]) +  Double.parseDouble(ingresos[1])
							+  Double.parseDouble(ingresos[2]);
					lblSinTit.setText("Enseñanzas sin titulación: " + ingresos[0] + "€");

					labelConTit.setText("Enseñanzas con titulación:" + ingresos[1] + "€");

					lblEnsProp.setText("Enseñanzas propias:" + ingresos[2] + "€");

					lblTotal.setText("Total: " + sum + "€");
				} catch (Exception e) {
					// TODO Auto-generated catch block

				}

			}
		});
		btnConsultarCursos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				consultarCursos.setSize(new java.awt.Dimension(1500, 500));

				List<CursoPropio> cursos = null;
				try {
					cursos = CursoPropioDAO.obtenerCursos();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String[] cabecera = { "Id", "Nombre", "ETCS", "Fecha Inicio", "Fecha Fin", "Tasa Matricula", "Edicion",
						"Estado", "Tipo", "Centro", "Director", "Secretario", "Fecha Matricula", "Ultima Modificacion",
						"Motivo de Rechazo" };
				DefaultTableModel tabla = new DefaultTableModel(null, cabecera);
				JTable tablaCursos = new JTable(tabla);
				JScrollPane rollo = new JScrollPane(tablaCursos);
				add(rollo);
				DefaultTableModel tabla1 = (DefaultTableModel) tablaCursos.getModel();
				TableRowSorter<TableModel> tablaOrdenada = new TableRowSorter<TableModel>(tabla1);
				tablaCursos.setRowSorter(tablaOrdenada);
				String[] c = new String[cabecera.length];

			

				
				SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
				for (CursoPropio curso : cursos) {
					if (curso.getEstado().equals(EstadoCurso.PROPUESTA_RECHAZADA)
							|| curso.getEstado().equals(EstadoCurso.VALIDADO)) {

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
				}
				consultarCursos.setTitle("Consultar Cursos Validados o Rechazados");
				javax.swing.GroupLayout consultarCursosLayout = new javax.swing.GroupLayout(
						consultarCursos.getContentPane());
				consultarCursos.getContentPane().setLayout(consultarCursosLayout);
				consultarCursosLayout.setHorizontalGroup(
						consultarCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(consultarCursosLayout.createSequentialGroup().addGap(0, 0, 0)
										.addComponent(rollo, 0, 1500, 1500).addContainerGap(0, 0))

				);
				consultarCursosLayout
						.setVerticalGroup(
								consultarCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												consultarCursosLayout.createSequentialGroup()
														.addContainerGap(27, Short.MAX_VALUE).addGap(0, 0, 0)
														.addComponent(rollo, javax.swing.GroupLayout.PREFERRED_SIZE,
																400, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(32, 32, 32)));

				consultarCursos.setVisible(true);

			}

		});

		btnListarEdiciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListarEdiciones.setVisible(true);
			}
		});

		jButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String ed = jTextField1.getText();
				List<CursoPropio> cursos;

				try {
					cursos = GestorConsultas.ediciones(ed);
					Object[][] a = new Object[cursos.size()][15];
					SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
					int i = 0;
					for (CursoPropio c : cursos) {
						a[i][0] = c.getId();
						a[i][1] = c.getNombre();
						a[i][2] = String.valueOf(c.getEcts());
						a[i][3] = fecha.format(c.getFechaInicio());
						a[i][4] = fecha.format(c.getFechaFin());
						a[i][5] = String.valueOf(c.getTasaMatricula());
						a[i][6] = String.valueOf(c.getEdicion());
						a[i][7] = c.getTipo().toString();
						a[i][8] = c.getEstado().toString();
						a[i][9] = c.getCentro().getNombre();
						a[i][10] = c.getDirector().getDNI();
						a[i][11] = c.getSecretario().getDNI();
						a[i][12]=fecha.format(c.getFechaMatriculacion());
						a[i][13]=fecha.format(c.getUltimaModificacion());
						a[i][14]=c.getMotivoRechazo();

						i++;
					}
					tabla(a);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

	public void tabla(Object [][] a) {
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				a,
				new String[] { "Id", "Nombre", "ECTS", "Fecha inicio", "Fecha fin", "Tasa matricula", "Edicion",
						"Tipo curso", "Estado curso", "Nombre centro", "Director", "Secretario","Fecha Matricula","Ultima Modificacion","Motivo Rechazo" }));
	}

	/**
	 * @param args the command line arguments
	 */


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JFrame ConsultarIngresos;
	private javax.swing.JFrame ListarEdiciones;
	private javax.swing.JFrame consultarCursos;
	private javax.swing.JButton btnConsultarIngresos;
	private javax.swing.JButton btnListarEdiciones;
	private javax.swing.JButton btnConsultarCursos;
	private javax.swing.JLabel labelConTit;
	private javax.swing.JLabel lblEnsProp;
	private javax.swing.JLabel lblSinTit;
	private javax.swing.JLabel lblTotal;
	private javax.swing.JLabel lblUser;
	private javax.swing.JLabel lblUserIngresos;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JTextField jTextField1;
  private java.awt.ScrollPane scrollPane2;
  // End of variables declaration//GEN-END:variables

}
