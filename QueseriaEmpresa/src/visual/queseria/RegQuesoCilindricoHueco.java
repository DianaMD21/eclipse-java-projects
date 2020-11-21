package visual.queseria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.queseria.Queseria;
import logico.queseria.QuesoCilindroHueco;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegQuesoCilindricoHueco extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecioBase;
	private JTextField txtPrecioUnitario;
	private JTextField txtRadio;
	private JTextField txtLongitud;
	private JTextField txtRadioInterno;

	/*
	  @param queso 
	 */
	public RegQuesoCilindricoHueco(QuesoCilindroHueco queso, Queseria miQueseria) {
		setTitle("Queso Cil\u00EDndrico Hueco");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 455, 372);
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
			{
				JLabel lblRegistrarQuesoRegistrar = new JLabel("Registrar Queso Cil\u00EDndrico");
				lblRegistrarQuesoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblRegistrarQuesoRegistrar.setBounds(123, 10, 221, 21);
				panel.add(lblRegistrarQuesoRegistrar);
			}
			{
				JLabel lblPrecioBase = new JLabel("Precio Base");
				lblPrecioBase.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblPrecioBase.setBounds(67, 62, 119, 21);
				panel.add(lblPrecioBase);
			}
			{
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
				txtPrecioBase.setBounds(210, 60, 142, 23);
				panel.add(txtPrecioBase);
			}
			{
				JLabel lblPrecioUnitario = new JLabel("Precio Unitario");
				lblPrecioUnitario.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblPrecioUnitario.setBounds(67, 100, 119, 21);
				panel.add(lblPrecioUnitario);
			}
			{
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
				txtPrecioUnitario.setBounds(210, 98, 142, 23);
				panel.add(txtPrecioUnitario);
			}
			{
				JLabel lblRadio = new JLabel("Radio");
				lblRadio.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblRadio.setBounds(67, 141, 119, 21);
				panel.add(lblRadio);
			}
			{
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
				txtRadio.setBounds(210, 139, 142, 23);
				panel.add(txtRadio);
			}
			{
				JLabel lblLongitud = new JLabel("Longitud");
				lblLongitud.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblLongitud.setBounds(67, 225, 119, 21);
				panel.add(lblLongitud);
			}
			{
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
				txtLongitud.setBounds(210, 223, 142, 23);
				panel.add(txtLongitud);
			}
			{
				JLabel lblRadioInterno = new JLabel("Radio Interno");
				lblRadioInterno.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblRadioInterno.setBounds(67, 182, 119, 21);
				panel.add(lblRadioInterno);
			}
			{
				txtRadioInterno = new JTextField();
				txtRadioInterno.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char caracter = e.getKeyChar();
		                if (((caracter < '0') || (caracter > '9'))
		                        && (caracter != '\b')  && (caracter!='.')) {
		                    e.consume();
		                    
		                }
					}
				});
				txtRadioInterno.setColumns(10);
				txtRadioInterno.setBounds(210, 180, 142, 23);
				panel.add(txtRadioInterno);
			}
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtPrecioBase.getText().equalsIgnoreCase("")|| txtPrecioUnitario.getText().equalsIgnoreCase("")|| txtRadio.getText().equalsIgnoreCase("")|| txtLongitud.getText().equalsIgnoreCase("")||txtRadioInterno.getText().equalsIgnoreCase("")) {
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
				btnAceptar.setBounds(101, 267, 108, 31);
				panel.add(btnAceptar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnCancelar.setBounds(233, 267, 119, 31);
				panel.add(btnCancelar);
			}
		}
	}

}
