package visual.queseria;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.queseria.CilindroQueso;
import logico.queseria.Cliente;
import logico.queseria.EsferaQueso;
import logico.queseria.Factura;
import logico.queseria.Queseria;
import logico.queseria.Queso;
import logico.queseria.QuesoCilindroHueco;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;

public class QueseriaVisual extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private Queseria queseria;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Queseria miQueseria=new Queseria();
			QueseriaVisual dialog = new QueseriaVisual(miQueseria);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param miQueseria 
	 */
	public QueseriaVisual(Queseria miQueseria) {
		this.queseria=miQueseria;
		setFont(new Font("Tahoma", Font.PLAIN, 17));
		setTitle("Queser\u00EDa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim= getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			
			JMenuBar menuBar = new JMenuBar();
			panel.add(menuBar, BorderLayout.NORTH);
			
			JMenu mnmRegistrar = new JMenu("Registrar");
			mnmRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnmRegistrar);
			
			JMenuItem mntmCliente = new JMenuItem("Cliente");
			mntmCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cliente cliente=new Cliente();
					RegClienteVisual newClient=new RegClienteVisual(cliente,miQueseria);
					newClient.setVisible(true);
				}
			});
			mntmCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
			mnmRegistrar.add(mntmCliente);
			
			JMenu mnQueso = new JMenu("Queso");
			mnQueso.setFont(new Font("Tahoma", Font.PLAIN, 16));
			mnmRegistrar.add(mnQueso);
			
			JMenuItem mntmQuesoEsfera = new JMenuItem("Queso Esf\u00E9rico");
			mntmQuesoEsfera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Queso quesoE=new EsferaQueso();
					RegQuesoEsfera registrarQuesoE=new RegQuesoEsfera((EsferaQueso) quesoE,miQueseria);
					registrarQuesoE.setVisible(true);
				}
			});
			mntmQuesoEsfera.setFont(new Font("Tahoma", Font.PLAIN, 15));
			mnQueso.add(mntmQuesoEsfera);
			
			JMenuItem mntmQuesoCilndrico = new JMenuItem("Queso Cil\u00EDndrico");
			mntmQuesoCilndrico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Queso quesoC=new CilindroQueso();
					RegQuesoCilindrico registrarQuesoC=new RegQuesoCilindrico( (CilindroQueso) quesoC,miQueseria);
					registrarQuesoC.setVisible(true);
				}
			});
			mntmQuesoCilndrico.setFont(new Font("Tahoma", Font.PLAIN, 15));
			mnQueso.add(mntmQuesoCilndrico);
			
			JMenuItem mntmQuesoCilndricoHueco = new JMenuItem("Queso Cil\u00EDndrico Hueco");
			mntmQuesoCilndricoHueco.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Queso quesoCH=new QuesoCilindroHueco();
					RegQuesoCilindricoHueco registrarQuesoCH=new RegQuesoCilindricoHueco( (QuesoCilindroHueco) quesoCH,miQueseria);
					registrarQuesoCH.setVisible(true);
				}
			});
			mntmQuesoCilndricoHueco.setFont(new Font("Tahoma", Font.PLAIN, 15));
			mnQueso.add(mntmQuesoCilndricoHueco);
			
			JMenu mnmComprar = new JMenu("Comprar");
			mnmComprar.setFont(new Font("Tahoma", Font.PLAIN, 17));
			menuBar.add(mnmComprar);
			
			JMenuItem mntmFacturar = new JMenuItem("Realizar Factura");
			mntmFacturar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Factura factura=new Factura();
					FacturarVisual facturar=new FacturarVisual(factura,miQueseria);
					facturar.setVisible(true);
				}
			});
			mntmFacturar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			mnmComprar.add(mntmFacturar);
			
			JMenu mnListar = new JMenu("Listar");
			mnListar.setFont(new Font("Tahoma", Font.PLAIN, 17));
			menuBar.add(mnListar);
			
			JMenuItem mntmQuesos = new JMenuItem("Quesos");
			mntmQuesos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListarQuesos listar=new ListarQuesos(miQueseria);
					listar.setVisible(true);
				}
			});
			mntmQuesos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			mnListar.add(mntmQuesos);
			
			JMenuItem mntmClientes = new JMenuItem("Clientes");
			mntmClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListarClientes listar=new ListarClientes(miQueseria);
					listar.setVisible(true);
				}
			});
			mntmClientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
			mnListar.add(mntmClientes);
		}
	}
}
