package visual.queseria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.queseria.CilindroQueso;
import logico.queseria.EsferaQueso;
import logico.queseria.Queseria;
import logico.queseria.Queso;
import logico.queseria.QuesoCilindroHueco;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarQuesos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableQuesos;
	private List<Queso> listaMostrar=new ArrayList<>();
	private JRadioButton rdbtnCilindrico;
	private JRadioButton rdbtnCilindricoHueco;
	private JRadioButton rdbtnTodos;

	/*
	 
	public static void main(String[] args) {
		try {
			Queseria queseria=new Queseria();
			Queso queso1=new EsferaQueso(10,25,2,(long) queseria.getMyQuesos().size());
			queseria.addQueso(queso1);
			Queso queso2=new CilindroQueso(10,25,2,(float) 3.8,(long) queseria.getMyQuesos().size());
			queseria.addQueso(queso2);
			queseria.addQueso(queso2);
			Queso queso3=new QuesoCilindroHueco(10,25,2,(float) 3.8,5,(long) queseria.getMyQuesos().size());
			queseria.addQueso(queso3);
			ListarQuesos dialog = new ListarQuesos(queseria);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 @param queseria 
	 */
	public ListarQuesos(Queseria queseria) {
		setTitle("Listar");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 849, 391);
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
			
			JLabel lblNewLabel = new JLabel("Listar Quesos");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setBounds(359, 10, 142, 27);
			panel.add(lblNewLabel);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(52, 104, 712, 166);
			panel.add(scrollPane);
			
			tableQuesos = new JTable();
			tableQuesos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			scrollPane.setViewportView(tableQuesos);
			
			DefaultTableModel model = new DefaultTableModel() {
				public Class<?> getColumnClass(int column){
					switch (column) {
					case 0:
						return Long.class;
					case 1:
						return String.class;
					case 2:
						return Float.class;
					default:
						return Float.class;
					}
				}
			};
			tableQuesos.setModel(model);
			model.addColumn("ID");
			model.addColumn("Tipo");
			model.addColumn("Volumen");
			model.addColumn("Precio");
			listaMostrar=queseria.getMyQuesos();
			setTable(model,listaMostrar);
			
			JRadioButton rdbtnEsferico = new JRadioButton("Esf\u00E9rico");
			rdbtnEsferico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnEsferico.setEnabled(false);
					rdbtnCilindrico.setEnabled(true);
					rdbtnCilindricoHueco.setEnabled(true);
					rdbtnTodos.setEnabled(true);
					rdbtnEsferico.setSelected(true);
					rdbtnCilindrico.setSelected(false);
					rdbtnCilindricoHueco.setSelected(false);
					rdbtnTodos.setSelected(false);
					listaMostrar=queseria.quesosEsferaTotal();
					setTable(model,listaMostrar);
				}
			});
			rdbtnEsferico.setFont(new Font("Tahoma", Font.PLAIN, 14));
			rdbtnEsferico.setBounds(52, 58, 103, 21);
			panel.add(rdbtnEsferico);
			
			rdbtnCilindrico = new JRadioButton("Cil\u00EDndrico");
			rdbtnCilindrico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnEsferico.setEnabled(true);
					rdbtnCilindrico.setEnabled(false);
					rdbtnCilindricoHueco.setEnabled(true);
					rdbtnTodos.setEnabled(true);
					rdbtnEsferico.setSelected(false);
					rdbtnCilindrico.setSelected(true);
					rdbtnCilindricoHueco.setSelected(false);
					rdbtnTodos.setSelected(false);
					listaMostrar=queseria.quesosCilindroTotal();
					setTable(model,listaMostrar);
				}
			});
			rdbtnCilindrico.setFont(new Font("Tahoma", Font.PLAIN, 14));
			rdbtnCilindrico.setBounds(233, 58, 103, 21);
			panel.add(rdbtnCilindrico);
			
			rdbtnCilindricoHueco = new JRadioButton("Cil\u00EDndrico Hueco");
			rdbtnCilindricoHueco.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnEsferico.setEnabled(true);
					rdbtnCilindrico.setEnabled(true);
					rdbtnCilindricoHueco.setEnabled(false);
					rdbtnTodos.setEnabled(true);
					rdbtnEsferico.setSelected(false);
					rdbtnCilindrico.setSelected(false);
					rdbtnCilindricoHueco.setSelected(true);
					rdbtnTodos.setSelected(false);
					listaMostrar=queseria.quesosCilindroHuecoTotal();
					setTable(model,listaMostrar);
				}
			});
			rdbtnCilindricoHueco.setFont(new Font("Tahoma", Font.PLAIN, 14));
			rdbtnCilindricoHueco.setBounds(408, 58, 142, 21);
			panel.add(rdbtnCilindricoHueco);
			
			rdbtnTodos = new JRadioButton("Todos");
			rdbtnTodos.setSelected(true);
			rdbtnTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnEsferico.setEnabled(true);
					rdbtnCilindrico.setEnabled(true);
					rdbtnCilindricoHueco.setEnabled(true);
					rdbtnTodos.setEnabled(false);
					rdbtnEsferico.setSelected(false);
					rdbtnCilindrico.setSelected(false);
					rdbtnCilindricoHueco.setSelected(false);
					rdbtnTodos.setSelected(true);
					listaMostrar=queseria.getMyQuesos();
					setTable(model,listaMostrar);
				}
			});
			rdbtnTodos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			rdbtnTodos.setBounds(635, 58, 103, 21);
			panel.add(rdbtnTodos);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnSalir.setBounds(359, 296, 103, 27);
			panel.add(btnSalir);
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
				
		}
	}
}
