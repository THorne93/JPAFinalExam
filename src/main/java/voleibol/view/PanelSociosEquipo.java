package voleibol.view;

import java.util.List;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

import voleibol.utils.*;
import voleibol.controllers.EquipoController;
import voleibol.controllers.SocioController;
import voleibol.model.Equipo;
import voleibol.model.Socio;

import javax.swing.event.CaretEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSociosEquipo extends JPanel {


	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JComboBox comboBox;
	private JRadioButton btnNombre;
	private JRadioButton btnPApellido;
	private JRadioButton btnSApellido;
	private JRadioButton btnNaci;
	private List<Socio> socios = (List<Socio>) SocioController.getInstance().findAll();
	private List<Socio> allSocios = (List<Socio>) SocioController.getInstance().findAll();
	private JComboBox<Equipo> jcbEquipo;
	private List<Equipo> equipos = (List<Equipo>) EquipoController.getInstance().findAll();
	private JTable table;

	public PanelSociosEquipo() {
		//and set the panel here	
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{91, 138, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Socios de equipo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(5, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Equipo:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbEquipo = new JComboBox<Equipo>();
		jcbEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		GridBagConstraints gbc_jcbEquipo = new GridBagConstraints();
		gbc_jcbEquipo.gridwidth = 2;
		gbc_jcbEquipo.insets = new Insets(0, 0, 5, 0);
		gbc_jcbEquipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbEquipo.gridx = 1;
		gbc_jcbEquipo.gridy = 1;
		add(jcbEquipo, gbc_jcbEquipo);
		
		btnNombre = new JRadioButton("Ordenar por nombre");
		btnNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		GridBagConstraints gbc_btnNombre = new GridBagConstraints();
		gbc_btnNombre.insets = new Insets(0, 0, 5, 5);
		gbc_btnNombre.gridx = 1;
		gbc_btnNombre.gridy = 2;
		add(btnNombre, gbc_btnNombre);
		
		btnPApellido = new JRadioButton("Ordenar por primer apellido");
		btnPApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		GridBagConstraints gbc_btnPApellido = new GridBagConstraints();
		gbc_btnPApellido.insets = new Insets(0, 0, 5, 0);
		gbc_btnPApellido.gridx = 2;
		gbc_btnPApellido.gridy = 2;
		add(btnPApellido, gbc_btnPApellido);
		
		btnSApellido = new JRadioButton("Ordenar por segundo apellido");
		btnSApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		GridBagConstraints gbc_btnSApellido = new GridBagConstraints();
		gbc_btnSApellido.insets = new Insets(0, 0, 5, 5);
		gbc_btnSApellido.gridx = 1;
		gbc_btnSApellido.gridy = 3;
		add(btnSApellido, gbc_btnSApellido);
		
		btnNaci = new JRadioButton("Ordenar por fecha de nacimiento");
		btnNaci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		GridBagConstraints gbc_btnNaci = new GridBagConstraints();
		gbc_btnNaci.insets = new Insets(0, 0, 5, 0);
		gbc_btnNaci.gridx = 2;
		gbc_btnNaci.gridy = 3;
		add(btnNaci, gbc_btnNaci);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 5, 0, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		
		scrollPane.setMinimumSize(new Dimension(0, 200));
		scrollPane.setPreferredSize(new Dimension(0, 200));
		ButtonGroup btnGp= new ButtonGroup();
		btnGp.add(btnNaci);
		btnGp.add(btnNombre);
		btnGp.add(btnPApellido);
		btnGp.add(btnSApellido);
		loadAllEquipos();

		refreshTable();
		
		PanelSociosEquipo thisPanel = this; // Necesito un puntero a "this" antes de entrar en la clase anónima de MouseAdapter
		
	}
	
	private void loadAllEquipos() {
		List<Equipo> l = (List<Equipo>) EquipoController.getInstance().findAll();

		for (Equipo e : l) {
			jcbEquipo.addItem(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void refreshTable() {
		Equipo e = (Equipo) this.jcbEquipo.getSelectedItem();
		String eSelString = ""+ e.getId();
	
		if (btnNombre.isSelected()) {
			socios = (List<Socio>) SocioController.getInstance().findByLikeOperatorNombre("idEquipo", eSelString);
		}
		else if (btnPApellido.isSelected()) {
			socios = (List<Socio>) SocioController.getInstance().findByLikeOperatorPApellido("idEquipo", eSelString);
		}
		else if (btnSApellido.isSelected()) {
			socios = (List<Socio>) SocioController.getInstance().findByLikeOperatorSApellido("idEquipo", eSelString);
		}
		else if (btnNaci.isSelected()) {
			socios = (List<Socio>) SocioController.getInstance().findByLikeOperatorFecha("idEquipo", eSelString);
		}
		else {
			socios = (List<Socio>) SocioController.getInstance().findByLikeOperator("idEquipo", eSelString);
		}
		table = Table.getTable(socios);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				// Compruebo el doble clic
				if (e.getClickCount() > 1) {
					if (table.getSelectedRow() > -1) {
						Socio s = socios.get(table.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Has seleccionado a " +s.getNombre() +" con id: "+s.getId());
;
					}
				}
			}
		});
	}
}
