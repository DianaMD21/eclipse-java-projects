package visual.queseria;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.sun.prism.paint.Color;
import logico.queseria.CilindroQueso;
import logico.queseria.Cliente;
import logico.queseria.EsferaQueso;
import logico.queseria.Factura;
import logico.queseria.Queseria;
import logico.queseria.Queso;
import logico.queseria.QuesoCilindroHueco;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JCheckBox;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Dialog.ModalityType;
import java.awt.Label;
import java.awt.Checkbox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class FacturarVisual extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Queseria miQueseria;
	private List<Queso> quesosPresentar=new ArrayList<>();
	private List<Queso> quesosComprar=new ArrayList<>();
	private Label lblTotal;
	private JTable tableCliente;
	private JLabel lblClienteSel;
	private Calendar fecha=new GregorianCalendar();
	private JLabel lblFecha;

	/*
	
	 * @param queseria 
	 * @param factura 
	 */
	public FacturarVisual(Factura factura, Queseria queseria) {
		setTitle("Facturar");
		fecha.setTime(new Date());
		this.miQueseria=queseria;
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 806, 508);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblFactura = new JLabel("Factura");
				lblFactura.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblFactura.setBounds(363, 10, 78, 20);
				panel.add(lblFactura);
			}
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 68, 711, 110);
			panel.add(scrollPane);
			
			JScrollPane scrollPane1 = new JScrollPane();
			scrollPane1.setBounds(34, 231, 711, 110);
			panel.add(scrollPane1);
			
			table = new JTable();
			table.setFont(new Font("Tahoma", Font.PLAIN, 12));
			scrollPane.setViewportView(table);
			
			lblTotal = new Label("0.0");
			lblTotal.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblTotal.setBounds(656, 184, 102, 27);
			panel.add(lblTotal);
		    
			DefaultTableModel model = new DefaultTableModel() {
				public Class<?> getColumnClass(int column){
					switch (column) {
					case 0:
						return Long.class;
					case 1:
						return String.class;
					case 2:
						return Float.class;
					case 3:
						return Float.class;
					default:
						return Boolean.class;
					}
				}
			};
			table.setModel(model);
			model.addColumn("ID");
			model.addColumn("Tipo");
			model.addColumn("Volumen");
			model.addColumn("Precio");
			model.addColumn("Selección");
			quesosPresentar=miQueseria.getMyQuesos();
			setTable(model,quesosPresentar);
			
			table.getModel().addTableModelListener(
					new TableModelListener() 
					{
						public void tableChanged(TableModelEvent evt) 
						{
							float precio=0;
							for(int b=0;b<quesosPresentar.size();b++) {	
								if(model.getValueAt(b, 4).equals(true)) {
									precio+=(float)model.getValueAt(b, 3);
								}	
							}
							lblTotal.setText(String.valueOf(precio));
						}
					});
			
			tableCliente = new JTable();
			scrollPane1.setViewportView(tableCliente);
			
			DefaultTableModel modelClient = new DefaultTableModel() {
				public Class<?> getColumnClass(int column){
					switch (column) {
					case 0:
						return String.class;
					case 1:
						return String.class;
					default:
						return String.class;
					}
				}
			};
			
			tableCliente.setModel(modelClient);
			tableCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			modelClient.addColumn("Cédula");
			modelClient.addColumn("Nombre");
			modelClient.addColumn("Teléfono");
			setTableCliente(modelClient,miQueseria.getMyClients());
			
			tableCliente.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblClienteSel.setText("Cliente seleccionado: "+modelClient.getValueAt(tableCliente.getSelectedRow(), 0)+" / "+modelClient.getValueAt(tableCliente.getSelectedRow(), 1));
				}
			});
			
			Label label = new Label("Total:");
			label.setFont(new Font("Dialog", Font.PLAIN, 14));
			label.setBounds(569, 184, 62, 27);
			panel.add(label);
			
			Label label_1 = new Label("Quesos Disponibles:");
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_1.setBounds(34, 39, 207, 21);
			panel.add(label_1);
			
			lblClienteSel = new JLabel("Cliente seleccionado: ");
			lblClienteSel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblClienteSel.setBounds(34, 351, 711, 13);
			panel.add(lblClienteSel);
			
			JLabel lblNewLabel = new JLabel("Clientes:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(35, 203, 102, 20);
			panel.add(lblNewLabel);
			
			JButton btnFacturar = new JButton("Facturar");
			btnFacturar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					quesosComprar=getCheckQuesos(model);
					int index=tableCliente.getSelectedRow();
					if(quesosComprar.size()>0 && index>-1) {
						Cliente clienteFactura=miQueseria.getMyClients().get(miQueseria.buscarCliente((String) modelClient.getValueAt(index, 0)));
						factura.setMyQuesos(quesosComprar);
						factura.setCliente(clienteFactura);
						factura.setFecha(fecha);
						JOptionPane.showMessageDialog(null, "La factura fue creada correctamente", "Facturación correcta", JOptionPane.CLOSED_OPTION);
						miQueseria.addFactura(factura);
						updateQuesos(quesosComprar);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "No deje ningún campo vacío", "Problemas con la facturación", JOptionPane.CLOSED_OPTION);
				}
			});
			btnFacturar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnFacturar.setBounds(245, 396, 102, 36);
			panel.add(btnFacturar);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCancelar.setBounds(382, 396, 95, 36);
			panel.add(btnCancelar);
			
			JButton btnRegCliente = new JButton("Registrar nuevo cliente");
			btnRegCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cliente client=new Cliente();
					RegClienteVisual newClient=new RegClienteVisual(client,miQueseria);
					newClient.setVisible(true);
					setTableCliente(modelClient,miQueseria.getMyClients());
				}
			});
			btnRegCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnRegCliente.setBounds(559, 351, 186, 27);
			panel.add(btnRegCliente);
			
			lblFecha = new JLabel("");
			lblFecha.setText("Fecha: "+fecha.get(Calendar.DAY_OF_MONTH)+" / "+fecha.get(Calendar.MONTH)+" / "+fecha.get(Calendar.YEAR));
			lblFecha.setEnabled(false);
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFecha.setBounds(607, 10, 140, 20);
			panel.add(lblFecha);
		}
	}
	protected void updateQuesos(List<Queso> quesosComprar2) {
		int index=0;
		for(int a=0;a<quesosComprar2.size();a++) {
			index=miQueseria.buscarQueso(quesosComprar2.get(a).getIdCod());
			miQueseria.getMyQuesos().remove(index);
		}
	}

	protected List<Queso> getCheckQuesos(DefaultTableModel model) {
		List<Queso> quesos=new ArrayList<>();
		for(int b=0;b<miQueseria.getMyQuesos().size();b++) {
			if(model.getValueAt(b, 4).equals(true)) {
				quesos.add(miQueseria.getMyQuesos().get(miQueseria.buscarQueso((Long) model.getValueAt(b, 0))));
			}
		}
		return quesos;
	}

	private void setTableCliente(DefaultTableModel model, List<Cliente> myClients) {
		model.setRowCount(0);
		for(int b=0;b<myClients.size();b++) {
			model.addRow(new Object[0]);	
			model.setValueAt(myClients.get(b).getCedula(), b, 0);
			model.setValueAt(myClients.get(b).getNombre(), b, 1);
			model.setValueAt(myClients.get(b).getNumero(), b, 2);
		}
	}

	private void setTable(DefaultTableModel model, List<Queso> quesosPresentar2) {
		model.setRowCount(0);
		for(int b=0;b<quesosPresentar2.size();b++) {
			model.addRow(new Object[0]);	
			model.setValueAt(quesosPresentar2.get(b).getIdCod(), b, 0);
				if(quesosPresentar2.get(b) instanceof EsferaQueso)
					model.setValueAt("Queso Esférico", b, 1);
				if (quesosPresentar2.get(b) instanceof CilindroQueso & !(quesosPresentar2.get(b) instanceof QuesoCilindroHueco))
					model.setValueAt("Queso Cilíndrico", b, 1);
				if (quesosPresentar2.get(b) instanceof QuesoCilindroHueco)
					model.setValueAt("Queso Cilíndrico Hueco", b, 1);
				model.setValueAt(quesosPresentar2.get(b).getVolumen(), b, 2);
				model.setValueAt(quesosPresentar2.get(b).calcularPrecio(), b, 3);
				model.setValueAt(false, b, 4);
				
		}
	}
}
