package forme;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entitetiSalona.KlijentAdmin;
import entitetiSalona.KozmetickiSalon;
import entitetiSalona.Tretman;
import entitetiSalona.ZakazanTretman;
import entitetiSalona.ZakazanTretmanAdmin;
import enumi.Stanje;
import funkcionalnosti.ComboItem;
import funkcionalnosti.Funkcionalnost;
import korisnici.Klijent;
import korisnici.Kozmeticar;

import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class KlijentFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Klijent korisnik;
	CardLayout cardLayout;
	CardLayout cardLayout2;
	JPanel panelCards;
	JPanel panelZakazi;
	private JTextField textFieldCenaOd;
	private JTextField textFieldTrajanje;
	private JTextField textFieldCenaDo;
	JComboBox comboBoxTretman;
	JComboBox comboBoxKozmeticar;
	int idKozmeticara;
	JComboBox comboBoxVreme;
	JDateChooser dateChooser;
	JLabel lblNewLabelCena;
	JLabel lblNewLabelVreme;
	JLabel lblNewLabelDatum;
	JLabel lblNewLabelKozmeticar;
	JLabel lblNewLabelTretman;
	private JTable tableRealizovani;
	private JTable tableNeRealizovani;
	private JLabel lblPotrosnja;
	private JLabel lblStanje;
	private JLabel lblUslov;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the frame.
	 */
	public KlijentFrame(Klijent korisnik) {
		this.korisnik = korisnik;
		setTitle("Klijent - " + korisnik.getIme() + " " + korisnik.getPrezime());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton btnZakazi = new JButton("Zakazi");
		btnZakazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "name_824750217181600");
				cardLayout2.show(panelZakazi, "name_826667032195100");
			}
		});
		btnZakazi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnZakazi);
		
		JButton bntRealizovani = new JButton("Realizovani tretmani");
		bntRealizovani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "name_824751527752400");
				OsveziRealizovane();
			}
		});
		bntRealizovani.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(bntRealizovani);
		
		JButton btnNERealizovani = new JButton("Nerealizovani tretmani");
		btnNERealizovani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "name_824752739915300");
				OsveziNeRealizovane();
			}
		});
		btnNERealizovani.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnNERealizovani);
		
		JButton btnKartica = new JButton("Kartica lojalnosti");
		btnKartica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "name_824756214798600");
				PrikaziKarticu();
			}
		});
		btnKartica.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnKartica);

		panelCards = new JPanel();
		splitPane.setRightComponent(panelCards);
		panelCards.setLayout(new CardLayout(0, 0));
		cardLayout = (CardLayout)(panelCards.getLayout());
		
		panelZakazi = new JPanel();
		panelCards.add(panelZakazi, "name_824750217181600");
		panelZakazi.setLayout(new CardLayout(0, 0));
		cardLayout2 = (CardLayout)(panelZakazi.getLayout());
		
		JPanel panelTretman = new JPanel();
		panelZakazi.add(panelTretman, "name_826667032195100");
		panelTretman.setLayout(new MigLayout("", "[][][][grow][][][][][grow]", "[][][][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Trajanje:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelTretman.add(lblNewLabel_1, "flowx,cell 3 2");
		
		textFieldTrajanje = new JTextField();
		textFieldTrajanje.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTrajanje.setColumns(10);
		panelTretman.add(textFieldTrajanje, "cell 3 2,alignx center,aligny center");
		
		JLabel lblNewLabel_1_1 = new JLabel("Cena OD:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelTretman.add(lblNewLabel_1_1, "flowx,cell 3 3");
		
		textFieldCenaOd = new JTextField();
		textFieldCenaOd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelTretman.add(textFieldCenaOd, "cell 3 3,alignx center,aligny center");
		textFieldCenaOd.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tretman:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelTretman.add(lblNewLabel, "flowx,cell 8 3,alignx center,aligny center");
		
		comboBoxTretman = new JComboBox();
		comboBoxTretman.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelTretman.add(comboBoxTretman, "cell 8 3,alignx center,aligny center");
		
		JLabel lblNewLabel_1_2 = new JLabel("Cena DO:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelTretman.add(lblNewLabel_1_2, "flowx,cell 3 4");
		
		textFieldCenaDo = new JTextField();
		textFieldCenaDo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCenaDo.setColumns(10);
		panelTretman.add(textFieldCenaDo, "cell 3 4,alignx center,aligny center");
		
		JButton btnPretrazi = new JButton("Pretrazi");
		btnPretrazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					comboBoxTretman.removeAllItems();
					Pretraga();
					if(comboBoxTretman.getItemCount() == 0) 
					{
						JOptionPane.showMessageDialog(getContentPane(), "Takav termin ne postoji!", "", JOptionPane.WARNING_MESSAGE);  
						textFieldCenaOd.setText("");
						textFieldCenaDo.setText("");
						textFieldTrajanje.setText("");
						Pretraga();
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnPretrazi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelTretman.add(btnPretrazi, "cell 3 5,alignx center,aligny center");
		
		JButton btnDalje1 = new JButton("Sledeci korak >>>");
		btnDalje1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout2.show(panelZakazi, "name_826668642502000");
				PopuniKozmeticare();
			}
		});
		btnDalje1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelTretman.add(btnDalje1, "cell 8 8");
		
		JPanel panelKozmeticar = new JPanel();
		panelZakazi.add(panelKozmeticar, "name_826668642502000");
		panelKozmeticar.setLayout(new GridLayout(2, 1, 0, 0));
		
		comboBoxKozmeticar = new JComboBox();
		comboBoxKozmeticar.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panelKozmeticar.add(comboBoxKozmeticar);
		
		JPanel panel_1 = new JPanel();
		panelKozmeticar.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnPreskoci = new JButton("Preskoci");
		btnPreskoci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idKozmeticara = ((ComboItem)comboBoxKozmeticar.getModel().getElementAt(0)).getKey();
				cardLayout2.show(panelZakazi, "name_826670629744000");
				UcitajSlobodneTermine();
			}
		});
		btnPreskoci.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnPreskoci);
		
		JButton btnIzaberi = new JButton("Izaberi");
		btnIzaberi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idKozmeticara = ((ComboItem)comboBoxKozmeticar.getSelectedItem()).getKey();
				cardLayout2.show(panelZakazi, "name_826670629744000");
				UcitajSlobodneTermine();
			}
		});
		btnIzaberi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnIzaberi);
		
		JPanel panelDatum = new JPanel();
		panelZakazi.add(panelDatum, "name_826670629744000");
		panelDatum.setLayout(new MigLayout("", "[][][grow]", "[][][][grow][][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("Datum:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDatum.add(lblNewLabel_3, "flowx,cell 2 3,alignx center,aligny center");
		
		comboBoxVreme = new JComboBox();
		dateChooser = new JDateChooser();
		dateChooser.setPreferredSize(new Dimension(200, 20));
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				UcitajSlobodneTermine();
			}
		});
		panelDatum.add(dateChooser, "cell 2 3,alignx center,aligny center");
		
		JLabel lblNewLabel_2 = new JLabel("Vreme:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDatum.add(lblNewLabel_2, "flowx,cell 2 4,alignx center,aligny center");

		panelDatum.add(comboBoxVreme, "cell 2 4,alignx center,aligny center");
		
		JButton btnDalje2 = new JButton("Dalje >>>");
		btnDalje2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cardLayout2.show(panelZakazi, "name_826672467110900");
					lblNewLabelTretman.setText(Tretman.NadjiPoID(((ComboItem)comboBoxTretman.getSelectedItem()).getKey(), KozmetickiSalon.tretmani).getNaziv());
					lblNewLabelKozmeticar.setText(Kozmeticar.NadjiPoID(idKozmeticara, KozmetickiSalon.kozmeticari).getIme() + " " + 
							Kozmeticar.NadjiPoID(idKozmeticara, KozmetickiSalon.kozmeticari).getPrezime());
					lblNewLabelDatum.setText(dateChooser.getDate().getYear() + 1900 + "/" + (dateChooser.getDate().getMonth() + 1) + "/" + 
							dateChooser.getDate().getDate());
					lblNewLabelVreme.setText(((ComboItem)comboBoxVreme.getSelectedItem()).getValue());
					double cena = Tretman.NadjiPoID(((ComboItem)comboBoxTretman.getSelectedItem()).getKey(), KozmetickiSalon.tretmani).getCena();
					if(korisnik.getPravoNaKarticuLojalnosti()) 
					{
						cena *= 0.9;
					}
					lblNewLabelCena.setText(String.valueOf(cena));
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(getContentPane(), "Doslo je do greske!", "", JOptionPane.ERROR_MESSAGE);  
				}
			}
		});
		btnDalje2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelDatum.add(btnDalje2, "cell 2 6,alignx center,aligny center");
		
		JPanel panelPotvrda = new JPanel();
		panelZakazi.add(panelPotvrda, "name_826672467110900");
		panelPotvrda.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][]"));
		
		JLabel lblNewLabel_4 = new JLabel("Tretman:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPotvrda.add(lblNewLabel_4, "cell 1 2,alignx center");
		
		lblNewLabelTretman = new JLabel("New label");
		lblNewLabelTretman.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPotvrda.add(lblNewLabelTretman, "cell 2 2");
		
		JLabel lblNewLabel_4_1 = new JLabel("Kozmeticar:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPotvrda.add(lblNewLabel_4_1, "cell 1 3,alignx center,aligny center");
		
		lblNewLabelKozmeticar = new JLabel("New label");
		lblNewLabelKozmeticar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPotvrda.add(lblNewLabelKozmeticar, "cell 2 3");
		
		JLabel lblNewLabel_4_2 = new JLabel("Datum:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPotvrda.add(lblNewLabel_4_2, "cell 1 4,alignx center,aligny center");
		
		lblNewLabelDatum = new JLabel("New label");
		lblNewLabelDatum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPotvrda.add(lblNewLabelDatum, "cell 2 4");
		
		JLabel lblNewLabel_4_3 = new JLabel("Vreme:");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPotvrda.add(lblNewLabel_4_3, "cell 1 5,alignx center,aligny center");
		
		lblNewLabelVreme = new JLabel("New label");
		lblNewLabelVreme.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPotvrda.add(lblNewLabelVreme, "cell 2 5");
		
		JLabel lblNewLabel_4_4 = new JLabel("Cena:");
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPotvrda.add(lblNewLabel_4_4, "cell 1 6,alignx center,aligny center");
		
		lblNewLabelCena = new JLabel("New label");
		lblNewLabelCena.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPotvrda.add(lblNewLabelCena, "cell 2 6");
		
		JButton btnPotvrdi = new JButton("Potvrdi kupovinu");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double cena = Tretman.NadjiPoID(((ComboItem)comboBoxTretman.getSelectedItem()).getKey(), KozmetickiSalon.tretmani).getCena();
				if(korisnik.getPravoNaKarticuLojalnosti()) 
				{
					cena *= 0.9;
				}
				korisnik.setPotrosnja(korisnik.getPotrosnja() + cena);
				korisnik.setStanje(korisnik.getStanje() - cena);
				KlijentAdmin.IzmeniKlijenta(korisnik.getId(), korisnik);
				Date vreme = dateChooser.getDate();
				String satS = ((ComboItem)comboBoxVreme.getSelectedItem()).getValue();
				vreme.setHours(Integer.parseInt(satS.split(":")[0]));
				vreme.setMinutes(0);
				ZakazanTretman zakazanTretman = new ZakazanTretman(korisnik.getId(), idKozmeticara, ((ComboItem)comboBoxTretman.getSelectedItem()).getKey(), vreme, Stanje.ZAKAZAN);
				ZakazanTretmanAdmin.DodajZakazanTretman(zakazanTretman);
				JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste zakazali tretman!", "", JOptionPane.INFORMATION_MESSAGE);  
				cardLayout2.show(panelZakazi, "name_826667032195100");
				OsveziRealizovane();
				OsveziNeRealizovane();
			}
		});
		btnPotvrdi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelPotvrda.add(btnPotvrdi, "cell 2 9");
		Pretraga();
		
		JPanel panelRealizovani = new JPanel();
		panelCards.add(panelRealizovani, "name_824751527752400");
		panelRealizovani.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelRealizovani.add(scrollPane, BorderLayout.CENTER);
		
		tableRealizovani = new JTable();
		tableRealizovani.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableRealizovani.setRowHeight(23);
		tableRealizovani.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableRealizovani.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Klijent", "Kozmeticar", "Tretman", "Datum i vreme", "Stanje"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Funkcionalnost.CentrirajTabelu(tableRealizovani);
		scrollPane.setViewportView(tableRealizovani);
		UcitajRealizovane();
		
		JPanel panelNERealizovani = new JPanel();
		panelCards.add(panelNERealizovani, "name_824752739915300");
		panelNERealizovani.setLayout(new BorderLayout(0, 0));
		
		JButton bntOtkazi = new JButton("Otkazi");
		bntOtkazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableNeRealizovani.getSelectedRow() != -1) 
				{
					int id = (int)tableNeRealizovani.getModel().getValueAt(tableNeRealizovani.getSelectedRow(), 0);
					int result = JOptionPane.showConfirmDialog(getContentPane(),"Da li zaista zelite da otkazete tretman?\nBice vam vraceno 10% od iznosa placanja.", "Otkazivanje",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) 
					{
						ZakazanTretman zakazanTretman = ZakazanTretman.NadjiPoID(id, KozmetickiSalon.zakazaniTretmani);
						if(zakazanTretman.getStanje() == Stanje.ZAKAZAN) 
						{
							korisnik.setPotrosnja(korisnik.getPotrosnja() - Tretman.NadjiPoID(zakazanTretman.getidTretmana(), KozmetickiSalon.tretmani).getCena() * 0.9);
							korisnik.setStanje(korisnik.getStanje() + Tretman.NadjiPoID(zakazanTretman.getidTretmana(), KozmetickiSalon.tretmani).getCena() * 0.1);
							KlijentAdmin.IzmeniKlijenta(korisnik.getId(), korisnik);
							zakazanTretman.setStanje(Stanje.OTKAZAO_KLIJENT);
							ZakazanTretmanAdmin.IzmeniZakazanTretman(zakazanTretman.getId(), zakazanTretman);
							OsveziRealizovane();
							OsveziNeRealizovane();
						}
					}
				}else 
				{
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		bntOtkazi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelNERealizovani.add(bntOtkazi, BorderLayout.SOUTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panelNERealizovani.add(scrollPane_1, BorderLayout.CENTER);
		
		tableNeRealizovani = new JTable();
		tableNeRealizovani.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableNeRealizovani.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Klijent", "Kozmeticar", "Tretman", "Datum i vreme", "Stanje"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableNeRealizovani.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableNeRealizovani.setRowHeight(23);
		Funkcionalnost.CentrirajTabelu(tableNeRealizovani);
		scrollPane_1.setViewportView(tableNeRealizovani);
		
		JPanel panelKarticaLojalnosti = new JPanel();
		panelCards.add(panelKarticaLojalnosti, "name_824756214798600");
		panelKarticaLojalnosti.setLayout(new MigLayout("", "[][][][]", "[][][][][][][][][]"));

		lblStanje = new JLabel("New label");
		lblStanje.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelKarticaLojalnosti.add(lblStanje, "cell 3 3,alignx center,aligny center");
		
		lblPotrosnja = new JLabel("New label");
		lblPotrosnja.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelKarticaLojalnosti.add(lblPotrosnja, "cell 3 6");
		
		lblUslov = new JLabel("New label");
		lblUslov.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelKarticaLojalnosti.add(lblUslov, "cell 3 8");
		splitPane.setDividerLocation(180);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("Opcije");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Odjavi se");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginFrame().main(new String[] {"", ""});
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Izlaz");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
	}
	
	
	private void Pretraga() 
	{
		try {
			if(textFieldTrajanje.getText().equals("") && textFieldCenaOd.getText().equals("") && textFieldCenaDo.getText().equals("")) 
			{
				for (Tretman tretman : KozmetickiSalon.tretmani) {
					comboBoxTretman.addItem(new ComboItem(tretman.getId(), tretman.getNaziv()));
				}
			}
			else 
			{
				for (Tretman tretman : KozmetickiSalon.tretmani) {
					if(tretman.getTrajanje() == Double.parseDouble(textFieldTrajanje.getText()) && tretman.getCena() >= Double.parseDouble(textFieldCenaOd.getText())
							&& tretman.getCena() <= Double.parseDouble(textFieldCenaDo.getText())) 
					{
						comboBoxTretman.addItem(new ComboItem(tretman.getId(), tretman.getNaziv()));
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
	}
	
	private void PopuniKozmeticare() 
	{
		comboBoxKozmeticar.removeAllItems();
		Tretman tretman = Tretman.NadjiPoID(((ComboItem)comboBoxTretman.getSelectedItem()).getKey(), KozmetickiSalon.tretmani);
		
		for(Kozmeticar kozmeticar : KozmetickiSalon.kozmeticari) 
		{
			if(kozmeticar.getObucenZaTretmane().contains(tretman.getId())) 
			{
				comboBoxKozmeticar.addItem(new ComboItem(kozmeticar.getId(), kozmeticar.getIme() + " " + kozmeticar.getPrezime()));
			}
		}
	}
	
	private void UcitajSlobodneTermine() 
	{
		comboBoxVreme.removeAllItems();
		try {
			Date datum = dateChooser.getDate();
			for (String string: KozmetickiSalon.RaspoloziviTermini) {
				if(Funkcionalnost.DaLiJeSlobodan(idKozmeticara, datum, string)) 
				{
					comboBoxVreme.addItem(new ComboItem(1, string));
				}
			}
			if(comboBoxVreme.getItemCount() == 0) 
			{
				JOptionPane.showMessageDialog(getContentPane(), "Izabrani kozmeticar tog dana nema slobodnih termina!", "Obavestenje", JOptionPane.WARNING_MESSAGE);  
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
	}
	
	private void OsveziRealizovane() 
	{
		tableRealizovani.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableRealizovani.getModel();
	    dm.getDataVector().removeAllElements();
	    
	    UcitajRealizovane();
	}
	
	private void UcitajRealizovane() 
	{
		DefaultTableModel dm = (DefaultTableModel) tableRealizovani.getModel();

		for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
			if(zakazanTretman.getStanje() == Stanje.IZVRSEN && zakazanTretman.getIdKlijenta() == korisnik.getId()) 
			{
				Object[] data = {zakazanTretman.getId(), Klijent.NadjiPoID(zakazanTretman.getIdKlijenta(), KozmetickiSalon.klijenti).getIme() + " " + 
						Klijent.NadjiPoID(zakazanTretman.getIdKlijenta(), KozmetickiSalon.klijenti).getPrezime(), 
						Kozmeticar.NadjiPoID(zakazanTretman.getIdKozmeticara(), KozmetickiSalon.kozmeticari).getIme() + " " +
						Kozmeticar.NadjiPoID(zakazanTretman.getIdKozmeticara(), KozmetickiSalon.kozmeticari).getPrezime(), 
						Tretman.NadjiPoID(zakazanTretman.getidTretmana(), KozmetickiSalon.tretmani).getNaziv(), 
						Funkcionalnost.dateToString(zakazanTretman.getVreme()), zakazanTretman.getStanje()};
				dm.addRow(data);
			}
		}
	}
	
	private void OsveziNeRealizovane() 
	{
		tableNeRealizovani.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableNeRealizovani.getModel();
	    dm.getDataVector().removeAllElements();
	    
	    UcitajNeRealizovane();
	}
	
	private void UcitajNeRealizovane() 
	{
		DefaultTableModel dm = (DefaultTableModel) tableNeRealizovani.getModel();

		for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
			if(zakazanTretman.getStanje() != Stanje.IZVRSEN && zakazanTretman.getIdKlijenta() == korisnik.getId()) 
			{
				Object[] data = {zakazanTretman.getId(), Klijent.NadjiPoID(zakazanTretman.getIdKlijenta(), KozmetickiSalon.klijenti).getIme() + " " + 
						Klijent.NadjiPoID(zakazanTretman.getIdKlijenta(), KozmetickiSalon.klijenti).getPrezime(), 
						Kozmeticar.NadjiPoID(zakazanTretman.getIdKozmeticara(), KozmetickiSalon.kozmeticari).getIme() + " " +
						Kozmeticar.NadjiPoID(zakazanTretman.getIdKozmeticara(), KozmetickiSalon.kozmeticari).getPrezime(), 
						Tretman.NadjiPoID(zakazanTretman.getidTretmana(), KozmetickiSalon.tretmani).getNaziv(), 
						Funkcionalnost.dateToString(zakazanTretman.getVreme()), zakazanTretman.getStanje()};
				dm.addRow(data);
			}
		}
	}
	
	private void PrikaziKarticu() 
	{
		if(korisnik.getPravoNaKarticuLojalnosti()) 
		{
			lblStanje.setText("Imate karticu lojalnosti!");
		}
		else 
		{
			lblStanje.setText("Jos uvek nemate karticu lojalnosti!");
		}
		lblPotrosnja.setText("Vasa potrosnja je: " + korisnik.getPotrosnja());
		lblUslov.setText("Uslov za karticu lojalnosti je: " + KozmetickiSalon.getUslov());
	}
}
