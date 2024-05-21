package voleibol.utils;

import java.util.EventListener;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class MiTableModel extends AbstractTableModel {

	Object datos[][] = null;
	String titulos[] = null;

	/**
	 * 
	 */
	public MiTableModel(Object[][] newData, String[] newTitles) {
		// Datos a presentar en la tabla
		datos = newData;
		titulos = newTitles;
	}

	public Object[][] getDatos() {
		return this.datos;
	}


	@Override
	public int getColumnCount() {
		return titulos.length;
	}

	@Override
	public void fireTableRowsInserted(int firstRow, int lastRow) {
		// TODO Auto-generated method stub
		super.fireTableRowsInserted(firstRow, lastRow);

	}

	@Override
	public int getRowCount() {
		return datos.length;
	}

	
	@Override
	public void fireTableDataChanged() {
//		datos = getDatosDeTabla(tipocontratos);
		super.fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return datos[rowIndex][columnIndex];
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public void fireTableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		super.fireTableChanged(e);
	}


	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}



	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (this.datos.length > 0) {
			return this.datos[0][columnIndex].getClass();
		}
		return String.class;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		this.datos[rowIndex][columnIndex] = aValue;
		fireTableCellUpdated(rowIndex, columnIndex);
	}

}
