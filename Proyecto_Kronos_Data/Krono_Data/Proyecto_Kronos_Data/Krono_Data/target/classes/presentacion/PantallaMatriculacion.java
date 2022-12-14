package presentacion;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import negocio.controllers.GestorMatriculacion;
import negocio.entities.CursoPropio;
import negocio.entities.Estudiante;
import negocio.entities.ModoPago;
import persistencia.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author david
 */
public class PantallaMatriculacion extends javax.swing.JFrame {

	/**
	 * Creates new form PantallaMatriculacion
	 * 
	 * @throws ClassNotFoundException
	 */
	public PantallaMatriculacion(Estudiante estudiante) throws ClassNotFoundException {
		List<CursoPropio> cursos = CursoPropioDAO.obtenerCursos();
		String[] c = new String[cursos.size()];
		int i = 0;
		for (CursoPropio cp : cursos) {
			c[i] = cursos.get(i++).getNombre();
		}

		initComponents(c, estudiante, cursos);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents(String[] c, final Estudiante estudiante, final List<CursoPropio> cursos) {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox<>();
		jComboBox2 = new javax.swing.JComboBox<>();
		jButton1 = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Usuario: " + estudiante.getDNI());

		jLabel2.setText("Seleccione curso");

		jLabel3.setText("Modo de pago");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(c));

		jComboBox2
				.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transferencia", "Tarjeta Credito" }));

		jButton1.setText("Validar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				int s = jComboBox1.getSelectedIndex();
				CursoPropio curso = cursos.get(s);

				String SeleccionTipoPago = (String) jComboBox2.getSelectedItem();
				ModoPago Pago = null;
				switch (SeleccionTipoPago) {
				case "Transferencia":
					Pago = ModoPago.TRANSFERENCIA;
					break;
				case "Tarjeta Credito":
					Pago = ModoPago.TARJETA_CREDITO;
					break;

				}
				if (GestorMatriculacion.realizarMatriculacion(curso, estudiante, Pago) == 1) {
					jTextArea1.setText("La matricula realizada del curso: " + curso.getNombre()
							+ " por el estudiante con DNI: " + estudiante.getDNI());

				} else {
					jTextArea1.setText("Error, la matricula ya existe");

				}

			}
		});

		jLabel4.setForeground(java.awt.Color.red);
		jLabel4.setText("Estado");
		jTextArea1.setEditable(false);
		jTextArea1.setColumns(36);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jButton1)
						.addContainerGap())
				.addGroup(layout.createSequentialGroup().addGap(32, 32, 32).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel4)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2).addComponent(jLabel3).addComponent(jLabel1))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85,
										Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jComboBox1, 0, 150, Short.MAX_VALUE).addComponent(jComboBox2, 0,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(42, 42, 42)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(24, 24, 24).addComponent(jLabel1).addGap(46, 46, 46)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(38, 38, 38)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(jLabel4)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(78, 78, 78).addComponent(jButton1))
								.addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(18, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton1ActionPerformed

	/**
	 * @param args the command line arguments
	 */

	// </editor-fold>

	/* Create and display the form */

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JComboBox<String> jComboBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JScrollPane jScrollPane1;
	public static javax.swing.JTextArea jTextArea1;
	// End of variables declaration//GEN-END:variables
}
