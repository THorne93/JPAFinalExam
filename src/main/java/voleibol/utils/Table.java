package voleibol.utils;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import voleibol.model.Socio;

public class Table {

	public static JTable jTable;
	static MiTableModel tableModel;
	private List<Socio> socios;

	
	public static String[] getTitulosColumnas() {
		return new String[] { "Nombre", "Primer apellido", "Segundo apellido", "Fecha de nacimiento"};
	}


	public static Object[][] getDatosDeTabla(List<Socio> socios) {

		Object[][] datos = new Object[socios.size()][4];

		for (int i = 0; i < socios.size(); i++) {
			Socio s = socios.get(i);
			datos[i][0] = s.getNombre();
			datos[i][1] = s.getApellido1();
			datos[i][2] = s.getApellido2();
			datos[i][3] = s.getFechaNacimiento();

		}

		return datos;
	}

	public static JTable getTable(List<Socio> socios) {
		tableModel = new MiTableModel(getDatosDeTabla(socios), getTitulosColumnas());
		jTable = new JTable(tableModel);
		return jTable;
	}
}
