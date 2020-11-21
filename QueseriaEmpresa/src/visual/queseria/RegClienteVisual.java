package visual.queseria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.security.ntlm.Client;

import logico.queseria.Cliente;
import logico.queseria.Queseria;

import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegClienteVisual extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Cliente miCliente;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	
	/*  @param client 
	  @param queseria 
	 */
	public RegClienteVisual(Cliente client, Queseria queseria) {
		setFont(new Font("Tahoma", Font.PLAIN, 16));
		setTitle("Cliente");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 428, 415);
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
			
			JLabel lblRegCliente = new JLabel("Registrar Cliente");
			lblRegCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblRegCliente.setBounds(133, 10, 151, 27);
			panel.add(lblRegCliente);
			
			JLabel lblCedula = new JLabel("C\u00E9dula");
			lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblCedula.setBounds(37, 67, 76, 19);
			panel.add(lblCedula);
			
			txtCedula = new JTextField();
			txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtCedula.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')  || (txtCedula.getText().length()==11)) {
	                    e.consume();
	                    
	                }
				}
			});
			txtCedula.setBounds(150, 60, 198, 27);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNombre.setBounds(37, 115, 76, 19);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
	                if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z'))
	                        && (caracter != '\b') && (caracter!=32)) {
	                    e.consume();
	                }
				}
			});
			txtNombre.setBounds(150, 113, 198, 27);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblApellidos = new JLabel("Apellidos");
			lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblApellidos.setBounds(37, 169, 76, 19);
			panel.add(lblApellidos);
			
			txtApellidos = new JTextField();
			txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtApellidos.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
	                if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z'))
	                        && (caracter != '\b') && (caracter!=32)) {
	                    e.consume();
	                }
				}
			});
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(150, 162, 198, 27);
			panel.add(txtApellidos);
			
			JLabel lblDireccion = new JLabel("Direcci\u00F3n");
			lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblDireccion.setBounds(37, 266, 76, 19);
			panel.add(lblDireccion);
			
			txtDireccion = new JTextField();
			txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(150, 264, 198, 27);
			panel.add(txtDireccion);
			
			JLabel lblTelefono = new JLabel("Tel\u00E9fono");
			lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTelefono.setBounds(37, 218, 76, 19);
			panel.add(lblTelefono);
			
			txtTelefono = new JTextField();
			txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtTelefono.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b') ) {
	                    e.consume();
	                }
				}
			});
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(150, 216, 198, 27);
			panel.add(txtTelefono);
			
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtCedula.getText().equalsIgnoreCase("")|| txtNombre.getText().equalsIgnoreCase("")|| txtApellidos.getText().equalsIgnoreCase("")||txtDireccion.getText().equalsIgnoreCase("")||txtTelefono.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "No deje ningún campo vacío, por favor", "Problema de registo", JOptionPane.CLOSED_OPTION);
					}
					else if(txtCedula.getText().length()!=11) {
						JOptionPane.showMessageDialog(null, "Complete su cédula correctamente", "Problema de registo", JOptionPane.CLOSED_OPTION);
					}
					else if(queseria.buscarCliente(txtCedula.getText())!=-1) {
						JOptionPane.showMessageDialog(null, "Este cliente ya existe", "Problema de registo", JOptionPane.CLOSED_OPTION);
					}
					else {
						client.setCedula(txtCedula.getText());
						client.setNombre(txtNombre.getText()+txtApellidos.getText());
						client.setDireccion(txtDireccion.getText());
						client.setNumero(txtTelefono.getText());
						JOptionPane.showMessageDialog(null, "El cliente fue registrado correctamente", "Registro correcto", JOptionPane.CLOSED_OPTION);
						queseria.addCliente(client);
						dispose();
					}
					
				}
			});
			btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnAceptar.setBounds(81, 315, 98, 27);
			panel.add(btnAceptar);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnCancelar.setBounds(219, 315, 98, 27);
			panel.add(btnCancelar);
		}
	}
}
