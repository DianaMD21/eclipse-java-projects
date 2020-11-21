package visual.queseria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.queseria.EsferaQueso;
import logico.queseria.Queseria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegQuesoEsfera extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecioBase;
	private JTextField txtPrecioUnitario;
	private JTextField txtRadio;

	/*
	 
	  @param queso 
	 */
	public RegQuesoEsfera(EsferaQueso queso, Queseria miQueseria) {
		setTitle("Registrar Queso");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 452, 292);
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
				JLabel lblRegQuesoEsfera = new JLabel("Registrar Queso Esf\u00E9rico");
				lblRegQuesoEsfera.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblRegQuesoEsfera.setBounds(112, 10, 221, 21);
				panel.add(lblRegQuesoEsfera);
			}
			{
				JLabel lblPrecioBase = new JLabel("Precio Base");
				lblPrecioBase.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblPrecioBase.setBounds(56, 62, 119, 21);
				panel.add(lblPrecioBase);
			}
			
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
			txtPrecioBase.setBounds(199, 60, 142, 23);
			panel.add(txtPrecioBase);
			txtPrecioBase.setColumns(10);
			
			JLabel lblPrecioUnitario = new JLabel("Precio Unitario");
			lblPrecioUnitario.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblPrecioUnitario.setBounds(56, 100, 119, 21);
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
			txtPrecioUnitario.setBounds(199, 98, 142, 23);
			panel.add(txtPrecioUnitario);
			
			JLabel lblRadioDelQueso = new JLabel("Radio");
			lblRadioDelQueso.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblRadioDelQueso.setBounds(56, 141, 119, 21);
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
			txtRadio.setBounds(199, 139, 142, 23);
			panel.add(txtRadio);
			
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtPrecioBase.getText().equalsIgnoreCase("")|| txtPrecioUnitario.getText().equalsIgnoreCase("")|| txtRadio.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "No deje ningún campo vacío, por favor", "Problema de registo", JOptionPane.CLOSED_OPTION);
					}
					else {
						queso.setPrecioBase(Float.parseFloat(txtPrecioBase.getText()));
						queso.setPrecioUnitario(Float.parseFloat(txtPrecioUnitario.getText()));
						queso.setRadioE(Float.parseFloat(txtRadio.getText()));
						JOptionPane.showMessageDialog(null, "El queso fue registrado correctamente", "Registro correcto", JOptionPane.CLOSED_OPTION);
						miQueseria.addQueso(queso);
						dispose();
					}
				}
			});
			btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAceptar.setBounds(90, 184, 109, 35);
			panel.add(btnAceptar);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCancelar.setBounds(222, 184, 119, 35);
			panel.add(btnCancelar);
		}
	}
}
