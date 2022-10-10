package presentacion;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import persistencia.GestorBD;

public class PantallaLogin extends JFrame {
	private JTextPane textPane;
	private JPanel contentPane;
	private JTextField textFieldDNI;
	private JTextField textFieldNombre;
	private JTextPane textPaneEstado;

	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					PantallaLogin frame = new PantallaLogin();
					GestorBD.conectarBD();
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

		JLabel lblLogin = new JLabel("DNI:");
		lblLogin.setBounds(6, 81, 69, 16);
		contentPane.add(lblLogin);

		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(87, 75, 134, 28);
		contentPane.add(textFieldDNI);

		JLabel lblDNI = new JLabel("Nombre:");
		lblDNI.setBounds(6, 37, 69, 16);
		contentPane.add(lblDNI);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(87, 31, 134, 28);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
	}

	public void login() {

		// TODO - implement PantallaLogin.login
		throw new UnsupportedOperationException();
	}

	public void logout() {
		// TODO - implement PantallaLogin.logout
		throw new UnsupportedOperationException();
	}

}
