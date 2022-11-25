/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import negocio.controllers.GestorConsultas;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.Usuario;
import net.ucanaccess.util.Logger;
import persistencia.CursoPropioDAO;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
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
	// Code">//GEN-BEGIN:initComponents
	private void initComponents(Usuario user) {

		ListarEdiciones = new javax.swing.JFrame();
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
		btnOrdenarFechas = new javax.swing.JButton();
		jComboBox1 = new javax.swing.JComboBox<>();

		ListarEdiciones.setAutoRequestFocus(false);
		ListarEdiciones.setSize(new java.awt.Dimension(400, 400));

		javax.swing.GroupLayout ListarEdicionesLayout = new javax.swing.GroupLayout(ListarEdiciones.getContentPane());
		ListarEdiciones.getContentPane().setLayout(ListarEdicionesLayout);
		ListarEdicionesLayout.setHorizontalGroup(ListarEdicionesLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		ListarEdicionesLayout.setVerticalGroup(ListarEdicionesLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));

		
		ConsultarIngresos.setSize(new java.awt.Dimension(400, 400));

		lblUserIngresos.setText("Usuario: " + user.getDNI());

		javax.swing.GroupLayout ConsultarIngresosLayout = new javax.swing.GroupLayout(
				ConsultarIngresos.getContentPane());
		ConsultarIngresos.getContentPane().setLayout(ConsultarIngresosLayout);
		ConsultarIngresosLayout.setHorizontalGroup(ConsultarIngresosLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(ConsultarIngresosLayout.createSequentialGroup().addContainerGap()
						.addGroup(ConsultarIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblUserIngresos).addComponent(lblSinTit).addComponent(labelConTit)
								.addComponent(lblEnsProp).addComponent(lblTotal))
						.addContainerGap(336, Short.MAX_VALUE)));
		ConsultarIngresosLayout.setVerticalGroup(ConsultarIngresosLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(ConsultarIngresosLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblUserIngresos).addGap(30, 30, 30).addComponent(lblSinTit).addGap(18, 18, 18)
						.addComponent(labelConTit).addGap(18, 18, 18).addComponent(lblEnsProp).addGap(18, 18, 18)
						.addComponent(lblTotal).addContainerGap(192, Short.MAX_VALUE)));

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setAutoRequestFocus(false);
		setSize(new java.awt.Dimension(400, 400));

		lblUser.setText(" Usuario :" + user.getDNI());

		btnConsultarIngresos.setText("Consultar Ingresos");

		btnListarEdiciones.setText("Listar Ediciones");

		btnConsultarCursos.setText("Consultar cursos");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(lblUser))
						.addGroup(layout.createSequentialGroup().addGap(124, 124, 124)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btnConsultarIngresos, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnListarEdiciones, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnConsultarCursos, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				.addContainerGap(123, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(lblUser).addGap(18, 18, 18)
						.addComponent(btnConsultarIngresos).addGap(27, 27, 27).addComponent(btnListarEdiciones)
						.addGap(27, 27, 27).addComponent(btnConsultarCursos).addContainerGap(123, Short.MAX_VALUE)));
		buttons(user);
		pack();
	}// </editor-fold>//GEN-END:initComponents

	public void buttons(final Usuario user) {
		btnConsultarIngresos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ConsultarIngresos.setVisible(true);
				lblUser.setText("Usuario :" + user.getDNI());
				String[] ingresos;
				try {
					ingresos = GestorConsultas.obtenerIngresos();
					double sum = Double.parseDouble(ingresos[0]) + Double.parseDouble(ingresos[1])
							+ Double.parseDouble(ingresos[2]);

					lblSinTit.setText("Enseñanzas sin titulación: " + ingresos[0] + "€");

					labelConTit.setText("Enseñanzas con titulación:" + ingresos[1] + "€");

					lblEnsProp.setText("Enseñanzas propias:" + ingresos[2] + "€");

					lblTotal.setText("Total: " + sum + "€");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Logger.log("mensaje de error");

				}

			}
		});
		btnConsultarCursos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				consultarCursos.setSize(new java.awt.Dimension(1500, 500));

				
			/*	List<CursoPropio> cursos = null;
				try {
					cursos = CursoPropioDAO.obtenerCursosPorTipo(CursoPropioDAO.obtenerCursos(),
							EstadoCurso.PROPUESTA_RECHAZADA);
					cursos.addAll(
							CursoPropioDAO.obtenerCursosPorTipo(CursoPropioDAO.obtenerCursos(), EstadoCurso.VALIDADO));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				String cabecera[] = { "Id", "Nombre", "ETCS", "Fecha Inicio", "Fecha Fin", "Tasa Matricula", "Edicion",
						"Estado", "Tipo", "Centro", "Director", "Secretario", "Fecha Matricula", "Ultima Modificacion",
						"Motivo de Rechazo" };
				DefaultTableModel Tabla = new DefaultTableModel(null, cabecera);
				JTable tablaCursos = new JTable(Tabla);
				JScrollPane rollo = new JScrollPane(tablaCursos);
				add(rollo);
				DefaultTableModel tabla = (DefaultTableModel) tablaCursos.getModel();
				String[] c = new String[cabecera.length];
				
				jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fechas"," Fechas" }));

		        
				btnOrdenarFechas.setText("Ordenar");
				SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
				/*for (int i = 0; i < cursos.size(); i++) {
					CursoPropio curso = cursos.get(i);
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
					c[12] = fecha.format(curso.getFecha_matriculacion());
					c[13] = fecha.format(curso.getUltima_modificacion());
					c[14] = curso.getMotivo_Rechazo();
					tabla.addRow(c);

				}*/
				
				/*javax.swing.GroupLayout consultarCursosLayout = new javax.swing.GroupLayout(consultarCursos.getContentPane());
		        consultarCursos.getContentPane().setLayout(consultarCursosLayout);
		        consultarCursosLayout.setHorizontalGroup(
		            consultarCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, consultarCursosLayout.createSequentialGroup()
		                .addContainerGap(0, 0)
		                .addComponent(rollo, 0, 1500,1500)
		                .addGap(0, 0, 0))
		        );
		        consultarCursosLayout.setVerticalGroup(
		            consultarCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, consultarCursosLayout.createSequentialGroup()
		                .addContainerGap(27, Short.MAX_VALUE)
		                .addComponent(rollo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addGap(32, 32, 32))
		        );
*/
		        javax.swing.GroupLayout consultarCursosLayout = new javax.swing.GroupLayout(consultarCursos.getContentPane());
		        consultarCursos.getContentPane().setLayout(consultarCursosLayout);
		        consultarCursosLayout.setHorizontalGroup(
		            consultarCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(consultarCursosLayout.createSequentialGroup()
		                .addGap(0,0,0)
		                .addComponent(rollo, 0, 1500,1500)
		                .addContainerGap(0, 0))
		            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultarCursosLayout.createSequentialGroup()
		                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addGap(0, 18, 18)
		                .addComponent(btnOrdenarFechas)
		                .addGap(480, 480, 480))
		        );
		        consultarCursosLayout.setVerticalGroup(
		            consultarCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultarCursosLayout.createSequentialGroup()
		                .addContainerGap(27, Short.MAX_VALUE)
		                .addGroup(consultarCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(btnOrdenarFechas))
		                .addGap(0, 0, 0)
		                .addComponent(rollo, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addGap(32,32,32))
		        );
		        
				consultarCursos.setVisible(true);
				
				
			

			}
		});
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
	private javax.swing.JButton btnOrdenarFechas;
	private javax.swing.JButton btnConsultarCursos;
	private javax.swing.JLabel labelConTit;
	private javax.swing.JLabel lblEnsProp;
	private javax.swing.JLabel lblSinTit;
	private javax.swing.JLabel lblTotal;
	private javax.swing.JLabel lblUser;
	private javax.swing.JLabel lblUserIngresos;
	private javax.swing.JComboBox<String> jComboBox1;
	// End of variables declaration//GEN-END:variables
}
