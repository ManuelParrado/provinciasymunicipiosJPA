package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controller.ControladorMunicipio;
import controller.ControladorProvincia;
import model.Municipio;
import model.Provincia;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField jFiltra;
	private JTextField jMunicipio;
	private JComboBox<Provincia> jcbProvincia;
	private JComboBox<Municipio> jcbMunicipio; 
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		jFiltra = new JTextField();
		GridBagConstraints gbc_jFiltra = new GridBagConstraints();
		gbc_jFiltra.insets = new Insets(0, 0, 5, 5);
		gbc_jFiltra.fill = GridBagConstraints.HORIZONTAL;
		gbc_jFiltra.gridx = 0;
		gbc_jFiltra.gridy = 0;
		contentPane.add(jFiltra, gbc_jFiltra);
		jFiltra.setColumns(10);
		
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtraMunicipio();
			}
		});
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnFiltrar.gridx = 1;
		gbc_btnFiltrar.gridy = 0;
		contentPane.add(btnFiltrar, gbc_btnFiltrar);
		
		jcbMunicipio = new JComboBox<Municipio>();
		GridBagConstraints gbc_jcbMunicipio = new GridBagConstraints();
		gbc_jcbMunicipio.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMunicipio.gridx = 0;
		gbc_jcbMunicipio.gridy = 1;
		contentPane.add(jcbMunicipio, gbc_jcbMunicipio);
		
		JButton btnSelecionarMun = new JButton("Seleccionar");
		btnSelecionarMun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				seleccionaMunicipio();
			}
		});
		GridBagConstraints gbc_btnSelecionarMun = new GridBagConstraints();
		gbc_btnSelecionarMun.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelecionarMun.gridx = 1;
		gbc_btnSelecionarMun.gridy = 1;
		contentPane.add(btnSelecionarMun, gbc_btnSelecionarMun);
		
		JLabel lblNewLabel = new JLabel("Municipio Seleccionado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(181, 253, 248));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombrel del municipio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jMunicipio = new JTextField();
		GridBagConstraints gbc_jMunicipio = new GridBagConstraints();
		gbc_jMunicipio.insets = new Insets(0, 0, 5, 0);
		gbc_jMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jMunicipio.gridx = 1;
		gbc_jMunicipio.gridy = 0;
		panel.add(jMunicipio, gbc_jMunicipio);
		jMunicipio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Provincia del municipio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbProvincia = new JComboBox<Provincia>();
		GridBagConstraints gbc_jcbProvincia = new GridBagConstraints();
		gbc_jcbProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProvincia.gridx = 1;
		gbc_jcbProvincia.gridy = 1;
		panel.add(jcbProvincia, gbc_jcbProvincia);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 2;
		panel.add(btnGuardar, gbc_btnGuardar);
		
		jMunicipio.setEnabled(false);
		
		
		
	}

	
	private void filtraMunicipio() {
		
		this.jcbMunicipio.removeAllItems();
		
		List<Municipio> lista = ControladorMunicipio.findByLikeNombre(jFiltra.getText());
		
		if (lista != null) {
			for (Municipio m : lista) {
				this.jcbMunicipio.addItem(m);
			}	
		}

	}
	
	private void seleccionaMunicipio() {
		
		Municipio m = (Municipio) jcbMunicipio.getSelectedItem();
		
		jMunicipio.setText(m.getNombre());
		
		List<Provincia> lista = ControladorProvincia.findAll();
		
		if (lista != null) {
			for (Provincia p : lista) {
				this.jcbProvincia.addItem(p);
			}	
		}
		
	}

	private void guardar() {
		
		Provincia p = (Provincia) jcbProvincia.getSelectedItem();
		Municipio m = (Municipio) jcbMunicipio.getSelectedItem();
		
		if (p != null && m != null) {
			
			m.setProvincia(p);
			ControladorMunicipio.guardar(m);
			
		}
		
	}

	
}
