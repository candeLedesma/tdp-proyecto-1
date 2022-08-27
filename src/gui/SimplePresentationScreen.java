package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Color;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel lblLU;
	private JTextField textFieldLU;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	private JTextField textFieldEmail;
	private JTextField textFieldGithub;
	private JLabel lblfecha;

	public SimplePresentationScreen(Student studentData) {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		lblLU = new JLabel("LU");
		lblLU.setBounds(12, 12, 60, 15);
		tabInformation.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(12, 39, 60, 15);
		tabInformation.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 66, 60, 15);
		tabInformation.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(12, 93, 60, 15);
		tabInformation.add(lblEmail);
		
		JLabel lblGithub = new JLabel("Github URL");
		lblGithub.setBounds(12, 120, 78, 15);
		tabInformation.add(lblGithub);
		
		textFieldLU = new JTextField();
		textFieldLU.setBounds(109, 10, 264, 19);
		tabInformation.add(textFieldLU);
		textFieldLU.setColumns(10);
		String lu= Integer.toString(studentData.getId());
		textFieldLU.setText(lu);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(109, 37, 264, 19);
		tabInformation.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		textFieldApellido.setText(studentData.getLastName());
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(109, 64, 264, 19);
		tabInformation.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.setText(studentData.getFirstName());

		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(109, 91, 264, 19);
		tabInformation.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		textFieldEmail.setText(studentData.getMail());
		
		textFieldGithub = new JTextField();
		textFieldGithub.setBounds(108, 118, 265, 19);
		tabInformation.add(textFieldGithub);
		textFieldGithub.setColumns(10);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		textFieldGithub.setText(studentData.getGithubURL());
		
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource("/images/chickenIcon.png")));
		contentPane.add(lblImagen, BorderLayout.EAST);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		lblfecha = new JLabel("Esta ventana fue generada el "+ dtf.format(now));
		contentPane.add(lblfecha, BorderLayout.SOUTH);
		setVisible(true);
	}
}