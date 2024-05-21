package voleibol.view;

import java.util.List;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

import voleibol.controllers.EquipoController;
import voleibol.model.Equipo;

import javax.swing.event.CaretEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelClasificacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JButton btnReset;
	private JButton btnDown;
	private JButton btnEliminar;
	private JButton btnUp;
	private List<Equipo> equipos = (List<Equipo>) EquipoController.getInstance().findAll();
	private JList<Equipo> jListEquipos;
	private DefaultListModel<Equipo> listModelEquipos = null;
	private JList list;


	public PanelClasificacion() {
	
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 307, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Clasificación");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(5, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equipos = (List<Equipo>) EquipoController.getInstance().findAll();
				cargarEquipos();
			}
		});
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 5, 0);
		gbc_btnReset.gridx = 2;
		gbc_btnReset.gridy = 3;
		add(btnReset, gbc_btnReset);
		
		btnUp = new JButton("Arriba");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListEquipos.getSelectedIndex() > 0) {
					int equipo = jListEquipos.getSelectedIndex();
					Equipo eTemp = equipos.get(equipo-1);
					equipos.set(equipo-1, equipos.get(equipo));
					equipos.set(equipo, eTemp);
					cargarEquipos();
					jListEquipos.setSelectedIndex(equipo-1);
				}

			}
		});
		GridBagConstraints gbc_btnUp = new GridBagConstraints();
		gbc_btnUp.insets = new Insets(0, 0, 5, 0);
		gbc_btnUp.gridx = 2;
		gbc_btnUp.gridy = 4;
		add(btnUp, gbc_btnUp);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 8;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		jListEquipos =  new JList(this.getDefaultListModel());
		this.jListEquipos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(jListEquipos);
		
		btnDown = new JButton("Abajo");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int equipo = jListEquipos.getSelectedIndex();
				if (equipo < equipos.size() -1) {
					Equipo eTemp = equipos.get(equipo+1);
					equipos.set(equipo+1, equipos.get(equipo));
					equipos.set(equipo, eTemp);
					cargarEquipos();
					jListEquipos.setSelectedIndex(equipo+1);
				}
			}
		});
		GridBagConstraints gbc_btnDown = new GridBagConstraints();
		gbc_btnDown.insets = new Insets(0, 0, 5, 0);
		gbc_btnDown.gridx = 2;
		gbc_btnDown.gridy = 5;
		add(btnDown, gbc_btnDown);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int equipo = jListEquipos.getSelectedIndex();
				equipos.remove(equipo);
				cargarEquipos();

			}
		});
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminar.gridx = 2;
		gbc_btnEliminar.gridy = 6;
		add(btnEliminar, gbc_btnEliminar);
		cargarEquipos();
		
		System.out.println(jListEquipos.getMaxSelectionIndex());
	}
	
	private DefaultListModel getDefaultListModel() {
		this.listModelEquipos = new DefaultListModel<Equipo>();
		return this.listModelEquipos;

	}
	
	private void cargarEquipos() {
		this.listModelEquipos.clear();
		for (int i = 0; i < equipos.size(); i++) {
			this.listModelEquipos.addElement(this.equipos.get(i));
		}

	}	

}
