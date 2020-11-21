package visual.queseria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.queseria.CilindroQueso;
import logico.queseria.Queseria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegQuesoCilindrico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecioBase;
	private JTextField txtPrecioUnitario;
	private JTextField txtRadio;
	private JTextField txtLongitud;

	/*
	  @param queso 
	 */
	public RegQuesoCilindrico(CilindroQueso queso, Queseria miQueseria) {
		setTitle("Queso Cil\u00EDndrico");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 451, 340);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblRegistrarQuesoRegistrar = new JLabel("Registrar Queso Cil\u00EDndrico");
			lblRegistrarQuesoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblRegistrarQuesoRegistrar.setBounds(122, 22, 221, 21);
			panel.add(lblRegistrarQuesoRegistrar);
			
			JLabel lblPrecioBase = new JLabel("Precio Base");
			lblPrecioBase.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblPrecioBase.setBounds(66, 74, 119, 21);
			panel.add(lblPrecioBase);
			
			txtPrecioBase = new JTextField();
			txtPrecioBase.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')  && (caracter!='.')) {
	                    e.consume();
	                    
	                }
				}
			});
			txtPrecioBase.setColumns(10);
			txtPrecioBase.setBounds(209, 72, 142, 23);
			panel.add(txtPrecioBase);
			
			JLabel lblPrecioUnitario = new JLabel("Precio Unitario");
			lblPrecioUnitario.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblPrecioUnitario.setBounds(66, 112, 119, 21);
			panel.add(lblPrecioUnitario);
			
			txtPrecioUnitario = new JTextField();
			txtPrecioUnitario.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')  && (caracter!='.')) {
	                    e.consume();
	                    
	                }
				}
			});
			txtPrecioUnitario.setColumns(10);
			txtPrecioUnitario.setBounds(209, 110, 142, 23);
			panel.add(txtPrecioUnitario);
			
			JLabel lblRadioDelQueso = new JLabel("Radio");
			lblRadioDelQueso.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblRadioDelQueso.setBounds(66, 153, 119, 21);
			panel.add(lblRadioDelQueso);
			
			txtRadio = new JTextField();
			txtRadio.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')  && (caracter!='.')) {
	                    e.consume();
	                    
	                }
				}
			});
			txtRadio.setColumns(10);
			txtRadio.setBounds(209, 151, 142, 23);
			panel.add(txtRadio);
			
			JLabel lblLongitud = new JLabel("Longitud");
			lblLongitud.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblLongitud.setBounds(66, 190, 119, 21);
			panel.add(lblLongitud);
			
			txtLongitud = new JTextField();
			txtLongitud.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')  && (caracter!='.')) {
	                    e.consume();
	                    
	                }
				}
			});
			txtLongitud.setColumns(10);
			txtLongitud.setBounds(209, 188, 142, 23);
			panel.add(txtLongitud);
			
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtPrecioBase.getText().equalsIgnoreCase("")|| txtPrecioUnitario.getText().equalsIgnoreCase("")|| txtRadio.getText().equalsIgnoreCase("")|| txtLongitud.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "No deje ningún campo vacío, por favor", "Problema de registo", JOptionPane.CLOSED_OPTION);
					}
					else {
						queso.setPrecioBase(Float.parseFloat(txtPrecioBase.getText()));
						queso.setPrecioUnitario(Float.parseFloat(txtPrecioUnitario.getText()));
						queso.setRadioC(Float.parseFloat(txtRadio.getText()));
						queso.setLongitud(Float.parseFloat(txtLongitud.getText()));
						JOptionPane.showMessageDialog(null, "El queso fue registrado correctamente", "Registro correcto", JOptionPane.CLOSED_OPTION);
						miQueseria.addQueso(queso);
						dispose();
					}
				}
			});
			btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAceptar.setBounds(100, 232, 108, 36);
			panel.add(btnAceptar);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCancelar.setBounds(232, 232, 119, 36);
			panel.add(btnCancelar);
			
		}
	}
}
