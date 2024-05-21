package voleibol.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import voleibol.utils.Apariencia;


public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	public Principal() {
		super("Ventana Principal");
		
		this.setBounds(0, 0, 500, 400);
		
		
		PanelSocios panelSocios = new PanelSocios();
		PanelSociosEquipo panelSociosEquipo = new PanelSociosEquipo();
		PanelClasificacion panelClasificacion = new PanelClasificacion();
		JTabbedPane panelTabbed = new JTabbedPane();

		panelTabbed.addTab("Datos del socio", panelSocios);
		panelTabbed.addTab("Socios por equipo", panelSociosEquipo);
		panelTabbed.addTab("Clasificación", panelClasificacion);
		panelTabbed.setSelectedIndex(0);
		this.getContentPane().add(panelTabbed);



	}


	public static void main(String[] args) {

		Principal ventana = new Principal();
		ventana.setVisible(true);
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
	}

	private static void cerrarAplicacion() {
		String[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(null, "¿Desea cerrar la aplicación?", "Salir de la aplicación",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}


}