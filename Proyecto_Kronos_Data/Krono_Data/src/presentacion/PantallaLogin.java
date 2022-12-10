package presentacion;

import java.awt.Color;
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


public class PantallaLogin extends JFrame implements ActionListener {
	public static JTextPane textPane;
	private JPanel contentPane;
	private JTextField textFieldDNI;
	private JTextField textFieldContrasena;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					PantallaLogin frame = new PantallaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
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

		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setBounds(6, 81, 69, 16);
		contentPane.add(lblContrasena);
		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(87, 75, 134, 28);
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		JLabel label1 = new JLabel("Estado");
		label1.setForeground(Color.RED);
		label1.setBounds(6, 120, 61, 16);
		contentPane.add(label1);
		textPane = new JTextPane();
		textPane.setToolTipText(
				"Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 168, 400, 75);
		contentPane.add(textPane);

		JButton bLogin = new JButton("Login");
		bLogin.setBounds(300, 80, 70, 35);
		contentPane.add(bLogin);
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					login(textFieldDNI.getText(), textFieldContrasena.getText());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					//Logger.log("mensaje de error");
				}
			}
		});
	}

	public void login(String textFieldDNI, String textFieldContrasena) throws Exception {
		GestorUsuario usuario = new GestorUsuario();
		switch (usuario.login(textFieldDNI, textFieldContrasena)) {
		case 'E':
			textPane.setText("EL login ha sido correcto: Bienvenido " + usuario.getEstudiante().getNombre() + " "
					+ usuario.getEstudiante().getApellidos());
			PantallaMatriculacion frame = new PantallaMatriculacion(usuario.getEstudiante());
			frame.setVisible(true);
			break;

		case 'P':
			textPane.setText("EL login ha sido correcto: Bienvenido " + usuario.getProfesorUCLM().getNombre() + " "
					+ usuario.getProfesorUCLM().getApellidos());
			PantallaDireccionCursos frame1 = new PantallaDireccionCursos(usuario.getProfesorUCLM());
			frame1.setVisible(true);
			break;

		case 'G':
			textPane.setText("EL login ha sido correcto: Bienvenido Jefe de Gabiente del Vicerrectorado con DNI: "
					+ usuario.getUsuario().getDNI());

			PantallaJefeGabineteVicerrectorado frame2 = new PantallaJefeGabineteVicerrectorado(usuario.getUsuario());
			frame2.setVisible(true);
			break;
		case 'J':
			textPane.setText("EL login ha sido correcto: Bienvenido Personal del Vicerrectorado con DNI: "
					+ usuario.getUsuario().getDNI());

			PantallaEmpleadosVicerrectorado frame3 = new PantallaEmpleadosVicerrectorado();
			frame3.setVisible(true);
			break;
		case '0':
			PantallaLogin.textPane.setText("Usted ha metido mal la contrasena");
			break;
		case '1':
			PantallaLogin.textPane.setText("El DNI introducido no corresponde con ningun usuario");
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
