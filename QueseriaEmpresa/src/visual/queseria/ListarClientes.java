package visual.queseria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.queseria.Cliente;
import logico.queseria.Queseria;
import logico.queseria.Queso;

public class ListarClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableClients;
	private List<Cliente> listaMostrar=new ArrayList<>();

	/*
	public static void main(String[] args) {
		try {
			Queseria queseria=new Queseria();
			ListarClientes dialog = new ListarClientes(queseria);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@param queseria 
	 */
	public ListarClientes(Queseria queseria) {
		setTitle("Listar");
		listaMostrar=queseria.getMyClients();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 847, 354);
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
			
			JLabel lblNewLabel = new JLabel("Listar Clientes");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setBounds(359, 10, 142, 27);
			panel.add(lblNewLabel);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(52, 65, 712, 166);
			panel.add(scrollPane);
			
			tableClients = new JTable();
			tableClients.setFont(new Font("Tahoma", Font.PLAIN, 12));
			scrollPane.setViewportView(tableClients);
			
			DefaultTableModel model = new DefaultTableModel() {
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
			
			tableClients.setModel(model);
			tableClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			model.addColumn("Cédula");
			model.addColumn("Nombre");
			model.addColumn("Teléfono");
			setTable(model,listaMostrar);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnSalir.setBounds(359, 257, 103, 27);
			panel.add(btnSalir);
		}
	}

	private void setTable(DefaultTableModel model, List<Cliente> listaMostrar2) {
		model.setRowCount(0);
		for(int b=0;b<listaMostrar2.size();b++) {
			model.addRow(new Object[0]);	
			model.setValueAt(listaMostrar2.get(b).getCedula(), b, 0);
			model.setValueAt(listaMostrar2.get(b).getNombre(), b, 1);
			model.setValueAt(listaMostrar2.get(b).getNumero(), b, 2);
		}
	}

}
