package vistas;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	
	// implementamos el singleton
	private static VentanaPrincipal instance = null;
	
	private PanelPrincipal panelPrincipal;
	private PanelEquipo panelEquipo;
	private PanelComprobar panelComprobacion;

	private VentanaPrincipal() {
		
		setTitle("THE LABY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		setSize(430, 350);
		setResizable(false);
		
		colocaComponentes();
		
		setVisible(true);
	}
	
	/**
	 * coloca los componentes de la ventana
	 */
	private void colocaComponentes() {
		
		panelPrincipal = new PanelPrincipal();
		getContentPane().add(panelPrincipal, panelPrincipal.getName());
		
		panelEquipo = new PanelEquipo();
		getContentPane().add(panelEquipo, panelEquipo.getName());
		
		panelComprobacion = new PanelComprobar();
		getContentPane().add(panelComprobacion, panelComprobacion.getName());
	}

	public PanelPrincipal getPanelPrincipal() {
		return panelPrincipal;
	}

	public PanelEquipo getPanelEquipo() {
		return panelEquipo;
	}

	public PanelComprobar getPanelComprobacion() {
		return panelComprobacion;
	}

	public static VentanaPrincipal getInstance() {
		if (instance == null) {
			instance = new VentanaPrincipal();
		}
		return instance;
	}
	
}
