package forme;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import korisnici.Kozmeticar;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entitetiSalona.KozmetickiSalon;
import entitetiSalona.Tretman;
import entitetiSalona.ZakazanTretman;
import funkcionalnosti.Funkcionalnost;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class KozmeticarFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Kozmeticar korisnik;
	private JTable table;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the frame.
	 */
	public KozmeticarFrame(Kozmeticar korisnik) {
		this.korisnik = korisnik;
		setTitle("Kozmeticar - " + korisnik.getIme() + " " + korisnik.getPrezime());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(25);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Zakazanog Tretmana", "Tip tretmana", "Datum i vreme"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(170);
		table.getColumnModel().getColumn(0).setMinWidth(170);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		scrollPane.setViewportView(table);
		Funkcionalnost.CentrirajTabelu(table);
		
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
			if(zakazanTretman.getIdKozmeticara() == korisnik.getId()) 
			{
				Object[] data = {zakazanTretman.getId(), Tretman.NadjiPoID(zakazanTretman.getidTretmana(), KozmetickiSalon.tretmani).getNaziv(),
						Funkcionalnost.dateToString(zakazanTretman.getVreme())};
				dm.addRow(data);
			}
		}
		
		menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		mnNewMenu = new JMenu("Dodatne opcije");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Dodeljeni tretmani");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tretmani = "";
				for (Integer integer : korisnik.getObucenZaTretmane()) {
					tretmani += Tretman.NadjiPoID(integer, KozmetickiSalon.tretmani).getNaziv() + ", ";
				}
				JOptionPane.showMessageDialog(getContentPane(), "Tipovi tretmana koji su vam dodeljeni su: " + tretmani.substring(0, tretmani.length() - 2), "Dodeljeni tretmani", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Odjavi se");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginFrame().main(new String[] {"", ""});
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Izlaz");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
	}

}
