package forme;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import korisnici.Klijent;
import korisnici.Kozmeticar;
import korisnici.Recepcioner;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.table.DefaultTableModel;

import funkcionalnosti.ComboItem;
import funkcionalnosti.FilterPanel;
import funkcionalnosti.FilterPanelCena;
import funkcionalnosti.Funkcionalnost;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import entitetiSalona.KlijentAdmin;
import entitetiSalona.KozmetickiSalon;
import entitetiSalona.Tretman;
import entitetiSalona.ZakazanTretman;
import entitetiSalona.ZakazanTretmanAdmin;
import enumi.Stanje;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class RecepcionerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Recepcioner korisnik;
	private JTable table;
	private JComboBox comboBoxKlijent;
	private JComboBox comboBoxKozmeticar;
	private JComboBox comboBoxTretman;
	private JDateChooser dateChooser;
	private JComboBox comboBoxVreme;
	private int idStarog;
	private int idStarogT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the frame.
	 */
	public RecepcionerFrame(Recepcioner korisnik) {
		this.korisnik = korisnik;
		setTitle("Recepcioner - " + korisnik.getIme() + " " + korisnik.getPrezime());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(21);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
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
		scrollPane.setViewportView(table);
		Funkcionalnost.CentrirajTabelu(table);
		table.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {

		    public void valueChanged(ListSelectionEvent lse) {
		        if (!lse.getValueIsAdjusting() && table.getSelectedRow() != -1) {
		            int idZakazanogTretmana = (int)table.getModel().getValueAt(table.getSelectedRow(), 0);
		            ZakazanTretman izmena = ZakazanTretman.NadjiPoID(idZakazanogTretmana, KozmetickiSalon.zakazaniTretmani);
		            Klijent klijent = Klijent.NadjiPoID(izmena.getIdKlijenta(), KozmetickiSalon.klijenti);
		            idStarog = klijent.getId();
		            idStarogT = izmena.getidTretmana();
		            comboBoxKlijent.getModel().setSelectedItem(new ComboItem(klijent.getId(), klijent.getIme() + " " + klijent.getPrezime()));
		            Kozmeticar kozmeticar = Kozmeticar.NadjiPoID(izmena.getIdKozmeticara(), KozmetickiSalon.kozmeticari);
		            comboBoxKozmeticar.getModel().setSelectedItem (new ComboItem(kozmeticar.getId(), kozmeticar.getIme() + " " + kozmeticar.getPrezime()));
		            dateChooser.setDate(izmena.getVreme());
		            Tretman tretman = Tretman.NadjiPoID(izmena.getidTretmana(), KozmetickiSalon.tretmani);
					comboBoxTretman.getModel().setSelectedItem(new ComboItem(tretman.getId(), tretman.getNaziv()));
					comboBoxVreme.getModel().setSelectedItem(new ComboItem(1, izmena.getVreme().getHours() + ":00"));
		        }
		    }
		});
		UcitajZakazaneTretmane();
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_1 = new JSplitPane();
		panel.add(splitPane_1, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setLeftComponent(panel_1);
		panel_1.setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton btnZakazi = new JButton("Zakazi");
		btnZakazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					int idKlijenta = ((ComboItem)comboBoxKlijent.getSelectedItem()).getKey();
					int idKozmeticara = ((ComboItem)comboBoxKozmeticar.getSelectedItem()).getKey();
					int idTretmana = ((ComboItem)comboBoxTretman.getSelectedItem()).getKey();
					Stanje stanje = Stanje.ZAKAZAN;
					Date datum = dateChooser.getDate();
					String vreme = ((ComboItem)comboBoxVreme.getSelectedItem()).getValue();
					datum.setHours(Integer.parseInt(vreme.split(":")[0]));
					datum.setMinutes(0);
					ZakazanTretman novi = new ZakazanTretman(idKlijenta, idKozmeticara, idTretmana, datum, stanje);
		    		ZakazanTretmanAdmin.DodajZakazanTretman(novi);
		    		double cena = Tretman.NadjiPoID(idTretmana, KozmetickiSalon.tretmani).getCena();
		    		Klijent klijent = Klijent.NadjiPoID(idKlijenta, KozmetickiSalon.klijenti);
		    		if(klijent.getPravoNaKarticuLojalnosti()) 
		    		{
		    			cena *= 0.9;
		    		}
		    		klijent.setStanje(klijent.getStanje() - cena);
		    		klijent.setPotrosnja(klijent.getPotrosnja() + cena);
		    		KlijentAdmin.IzmeniKlijenta(idKlijenta, klijent);
		    		OsveziZakazaneTretmane();
		    		//UcitajSlobodneTermine();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnZakazi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnZakazi);
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
				try {
					int id = (int)table.getModel().getValueAt(table.getSelectedRow(), 0);
					int idKlijenta = ((ComboItem)comboBoxKlijent.getSelectedItem()).getKey();
					int idKozmeticara = ((ComboItem)comboBoxKozmeticar.getSelectedItem()).getKey();
					int idTretmana = ((ComboItem)comboBoxTretman.getSelectedItem()).getKey();
					Stanje stanje = Stanje.ZAKAZAN;
					Date datum = dateChooser.getDate();
					String vreme = ((ComboItem)comboBoxVreme.getSelectedItem()).getValue();
					datum.setHours(Integer.parseInt(vreme.split(":")[0]));
					datum.setMinutes(0);
					if(idKlijenta != idStarog) 
		    		{
		    			Klijent stari = Klijent.NadjiPoID(idStarog, KozmetickiSalon.klijenti);
		    			stari.setStanje(stari.getStanje() + Tretman.NadjiPoID(idStarogT, KozmetickiSalon.tretmani).getCena());
		    			stari.setPotrosnja(stari.getPotrosnja() - Tretman.NadjiPoID(idStarogT, KozmetickiSalon.tretmani).getCena());
		    			KlijentAdmin.IzmeniKlijenta(idStarog, stari);
		    		}
		    		Klijent novi = Klijent.NadjiPoID(idKlijenta, KozmetickiSalon.klijenti);
		    		double k = 1;
		    		if(novi.getPravoNaKarticuLojalnosti()) 
		    		{
		    			k = 0.9;
		    		}
		    		novi.setStanje(novi.getStanje() - Tretman.NadjiPoID(idTretmana, KozmetickiSalon.tretmani).getCena() * k);
		    		novi.setPotrosnja(novi.getPotrosnja() + Tretman.NadjiPoID(idTretmana, KozmetickiSalon.tretmani).getCena() * k);
					ZakazanTretman izmena = new ZakazanTretman(id, idKlijenta, idKozmeticara, idTretmana, datum, stanje);
		    		ZakazanTretmanAdmin.IzmeniZakazanTretman(id, izmena);
		    		OsveziZakazaneTretmane();
		    		//UcitajSlobodneTermine();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnIzmeni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnIzmeni);
		
		JButton btnOtkazi2 = new JButton("Otkazi");
		btnOtkazi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) 
				{
					int id = (int)table.getModel().getValueAt(table.getSelectedRow(), 0);
					int result = JOptionPane.showConfirmDialog(getContentPane(),"Da li zaista zelite da otkazete tretman?", "Otkazivanje",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) 
					{
						ZakazanTretman zakazanTretman = ZakazanTretman.NadjiPoID(id, KozmetickiSalon.zakazaniTretmani);
						if(zakazanTretman.getStanje() != Stanje.ZAKAZAN) return;
						zakazanTretman.setStanje(Stanje.OTKAZAO_SALON);
						ZakazanTretmanAdmin.IzmeniZakazanTretman(id, zakazanTretman);
						double cena = Tretman.NadjiPoID(zakazanTretman.getidTretmana(), KozmetickiSalon.tretmani).getCena();
						Klijent klijent = Klijent.NadjiPoID(zakazanTretman.getIdKlijenta(), KozmetickiSalon.klijenti);
						klijent.setStanje(klijent.getStanje() + cena);
						klijent.setPotrosnja(klijent.getPotrosnja() - cena);
						KlijentAdmin.IzmeniKlijenta(klijent.getId(), klijent);
						OsveziZakazaneTretmane();
					}
				}else 
				{
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		
		JButton btnOtkazi_1 = new JButton("Nije se pojavio");
		btnOtkazi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() != -1) 
				{
					int id = (int)table.getModel().getValueAt(table.getSelectedRow(), 0);
					int result = JOptionPane.showConfirmDialog(getContentPane(),"Da li ste sigurni da se klijent nije pojavio?", "Otkazivanje",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) 
					{
						ZakazanTretman zakazanTretman = ZakazanTretman.NadjiPoID(id, KozmetickiSalon.zakazaniTretmani);
						if(zakazanTretman.getStanje() != Stanje.ZAKAZAN) return;
						zakazanTretman.setStanje(Stanje.NIJE_SE_POJAVIO);
						ZakazanTretmanAdmin.IzmeniZakazanTretman(id, zakazanTretman);
						OsveziZakazaneTretmane();					}
				}else 
				{
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnOtkazi_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnOtkazi_1);
		btnOtkazi2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnOtkazi2);
		
		JPanel panel_2 = new JPanel();
		splitPane_1.setRightComponent(panel_2);
		panel_2.setLayout(new MigLayout("", "[][][][grow][][grow]", "[][][][][][][grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("Klijent:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_4, "cell 2 2,alignx center,aligny center");

		comboBoxKlijent = new JComboBox();
		panel_2.add(comboBoxKlijent, "cell 3 2,alignx center,aligny center");
		PopuniComboBoxKlijente();
		
		JLabel lblNewLabel_2 = new JLabel("Kozmeticar:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2, "cell 2 4,alignx center,aligny center");
		comboBoxTretman = new JComboBox();
		comboBoxKozmeticar = new JComboBox();
		comboBoxVreme = new JComboBox();
		comboBoxKozmeticar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopuniComboBoxTretmane();
				UcitajSlobodneTermine();
			}
		});
		panel_2.add(comboBoxKozmeticar, "cell 3 4,alignx center,aligny center");
		PopuniComboBoxKozmeticare();
		
		JLabel lblNewLabel_3 = new JLabel("Tretman:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_3, "cell 4 4,alignx trailing");
		
		panel_2.add(comboBoxTretman, "cell 5 4,growx");
		
		JLabel lblNewLabel = new JLabel("Datum:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel, "cell 2 6,alignx center,aligny center");
		
		dateChooser = new JDateChooser();
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				UcitajSlobodneTermine();
			}
		});
		dateChooser.setPreferredSize(new Dimension(200, 20));
		panel_2.add(dateChooser, "cell 3 6,alignx center,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Vreme:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_1, "cell 4 6,alignx center,aligny center");
		
		panel_2.add(comboBoxVreme, "cell 5 6,alignx center,aligny center");
		splitPane_1.setDividerLocation(150);
		splitPane.setDividerLocation(250);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu_1 = new JMenu("Opcije");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Odjavi se");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginFrame().main(new String[] {"", ""});
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Izlaz");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("Filtriraj tretmane");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTip = new JMenuItem("Tip");
		mntmTip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, new FilterPanel(),
		                  "Filtriranje po tipu tretmana", JOptionPane.OK_CANCEL_OPTION,
		                  JOptionPane.PLAIN_MESSAGE);
				if(result == JOptionPane.OK_OPTION) 
				{
					FilterTip((ComboItem)FilterPanel.comboBoxTretman.getSelectedItem());
				}
			}
		});
		mntmTip.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(mntmTip);
		
		JMenuItem mntmCena = new JMenuItem("Cena");
		mntmCena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, new FilterPanelCena(),
		                  "Filtriranje po ceni tretmana", JOptionPane.OK_CANCEL_OPTION,
		                  JOptionPane.PLAIN_MESSAGE);
				if(result == JOptionPane.OK_OPTION) 
				{
					try {
						FilterCena(Double.parseDouble(FilterPanelCena.textFieldOd.getText()), Double.parseDouble(FilterPanelCena.textFieldDo.getText()));
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos cena!", "Greska", JOptionPane.WARNING_MESSAGE);  
					}
				}
			}
		});
		mntmCena.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(mntmCena);
		
		JMenuItem mntmBez = new JMenuItem("Bez filtera");
		mntmBez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OsveziZakazaneTretmane();
			}
		});
		mntmBez.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(mntmBez);
	}
	
	private void OsveziZakazaneTretmane() 
	{
		table.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
	    dm.getDataVector().removeAllElements();
	    
	    UcitajZakazaneTretmane();
	}
	
	private void UcitajZakazaneTretmane() 
	{
		DefaultTableModel dm = (DefaultTableModel) table.getModel();

		for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
			Object[] data = {zakazanTretman.getId(), Klijent.NadjiPoID(zakazanTretman.getIdKlijenta(), KozmetickiSalon.klijenti).getIme() + " " + 
					Klijent.NadjiPoID(zakazanTretman.getIdKlijenta(), KozmetickiSalon.klijenti).getPrezime(), 
					Kozmeticar.NadjiPoID(zakazanTretman.getIdKozmeticara(), KozmetickiSalon.kozmeticari).getIme() + " " +
					Kozmeticar.NadjiPoID(zakazanTretman.getIdKozmeticara(), KozmetickiSalon.kozmeticari).getPrezime(), 
					Tretman.NadjiPoID(zakazanTretman.getidTretmana(), KozmetickiSalon.tretmani).getNaziv(), 
					Funkcionalnost.dateToString(zakazanTretman.getVreme()), zakazanTretman.getStanje()};
			dm.addRow(data);
		}
	}
	
	private void PopuniComboBoxKlijente() 
	{
		comboBoxKlijent.removeAllItems();
		for (Klijent klijent : KozmetickiSalon.klijenti) {
			comboBoxKlijent.addItem (new ComboItem(klijent.getId(), klijent.getIme() + " " + klijent.getPrezime()));
		}
	}
	
	private void PopuniComboBoxKozmeticare() 
	{
		comboBoxKozmeticar.removeAllItems();
		for (Kozmeticar kozmeticar : KozmetickiSalon.kozmeticari) {
			comboBoxKozmeticar.addItem (new ComboItem(kozmeticar.getId(), kozmeticar.getIme() + " " + kozmeticar.getPrezime()));
		}
	}
	
	private void PopuniComboBoxTretmane() 
	{
		comboBoxTretman.removeAllItems();
		try {
			int idKozmeticara = ((ComboItem)comboBoxKozmeticar.getModel().getSelectedItem()).getKey();
			List<Integer> vestineInt = Kozmeticar.NadjiPoID(idKozmeticara, KozmetickiSalon.kozmeticari).getObucenZaTretmane();
			List<String> vestineStr = Funkcionalnost.ProcitajVestineKozmeticara(vestineInt);
			for (int i = 0; i < vestineStr.size(); i++) {
				comboBoxTretman.addItem(new ComboItem(vestineInt.get(i), vestineStr.get(i)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
	}
	
	private void UcitajSlobodneTermine() 
	{
		comboBoxVreme.removeAllItems();
		try {
			int idKozmeticara = ((ComboItem)comboBoxKozmeticar.getModel().getSelectedItem()).getKey();
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
	
	private void FilterTip(ComboItem item) 
	{
		table.clearSelection();
		Tretman tretman = Tretman.NadjiPoID(item.getKey(), KozmetickiSalon.tretmani);
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();

		for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
			if(zakazanTretman.getidTretmana() == tretman.getId()) 
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
	
	private void FilterCena(double min, double max) 
	{
		table.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();

		for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
			Tretman tretman = Tretman.NadjiPoID(zakazanTretman.getidTretmana(), KozmetickiSalon.tretmani);
			if(tretman.getCena() >= min && tretman.getCena() <= max) 
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
}
