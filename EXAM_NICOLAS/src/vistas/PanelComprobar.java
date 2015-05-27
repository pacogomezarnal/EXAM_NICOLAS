package vistas;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.IngresoLaby;

public class PanelComprobar extends JPanel {
	
	private IngresoLaby ingresar;
	
	private JTextField textId, textApellido, textMensaje;
	private JButton btnComprobar, btnAtras;
	
	public PanelComprobar() {
		
		ingresar = new IngresoLaby();// iniciamos el objeto loby
		
		setName("Comprobacion");
		setSize(430, 350);
		setLayout(null);
		
		colocaComponentes();
	}
	
	private void consultaDatos() {
		int id = Integer.parseInt(textId.getText());// sacamos el entero de l campo id
		String apellido = textApellido.getText();// sacamos el string del campo id
		
		String codigo = ingresar.checkCod(id, apellido);// consyltamos is el codigo y apellido son correctos
		
		textMensaje.setText(codigo);// colocamos el texto devueltp
	}
	
	/**
	 * cambia al panel Equipos
	 */
	private void cambiaPanelAnterior() {
		CardLayout cl = (CardLayout) VentanaPrincipal.getInstance().getContentPane().getLayout();// obtenemos el card layout
		cl.show(VentanaPrincipal.getInstance().getContentPane(), VentanaPrincipal.getInstance().getPanelEquipo().getName());// mostramos el pael Equipos
	}
	
	/**
	 * Coloca los componentes de la ventana
	 */
	private void colocaComponentes() {
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 11, 46, 14);
		add(lblId);
		
		JLabel lblApellido = new JLabel("1er Apellido");
		lblApellido.setBounds(168, 11, 131, 14);
		add(lblApellido);
		
		textId = new JTextField();
		textId.setBounds(10, 36, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(168, 36, 118, 20);
		add(textApellido);
		textApellido.setColumns(10);
		
		btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaDatos();
			}
		});
		btnComprobar.setBounds(10, 83, 362, 23);
		add(btnComprobar);
		
		textMensaje = new JTextField();
		textMensaje.setEditable(false);
		textMensaje.setBounds(10, 117, 362, 20);
		add(textMensaje);
		textMensaje.setColumns(10);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 254, 89, 23);
		add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiaPanelAnterior();
			}
		});
	}
}
