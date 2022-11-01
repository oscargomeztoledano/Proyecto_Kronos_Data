package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import negocio.controllers.*;
import negocio.entities.Estudiante;
import negocio.entities.Profesor;
import persistencia.EstudianteDAO;
import persistencia.GestorBD;
import persistencia.ProfesorDAO;

public class PantallaLogin extends JFrame implements ActionListener {
	private JTextPane textPane;
	private JPanel contentPane;
	private JTextField textFieldDNI;
	private JTextField textFieldContrasena;
	private JTextPane textPaneEstado;

	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					PantallaLogin frame = new PantallaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaLogin() {
		setTitle("Log in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(6, 37, 69, 16);
		contentPane.add(lblDNI);

		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(87, 31, 134, 28);
		contentPane.add(textFieldDNI);

		JLabel lblContrasena = new JLabel("Contrase�a:");
		lblContrasena.setBounds(6, 81, 69, 16);
		contentPane.add(lblContrasena);

		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(87, 75, 134, 28);
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		JButton Blogin = new JButton("Login");
		Blogin.setBounds(300, 80, 70, 35);
		contentPane.add(Blogin);
		Blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					login(textFieldDNI.getText(), textFieldContrasena.getText());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public void login(String textFieldDNI, String textFieldContrasena) throws Exception {
		GestorUsuario usuario = new GestorUsuario();
		switch (usuario.login(textFieldDNI, textFieldContrasena)) {
		case 'E':
			PantallaMatriculacion frame = new PantallaMatriculacion();
			frame.setVisible(true);			
			break;

		case 'P':
			PantallaDireccionCursos frame1 = new PantallaDireccionCursos();
			frame1.setVisible(true);			
			break;

		case 'G':
			PantallaJefeGabineteVicerrectorado frame2 = new PantallaJefeGabineteVicerrectorado();
			frame2.setVisible(true);		
			break;
		case 'J':
			PantallaEmpleadosVicerrectorado frame3 = new PantallaEmpleadosVicerrectorado();
			frame3.setVisible(true);	
			break;
		case '0':
			//No existe esa contrase�a
			break;
		case '1':
			//El usuario no tiene tipousuario
			break;
		}
	}

	public void logout() {
		// TODO - implement PantallaLogin.logout
		throw new UnsupportedOperationException();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
