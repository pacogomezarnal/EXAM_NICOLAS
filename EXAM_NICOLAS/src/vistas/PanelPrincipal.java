package vistas;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Cadete;
import Model.ModeloCadete;

public class PanelPrincipal extends JPanel {
	
	private static final int idCadete = 25;
	private ModeloCadete modeloCadete;
	
	private JTextField textNombre, textApellidos, textEdad, textNac, textId;
	private JButton btnSiguiente;

	public PanelPrincipal() {
		
		modeloCadete = new ModeloCadete();// iniciamos el modelo cadete
		
		setLayout(null);
		setSize(430, 350);
		setName("Principal");
		
		colocaComponentes();
		cargaDatosCadete();
	}
	
	/**
	 * carga los datos del cadete consultado en los textfields correspondientes
	 */
	private void cargaDatosCadete() {
		Cadete c = modeloCadete.consultaCadete(idCadete);// cuardamos el caderte de la consulta
		// mostramos los datos
		textId.setText(c.getId()+"");
		textNombre.setText(c.getNombre());
		textApellidos.setText(c.getApellidos());
		textEdad.setText(c.getEdad()+"");
		textNac.setText(c.getNacionalidad());
	}
	
	/**
	 * cambia al panel Equipo
	 */
	private void cambiaPanelSiguiente() {
		CardLayout cl = (CardLayout) VentanaPrincipal.getInstance().getContentPane().getLayout();// obtenemos el cardLayout
		cl.show(VentanaPrincipal.getInstance().getContentPane(), VentanaPrincipal.getInstance().getPanelEquipo().getName());// mostramos el panel Equipo
	}
	
	/**
	 * coloca los componentes del panel
	 */
	private void colocaComponentes() {
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/imagen.png"));
		Image img = icono.getImage();
		img = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		icono.setImage(img);
		
		JLabel imagen = new JLabel(icono);
		imagen.setBounds(10, 11, 142, 144);
		add(imagen);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(197, 11, 46, 14);
		add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(197, 31, 86, 20);
		add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(197, 62, 46, 14);
		add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		textApellidos.setBounds(197, 87, 86, 20);
		add(textApellidos);
		textApellidos.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(197, 118, 46, 14);
		add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setEditable(false);
		textEdad.setBounds(197, 143, 86, 20);
		add(textEdad);
		textEdad.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(197, 174, 86, 14);
		add(lblNacionalidad);
		
		textNac = new JTextField();
		textNac.setEditable(false);
		textNac.setBounds(197, 199, 86, 20);
		add(textNac);
		textNac.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(305, 11, 46, 14);
		add(lblId);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(293, 31, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(305, 266, 89, 23);
		add(btnSiguiente);
		btnSiguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiaPanelSiguiente();
			}
		});
	}
}
