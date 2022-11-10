package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PantallaJefeGabineteVicerrectorado extends JFrame {
private JPanel contentPane;
	public PantallaJefeGabineteVicerrectorado() {
		setTitle("Consultas Cursos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void realizarConsulta() {
		// TODO - implement PantallaJefeGabineteVicerrectorado.realizarConsulta
		throw new UnsupportedOperationException();
	}

}