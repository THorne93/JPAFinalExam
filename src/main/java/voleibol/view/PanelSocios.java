package voleibol.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.event.ChangeEvent;

import voleibol.controllers.EquipoController;
import voleibol.model.Equipo;
import voleibol.model.Socio;
import voleibol.controllers.*;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class PanelSocios extends JPanel {

	private static final long serialVersionUID = 1L;
	Socio currentSocio;
	private JTextField jtfNombre;
	private JTextField jtfPAp;
	private JTextField jtfSAp;
	private JFormattedTextField jftfFecha;
	private JSlider jSlider;
	private JComboBox<Equipo> jcbEquipo;
	private List<Equipo> equipos = (List<Equipo>) EquipoController.getInstance().findAll();
	private JCheckBox activoChk;
	private JLabel lblAnos;

	/**
	 * Create the panel.
	 */
	public PanelSocios() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		JButton btnFirst = new JButton("");
		btnFirst.setSelectedIcon(new ImageIcon(PanelSocios.class.getResource("/voleibol/utils/res/gotostart.png")));
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEntityOnPanel((Socio) SocioController.getInstance().findFirst());
			}
		});
		btnFirst.setIcon(new ImageIcon(PanelSocios.class.getResource("/voleibol/utils/res/gotostart.png")));
		toolBar.add(btnFirst);

		JButton btnPrevious = new JButton("");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEntityOnPanel((Socio) SocioController.getInstance().findPrevious(currentSocio.getId()));
			}
		});
		btnPrevious.setIcon(new ImageIcon(PanelSocios.class.getResource("/voleibol/utils/res/previous.png")));
		toolBar.add(btnPrevious);

		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEntityOnPanel((Socio) SocioController.getInstance().findNext(currentSocio.getId()));
			}
		});
		btnNext.setIcon(new ImageIcon(PanelSocios.class.getResource("/voleibol/utils/res/next.png")));
		toolBar.add(btnNext);

		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEntityOnPanel((Socio) SocioController.getInstance().findLast());
			}
		});
		btnLast.setIcon(new ImageIcon(PanelSocios.class.getResource("/voleibol/utils/res/gotoend.png")));
		toolBar.add(btnLast);

		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEntity();
			}
		});
		btnNew.setIcon(new ImageIcon(PanelSocios.class.getResource("/voleibol/utils/res/nuevo.png")));
		toolBar.add(btnNew);

		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveEntity();
			}
		});
		btnSave.setIcon(new ImageIcon(PanelSocios.class.getResource("/voleibol/utils/res/guardar.png")));
		toolBar.add(btnSave);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteEntity();
			}
		});
		btnDelete.setIcon(new ImageIcon(PanelSocios.class.getResource("/voleibol/utils/res/eliminar.png")));
		toolBar.add(btnDelete);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel_1 = new JLabel("Gestión de socios");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.insets = new Insets(5, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 2;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Primer Apellido:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfPAp = new JTextField();
		GridBagConstraints gbc_jtfPAp = new GridBagConstraints();
		gbc_jtfPAp.gridwidth = 2;
		gbc_jtfPAp.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPAp.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPAp.gridx = 1;
		gbc_jtfPAp.gridy = 2;
		panel.add(jtfPAp, gbc_jtfPAp);
		jtfPAp.setColumns(10);

		JLabel lblNewLabel_4_1 = new JLabel("Segundo Apellido:");
		GridBagConstraints gbc_lblNewLabel_4_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1.gridx = 0;
		gbc_lblNewLabel_4_1.gridy = 3;
		panel.add(lblNewLabel_4_1, gbc_lblNewLabel_4_1);

		jtfSAp = new JTextField();
		GridBagConstraints gbc_jtfSAp = new GridBagConstraints();
		gbc_jtfSAp.gridwidth = 2;
		gbc_jtfSAp.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSAp.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSAp.gridx = 1;
		gbc_jtfSAp.gridy = 3;
		panel.add(jtfSAp, gbc_jtfSAp);
		jtfSAp.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jftfFecha = new JFormattedTextField();
		GridBagConstraints gbc_jftfFecha = new GridBagConstraints();
		gbc_jftfFecha.gridwidth = 2;
		gbc_jftfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jftfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jftfFecha.gridx = 1;
		gbc_jftfFecha.gridy = 4;
		panel.add(jftfFecha, gbc_jftfFecha);

		JLabel lblNewLabel_2 = new JLabel("Antiguedad (años):");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jSlider = new JSlider();
		GridBagConstraints gbc_jSlider = new GridBagConstraints();
		gbc_jSlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_jSlider.insets = new Insets(0, 0, 5, 5);
		gbc_jSlider.gridx = 1;
		gbc_jSlider.gridy = 5;
		panel.add(jSlider, gbc_jSlider);

		lblAnos = new JLabel("años");
		GridBagConstraints gbc_lblAnos = new GridBagConstraints();
		gbc_lblAnos.insets = new Insets(0, 0, 5, 0);
		gbc_lblAnos.gridx = 2;
		gbc_lblAnos.gridy = 5;
		panel.add(lblAnos, gbc_lblAnos);

		activoChk = new JCheckBox("Socio en activo");
		GridBagConstraints gbc_activoChk = new GridBagConstraints();
		gbc_activoChk.anchor = GridBagConstraints.WEST;
		gbc_activoChk.insets = new Insets(0, 0, 5, 5);
		gbc_activoChk.gridx = 1;
		gbc_activoChk.gridy = 6;
		panel.add(activoChk, gbc_activoChk);

		JLabel lblNewLabel_7 = new JLabel("Equipo:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jcbEquipo = new JComboBox<Equipo>();
		GridBagConstraints gbc_jcbEquipo = new GridBagConstraints();
		gbc_jcbEquipo.gridwidth = 2;
		gbc_jcbEquipo.insets = new Insets(0, 0, 0, 5);
		gbc_jcbEquipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbEquipo.gridx = 1;
		gbc_jcbEquipo.gridy = 7;
		panel.add(jcbEquipo, gbc_jcbEquipo);

		addControlCustomizableBehaviours();
		loadAllEquipos();
		showEntityOnPanel((Socio) SocioController.getInstance().findFirst());
	}

	private void loadAllEquipos() {
		List<Equipo> l = (List<Equipo>) EquipoController.getInstance().findAll();

		for (Equipo e : l) {
			jcbEquipo.addItem(e);
		}
	}

	private void addControlCustomizableBehaviours() {

		this.jftfFecha.setFormatterFactory(new AbstractFormatterFactory() {
			@Override
			public AbstractFormatter getFormatter(JFormattedTextField tf) {
				return new JFormattedTextField.AbstractFormatter() {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

					@Override
					public String valueToString(Object value) throws ParseException {
						if (value != null && value instanceof Date) {
							jftfFecha.setBackground(Color.WHITE);
							return sdf.format(((Date) value));
						}
						return "";
					}

					@Override
					public Object stringToValue(String text) throws ParseException {
						try {
							return sdf.parse(text);
						} catch (Exception e) {
							jftfFecha.setBackground(Color.RED);
							JOptionPane.showMessageDialog(null, "Error en la fecha");
							return null;
						}
					}
				};
			}
		});

		this.jSlider.addChangeListener(new javax.swing.event.ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				showSliderBalanceDescriptor();
			}
		});
	}

	private void showEntityOnPanel(Socio socio) {

		if (socio != null) {
			this.currentSocio = socio;
			this.jtfNombre.setText(this.currentSocio.getNombre());
			this.jtfPAp.setText(this.currentSocio.getApellido1());
			this.jtfSAp.setText(this.currentSocio.getApellido2());
			this.jftfFecha
					.setText(GuiUtils.getFormattedStringFromDate("dd/MM/yyyy", this.currentSocio.getFechaNacimiento()));
			this.jSlider.setValue(this.currentSocio.getAntiguedadAnios());
			this.jSlider.setMaximum(200);
			this.jSlider.setMinimum(0);

			for (int i = 0; i < jcbEquipo.getItemCount(); i++) {
				if (this.currentSocio.getEquipo().getId() == jcbEquipo.getItemAt(i).getId()) {
					jcbEquipo.setSelectedIndex(i);
				}
			}
			this.activoChk.setSelected(this.currentSocio.getActivo());
			showSliderBalanceDescriptor();
		}

	}

	private void showSliderBalanceDescriptor() {
		this.lblAnos.setText(this.jSlider.getValue() + " años ");
	}

	private void newEntity() {
		this.currentSocio = new Socio();
		this.currentSocio.setId(0);
		this.currentSocio.setEquipo(EquipoController.getInstance().findById(1));
		
		showEntityOnPanel(currentSocio);
	}

	private void saveEntity() {
		Equipo e = (Equipo) jcbEquipo.getSelectedItem();
		this.currentSocio.setNombre(this.jtfNombre.getText());
		if (this.jftfFecha.getText() != null) {
			this.currentSocio.setFechaNacimiento(GuiUtils.getDateFromFormattedString("dd/MM/yyyy", this.jftfFecha.getText()));
		}
		else {
			JOptionPane.showMessageDialog(null, " hay que poner una fecha");
			return;
		}
		this.currentSocio.setApellido1(this.jtfPAp.getText());
		this.currentSocio.setApellido2(this.jtfSAp.getText());
		this.currentSocio.setActivo(activoChk.isSelected());
		this.currentSocio.setAntiguedadAnios(jSlider.getValue());
		this.currentSocio.setEquipo(e);
		
		try {
			SocioController.getInstance().save(currentSocio);
			JOptionPane.showMessageDialog(null, "Socio guardado correctamente");
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "NO se ha guardado el socio. ERROR");
		}
	}

	private void deleteEntity () {
		try {
			String respuestas[] = new String[] {"Sí", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(
					null, 
					"¿Realmente desea eliminar el registro?", 
					"Eliminación de fabricante", 
			        JOptionPane.DEFAULT_OPTION, 
			        JOptionPane.WARNING_MESSAGE, 
			        null, respuestas, 
			        respuestas[1]);
		    
			if(opcionElegida == 0) {
				SocioController.getInstance().remove(currentSocio);
				JOptionPane.showMessageDialog(null, "Socio borrado correctamente");

		    	  this.currentSocio = SocioController.getInstance().findPrevious(this.currentSocio.getId());
		    	  if (this.currentSocio != null) { // Existe un anterior, lo muestro
		    		  showEntityOnPanel(currentSocio);
		    	  }
		    	  else {
		    		  this.currentSocio = SocioController.getInstance().findNext(this.currentSocio.getId());
			    	  if (this.currentSocio != null) { // Existe un anterior, lo muestro
			    		  showEntityOnPanel(currentSocio);
			    	  }
		    		  else { // No quedan registros en la tabla
		    			  newEntity();
		    		  }
		    	  }
		      }
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
