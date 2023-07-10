package forme;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entitetiSalona.KlijentAdmin;
import entitetiSalona.KozmeticarAdmin;
import entitetiSalona.KozmetickiSalon;
import entitetiSalona.MenadzerAdmin;
import entitetiSalona.RecepcionerAdmin;
import entitetiSalona.Tretman;
import entitetiSalona.TretmanAdmin;
import entitetiSalona.ZakazanTretman;
import entitetiSalona.ZakazanTretmanAdmin;
import enumi.Pol;
import funkcionalnosti.CheckboxListCellRenderer;
import funkcionalnosti.ComboItem;
import funkcionalnosti.Funkcionalnost;
import korisnici.Klijent;
import korisnici.Kozmeticar;
import korisnici.Menadzer;
import korisnici.Recepcioner;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.lang.invoke.CallSite;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import java.awt.ComponentOrientation;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.standalone.issues.TestForExtremeEdgeCaseData;
import org.knowm.xchart.style.Styler.LegendPosition;

import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultCellEditor;
import javax.swing.DropMode;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JScrollPane;
import java.awt.Component;

import net.miginfocom.layout.ContainerWrapper;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import enumi.Stanje;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class MenadzerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menadzer korisnik;
	private JButton btnPrihodiRashodi;
	CardLayout cardLayout;
	CardLayout cardLayout2;
	CardLayout cardLayout3;
	private JTable tableMenadzeri;
	private JTextField textFieldImeMenadzera;
	private JTextField textFieldPrezimeMenadzera;
	private JTextField textFieldTelefonMenadzera;
	private JTextField textFieldSpremaMenadzera;
	private JTextField textFieldStazMenadzera;
	private JTextField textFieldKoefMenadzera;
	private JTextField textFieldOsnovaMenadzera;
	private JTextField textFieldAdresaMenadzera;
	private JTextField textFieldKorImeMenadzera;
	private JTextField textFieldBonusMenadzera;
	private JTextField textFieldLozinkaMenadzera;
	private JDateChooser dateChooserOdStanje;
	private JDateChooser dateChooserDoStanje;
	private JDateChooser dateChooserOdUsluge;
	private JDateChooser dateChooserDoUsluge;
	private JComboBox comboBoxMenadzer;
	private JComboBox comboBoxKozmeticar;
	private JComboBox comboBoxRec;
	private JComboBox comboBoxKlijent;
	private JComboBox comboBoxVestine;
	private JPanel panel_21;
	private JPanel panel_22;
	private JPanel panel_23;
	private JRadioButton rdbtnIma;
	private JRadioButton rdbtnNema;
	private JMenu menuStatistika;
	private List<Integer> vestinePom;
	private int idStarog;
	private int idStarogT;
	private JList listVestine;
	private JTable tableKozmeticari;
	private JComboBox comboBoxIDKlijenta;
	private JComboBox comboBoxIDKozmeticara;
	private JComboBox comboBoxIDTretmana;
	private JComboBox comboBoxStanje;
	private JComboBox comboBoxVremeZakazivanja;
	private JComboBox comboBoxBrojUsluga;
	private JLabel lblPrihodi;
	private JLabel lblRashodi;
	private JDateChooser dateChooser;
	private JDateChooser dateChooserOdKozm;
	private JDateChooser dateChooserDoKozm;
	private JDateChooser dateChooserPROd;
	private JDateChooser dateChooserPRDo;
	private JTextField textFieldSpremaKozmeticara;
	private JTextField textFieldImeKozmeticara;
	private JTextField textFieldPrezimeKozmeticara;
	private JTextField textFieldTelefonKozmeticara;
	private JTextField textFieldAdresaKozmeticara;
	private JTextField textFieldStazKozmeticara;
	private JTextField textFieldKoefKozmeticara;
	private JTextField textFieldOsnovaKozmeticara;
	private JTextField textFieldBonusKozmeticara;
	private JTextField textFieldKorImeKozmeticara;
	private JTextField textFieldLozinkaKozmeticara;
	private JTable tableRecepcioneri;
	private JTextField textFieldLozinkaRec;
	private JTextField textFieldImeRec;
	private JTextField textFieldPrezimeRec;
	private JTextField textFieldTelefonRec;
	private JTextField textFieldAdresaRec;
	private JTextField textFieldKorImeRec;
	private JTextField textFieldSpremaRec;
	private JTextField textFieldStazRec;
	private JTextField textFieldKoefRec;
	private JTextField textFieldOsnovaRec;
	private JTextField textFieldBonusRec;
	private JTable tableKlijenti;
	private JTextField textFieldKorImeKl;
	private JTextField textFieldImeKl;
	private JTextField textFieldPrezimeKl;
	private JTextField textFieldTelefonKl;
	private JTextField textFieldLozinkaKl;
	private JTextField textFieldAdresaKl;
	private JTextField textFieldStanjeKl;
	private JTextField textFieldPotrosnjaKl;
	private JTable tableTretmani;
	private JTextField textFieldNazivTretmana;
	private JTextField textFieldCenaTretmana;
	private JTextField textFieldTrajanjeTretmana;
	private JTable tableZakazaniTretmani;
	private JTable tableIzvestajKozmeticara;
	private JTable tableStanjeIzvestaj;
	private JTable tableBrojUsluga;
	private JTable tableKartice;
	private JTextField textFieldUslov;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public MenadzerFrame(Menadzer korisnik) {
		this.korisnik = korisnik;
		setTitle("Menadzer - " + korisnik.getIme() + " " + korisnik.getPrezime());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 645);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
		getContentPane().setLayout(new BorderLayout(0, 0));
		AzurirajStanjaTretmana();
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(3);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panelCards = new JPanel();
		splitPane.setRightComponent(panelCards);
		panelCards.setLayout(new CardLayout(0, 0));
		
		cardLayout = (CardLayout)(panelCards.getLayout());
		
		JPanel panelMenadzeri = new JPanel();
		panelCards.add(panelMenadzeri, "pnlMenadzeri");
		panelMenadzeri.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(this.getBounds().width, (int)(this.getBounds().height / 2.3)));
		panelMenadzeri.add(scrollPane, BorderLayout.NORTH);
		
		tableMenadzeri = new JTable();
		tableMenadzeri.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableMenadzeri.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableMenadzeri.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tableMenadzeri.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ime", "Prezime", "Pol", "Telefon", "Adresa", "Korisnicko ime", "Lozinka", "Strucna sprema", "Staz", "Koeficijent", "Osnova", "Bonus", "Plata"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableMenadzeri.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {

		    public void valueChanged(ListSelectionEvent lse) {
		        if (!lse.getValueIsAdjusting() && tableMenadzeri.getSelectedRow() != -1) {
		            int idMenadzera = (int)tableMenadzeri.getModel().getValueAt(tableMenadzeri.getSelectedRow(), 0);
		            Menadzer izmena = Menadzer.NadjiPoID(idMenadzera, KozmetickiSalon.menadzeri);
		            textFieldImeMenadzera.setText(izmena.getIme());
		            textFieldPrezimeMenadzera.setText(izmena.getPrezime());
		            comboBoxMenadzer.setSelectedItem(izmena.getPol());
		            textFieldTelefonMenadzera.setText(izmena.getTelefon());
		            textFieldAdresaMenadzera.setText(izmena.getAdresa());
		            textFieldKorImeMenadzera.setText(izmena.getKorisnickoIme());
		            textFieldLozinkaMenadzera.setText(izmena.getLozinka());
		            textFieldSpremaMenadzera.setText(Integer.toString(izmena.getNivoStrucneSpreme()));
		            textFieldStazMenadzera.setText(Integer.toString(izmena.getStaz()));
		            textFieldKoefMenadzera.setText(Double.toString(izmena.getKoeficijent()));
		            textFieldOsnovaMenadzera.setText(Double.toString(izmena.getOsnova()));
		            textFieldBonusMenadzera.setText(Double.toString(izmena.getBonus()));
		        }
		    }
		});
		Funkcionalnost.CentrirajTabelu(tableMenadzeri);
		tableMenadzeri.getColumnModel().getColumn(0).setPreferredWidth(35);
		tableMenadzeri.getColumnModel().getColumn(0).setMaxWidth(35);
		scrollPane.setViewportView(tableMenadzeri);
		UcitajMenadzere();
		
		JSplitPane splitPane_1 = new JSplitPane();
		panelMenadzeri.add(splitPane_1, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setLeftComponent(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnNewButtonDodajMenadzera = new JButton("Dodaj");
		btnNewButtonDodajMenadzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textFieldImeMenadzera.getText().equals("") || textFieldPrezimeMenadzera.getText().equals("") || textFieldTelefonMenadzera.getText().equals("") ||
						textFieldAdresaMenadzera.getText().equals("") || textFieldKorImeMenadzera.getText().equals("") || textFieldLozinkaMenadzera.getText().equals("") ||
						textFieldSpremaMenadzera.getText().equals("") || textFieldStazMenadzera.getText().equals("") || textFieldKoefMenadzera.getText().equals("") ||
						textFieldOsnovaMenadzera.getText().equals("") || textFieldBonusMenadzera.getText().equals(""))) 
				{
					try {
						String ime = textFieldImeMenadzera.getText();
						String prezime = textFieldPrezimeMenadzera.getText();
						Pol pol = (Pol)comboBoxMenadzer.getSelectedItem();
						String telefon = textFieldTelefonMenadzera.getText();
						String adresa = textFieldAdresaMenadzera.getText();
						String korisnickoIme = textFieldKorImeMenadzera.getText();
						String lozinka = textFieldLozinkaMenadzera.getText();
						int sprema = Integer.parseInt(textFieldSpremaMenadzera.getText());
						int staz = Integer.parseInt(textFieldStazMenadzera.getText());
						double koeficijent = Double.parseDouble(textFieldKoefMenadzera.getText());
						double osnova = Double.parseDouble(textFieldOsnovaMenadzera.getText());
						double bonus = Double.parseDouble(textFieldBonusMenadzera.getText());
			    		Menadzer novi = new Menadzer(ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, sprema, staz, koeficijent, osnova, bonus);
			    		MenadzerAdmin.DodajMenadzera(novi);
			    		OsveziMenadzere();
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
						JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
						return;
					}
				}
				else{
					JOptionPane.showMessageDialog(getContentPane(), "Sva polja moraju biti popunjena!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		
		btnNewButtonDodajMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnNewButtonDodajMenadzera);
		
		JButton btnIzmeniMenadzera = new JButton("Izmeni");
		btnIzmeniMenadzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableMenadzeri.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
				if(!(textFieldImeMenadzera.getText().equals("") || textFieldPrezimeMenadzera.getText().equals("") || textFieldTelefonMenadzera.getText().equals("") ||
						textFieldAdresaMenadzera.getText().equals("") || textFieldKorImeMenadzera.getText().equals("") || textFieldLozinkaMenadzera.getText().equals("") ||
						textFieldSpremaMenadzera.getText().equals("") || textFieldStazMenadzera.getText().equals("") || textFieldKoefMenadzera.getText().equals("") ||
						textFieldOsnovaMenadzera.getText().equals("") || textFieldBonusMenadzera.getText().equals(""))) 
				{
					try {
						int id = (int)tableMenadzeri.getModel().getValueAt(tableMenadzeri.getSelectedRow(), 0);
						String ime = textFieldImeMenadzera.getText();
						String prezime = textFieldPrezimeMenadzera.getText();
						Pol pol = (Pol)comboBoxMenadzer.getSelectedItem();
						String telefon = textFieldTelefonMenadzera.getText();
						String adresa = textFieldAdresaMenadzera.getText();
						String korisnickoIme = textFieldKorImeMenadzera.getText();
						String lozinka = textFieldLozinkaMenadzera.getText();
						int sprema = Integer.parseInt(textFieldSpremaMenadzera.getText());
						int staz = Integer.parseInt(textFieldStazMenadzera.getText());
						double koeficijent = Double.parseDouble(textFieldKoefMenadzera.getText());
						double osnova = Double.parseDouble(textFieldOsnovaMenadzera.getText());
						double bonus = Double.parseDouble(textFieldBonusMenadzera.getText());
			    		Menadzer izmena = new Menadzer(id, ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, sprema, staz, koeficijent, osnova, bonus);
			    		MenadzerAdmin.IzmeniMenadzera(id, izmena);
			    		OsveziMenadzere();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
						return;
					}
				}
				else{
					JOptionPane.showMessageDialog(getContentPane(), "Sva polja moraju biti popunjena!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnIzmeniMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnIzmeniMenadzera);
		
		JButton btnObrisiMenadzera = new JButton("Obrisi");
		btnObrisiMenadzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableMenadzeri.getSelectedRow() != -1) 
				{
					int id = (int)tableMenadzeri.getModel().getValueAt(tableMenadzeri.getSelectedRow(), 0);
					int result = JOptionPane.showConfirmDialog(getContentPane(),"Da li zaista zelite da obrisete korisnika?", "Brisanje",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) 
					{
						MenadzerAdmin.ObrisiMenadzera(id);
						OsveziMenadzere();
					}
				}else 
				{
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnObrisiMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnObrisiMenadzera);
		
		JPanel panel_2 = new JPanel();
		splitPane_1.setRightComponent(panel_2);
		panel_2.setLayout(new MigLayout("", "[][][grow][][][][][][][grow]", "[][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Ime:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblNewLabel, "cell 1 1,alignx trailing");
		
		textFieldImeMenadzera = new JTextField();
		textFieldImeMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldImeMenadzera.setColumns(10);
		panel_2.add(textFieldImeMenadzera, "cell 2 1,growx");
		
		JLabel lblStrucnaSprema = new JLabel("Strucna sprema:");
		lblStrucnaSprema.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblStrucnaSprema, "cell 8 1,alignx trailing");
		
		textFieldSpremaMenadzera = new JTextField();
		textFieldSpremaMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldSpremaMenadzera.setColumns(10);
		panel_2.add(textFieldSpremaMenadzera, "cell 9 1,growx");
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblPrezime, "cell 1 2,alignx trailing");
		
		textFieldPrezimeMenadzera = new JTextField();
		textFieldPrezimeMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldPrezimeMenadzera.setColumns(10);
		panel_2.add(textFieldPrezimeMenadzera, "cell 2 2,growx");
		
		JLabel lblStaz = new JLabel("Staz:");
		lblStaz.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblStaz, "cell 8 2,alignx trailing");
		
		textFieldStazMenadzera = new JTextField();
		textFieldStazMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldStazMenadzera.setColumns(10);
		panel_2.add(textFieldStazMenadzera, "cell 9 2,growx");
		
		JLabel lblPol = new JLabel("Pol:");
		lblPol.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblPol, "cell 1 3,alignx trailing");
		
		comboBoxMenadzer = new JComboBox();
		comboBoxMenadzer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxMenadzer.setModel(new DefaultComboBoxModel(Pol.values()));
		panel_2.add(comboBoxMenadzer, "cell 2 3,growx");
		
		JLabel lblKoeficijent = new JLabel("Koeficijent:");
		lblKoeficijent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblKoeficijent, "cell 8 3,alignx trailing");
		
		textFieldKoefMenadzera = new JTextField();
		textFieldKoefMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldKoefMenadzera.setColumns(10);
		panel_2.add(textFieldKoefMenadzera, "cell 9 3,growx");
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblTelefon, "cell 1 4,alignx trailing");
		
		textFieldTelefonMenadzera = new JTextField();
		textFieldTelefonMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldTelefonMenadzera.setColumns(10);
		panel_2.add(textFieldTelefonMenadzera, "cell 2 4,growx");
		
		JLabel lblOsnova = new JLabel("Osnova:");
		lblOsnova.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblOsnova, "cell 8 4,alignx trailing");
		
		textFieldOsnovaMenadzera = new JTextField();
		textFieldOsnovaMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldOsnovaMenadzera.setColumns(10);
		panel_2.add(textFieldOsnovaMenadzera, "cell 9 4,growx");
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblAdresa, "cell 1 5,alignx trailing");
		
		textFieldAdresaMenadzera = new JTextField();
		textFieldAdresaMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldAdresaMenadzera.setColumns(10);
		panel_2.add(textFieldAdresaMenadzera, "cell 2 5,growx");
		
		JLabel lblBonus = new JLabel("Bonus:");
		lblBonus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblBonus, "cell 8 5,alignx trailing");
		
		textFieldBonusMenadzera = new JTextField();
		textFieldBonusMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldBonusMenadzera.setColumns(10);
		panel_2.add(textFieldBonusMenadzera, "cell 9 5,growx");
		
		JLabel lblKorisnickoIme = new JLabel("Korisnicko ime:");
		lblKorisnickoIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblKorisnickoIme, "cell 1 6,alignx trailing");
		
		textFieldKorImeMenadzera = new JTextField();
		textFieldKorImeMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldKorImeMenadzera.setColumns(10);
		panel_2.add(textFieldKorImeMenadzera, "cell 2 6,growx");
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblLozinka, "cell 1 7,alignx trailing");
		
		textFieldLozinkaMenadzera = new JTextField();
		textFieldLozinkaMenadzera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldLozinkaMenadzera.setColumns(10);
		panel_2.add(textFieldLozinkaMenadzera, "cell 2 7,growx");
		splitPane_1.setDividerLocation(150);
		
		JPanel panelKozmeticari = new JPanel();
		panelCards.add(panelKozmeticari, "pnlKozmeticari");
		panelKozmeticari.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(this.getBounds().width, (int)(this.getBounds().height / 2.3)));

		panelKozmeticari.add(scrollPane_1, BorderLayout.NORTH);
		
		tableKozmeticari = new JTable();
		tableKozmeticari.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableKozmeticari.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableKozmeticari.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ime", "Prezime", "Pol", "Telefon", "Adresa", "Korisnicko ime", "Lozinka", "Strucna sprema", "Staz", "Koeficijent", "Osnova", "Bonus", "Plata", "Vestine"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableKozmeticari.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableKozmeticari.getColumnModel().getColumn(0).setMaxWidth(30);
		tableKozmeticari.getColumnModel().getColumn(3).setPreferredWidth(40);
		tableKozmeticari.getColumnModel().getColumn(3).setMaxWidth(50);
		tableKozmeticari.getColumnModel().getColumn(8).setMaxWidth(442345);
		Funkcionalnost.CentrirajTabelu(tableKozmeticari);
		scrollPane_1.setViewportView(tableKozmeticari);
		tableKozmeticari.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
			
		    public void valueChanged(ListSelectionEvent lse) {
		        if (!lse.getValueIsAdjusting() && tableKozmeticari.getSelectedRow() != -1) {
		            int idKozmeticara = (int)tableKozmeticari.getModel().getValueAt(tableKozmeticari.getSelectedRow(), 0);
		            Kozmeticar izmena = Kozmeticar.NadjiPoID(idKozmeticara, KozmetickiSalon.kozmeticari);
		            textFieldImeKozmeticara.setText(izmena.getIme());
		            textFieldPrezimeKozmeticara.setText(izmena.getPrezime());
		            comboBoxKozmeticar.setSelectedItem(izmena.getPol());
		            textFieldTelefonKozmeticara.setText(izmena.getTelefon());
		            textFieldAdresaKozmeticara.setText(izmena.getAdresa());
		            textFieldKorImeKozmeticara.setText(izmena.getKorisnickoIme());
		            textFieldLozinkaKozmeticara.setText(izmena.getLozinka());
		            textFieldSpremaKozmeticara.setText(Integer.toString(izmena.getNivoStrucneSpreme()));
		            textFieldStazKozmeticara.setText(Integer.toString(izmena.getStaz()));
		            textFieldKoefKozmeticara.setText(Double.toString(izmena.getKoeficijent()));
		            textFieldOsnovaKozmeticara.setText(Double.toString(izmena.getOsnova()));
		            textFieldBonusKozmeticara.setText(Double.toString(izmena.getBonus()));
		            UcitajOdredjeneVestine(izmena.getObucenZaTretmane());
		        }
		    }
		});
		UcitajKozmeticare();
		
		JSplitPane splitPane_2 = new JSplitPane();
		panelKozmeticari.add(splitPane_2, BorderLayout.CENTER);
		
		JPanel panel_1_1 = new JPanel();
		splitPane_2.setLeftComponent(panel_1_1);
		panel_1_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnDodajKozmeticara = new JButton("Dodaj");
		btnDodajKozmeticara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textFieldKorImeKozmeticara.getText().equals("") || textFieldPrezimeKozmeticara.getText().equals("") || textFieldTelefonKozmeticara.getText().equals("") ||
						textFieldAdresaKozmeticara.getText().equals("") || textFieldKorImeKozmeticara.getText().equals("") || textFieldLozinkaKozmeticara.getText().equals("") ||
						textFieldSpremaKozmeticara.getText().equals("") || textFieldStazKozmeticara.getText().equals("") || textFieldKoefKozmeticara.getText().equals("") ||
						textFieldOsnovaKozmeticara.getText().equals("") || textFieldBonusKozmeticara.getText().equals(""))) 
				{
					try {
						String ime = textFieldImeKozmeticara.getText();
						String prezime = textFieldPrezimeKozmeticara.getText();
						Pol pol = (Pol)comboBoxKozmeticar.getSelectedItem();
						String telefon = textFieldTelefonKozmeticara.getText();
						String adresa = textFieldAdresaKozmeticara.getText();
						String korisnickoIme = textFieldKorImeKozmeticara.getText();
						String lozinka = textFieldLozinkaKozmeticara.getText();
						int sprema = Integer.parseInt(textFieldSpremaKozmeticara.getText());
						int staz = Integer.parseInt(textFieldStazKozmeticara.getText());
						double koeficijent = Double.parseDouble(textFieldKoefKozmeticara.getText());
						double osnova = Double.parseDouble(textFieldOsnovaKozmeticara.getText());
						double bonus = Double.parseDouble(textFieldBonusKozmeticara.getText());
						List<Integer> vestine = new ArrayList<Integer>(vestinePom);
						if(vestine.isEmpty()) 
						{
							JOptionPane.showMessageDialog(getContentPane(), "Niste izabrali vestine kozmeticara!", "Greska", JOptionPane.WARNING_MESSAGE);  
							return;
						}
			    		Kozmeticar novi = new Kozmeticar(ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, sprema, staz, koeficijent, osnova, bonus, vestine);
			    		KozmeticarAdmin.DodajKozmeticara(novi);
			    		OsveziKozmeticare();
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
						JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
						return;
					}
				}
				else{
					JOptionPane.showMessageDialog(getContentPane(), "Sva polja moraju biti popunjena!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnDodajKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1_1.add(btnDodajKozmeticara);
		
		JButton btnIzmeniKozmeticara = new JButton("Izmeni");
		btnIzmeniKozmeticara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableKozmeticari.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
				if(!(textFieldImeKozmeticara.getText().equals("") || textFieldPrezimeKozmeticara.getText().equals("") || textFieldTelefonKozmeticara.getText().equals("") ||
						textFieldAdresaKozmeticara.getText().equals("") || textFieldKorImeKozmeticara.getText().equals("") || textFieldLozinkaKozmeticara.getText().equals("") ||
						textFieldSpremaKozmeticara.getText().equals("") || textFieldStazKozmeticara.getText().equals("") || textFieldKoefKozmeticara.getText().equals("") ||
						textFieldOsnovaKozmeticara.getText().equals("") || textFieldBonusKozmeticara.getText().equals(""))) 
				{
					try {
						int id = (int)tableKozmeticari.getModel().getValueAt(tableKozmeticari.getSelectedRow(), 0);
						String ime = textFieldImeKozmeticara.getText();
						String prezime = textFieldPrezimeKozmeticara.getText();
						Pol pol = (Pol)comboBoxKozmeticar.getSelectedItem();
						String telefon = textFieldTelefonKozmeticara.getText();
						String adresa = textFieldAdresaKozmeticara.getText();
						String korisnickoIme = textFieldKorImeKozmeticara.getText();
						String lozinka = textFieldLozinkaKozmeticara.getText();
						int sprema = Integer.parseInt(textFieldSpremaKozmeticara.getText());
						int staz = Integer.parseInt(textFieldStazKozmeticara.getText());
						double koeficijent = Double.parseDouble(textFieldKoefKozmeticara.getText());
						double osnova = Double.parseDouble(textFieldOsnovaKozmeticara.getText());
						double bonus = Double.parseDouble(textFieldBonusKozmeticara.getText());
						List<Integer> vestine = new ArrayList<Integer>(vestinePom);
			    		Kozmeticar izmena = new Kozmeticar(id, ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, sprema, staz, koeficijent, osnova, bonus, vestine);
			    		KozmeticarAdmin.IzmeniKozmeticara(id, izmena);
			    		OsveziKozmeticare();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
						return;
					}
				}
				else{
					JOptionPane.showMessageDialog(getContentPane(), "Sva polja moraju biti popunjena!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnIzmeniKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1_1.add(btnIzmeniKozmeticara);
		
		JButton btnObrisiKozmeticara = new JButton("Obrisi");
		btnObrisiKozmeticara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableKozmeticari.getSelectedRow() != -1) 
				{
					int id = (int)tableKozmeticari.getModel().getValueAt(tableKozmeticari.getSelectedRow(), 0);
					int result = JOptionPane.showConfirmDialog(getContentPane(),"Da li zaista zelite da obrisete korisnika?", "Brisanje",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) 
					{
						KozmeticarAdmin.ObrisiKozmeticara(id);
						List<Integer> zaBrisanje = new ArrayList<Integer>();
						for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
							if(zakazanTretman.getIdKozmeticara() == id) 
							{
								zaBrisanje.add(zakazanTretman.getId());
							}
						}
						for (Integer integer : zaBrisanje) {
							ZakazanTretmanAdmin.ObrisiZakazanTretman(integer);
						}
						OsveziKozmeticare();
						OsveziZakazaneTretmane();
					}
				}else 
				{
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnObrisiKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1_1.add(btnObrisiKozmeticara);
		
		JPanel panel = new JPanel();
		splitPane_2.setRightComponent(panel);
		panel.setLayout(new MigLayout("", "[][][grow][][][][][][grow][grow]", "[][][][][][][][][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Ime:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1, "cell 1 1,alignx trailing");
		
		textFieldImeKozmeticara = new JTextField();
		textFieldImeKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldImeKozmeticara.setColumns(10);
		panel.add(textFieldImeKozmeticara, "cell 2 1,growx");
		
		JLabel lblNewLabel_1_7 = new JLabel("Strucna sprema:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1_7, "cell 8 1,alignx trailing");
		
		textFieldSpremaKozmeticara = new JTextField();
		textFieldSpremaKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(textFieldSpremaKozmeticara, "cell 9 1,growx");
		textFieldSpremaKozmeticara.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prezime:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1_1, "cell 1 2,alignx trailing");
		
		textFieldPrezimeKozmeticara = new JTextField();
		textFieldPrezimeKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldPrezimeKozmeticara.setColumns(10);
		panel.add(textFieldPrezimeKozmeticara, "cell 2 2,growx");
		
		JLabel lblNewLabel_1_8 = new JLabel("Staz:");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1_8, "cell 8 2,alignx trailing");
		
		textFieldStazKozmeticara = new JTextField();
		textFieldStazKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldStazKozmeticara.setColumns(10);
		panel.add(textFieldStazKozmeticara, "cell 9 2,growx");
		
		JLabel lblNewLabel_1_2 = new JLabel("Pol:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1_2, "cell 1 3,alignx trailing");
		
		comboBoxKozmeticar = new JComboBox();
		comboBoxKozmeticar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxKozmeticar.setModel(new DefaultComboBoxModel(Pol.values()));
		panel.add(comboBoxKozmeticar, "cell 2 3,growx");
		
		JLabel lblNewLabel_1_9 = new JLabel("Koeficijent:");
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1_9, "cell 8 3,alignx trailing");
		
		textFieldKoefKozmeticara = new JTextField();
		textFieldKoefKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldKoefKozmeticara.setColumns(10);
		panel.add(textFieldKoefKozmeticara, "cell 9 3,growx");
		
		JLabel lblNewLabel_1_3 = new JLabel("Telefon:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1_3, "cell 1 4,alignx trailing");
		
		textFieldTelefonKozmeticara = new JTextField();
		textFieldTelefonKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldTelefonKozmeticara.setColumns(10);
		panel.add(textFieldTelefonKozmeticara, "cell 2 4,growx");
		
		JLabel lblNewLabel_1_10 = new JLabel("Osnova:");
		lblNewLabel_1_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1_10, "cell 8 4,alignx trailing");
		
		textFieldOsnovaKozmeticara = new JTextField();
		textFieldOsnovaKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldOsnovaKozmeticara.setColumns(10);
		panel.add(textFieldOsnovaKozmeticara, "cell 9 4,growx");
		
		JLabel lblNewLabel_1_4 = new JLabel("Adresa:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1_4, "cell 1 5,alignx trailing");
		
		textFieldAdresaKozmeticara = new JTextField();
		textFieldAdresaKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldAdresaKozmeticara.setColumns(10);
		panel.add(textFieldAdresaKozmeticara, "cell 2 5,growx");
		
		JLabel lblNewLabel_1_11 = new JLabel("Bonus:");
		lblNewLabel_1_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1_11, "cell 8 5,alignx trailing");
		
		textFieldBonusKozmeticara = new JTextField();
		textFieldBonusKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldBonusKozmeticara.setColumns(10);
		panel.add(textFieldBonusKozmeticara, "cell 9 5,growx");
		
		JLabel lblNewLabel_1_5 = new JLabel("Korisnicko ime:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1_5, "cell 1 6,alignx trailing");
		
		textFieldKorImeKozmeticara = new JTextField();
		textFieldKorImeKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldKorImeKozmeticara.setColumns(10);
		panel.add(textFieldKorImeKozmeticara, "cell 2 6,growx");
		
		comboBoxVestine = new JComboBox();
		comboBoxVestine.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(comboBoxVestine, "cell 8 6,growx");
		vestinePom = new ArrayList<Integer>();
		UcitajSveVestine();
		splitPane_2.setDividerLocation(150);
		
		JButton btnDodajVestinu = new JButton("Dodaj vestinu");
		btnDodajVestinu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComboItem selektovanItem = (ComboItem)comboBoxVestine.getSelectedItem();
				for (int i = 0; i < vestinePom.size(); i++) {
					if(selektovanItem.getKey() == vestinePom.get(i)) return;
				}
				vestinePom.add(selektovanItem.getKey());
				List<Integer> copy = new ArrayList<>(vestinePom);
				UcitajOdredjeneVestine(copy);
			}
		});
		btnDodajVestinu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnDodajVestinu, "cell 9 6");
		
		JLabel lblNewLabel_1_6 = new JLabel("Lozinka:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1_6, "cell 1 7,alignx trailing");
		
		textFieldLozinkaKozmeticara = new JTextField();
		textFieldLozinkaKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldLozinkaKozmeticara.setColumns(10);
		panel.add(textFieldLozinkaKozmeticara, "cell 2 7,growx");
		
		listVestine = new JList();
		listVestine.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(listVestine, "cell 8 7 1 2,grow");
		
		JButton btnObrisiVestinu = new JButton("Obrisi vestinu");
		btnObrisiVestinu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int index = listVestine.getSelectedIndex();
					vestinePom.remove(index);
					List<Integer> copy = new ArrayList<Integer>(vestinePom);
					UcitajOdredjeneVestine(copy);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red u listi vestina!", "Greska", JOptionPane.WARNING_MESSAGE);  
				}
			}
		});
		btnObrisiVestinu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnObrisiVestinu, "cell 9 7");
		
		
		JPanel panelRecepcioneri = new JPanel();
		panelCards.add(panelRecepcioneri, "pnlRecepcioneri");
		panelRecepcioneri.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setPreferredSize(new Dimension(this.getBounds().width, (int)(this.getBounds().height / 2.3)));
		panelRecepcioneri.add(scrollPane_2, BorderLayout.NORTH);
		
		tableRecepcioneri = new JTable();
		tableRecepcioneri.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableRecepcioneri.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableRecepcioneri.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ime", "Prezime", "Pol", "Telefon", "Adresa", "Korisnicko ime", "Lozinka", "Strucna sprema", "Staz", "Koeficijent", "Osnova", "Bonus", "Plata"
			}
		));
		tableRecepcioneri.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableRecepcioneri.getColumnModel().getColumn(0).setMaxWidth(30);
		tableRecepcioneri.getColumnModel().getColumn(9).setMaxWidth(3333);
		scrollPane_2.setViewportView(tableRecepcioneri);
		Funkcionalnost.CentrirajTabelu(tableRecepcioneri);
		tableRecepcioneri.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
			
		    public void valueChanged(ListSelectionEvent lse) {
		        if (!lse.getValueIsAdjusting() && tableRecepcioneri.getSelectedRow() != -1) {
		            int idRecepcionera = (int)tableRecepcioneri.getModel().getValueAt(tableRecepcioneri.getSelectedRow(), 0);
		            Recepcioner izmena = Recepcioner.NadjiPoID(idRecepcionera, KozmetickiSalon.recepcioneri);
		            textFieldImeRec.setText(izmena.getIme());
		            textFieldPrezimeRec.setText(izmena.getPrezime());
		            comboBoxRec.setSelectedItem(izmena.getPol());
		            textFieldTelefonRec.setText(izmena.getTelefon());
		            textFieldAdresaRec.setText(izmena.getAdresa());
		            textFieldKorImeRec.setText(izmena.getKorisnickoIme());
		            textFieldLozinkaRec.setText(izmena.getLozinka());
		            textFieldSpremaRec.setText(Integer.toString(izmena.getNivoStrucneSpreme()));
		            textFieldStazRec.setText(Integer.toString(izmena.getStaz()));
		            textFieldKoefRec.setText(Double.toString(izmena.getKoeficijent()));
		            textFieldOsnovaRec.setText(Double.toString(izmena.getOsnova()));
		            textFieldBonusRec.setText(Double.toString(izmena.getBonus()));
		        }
		    }
		});
		UcitajRecepcionere();
		
		JSplitPane splitPane_3 = new JSplitPane();
		panelRecepcioneri.add(splitPane_3, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		splitPane_3.setLeftComponent(panel_3);
		panel_3.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnDodajRecepcionera = new JButton("Dodaj");
		btnDodajRecepcionera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textFieldImeRec.getText().equals("") || textFieldPrezimeRec.getText().equals("") || textFieldTelefonRec.getText().equals("") ||
						textFieldAdresaRec.getText().equals("") || textFieldKorImeRec.getText().equals("") || textFieldLozinkaRec.getText().equals("") ||
						textFieldSpremaRec.getText().equals("") || textFieldStazRec.getText().equals("") || textFieldKoefRec.getText().equals("") ||
						textFieldOsnovaRec.getText().equals("") || textFieldBonusRec.getText().equals(""))) 
				{
					try {
						String ime = textFieldImeRec.getText();
						String prezime = textFieldPrezimeRec.getText();
						Pol pol = (Pol)comboBoxRec.getSelectedItem();
						String telefon = textFieldTelefonRec.getText();
						String adresa = textFieldAdresaRec.getText();
						String korisnickoIme = textFieldKorImeRec.getText();
						String lozinka = textFieldLozinkaRec.getText();
						int sprema = Integer.parseInt(textFieldSpremaRec.getText());
						int staz = Integer.parseInt(textFieldStazRec.getText());
						double koeficijent = Double.parseDouble(textFieldKoefRec.getText());
						double osnova = Double.parseDouble(textFieldOsnovaRec.getText());
						double bonus = Double.parseDouble(textFieldBonusRec.getText());
			    		Recepcioner novi = new Recepcioner(ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, sprema, staz, koeficijent, osnova, bonus);
			    		RecepcionerAdmin.DodajRecepcionera(novi);
			    		OsveziRecepcionere();
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
						JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
						return;
					}
				}
				else{
					JOptionPane.showMessageDialog(getContentPane(), "Sva polja moraju biti popunjena!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnDodajRecepcionera.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(btnDodajRecepcionera);
		
		JButton btnIzmeniRecepcionera = new JButton("Izmeni");
		btnIzmeniRecepcionera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableRecepcioneri.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
				if(!(textFieldImeRec.getText().equals("") || textFieldPrezimeRec.getText().equals("") || textFieldTelefonRec.getText().equals("") ||
						textFieldAdresaRec.getText().equals("") || textFieldKorImeRec.getText().equals("") || textFieldLozinkaRec.getText().equals("") ||
						textFieldSpremaRec.getText().equals("") || textFieldStazRec.getText().equals("") || textFieldKoefRec.getText().equals("") ||
						textFieldOsnovaRec.getText().equals("") || textFieldBonusRec.getText().equals(""))) 
				{
					try {
						int id = (int)tableRecepcioneri.getModel().getValueAt(tableRecepcioneri.getSelectedRow(), 0);
						String ime = textFieldImeRec.getText();
						String prezime = textFieldPrezimeRec.getText();
						Pol pol = (Pol)comboBoxRec.getSelectedItem();
						String telefon = textFieldTelefonRec.getText();
						String adresa = textFieldAdresaRec.getText();
						String korisnickoIme = textFieldKorImeRec.getText();
						String lozinka = textFieldLozinkaRec.getText();
						int sprema = Integer.parseInt(textFieldSpremaRec.getText());
						int staz = Integer.parseInt(textFieldStazRec.getText());
						double koeficijent = Double.parseDouble(textFieldKoefRec.getText());
						double osnova = Double.parseDouble(textFieldOsnovaRec.getText());
						double bonus = Double.parseDouble(textFieldBonusRec.getText());
			    		Recepcioner izmena = new Recepcioner(id, ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, sprema, staz, koeficijent, osnova, bonus);
			    		RecepcionerAdmin.IzmeniRecepcionera(id, izmena);
			    		OsveziRecepcionere();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
						return;
					}
				}
				else{
					JOptionPane.showMessageDialog(getContentPane(), "Sva polja moraju biti popunjena!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnIzmeniRecepcionera.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(btnIzmeniRecepcionera);
		
		JButton btnObrisiRecepcionera = new JButton("Obrisi");
		btnObrisiRecepcionera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableRecepcioneri.getSelectedRow() != -1) 
				{
					int id = (int)tableRecepcioneri.getModel().getValueAt(tableRecepcioneri.getSelectedRow(), 0);
					int result = JOptionPane.showConfirmDialog(getContentPane(),"Da li zaista zelite da obrisete korisnika?", "Brisanje",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) 
					{
						RecepcionerAdmin.ObrisiRecepcionera(id);
						OsveziRecepcionere();
					}
				}else 
				{
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnObrisiRecepcionera.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(btnObrisiRecepcionera);
		
		JPanel panel_4 = new JPanel();
		splitPane_3.setRightComponent(panel_4);
		panel_4.setLayout(new MigLayout("", "[][][grow][][][][][][][grow]", "[][][][][][][]"));
		
		JLabel lblNewLabel_2 = new JLabel("Ime:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_2, "cell 1 1,alignx trailing");
		
		textFieldImeRec = new JTextField();
		textFieldImeRec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldImeRec.setColumns(10);
		panel_4.add(textFieldImeRec, "cell 2 1,growx");
		
		JLabel lblNewLabel_2_6 = new JLabel("Lozinka:");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_2_6, "cell 8 1,alignx trailing");
		
		textFieldLozinkaRec = new JTextField();
		textFieldLozinkaRec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(textFieldLozinkaRec, "cell 9 1,growx");
		textFieldLozinkaRec.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Prezime:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_2_1, "cell 1 2,alignx trailing");
		
		textFieldPrezimeRec = new JTextField();
		textFieldPrezimeRec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldPrezimeRec.setColumns(10);
		panel_4.add(textFieldPrezimeRec, "cell 2 2,growx");
		
		JLabel lblNewLabel_2_7 = new JLabel("Strucna sprema:");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_2_7, "cell 8 2,alignx trailing");
		
		textFieldSpremaRec = new JTextField();
		textFieldSpremaRec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldSpremaRec.setColumns(10);
		panel_4.add(textFieldSpremaRec, "cell 9 2,growx");
		
		JLabel lblNewLabel_2_2 = new JLabel("Pol:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_2_2, "cell 1 3,alignx trailing");
		
		comboBoxRec = new JComboBox();
		comboBoxRec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxRec.setModel(new DefaultComboBoxModel(Pol.values()));
		panel_4.add(comboBoxRec, "cell 2 3,growx");
		
		JLabel lblNewLabel_2_8 = new JLabel("Staz:");
		lblNewLabel_2_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_2_8, "cell 8 3,alignx trailing");
		
		textFieldStazRec = new JTextField();
		textFieldStazRec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldStazRec.setColumns(10);
		panel_4.add(textFieldStazRec, "cell 9 3,growx");
		
		JLabel lblNewLabel_2_3 = new JLabel("Telefon:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_2_3, "cell 1 4,alignx trailing");
		
		textFieldTelefonRec = new JTextField();
		textFieldTelefonRec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldTelefonRec.setColumns(10);
		panel_4.add(textFieldTelefonRec, "cell 2 4,growx");
		
		JLabel lblNewLabel_2_9 = new JLabel("Koeficijent:");
		lblNewLabel_2_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_2_9, "cell 8 4,alignx trailing");
		
		textFieldKoefRec = new JTextField();
		textFieldKoefRec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldKoefRec.setColumns(10);
		panel_4.add(textFieldKoefRec, "cell 9 4,growx");
		
		JLabel lblNewLabel_2_4 = new JLabel("Adresa:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_2_4, "cell 1 5,alignx trailing");
		
		textFieldAdresaRec = new JTextField();
		textFieldAdresaRec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldAdresaRec.setColumns(10);
		panel_4.add(textFieldAdresaRec, "cell 2 5,growx");
		
		JLabel lblNewLabel_2_10 = new JLabel("Osnova:");
		lblNewLabel_2_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_2_10, "cell 8 5,alignx trailing");
		
		textFieldOsnovaRec = new JTextField();
		textFieldOsnovaRec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldOsnovaRec.setColumns(10);
		panel_4.add(textFieldOsnovaRec, "cell 9 5,growx");
		
		JLabel lblNewLabel_2_5 = new JLabel("Korisnicko ime:");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_2_5, "cell 1 6,alignx trailing");
		
		textFieldKorImeRec = new JTextField();
		textFieldKorImeRec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldKorImeRec.setColumns(10);
		panel_4.add(textFieldKorImeRec, "cell 2 6,growx");
		
		JLabel lblNewLabel_2_11 = new JLabel("Bonus:");
		lblNewLabel_2_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_2_11, "cell 8 6,alignx trailing");
		
		textFieldBonusRec = new JTextField();
		textFieldBonusRec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldBonusRec.setColumns(10);
		panel_4.add(textFieldBonusRec, "cell 9 6,growx");
		splitPane_3.setDividerLocation(150);
		
		JPanel panelKlijenti = new JPanel();
		panelCards.add(panelKlijenti, "pnlKlijenti");
		panelKlijenti.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setPreferredSize(new Dimension(this.getBounds().width, (int)(this.getBounds().height / 2.3)));
		panelKlijenti.add(scrollPane_3, BorderLayout.NORTH);
		
		tableKlijenti = new JTable();
		tableKlijenti.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableKlijenti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableKlijenti.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ime", "Prezime", "Pol", "Telefon", "Adresa", "Korisnicko ime", "Lozinka", "Stanje", "Potrosnja", "Kartica lojalnosti"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableKlijenti.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableKlijenti.getColumnModel().getColumn(0).setMaxWidth(30);
		Funkcionalnost.CentrirajTabelu(tableKlijenti);
		scrollPane_3.setViewportView(tableKlijenti);
		UcitajKlijente();
		tableKlijenti.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {

		    public void valueChanged(ListSelectionEvent lse) {
		        if (!lse.getValueIsAdjusting() && tableKlijenti.getSelectedRow() != -1) {
		            int idKlijenta = (int)tableKlijenti.getModel().getValueAt(tableKlijenti.getSelectedRow(), 0);
		            Klijent izmena = Klijent.NadjiPoID(idKlijenta, KozmetickiSalon.klijenti);
		            textFieldImeKl.setText(izmena.getIme());
		            textFieldPrezimeKl.setText(izmena.getPrezime());
		            comboBoxKlijent.setSelectedItem(izmena.getPol());
		            textFieldTelefonKl.setText(izmena.getTelefon());
		            textFieldAdresaKl.setText(izmena.getAdresa());
		            textFieldKorImeKl.setText(izmena.getKorisnickoIme());
		            textFieldLozinkaKl.setText(izmena.getLozinka());
		            textFieldStanjeKl.setText(Double.toString(izmena.getStanje()));
		            textFieldPotrosnjaKl.setText(Double.toString(izmena.getPotrosnja()));
		            if(izmena.getPravoNaKarticuLojalnosti()) 
		            {
		            	rdbtnIma.setSelected(true);
		            }
		            else 
		            {
		            	rdbtnNema.setSelected(true);
		            }
		        }
		    }
		});
		
		
		JSplitPane splitPane_4 = new JSplitPane();
		panelKlijenti.add(splitPane_4, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		splitPane_4.setLeftComponent(panel_5);
		panel_5.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnDodajKlijenta = new JButton("Dodaj");
		btnDodajKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textFieldImeKl.getText().equals("") || textFieldPrezimeKl.getText().equals("") || textFieldTelefonKl.getText().equals("") ||
						textFieldAdresaKl.getText().equals("") || textFieldKorImeKl.getText().equals("") || textFieldLozinkaKl.getText().equals("") ||
						textFieldStanjeKl.getText().equals("") || textFieldPotrosnjaKl.getText().equals(""))) 
				{
					try {
						String ime = textFieldImeKl.getText();
						String prezime = textFieldPrezimeKl.getText();
						Pol pol = (Pol)comboBoxKlijent.getSelectedItem();
						String telefon = textFieldTelefonKl.getText();
						String adresa = textFieldAdresaKl.getText();
						String korisnickoIme = textFieldKorImeKl.getText();
						String lozinka = textFieldLozinkaKl.getText();
						double stanje = Double.parseDouble(textFieldStanjeKl.getText());
						double potrosnja = Double.parseDouble(textFieldPotrosnjaKl.getText());
						Boolean pravo = true;
						if(rdbtnNema.isSelected()) 
						{
							pravo = false;
						}
						Klijent novi = new Klijent(ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, stanje, potrosnja, pravo);
			    		KlijentAdmin.DodajKlijenta(novi);
			    		OsveziKlijente();
			    		AzurirajKarticeLojalnosti();
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
						JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
						return;
					}
				}
				else{
					JOptionPane.showMessageDialog(getContentPane(), "Sva polja moraju biti popunjena!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnDodajKlijenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(btnDodajKlijenta);
		
		JButton btnIzmeniKlijenta = new JButton("Izmeni");
		btnIzmeniKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableKlijenti.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
				if(!(textFieldImeKl.getText().equals("") || textFieldPrezimeKl.getText().equals("") || textFieldTelefonKl.getText().equals("") ||
						textFieldAdresaKl.getText().equals("") || textFieldKorImeKl.getText().equals("") || textFieldLozinkaKl.getText().equals("") ||
						textFieldStanjeKl.getText().equals("") || textFieldPotrosnjaKl.getText().equals(""))) 
				{
					try {
						int id = (int)tableKlijenti.getModel().getValueAt(tableKlijenti.getSelectedRow(), 0);
						String ime = textFieldImeKl.getText();
						String prezime = textFieldPrezimeKl.getText();
						Pol pol = (Pol)comboBoxKlijent.getSelectedItem();
						String telefon = textFieldTelefonKl.getText();
						String adresa = textFieldAdresaKl.getText();
						String korisnickoIme = textFieldKorImeKl.getText();
						String lozinka = textFieldLozinkaKl.getText();
						double stanje = Double.parseDouble(textFieldStanjeKl.getText());
						double potrosnja = Double.parseDouble(textFieldPotrosnjaKl.getText());
						Boolean pravo = true;
						if(rdbtnNema.isSelected()) 
						{
							pravo = false;
						}
						Klijent izmena = new Klijent(id, ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, stanje, potrosnja, pravo);
						KlijentAdmin.IzmeniKlijenta(id, izmena);
			    		OsveziKlijente();
			    		AzurirajKarticeLojalnosti();
			    							} catch (Exception e2) {
						JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
						return;
					}
				}
				else{
					JOptionPane.showMessageDialog(getContentPane(), "Sva polja moraju biti popunjena!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnIzmeniKlijenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(btnIzmeniKlijenta);
		
		JButton btnObrisiKlijenta = new JButton("Obrisi");
		btnObrisiKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableKlijenti.getSelectedRow() != -1) 
				{
					int id = (int)tableKlijenti.getModel().getValueAt(tableKlijenti.getSelectedRow(), 0);
					int result = JOptionPane.showConfirmDialog(getContentPane(),"Da li zaista zelite da obrisete korisnika?", "Brisanje",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) 
					{
						KlijentAdmin.ObrisiKlijenta(id);
						List<Integer> zaBrisanje = new ArrayList<Integer>();
						for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
							if(zakazanTretman.getIdKlijenta() == id) 
							{
								zaBrisanje.add(zakazanTretman.getId());
							}
						}
						for (Integer integer : zaBrisanje) {
							ZakazanTretmanAdmin.ObrisiZakazanTretman(integer);
						}
						OsveziKlijente();
						OsveziZakazaneTretmane();
					}
				}else 
				{
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnObrisiKlijenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(btnObrisiKlijenta);
		
		JPanel panel_6 = new JPanel();
		splitPane_4.setRightComponent(panel_6);
		panel_6.setLayout(new MigLayout("", "[][][grow][][][][][][][grow]", "[][][][][][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("Ime:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(lblNewLabel_3, "cell 1 1,alignx trailing");
		
		textFieldImeKl = new JTextField();
		textFieldImeKl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldImeKl.setColumns(10);
		panel_6.add(textFieldImeKl, "cell 2 1,growx");
		
		JLabel lblNewLabel_3_5 = new JLabel("Korisnicko ime:");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(lblNewLabel_3_5, "cell 8 1,alignx trailing");
		
		textFieldKorImeKl = new JTextField();
		textFieldKorImeKl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(textFieldKorImeKl, "cell 9 1,growx");
		textFieldKorImeKl.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Prezime:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(lblNewLabel_3_1, "cell 1 2,alignx trailing");
		
		textFieldPrezimeKl = new JTextField();
		textFieldPrezimeKl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldPrezimeKl.setColumns(10);
		panel_6.add(textFieldPrezimeKl, "cell 2 2,growx");
		
		JLabel lblNewLabel_3_6 = new JLabel("Lozinka:");
		lblNewLabel_3_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(lblNewLabel_3_6, "cell 8 2,alignx trailing");
		
		textFieldLozinkaKl = new JTextField();
		textFieldLozinkaKl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldLozinkaKl.setColumns(10);
		panel_6.add(textFieldLozinkaKl, "cell 9 2,growx");
		
		JLabel lblNewLabel_3_2 = new JLabel("Pol:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(lblNewLabel_3_2, "cell 1 3,alignx trailing");
		
		comboBoxKlijent = new JComboBox();
		comboBoxKlijent.setModel(new DefaultComboBoxModel(Pol.values()));
		comboBoxKlijent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(comboBoxKlijent, "cell 2 3,growx");
		
		JLabel lblNewLabel_3_7 = new JLabel("Stanje:");
		lblNewLabel_3_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(lblNewLabel_3_7, "cell 8 3,alignx trailing");
		
		textFieldStanjeKl = new JTextField();
		textFieldStanjeKl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldStanjeKl.setColumns(10);
		panel_6.add(textFieldStanjeKl, "cell 9 3,growx");
		
		JLabel lblNewLabel_3_3 = new JLabel("Telefon:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(lblNewLabel_3_3, "cell 1 4,alignx trailing");
		
		textFieldTelefonKl = new JTextField();
		textFieldTelefonKl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldTelefonKl.setColumns(10);
		panel_6.add(textFieldTelefonKl, "cell 2 4,growx");
		
		JLabel lblNewLabel_3_8 = new JLabel("Potrosnja:");
		lblNewLabel_3_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(lblNewLabel_3_8, "cell 8 4,alignx trailing");
		
		textFieldPotrosnjaKl = new JTextField();
		textFieldPotrosnjaKl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldPotrosnjaKl.setColumns(10);
		panel_6.add(textFieldPotrosnjaKl, "cell 9 4,growx");
		
		JLabel lblNewLabel_3_4 = new JLabel("Adresa:");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(lblNewLabel_3_4, "cell 1 5,alignx trailing");
		
		textFieldAdresaKl = new JTextField();
		textFieldAdresaKl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldAdresaKl.setColumns(10);
		panel_6.add(textFieldAdresaKl, "cell 2 5,growx");
		
		JLabel lblNewLabel_3_8_1 = new JLabel("Kartica lojalnosti:");
		lblNewLabel_3_8_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(lblNewLabel_3_8_1, "cell 8 5");
		
		rdbtnIma = new JRadioButton("Ima");
		rdbtnIma.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(rdbtnIma, "cell 9 5");
		
		rdbtnNema = new JRadioButton("Nema");
		rdbtnNema.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(rdbtnNema, "cell 9 6");
		rdbtnNema.setSelected(true);
		splitPane_4.setDividerLocation(150);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnIma);
		group.add(rdbtnNema);
		
		JPanel panelTretmani = new JPanel();
		panelCards.add(panelTretmani, "pnlTretmani");
		panelTretmani.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setPreferredSize(new Dimension(this.getBounds().width, (int)(this.getBounds().height / 1.75)));
		panelTretmani.add(scrollPane_4, BorderLayout.NORTH);
		
		tableTretmani = new JTable();
		tableTretmani.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableTretmani.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTretmani.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Naziv", "Trajanje (min)", "Cena"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Funkcionalnost.CentrirajTabelu(tableTretmani);
		scrollPane_4.setViewportView(tableTretmani);
		UcitajTretmane();
		tableTretmani.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {

		    public void valueChanged(ListSelectionEvent lse) {
		        if (!lse.getValueIsAdjusting() && tableTretmani.getSelectedRow() != -1) {
		            int idTretmana = (int)tableTretmani.getModel().getValueAt(tableTretmani.getSelectedRow(), 0);
		            Tretman izmena = Tretman.NadjiPoID(idTretmana, KozmetickiSalon.tretmani);
		            textFieldNazivTretmana.setText(izmena.getNaziv());
		            textFieldTrajanjeTretmana.setText(Integer.toString(izmena.getTrajanje()));
		            textFieldCenaTretmana.setText(Double.toString(izmena.getCena()));
		        }
		    }
		});
		
		JSplitPane splitPane_5 = new JSplitPane();
		panelTretmani.add(splitPane_5, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		splitPane_5.setLeftComponent(panel_7);
		panel_7.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnDodajTretman = new JButton("Dodaj");
		btnDodajTretman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textFieldNazivTretmana.getText().equals("") || textFieldTrajanjeTretmana.getText().equals("") || textFieldCenaTretmana.getText().equals(""))) 
				{
					try {
						String naziv = textFieldNazivTretmana.getText();
						int trajanje = Integer.parseInt(textFieldTrajanjeTretmana.getText());
						double cena = Double.parseDouble(textFieldCenaTretmana.getText());
						Tretman novi = new Tretman(naziv, trajanje, cena);
			    		TretmanAdmin.DodajTretman(novi);
			    		OsveziTretmane();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
						return;
					}
				}
				else{
					JOptionPane.showMessageDialog(getContentPane(), "Sva polja moraju biti popunjena!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnDodajTretman.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_7.add(btnDodajTretman);
		
		JButton btnIzmeniTretman = new JButton("Izmeni");
		btnIzmeniTretman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableTretmani.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
				if(!(textFieldNazivTretmana.getText().equals("") || textFieldTrajanjeTretmana.getText().equals("") || textFieldCenaTretmana.getText().equals(""))) 
				{
					try {
						int id = (int)tableTretmani.getModel().getValueAt(tableTretmani.getSelectedRow(), 0);
						String naziv = textFieldNazivTretmana.getText();
						int trajanje = Integer.parseInt(textFieldTrajanjeTretmana.getText());
						double cena = Double.parseDouble(textFieldCenaTretmana.getText());
						Boolean pravo = true;
						Tretman izmena = new Tretman(id, naziv, trajanje, cena);
						TretmanAdmin.IzmeniTretman(id, izmena);
			    		OsveziTretmane();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
						return;
					}
				}
				else{
					JOptionPane.showMessageDialog(getContentPane(), "Sva polja moraju biti popunjena!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnIzmeniTretman.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_7.add(btnIzmeniTretman);
		
		JButton btnObrisiTretman = new JButton("Obrisi");
		btnObrisiTretman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableTretmani.getSelectedRow() != -1) 
				{
					int id = (int)tableTretmani.getModel().getValueAt(tableTretmani.getSelectedRow(), 0);
					int result = JOptionPane.showConfirmDialog(getContentPane(),"Da li zaista zelite da obrisete tretman?", "Brisanje",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) 
					{
						TretmanAdmin.ObrisiTretman(id);
						for (Kozmeticar kozmeticar : KozmetickiSalon.kozmeticari) {
							if(kozmeticar.getObucenZaTretmane().contains(id)) 
							{
								List<Integer> lista = kozmeticar.getObucenZaTretmane();
								lista.remove(lista.indexOf(id));
								kozmeticar.setObucenZaTretmane(lista);
								KozmeticarAdmin.IzmeniKozmeticara(kozmeticar.getId(), kozmeticar);
							}
						}
						List<Integer> zaBrisanje = new ArrayList<Integer>();
						for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
							if(zakazanTretman.getidTretmana() == id)
							{
								zaBrisanje.add(zakazanTretman.getId());
							}
						}
						for (Integer integer : zaBrisanje) {
							ZakazanTretmanAdmin.ObrisiZakazanTretman(integer);
						}
						OsveziTretmane();
					}
				}else 
				{
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnObrisiTretman.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_7.add(btnObrisiTretman);
		
		JPanel panel_8 = new JPanel();
		splitPane_5.setRightComponent(panel_8);
		panel_8.setLayout(new MigLayout("", "[][][grow]", "[][][][][][][]"));
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_8.add(lblNaziv, "flowx,cell 2 2,alignx center,aligny center");
		
		textFieldNazivTretmana = new JTextField();
		textFieldNazivTretmana.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_8.add(textFieldNazivTretmana, "cell 2 2,alignx center");
		textFieldNazivTretmana.setColumns(10);
		
		JLabel lblTrajanje = new JLabel("Trajanje:");
		lblTrajanje.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_8.add(lblTrajanje, "flowx,cell 2 4,alignx center,aligny center");
		
		textFieldTrajanjeTretmana = new JTextField();
		textFieldTrajanjeTretmana.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldTrajanjeTretmana.setColumns(10);
		panel_8.add(textFieldTrajanjeTretmana, "cell 2 4,alignx center");
		
		JLabel label_1_1 = new JLabel("Cena:");
		label_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_8.add(label_1_1, "flowx,cell 2 6,alignx center,aligny center");
		
		textFieldCenaTretmana = new JTextField();
		textFieldCenaTretmana.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCenaTretmana.setColumns(10);
		panel_8.add(textFieldCenaTretmana, "cell 2 6,alignx center,aligny center");
		splitPane_5.setDividerLocation(150);
		
		JPanel panelZakazaniTretmani = new JPanel();
		panelCards.add(panelZakazaniTretmani, "pnlZakazaniTretmani");
		panelZakazaniTretmani.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setPreferredSize(new Dimension(this.getBounds().width, (int)(this.getBounds().height / 2.3)));
		panelZakazaniTretmani.add(scrollPane_5, BorderLayout.NORTH);
		
		tableZakazaniTretmani = new JTable();
		tableZakazaniTretmani.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableZakazaniTretmani.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Klijent", "Kozmeticar", "Tretman", "Vreme", "Stanje"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableZakazaniTretmani.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane_5.setViewportView(tableZakazaniTretmani);
		UcitajZakazaneTretmane();
		Funkcionalnost.CentrirajTabelu(tableZakazaniTretmani);
		tableZakazaniTretmani.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {

		    public void valueChanged(ListSelectionEvent lse) {
		        if (!lse.getValueIsAdjusting() && tableZakazaniTretmani.getSelectedRow() != -1) {
		            int idZakazanogTretmana = (int)tableZakazaniTretmani.getModel().getValueAt(tableZakazaniTretmani.getSelectedRow(), 0);
		            ZakazanTretman izmena = ZakazanTretman.NadjiPoID(idZakazanogTretmana, KozmetickiSalon.zakazaniTretmani);
		            Klijent klijent = Klijent.NadjiPoID(izmena.getIdKlijenta(), KozmetickiSalon.klijenti);
		            comboBoxIDKlijenta.getModel().setSelectedItem(new ComboItem(klijent.getId(), klijent.getIme() + " " + klijent.getPrezime()));
		            Kozmeticar kozmeticar = Kozmeticar.NadjiPoID(izmena.getIdKozmeticara(), KozmetickiSalon.kozmeticari);
		            comboBoxIDKozmeticara.getModel().setSelectedItem (new ComboItem(kozmeticar.getId(), kozmeticar.getIme() + " " + kozmeticar.getPrezime()));
		            PopuniComboBoxTretmane();
		            dateChooser.setDate(izmena.getVreme());
		            Tretman tretman = Tretman.NadjiPoID(izmena.getidTretmana(), KozmetickiSalon.tretmani);
					comboBoxIDTretmana.getModel().setSelectedItem(new ComboItem(tretman.getId(), tretman.getNaziv()));
					UcitajSlobodneTermine();
					comboBoxVremeZakazivanja.getModel().setSelectedItem(new ComboItem(1, izmena.getVreme().getHours() + ":00"));
					comboBoxStanje.getModel().setSelectedItem((Stanje)izmena.getStanje());
					
					idStarog = izmena.getIdKlijenta();
					idStarogT = izmena.getidTretmana();
		        }
		    }
		});
		
		JSplitPane splitPane_6 = new JSplitPane();
		panelZakazaniTretmani.add(splitPane_6, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		splitPane_6.setLeftComponent(panel_9);
		panel_9.setLayout(new GridLayout(3, 1, 0, 0));
		
		
		JPanel panel_10 = new JPanel();
		splitPane_6.setRightComponent(panel_10);
		panel_10.setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][][][][grow][][]"));
		
		JLabel lblNewLabel_4 = new JLabel("Klijent:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_10.add(lblNewLabel_4, "flowx,cell 5 1,alignx center");
		
		comboBoxIDKlijenta = new JComboBox();
		comboBoxIDKlijenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		PopuniComboBoxKlijente();
		
		panel_10.add(comboBoxIDKlijenta, "cell 5 1,alignx center");
		
		JLabel lblNewLabel_4_1 = new JLabel("Kozmeticar:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_10.add(lblNewLabel_4_1, "flowx,cell 5 3,alignx center");
		
		comboBoxIDKozmeticara = new JComboBox();
		PopuniComboBoxKozmeticare();
		comboBoxIDKozmeticara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopuniComboBoxTretmane();
				UcitajSlobodneTermine();
			}
		});
		comboBoxIDKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_10.add(comboBoxIDKozmeticara, "cell 5 3,alignx center");
		
		JLabel lblNewLabel_4_2 = new JLabel("Tretman:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_10.add(lblNewLabel_4_2, "flowx,cell 5 5,alignx center");
		
		comboBoxIDTretmana = new JComboBox();
		PopuniComboBoxTretmane();
		comboBoxIDTretmana.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_10.add(comboBoxIDTretmana, "cell 5 5,alignx center");
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Datum:");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_10.add(lblNewLabel_4_2_1, "flowx,cell 5 7,alignx center");
		
		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateChooser.setPreferredSize(new Dimension(200, 20));
		LocalDate localDate = LocalDate.now();
		panel_10.add(dateChooser, "cell 5 7,alignx center,aligny center");
		dateChooser.setDate(new Date(localDate.getYear() - 1900, localDate.getMonthValue() - 1, localDate.getDayOfMonth()));
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				UcitajSlobodneTermine();
			}
		});
		
		JLabel lblNewLabel_4_4 = new JLabel("Stanje:");
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_10.add(lblNewLabel_4_4, "flowx,cell 5 9,alignx center");
		
		comboBoxStanje = new JComboBox();
		comboBoxStanje.setEnabled(false);
		comboBoxStanje.setModel(new DefaultComboBoxModel(Stanje.values()));
		comboBoxStanje.removeItem((Stanje)Stanje.OTKAZAO_SALON);
		comboBoxStanje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_10.add(comboBoxStanje, "cell 5 9,alignx center");
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("Vreme:");
		lblNewLabel_4_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_10.add(lblNewLabel_4_2_1_1, "cell 5 7");
		
		comboBoxVremeZakazivanja = new JComboBox();
		comboBoxVremeZakazivanja.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_10.add(comboBoxVremeZakazivanja, "cell 5 7");
		splitPane_6.setDividerLocation(150);
		
		JButton btnDodajZakazan = new JButton("Dodaj");
		btnDodajZakazan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idKlijenta = ((ComboItem)comboBoxIDKlijenta.getSelectedItem()).getKey();
					int idKozmeticara = ((ComboItem)comboBoxIDKozmeticara.getSelectedItem()).getKey();
					int idTretmana = ((ComboItem)comboBoxIDTretmana.getSelectedItem()).getKey();
					Stanje stanje = Stanje.ZAKAZAN;
					Date datum = dateChooser.getDate();
					String vreme = ((ComboItem)comboBoxVremeZakazivanja.getSelectedItem()).getValue();
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
		    		OsveziKlijente();
		    		OsveziZakazaneTretmane();
		    		UcitajSlobodneTermine();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnDodajZakazan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(btnDodajZakazan);
		
		JButton btnObrisiZakazan = new JButton("Obrisi");
		btnObrisiZakazan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableZakazaniTretmani.getSelectedRow() != -1) 
				{
					int id = (int)tableZakazaniTretmani.getModel().getValueAt(tableZakazaniTretmani.getSelectedRow(), 0);
					int result = JOptionPane.showConfirmDialog(getContentPane(),"Da li zaista zelite da obrisete tretman?", "Brisanje",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) 
					{
						ZakazanTretmanAdmin.ObrisiZakazanTretman(id);
						OsveziZakazaneTretmane();
						UcitajSlobodneTermine();
					}
				}else 
				{
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		
		JButton btnIzmeniZakazan = new JButton("Izmeni");
		btnIzmeniZakazan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableZakazaniTretmani.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(getContentPane(), "Niste selektovali red!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
				try {
					int id = (int)tableZakazaniTretmani.getModel().getValueAt(tableZakazaniTretmani.getSelectedRow(), 0);
					int idKlijenta = ((ComboItem)comboBoxIDKlijenta.getSelectedItem()).getKey();
					int idKozmeticara = ((ComboItem)comboBoxIDKozmeticara.getSelectedItem()).getKey();
					int idTretmana = ((ComboItem)comboBoxIDTretmana.getSelectedItem()).getKey();
					Stanje stanje = (Stanje)comboBoxStanje.getSelectedItem();
					Date datum = dateChooser.getDate();
					String vreme = ((ComboItem)comboBoxVremeZakazivanja.getSelectedItem()).getValue();
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
		    		KlijentAdmin.IzmeniKlijenta(idKlijenta, novi);
					ZakazanTretman izmena = new ZakazanTretman(id, idKlijenta, idKozmeticara, idTretmana, datum, stanje);
					ZakazanTretmanAdmin.IzmeniZakazanTretman(id, izmena);
		    		OsveziZakazaneTretmane();
		    		OsveziKlijente();
		    		UcitajSlobodneTermine();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
		});
		btnIzmeniZakazan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(btnIzmeniZakazan);
		btnObrisiZakazan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(btnObrisiZakazan);
	
		JPanel panelPrihodiRashodi = new JPanel();
		panelCards.add(panelPrihodiRashodi, "pnlPrihodiRashodi");
		panelPrihodiRashodi.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_11 = new JSplitPane();
		splitPane_11.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panelPrihodiRashodi.add(splitPane_11, BorderLayout.CENTER);
		
		JPanel panel_20 = new JPanel();
		splitPane_11.setLeftComponent(panel_20);
		panel_20.setLayout(new MigLayout("", "[][][][][]", "[][][][][][]"));
		
		JLabel lblNewLabel_13 = new JLabel("Prihodi:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_20.add(lblNewLabel_13, "cell 3 2");
		
		lblPrihodi = new JLabel("");
		lblPrihodi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_20.add(lblPrihodi, "cell 4 2");
		
		JLabel lblNewLabel_14 = new JLabel("Rashodi:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_20.add(lblNewLabel_14, "cell 3 5");
		
		lblRashodi = new JLabel("");
		lblRashodi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_20.add(lblRashodi, "cell 4 5");
		
		JPanel fsg = new JPanel();
		splitPane_11.setRightComponent(fsg);
		fsg.setLayout(new MigLayout("", "[][][][][][grow]", "[grow][grow]"));
		
		JButton btnNewButton = new JButton("Prikazi prihode i rasode");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(dateChooserPROd.getDate().compareTo(dateChooserPRDo.getDate()) > 0) return;
					PrihodiRashodi();
				} catch (Exception e2) {
					// TODO: handle exception
					return;
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fsg.add(btnNewButton, "cell 0 0");
		
		JLabel lblNewLabel_11 = new JLabel("OD:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fsg.add(lblNewLabel_11, "flowx,cell 2 0,alignx center,aligny center");
		
		JLabel lblNewLabel_12 = new JLabel("DO:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fsg.add(lblNewLabel_12, "flowx,cell 2 1,alignx center,aligny center");
		
		dateChooserPRDo = new JDateChooser();
		dateChooserPRDo.setPreferredSize(new Dimension(200, 20));
		fsg.add(dateChooserPRDo, "cell 2 1,alignx center,aligny center");
		
		dateChooserPROd = new JDateChooser();
		dateChooserPROd.setPreferredSize(new Dimension(200, 20));
		fsg.add(dateChooserPROd, "cell 2 0,alignx center,aligny center");
		splitPane_11.setDividerLocation(400);
		
		JPanel panelIzvestaji = new JPanel();
		panelCards.add(panelIzvestaji, "pnlIzvestaji");
		panelIzvestaji.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_7 = new JSplitPane();
		splitPane_7.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panelIzvestaji.add(splitPane_7, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		splitPane_7.setRightComponent(panel_13);
		panel_13.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panelCards11 = new JPanel();
		splitPane_7.setLeftComponent(panelCards11);
		panelCards11.setLayout(new CardLayout(0, 0));
		cardLayout2 = (CardLayout)(panelCards11.getLayout());
		
		JPanel panel_11 = new JPanel();
		panelCards11.add(panel_11, "name_647387464013900");
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_8 = new JSplitPane();
		splitPane_8.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_11.add(splitPane_8);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		splitPane_8.setLeftComponent(scrollPane_6);
		
		tableIzvestajKozmeticara = new JTable();
		tableIzvestajKozmeticara.setRowHeight(25);
		tableIzvestajKozmeticara.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableIzvestajKozmeticara.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ime", "Prezime", "Broj tretmana", "Prihod"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableIzvestajKozmeticara.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane_6.setViewportView(tableIzvestajKozmeticara);
		splitPane_8.setDividerLocation(400);
		Funkcionalnost.CentrirajTabelu(tableIzvestajKozmeticara);
		
		JPanel panel_16 = new JPanel();
		splitPane_8.setRightComponent(panel_16);
		panel_16.setLayout(new MigLayout("", "[][][][][][][][][][grow]", "[grow][grow]"));
		
		JLabel lblNewLabel_5 = new JLabel("OD:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_16.add(lblNewLabel_5, "flowx,cell 9 0,alignx center");
		
		dateChooserOdKozm = new JDateChooser();
		dateChooserOdKozm.setPreferredSize(new Dimension(150, 20));
		panel_16.add(dateChooserOdKozm, "cell 9 0,alignx center,aligny center");
		
		JLabel lblNewLabel_6 = new JLabel("DO:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_16.add(lblNewLabel_6, "flowx,cell 9 1,alignx center");
		
		dateChooserDoKozm = new JDateChooser();
		dateChooserDoKozm.setPreferredSize(new Dimension(150, 20));
		panel_16.add(dateChooserDoKozm, "cell 9 1,alignx center,aligny center");
		
		JPanel panel_12 = new JPanel();
		panelCards11.add(panel_12, "name_647428042002200");
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_9 = new JSplitPane();
		splitPane_9.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_12.add(splitPane_9);
		
		JPanel panel_17 = new JPanel();
		splitPane_9.setLeftComponent(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_7 = new JScrollPane();
		panel_17.add(scrollPane_7, BorderLayout.CENTER);
		
		tableStanjeIzvestaj = new JTable();
		tableStanjeIzvestaj.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableStanjeIzvestaj.setRowHeight(25);
		tableStanjeIzvestaj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableStanjeIzvestaj.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tretman", "Datum", "Stanje"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_7.setViewportView(tableStanjeIzvestaj);
		Funkcionalnost.CentrirajTabelu(tableStanjeIzvestaj);
		
		JPanel panel_18 = new JPanel();
		splitPane_9.setRightComponent(panel_18);
		panel_18.setLayout(new MigLayout("", "[][][][][][][][][][grow][][][][][][grow]", "[][grow][grow]"));
		
		JLabel lblNewLabel_7 = new JLabel("OD:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_18.add(lblNewLabel_7, "flowx,cell 9 1,alignx center");
		
		dateChooserOdStanje = new JDateChooser();
		dateChooserOdStanje.setPreferredSize(new Dimension(150, 20));
		panel_18.add(dateChooserOdStanje, "cell 9 1,alignx center,aligny center");
		
		JLabel lblNewLabel_8 = new JLabel("DO:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_18.add(lblNewLabel_8, "flowx,cell 9 2,alignx center");
		
		dateChooserDoStanje = new JDateChooser();
		dateChooserDoStanje.setPreferredSize(new Dimension(150, 20));
		panel_18.add(dateChooserDoStanje, "cell 9 2,alignx center,aligny center");
		splitPane_9.setDividerLocation(400);
		
		JPanel panel_14 = new JPanel();
		panelCards11.add(panel_14, "name_647429845428600");
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_10 = new JSplitPane();
		splitPane_10.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_14.add(splitPane_10, BorderLayout.CENTER);
		
		JPanel panel_19 = new JPanel();
		splitPane_10.setRightComponent(panel_19);
		panel_19.setLayout(new MigLayout("", "[][][][][][][][][][][][grow]", "[grow][grow]"));
		
		JLabel lblNewLabel_9 = new JLabel("OD:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_19.add(lblNewLabel_9, "flowx,cell 9 0,alignx center,aligny center");
		
		dateChooserOdUsluge = new JDateChooser();
		dateChooserOdUsluge.setPreferredSize(new Dimension(150, 20));
		panel_19.add(dateChooserOdUsluge, "cell 9 0,alignx center,aligny center");
		
		comboBoxBrojUsluga = new JComboBox();
		panel_19.add(comboBoxBrojUsluga, "cell 11 0,alignx center,aligny center");
		PopuniComboBoxSveTretmane();
		
		JLabel lblNewLabel_10 = new JLabel("DO:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_19.add(lblNewLabel_10, "flowx,cell 9 1,alignx center,aligny center");
		
		dateChooserDoUsluge = new JDateChooser();
		dateChooserDoUsluge.setPreferredSize(new Dimension(150, 20));
		panel_19.add(dateChooserDoUsluge, "cell 9 1,alignx center,aligny center");
		
		JScrollPane scrollPane_8 = new JScrollPane();
		splitPane_10.setLeftComponent(scrollPane_8);
		
		tableBrojUsluga = new JTable();
		tableBrojUsluga.setRowHeight(25);
		tableBrojUsluga.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableBrojUsluga.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Naziv", "Trajanje", "Cena", "Broj zakazanih tretmana", "Prihodi"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Funkcionalnost.CentrirajTabelu(tableBrojUsluga);
		scrollPane_8.setViewportView(tableBrojUsluga);
		splitPane_10.setDividerLocation(375);
		
		JPanel panel_15 = new JPanel();
		panelCards11.add(panel_15, "name_647431439290600");
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_9 = new JScrollPane();
		panel_15.add(scrollPane_9, BorderLayout.CENTER);
		
		tableKartice = new JTable();
		tableKartice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableKartice.setRowHeight(25);
		tableKartice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableKartice.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ime", "Prezime", "Pol", "Potrosnja", "Pravo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Funkcionalnost.CentrirajTabelu(tableKartice);
		scrollPane_9.setViewportView(tableKartice);
		splitPane_7.setDividerLocation(500);
		
		JButton btnIzvestajKozmeticari = new JButton("Prihodi kozmeticara");
		btnIzvestajKozmeticari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout2.show(panelCards11, "name_647387464013900");
				try {
					if(dateChooserOdKozm.getDate().compareTo(dateChooserDoKozm.getDate()) > 0) return;
					IzvestajKozmeticara();
				} catch (Exception e2) {
					// TODO: handle exception
					return;
				}
			}
		});
		btnIzvestajKozmeticari.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_13.add(btnIzvestajKozmeticari);
		
		JButton btnIzvestajStanja = new JButton("Stanja tretmana");
		btnIzvestajStanja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout2.show(panelCards11, "name_647428042002200");
				try {
					if(dateChooserOdStanje.getDate().compareTo(dateChooserDoStanje.getDate()) > 0) return;
					IzvestajStanja();
				} catch (Exception e2) {
					// TODO: handle exception
					return;
				}
			}
		});
		btnIzvestajStanja.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_13.add(btnIzvestajStanja);
		
		JButton btnIzvestajBrojTretmana = new JButton("Broj usluga");
		btnIzvestajBrojTretmana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout2.show(panelCards11, "name_647429845428600");
				try {
					if(dateChooserOdUsluge.getDate().compareTo(dateChooserDoUsluge.getDate()) > 0) return;
					IzvestajBrojUsluga();
				} catch (Exception e2) {
					// TODO: handle exception
					return;
				}
			}
		});
		btnIzvestajBrojTretmana.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_13.add(btnIzvestajBrojTretmana);
		
		JButton btnLojalnost = new JButton("Kartice lojalnosti");
		btnLojalnost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout2.show(panelCards11, "name_647431439290600");
				PrikaziLojalneKlijente();
			}
		});
		btnLojalnost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_13.add(btnLojalnost);
		
		JPanel panelStatistika = new JPanel();
		panelStatistika.setFocusCycleRoot(true);
		panelCards.add(panelStatistika, "pnlStatistika");
		panelStatistika.setLayout(new CardLayout(0, 0));
		cardLayout3 = (CardLayout)(panelStatistika.getLayout());
		
		panel_21 = new JPanel();
		panelStatistika.add(panel_21, "name_714053624925800");
		panel_21.setLayout(new BorderLayout(0, 0));
		
		panel_22 = new JPanel();
		panelStatistika.add(panel_22, "name_714056238214400");
		panel_22.setLayout(new BorderLayout(0, 0));
		
		panel_23 = new JPanel();
		panelStatistika.add(panel_23, "name_714058256595000");
		panel_23.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPodesavanja = new JPanel();
		panelCards.add(panelPodesavanja, "name_719162731129400");
		panelPodesavanja.setLayout(new MigLayout("", "[][][grow]", "[][][][][][][][][]"));
		
		JLabel lblNewLabel_15 = new JLabel("Uslov za karticu lojalnosti: ");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPodesavanja.add(lblNewLabel_15, "flowx,cell 2 2,alignx center,aligny center");
		
		textFieldUslov = new JTextField();
		textFieldUslov.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPodesavanja.add(textFieldUslov, "cell 2 2,alignx center,aligny center");
		textFieldUslov.setColumns(10);
		textFieldUslov.setText(String.valueOf(KozmetickiSalon.getUslov()));
		
		JButton btnPotvrdiUslov = new JButton("Potvrdi");
		btnPotvrdiUslov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					KozmetickiSalon.setUslov(Double.parseDouble(textFieldUslov.getText()));
					JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste izmenili uslov za karticu lojalnosti!", "", JOptionPane.INFORMATION_MESSAGE);  
					AzurirajKarticeLojalnosti();
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
				}
			}
		});
		btnPotvrdiUslov.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPodesavanja.add(btnPotvrdiUslov, "cell 2 3,alignx center,aligny center");
		
		JLabel lblNewLabel_16 = new JLabel("Nacin izracunavanja bonusa:");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPodesavanja.add(lblNewLabel_16, "flowx,cell 2 7,alignx center,aligny center");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"7% od prihoda", "10% je uradio vise od 15 tretmana", "fiksno"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPodesavanja.add(comboBox, "cell 2 7,alignx center,aligny center");
		
		JButton btnPotvrdiBonus = new JButton("Potvrdi");
		btnPotvrdiBonus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					KozmetickiSalon.setBonus((int)comboBox.getSelectedIndex());
					JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste izmenili nacin izracunavanja bonusa!", "", JOptionPane.INFORMATION_MESSAGE);  
					AzurirajBonuse();
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(getContentPane(), "Neispravan unos!", "Greska", JOptionPane.WARNING_MESSAGE);  
				}
			}
		});
		btnPotvrdiBonus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPodesavanja.add(btnPotvrdiBonus, "cell 2 8,alignx center,aligny center");
		
		JPanel menuPanel = new JPanel();
		splitPane.setLeftComponent(menuPanel);
		menuPanel.setLayout(new GridLayout(9, 1));
		
		JButton btnMenadzeri = new JButton("Menadzeri");
		btnMenadzeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "pnlMenadzeri");
				menuStatistika.setVisible(false);
				OsveziMenadzere();
			}
		});
		btnMenadzeri.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuPanel.add(btnMenadzeri);
		
		JButton btnKozmeticari = new JButton("Kozmeticari");
		btnKozmeticari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "pnlKozmeticari");
				menuStatistika.setVisible(false);
				OsveziKozmeticare();
				UcitajSveVestine();
			}
		});
		btnKozmeticari.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuPanel.add(btnKozmeticari);
		
		JButton btnRecepcioneri = new JButton("Recepcioneri");
		btnRecepcioneri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "pnlRecepcioneri");
				menuStatistika.setVisible(false);
				OsveziRecepcionere();
			}
		});
		btnRecepcioneri.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuPanel.add(btnRecepcioneri);
		
		JButton btnKlijenti = new JButton("Klijenti");
		btnKlijenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "pnlKlijenti");
				menuStatistika.setVisible(false);
				AzurirajKarticeLojalnosti();
				OsveziKlijente();
			}
		});
		btnKlijenti.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuPanel.add(btnKlijenti);
		
		JButton btnTretmani = new JButton("Tretmani");
		btnTretmani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "pnlTretmani");
				menuStatistika.setVisible(false);
				OsveziTretmane();
			}
		});
		btnTretmani.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuPanel.add(btnTretmani);
		
		JButton btnZakazaniTretmani = new JButton("Zakazani Tretmani");
		btnZakazaniTretmani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "pnlZakazaniTretmani");
				menuStatistika.setVisible(false);
				OsveziZakazaneTretmane();
				PopuniComboBoxKlijente();
				PopuniComboBoxKozmeticare();
			}
		});
		btnZakazaniTretmani.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuPanel.add(btnZakazaniTretmani);
		
		btnPrihodiRashodi = new JButton("Prihodi i rashodi");
		btnPrihodiRashodi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "pnlPrihodiRashodi");
				menuStatistika.setVisible(false);
			}
		});
		btnPrihodiRashodi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuPanel.add(btnPrihodiRashodi);
		
		JButton btnIzvestaji = new JButton("Izvestaji");
		btnIzvestaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "pnlIzvestaji");
				menuStatistika.setVisible(false);
			}
		});
		btnIzvestaji.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuPanel.add(btnIzvestaji);
		
		JButton btnStatistika = new JButton("Statistika");
		btnStatistika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "pnlStatistika");
				menuStatistika.setVisible(true);
				OsveziStatistiku();
			}
		});
		btnStatistika.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuPanel.add(btnStatistika);
		splitPane.setDividerLocation(177);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuMenadzer = new JMenu("Dodatne opcije");
		menuMenadzer.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		JMenuItem menuItemPodesavanja = new JMenuItem("Podesavanja");
		menuItemPodesavanja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "name_719162731129400");
			}
		});
		menuItemPodesavanja.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuMenadzer.add(menuItemPodesavanja);
		JMenuItem menuItem_2 = new JMenuItem("Odjavi se");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginFrame().main(new String[] {"", ""});
			}
		});
		menuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuMenadzer.add(menuItem_2);
		JMenuItem menuItem = new JMenuItem("Izlaz");
		menuItem.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		menuMenadzer.add(menuItem);
		
		menuBar.add(menuMenadzer);
		
	    menuStatistika = new JMenu("Statistika");
		menuStatistika.setVisible(false);
		menuStatistika.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(menuStatistika);
		JMenuItem menuBtnPrihodi = new JMenuItem("Prihodi po tipu usluge");
		menuBtnPrihodi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout3.show(panelStatistika, "name_714053624925800");
			}
		});
		menuBtnPrihodi.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuStatistika.add(menuBtnPrihodi);
		
		JMenuItem menuBtnOpterecenje = new JMenuItem("Opterecenje kozmeticara");
		menuBtnOpterecenje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout3.show(panelStatistika, "name_714056238214400");
			}
		});
		menuBtnOpterecenje.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuStatistika.add(menuBtnOpterecenje);
		
		JMenuItem menuBtnStatus = new JMenuItem("Statusi tretmana");
		menuBtnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout3.show(panelStatistika, "name_714058256595000");
		}});
		menuBtnStatus.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuStatistika.add(menuBtnStatus);
	}
	
	private void OsveziMenadzere() 
	{
		tableMenadzeri.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableMenadzeri.getModel();
	    dm.getDataVector().removeAllElements();
	    
	    UcitajMenadzere();
	}
	
	private void UcitajMenadzere() 
	{
		DefaultTableModel dm = (DefaultTableModel) tableMenadzeri.getModel();

		for (Menadzer menadzer : KozmetickiSalon.menadzeri) {
			Object[] data = {menadzer.getId(), menadzer.getIme(), menadzer.getPrezime(), menadzer.getPol(), menadzer.getTelefon(), menadzer.getAdresa(), 
					menadzer.getKorisnickoIme(), menadzer.getLozinka(), menadzer.getNivoStrucneSpreme(), menadzer.getStaz(), menadzer.getKoeficijent(), 
					menadzer.getOsnova(), menadzer.getBonus(), Math.round(menadzer.getPlata())};
			dm.addRow(data);
		}
	}
	
	private void OsveziKozmeticare() 
	{
		tableKozmeticari.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableKozmeticari.getModel();
	    dm.getDataVector().removeAllElements();
	    
	    UcitajKozmeticare();
	}
	
	private void UcitajKozmeticare() 
	{
		DefaultTableModel dm = (DefaultTableModel) tableKozmeticari.getModel();

		for (Kozmeticar kozmeticar : KozmetickiSalon.kozmeticari) {
			String vestine = "";
			Object[] data = {kozmeticar.getId(), kozmeticar.getIme(), kozmeticar.getPrezime(), kozmeticar.getPol(), kozmeticar.getTelefon(), kozmeticar.getAdresa(), 
					kozmeticar.getKorisnickoIme(), kozmeticar.getLozinka(), kozmeticar.getNivoStrucneSpreme(), kozmeticar.getStaz(), kozmeticar.getKoeficijent(), 
					kozmeticar.getOsnova(), kozmeticar.getBonus(), Math.round(kozmeticar.getPlata()), Funkcionalnost.PretvoriTretmane(kozmeticar.getObucenZaTretmane())};
			dm.addRow(data);
		}
	}
	
	private void OsveziRecepcionere() 
	{
		tableRecepcioneri.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableRecepcioneri.getModel();
	    dm.getDataVector().removeAllElements();
	    
	    UcitajRecepcionere();
	}
	
	private void UcitajRecepcionere() 
	{
		DefaultTableModel dm = (DefaultTableModel) tableRecepcioneri.getModel();

		for (Recepcioner recepcioner : KozmetickiSalon.recepcioneri) {
			Object[] data = {recepcioner.getId(), recepcioner.getIme(), recepcioner.getPrezime(), recepcioner.getPol(), recepcioner.getTelefon(), recepcioner.getAdresa(), 
					recepcioner.getKorisnickoIme(), recepcioner.getLozinka(), recepcioner.getNivoStrucneSpreme(), recepcioner.getStaz(), recepcioner.getKoeficijent(), 
					recepcioner.getOsnova(), recepcioner.getBonus(), Math.round(recepcioner.getPlata()) };
			dm.addRow(data);
		}
	}
	
	private void OsveziKlijente() 
	{
		tableKlijenti.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableKlijenti.getModel();
	    dm.getDataVector().removeAllElements();
	    
	    UcitajKlijente();
	}
	
	private void UcitajKlijente() 
	{
		DefaultTableModel dm = (DefaultTableModel) tableKlijenti.getModel();

		for (Klijent klijent : KozmetickiSalon.klijenti) {
			String imaNema = "";
			if(klijent.getPravoNaKarticuLojalnosti()) 
			{
				imaNema = "Ima";
			}else 
			{
				imaNema = "Nema";
			}
			Object[] data = {klijent.getId(), klijent.getIme(), klijent.getPrezime(), klijent.getPol(), klijent.getTelefon(), klijent.getAdresa(), 
					klijent.getKorisnickoIme(), klijent.getLozinka(), klijent.getStanje(), klijent.getPotrosnja(), imaNema};
			dm.addRow(data);
		}
	}
	
	private void OsveziTretmane() 
	{
		tableTretmani.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableTretmani.getModel();
	    dm.getDataVector().removeAllElements();
	    
	    UcitajTretmane();
	}
	
	private void UcitajTretmane() 
	{
		DefaultTableModel dm = (DefaultTableModel) tableTretmani.getModel();

		for (Tretman tretman : KozmetickiSalon.tretmani) {
			Object[] data = {tretman.getId(), tretman.getNaziv(), tretman.getTrajanje(), tretman.getCena()};
			dm.addRow(data);
		}
	}
	
	private void OsveziZakazaneTretmane() 
	{
		tableZakazaniTretmani.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableZakazaniTretmani.getModel();
	    dm.getDataVector().removeAllElements();
	    
	    UcitajZakazaneTretmane();
	}
	
	private void UcitajZakazaneTretmane() 
	{
		DefaultTableModel dm = (DefaultTableModel) tableZakazaniTretmani.getModel();

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
	
	private void UcitajSveVestine() 
	{
		comboBoxVestine.removeAllItems();
		for (int i = 0;  i < KozmetickiSalon.tretmani.size(); i++) {
			comboBoxVestine.addItem(new ComboItem(i + 1, KozmetickiSalon.tretmani.get(i).getNaziv()));
		}
	}
	
	private void UcitajOdredjeneVestine(List<Integer> vestine) 
	{
		DefaultListModel listmodel = new DefaultListModel();
		vestinePom.clear();
		for (int i = 0; i < vestine.size(); i++) {
			vestinePom.add(vestine.get(i));
			listmodel.addElement(new ComboItem(vestine.get(i), Tretman.NadjiPoID(vestine.get(i), KozmetickiSalon.tretmani).getNaziv()));
		}
		listVestine.setModel(listmodel);
	}
	
	private void PopuniComboBoxKlijente() 
	{
		comboBoxIDKlijenta.removeAllItems();
		for (Klijent klijent : KozmetickiSalon.klijenti) {
			comboBoxIDKlijenta.addItem (new ComboItem(klijent.getId(), klijent.getIme() + " " + klijent.getPrezime()));
		}
	}
	
	private void PopuniComboBoxKozmeticare() 
	{
		comboBoxIDKozmeticara.removeAllItems();
		for (Kozmeticar kozmeticar : KozmetickiSalon.kozmeticari) {
			comboBoxIDKozmeticara.addItem (new ComboItem(kozmeticar.getId(), kozmeticar.getIme() + " " + kozmeticar.getPrezime()));
		}
	}
	
	private void PopuniComboBoxTretmane() 
	{
		comboBoxIDTretmana.removeAllItems();
		try {
			int idKozmeticara = ((ComboItem)comboBoxIDKozmeticara.getModel().getSelectedItem()).getKey();
			List<Integer> vestineInt = Kozmeticar.NadjiPoID(idKozmeticara, KozmetickiSalon.kozmeticari).getObucenZaTretmane();
			List<String> vestineStr = Funkcionalnost.ProcitajVestineKozmeticara(vestineInt);
			for (int i = 0; i < vestineStr.size(); i++) {
				comboBoxIDTretmana.addItem(new ComboItem(vestineInt.get(i), vestineStr.get(i)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
	}
	
	private void PopuniComboBoxSveTretmane() 
	{
		for (Tretman tretman : KozmetickiSalon.tretmani) {
			comboBoxBrojUsluga.addItem(new ComboItem(tretman.getId(), tretman.getNaziv()));
		}
	}
	
	private void UcitajSlobodneTermine() 
	{
		comboBoxVremeZakazivanja.removeAllItems();
		try {
			int idKozmeticara = ((ComboItem)comboBoxIDKozmeticara.getModel().getSelectedItem()).getKey();
			Date datum = dateChooser.getDate();
			for (String string: KozmetickiSalon.RaspoloziviTermini) {
				if(Funkcionalnost.DaLiJeSlobodan(idKozmeticara, datum, string)) 
				{
					comboBoxVremeZakazivanja.addItem(new ComboItem(1, string));
				}
			}
			if(comboBoxVremeZakazivanja.getItemCount() == 0) 
			{
				JOptionPane.showMessageDialog(getContentPane(), "Izabrani kozmeticar tog dana nema slobodnih termina!", "Obavestenje", JOptionPane.WARNING_MESSAGE);  
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
	}
	
	private void PrihodiRashodi() 
	{
		Date pocetak = dateChooserPROd.getDate();
		Date kraj = dateChooserPRDo.getDate();
		double prihodi = 0;
		double rashodi = 0;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(pocetak);
		
		while (cal.getTime().compareTo(kraj) <= 0) {
			if(cal.get(Calendar.DAY_OF_MONTH) == 4) 
			{
				rashodi += 25000; //struja, voda, porezi, itd...
				rashodi += PlateKozmeticara();
				rashodi += 80000; //potrosni materijal
			}
			
			for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
				if((zakazanTretman.getVreme().getYear() + 1900) == cal.get(Calendar.YEAR) && zakazanTretman.getVreme().getMonth() == cal.get(Calendar.MONTH)
						&& zakazanTretman.getVreme().getDate() == cal.get(Calendar.DAY_OF_MONTH)) 
				{
					prihodi += Tretman.NadjiPoID(zakazanTretman.getidTretmana(), KozmetickiSalon.tretmani).getCena();
				}
			}
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		lblPrihodi.setText(String.valueOf(prihodi));;
		lblRashodi.setText(String.valueOf(Math.round(rashodi)));;
	}
	
	private double PlateKozmeticara() 
	{
		double s = 0;
		
		for (Kozmeticar kozmeticar : KozmetickiSalon.kozmeticari) {
			s += kozmeticar.getPlata();
		}
		
		return s;
	}
	
	private void IzvestajKozmeticara() 
	{
		tableIzvestajKozmeticara.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableIzvestajKozmeticara.getModel();
	    dm.getDataVector().removeAllElements();
	    
	    for (Kozmeticar kozmeticar : KozmetickiSalon.kozmeticari) {
			int brojTretmana = 0;
			double prihodi = 0;
			
			for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
				if(dateChooserOdKozm.getDate().compareTo(zakazanTretman.getVreme()) < 0 && dateChooserDoKozm.getDate().compareTo(zakazanTretman.getVreme()) > 0
						&& zakazanTretman.getIdKozmeticara() == kozmeticar.getId()) 
				{
					brojTretmana++;
					prihodi += Tretman.NadjiPoID(zakazanTretman.getidTretmana(), KozmetickiSalon.tretmani).getCena();
				}
			}
			Object[] data = {kozmeticar.getIme(), kozmeticar.getPrezime(), brojTretmana, prihodi};
			dm.addRow(data);
		}
	}
	
	public void IzvestajStanja() 
	{
		tableStanjeIzvestaj.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableStanjeIzvestaj.getModel();
	    dm.getDataVector().removeAllElements();
	    
	    for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
	    	if(dateChooserOdStanje.getDate().compareTo(zakazanTretman.getVreme()) < 0 && dateChooserDoStanje.getDate().compareTo(zakazanTretman.getVreme()) > 0) 
			{
	    		Object[] data = {Tretman.NadjiPoID(zakazanTretman.getidTretmana(), KozmetickiSalon.tretmani).getNaziv(), Funkcionalnost.dateToString(zakazanTretman.getVreme()), zakazanTretman.getStanje()};
				dm.addRow(data);
			}
		}	    
	}
	
	private void IzvestajBrojUsluga() 
	{
		tableBrojUsluga.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableBrojUsluga.getModel();
	    dm.getDataVector().removeAllElements();
	    
	    Tretman izabraniTretman = Tretman.NadjiPoID(((ComboItem)comboBoxBrojUsluga.getModel().getSelectedItem()).getKey(), KozmetickiSalon.tretmani);
	    int brojTretmana = 0;
	    double prihodi = 0;
	    
	    for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
			if(zakazanTretman.getidTretmana() == izabraniTretman.getId() && dateChooserOdUsluge.getDate().compareTo(zakazanTretman.getVreme()) < 0 &&
					dateChooserDoUsluge.getDate().compareTo(zakazanTretman.getVreme()) > 0)
			{
				brojTretmana++;
				prihodi += Tretman.NadjiPoID(zakazanTretman.getidTretmana(), KozmetickiSalon.tretmani).getCena();
			}
		}	 
	    
	    Object[] data = {izabraniTretman.getNaziv(), izabraniTretman.getTrajanje(), izabraniTretman.getCena(), brojTretmana, prihodi};
	    dm.addRow(data);
	}
	
	private void AzurirajKarticeLojalnosti() 
	{
		for (Klijent klijent : KozmetickiSalon.klijenti) {
			if(!klijent.getPravoNaKarticuLojalnosti() && klijent.getPotrosnja() >= KozmetickiSalon.getUslov()) 
			{
				klijent.setPravoNaKarticuLojalnosti(true);
			}
			else if(klijent.getPravoNaKarticuLojalnosti() && klijent.getPotrosnja() < KozmetickiSalon.getUslov()) 
			{
				klijent.setPravoNaKarticuLojalnosti(false);
			}
		}
		Klijent.SacuvajKlijente(KozmetickiSalon.klijenti);
	}
	
	private void PrikaziLojalneKlijente() 
	{
		tableKartice.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableKartice.getModel();
	    dm.getDataVector().removeAllElements();
	    
	    for (Klijent klijent : KozmetickiSalon.klijenti) {
			if(klijent.getPravoNaKarticuLojalnosti()) 
			{
				Object[] data = {klijent.getId(), klijent.getIme(), klijent.getPrezime(), klijent.getPol(), klijent.getPotrosnja(), "Ima"};
				dm.addRow(data);
			}
		}
	}
	
	private void AzurirajStanjaTretmana() 
	{
		for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
			LocalDate vremeTretmana = zakazanTretman.getVreme().toInstant()
  			      .atZone(ZoneId.systemDefault())
  			      .toLocalDate();
			if(vremeTretmana.isBefore(LocalDate.now()) && zakazanTretman.getStanje() == Stanje.ZAKAZAN) 
			{
				zakazanTretman.setStanje(Stanje.IZVRSEN);
			}
		}
		
		ZakazanTretman.SacuvajZakazaneTretmane(KozmetickiSalon.zakazaniTretmani);
	}
	
	private void OsveziStatistiku() 
	{
		//statistika 1
		panel_21.removeAll();

		CategoryChart chart = new CategoryChartBuilder().title("Prihodi po mesecima ove godine").build();
		
		List<Integer> sviMeseci = new ArrayList<Integer>();
		sviMeseci.add(1);
		sviMeseci.add(2);
		sviMeseci.add(3);
		sviMeseci.add(4);
		sviMeseci.add(5);
		sviMeseci.add(6);
		sviMeseci.add(7);
		sviMeseci.add(8);
		sviMeseci.add(9);
		sviMeseci.add(10);
		sviMeseci.add(11);
		sviMeseci.add(12);
		
		List<List<Double>> tretmaniPoMesecima = new ArrayList<List<Double>>();
		
		List<Integer> idOviTretmana = new ArrayList<Integer>();
		List<String> naziviTretmana = new ArrayList<String>();
		for (Tretman tretman : KozmetickiSalon.tretmani) {
			idOviTretmana.add(tretman.getId());
			naziviTretmana.add(tretman.getNaziv());
			
			List<Double> prihodiPoMesecima = new ArrayList<Double>();
			
			prihodiPoMesecima.add(0.0);
			prihodiPoMesecima.add(0.0);
			prihodiPoMesecima.add(0.0);
			prihodiPoMesecima.add(0.0);
			prihodiPoMesecima.add(0.0);
			prihodiPoMesecima.add(0.0);
			prihodiPoMesecima.add(0.0);
			prihodiPoMesecima.add(0.0);
			prihodiPoMesecima.add(0.0);
			prihodiPoMesecima.add(0.0);
			prihodiPoMesecima.add(0.0);
			prihodiPoMesecima.add(0.0);
			
			tretmaniPoMesecima.add(prihodiPoMesecima);
		}
		List<Double> prihodiPoMesecima = new ArrayList<Double>();
		
		prihodiPoMesecima.add(0.0);
		prihodiPoMesecima.add(0.0);
		prihodiPoMesecima.add(0.0);
		prihodiPoMesecima.add(0.0);
		prihodiPoMesecima.add(0.0);
		prihodiPoMesecima.add(0.0);
		prihodiPoMesecima.add(0.0);
		prihodiPoMesecima.add(0.0);
		prihodiPoMesecima.add(0.0);
		prihodiPoMesecima.add(0.0);
		prihodiPoMesecima.add(0.0);
		prihodiPoMesecima.add(0.0);
		
		tretmaniPoMesecima.add(prihodiPoMesecima);
		
		for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
			if((zakazanTretman.getVreme().getYear() + 1900) == LocalDate.now().getYear()) 
			{
				double cena = Tretman.NadjiPoID(zakazanTretman.getidTretmana(), KozmetickiSalon.tretmani).getCena();
				int indexTretmana = idOviTretmana.indexOf(zakazanTretman.getidTretmana());
				List<Double> lista = tretmaniPoMesecima.get(indexTretmana);
				lista.set(zakazanTretman.getVreme().getMonth(), lista.get(zakazanTretman.getVreme().getMonth()) + cena);
				tretmaniPoMesecima.set(indexTretmana, lista);
				
				//ukupno
				List<Double> ukupnoLista = tretmaniPoMesecima.get(tretmaniPoMesecima.size() - 1);
				ukupnoLista.set(zakazanTretman.getVreme().getMonth(), ukupnoLista.get(zakazanTretman.getVreme().getMonth()) + cena);
				tretmaniPoMesecima.set(tretmaniPoMesecima.size() - 1, ukupnoLista);
			}
		}
		
		for (int i = 0; i < tretmaniPoMesecima.size() - 1; i++) {
			chart.addSeries(naziviTretmana.get(i), sviMeseci, tretmaniPoMesecima.get(i));
		}
		chart.addSeries("Ukupno", sviMeseci, tretmaniPoMesecima.get(tretmaniPoMesecima.size() - 1));
		
		JPanel chartPanel1 = new XChartPanel<CategoryChart>(chart);
	    panel_21.add(chartPanel1, BorderLayout.CENTER);
		//statistika 2
		panel_22.removeAll();
		
	    PieChart cPieChart2 = new PieChartBuilder().title("Opterecenje kozmeticara u poslednjih 30 dana").build();
	    
	    for(Kozmeticar kozmeticar : KozmetickiSalon.kozmeticari) 
	    {
	    	int br = 0;
	    	for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
	    		LocalDate vremeTretmana = zakazanTretman.getVreme().toInstant()
	    			      .atZone(ZoneId.systemDefault())
	    			      .toLocalDate();
				if(zakazanTretman.getIdKozmeticara() == kozmeticar.getId() && 
						vremeTretmana.compareTo(LocalDate.now().minusDays(30)) >= 0 && 
						vremeTretmana.compareTo(LocalDate.now()) <= 0
					)
				{
					br++;
				}
			}
	    	cPieChart2.addSeries(kozmeticar.getIme() + " " + kozmeticar.getPrezime(), br);
	    }
	    
	    JPanel chartPanel2 = new XChartPanel<PieChart>(cPieChart2);
	    panel_22.add(chartPanel2, BorderLayout.CENTER);
	    
	    //statistika 3
	    panel_23.removeAll();
		
	    PieChart cPieChart3 = new PieChartBuilder().title("Statusi tretmana u poslednjih 30 dana").build();
	    
	    int zakazan = 0;
    	int izvrsen = 0;
    	int nijeSePojavio = 0;
    	int otkazaoK = 0;
    	int otkazaoS = 0;
    	
    	for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
    		LocalDate vremeTretmana = zakazanTretman.getVreme().toInstant()
    			      .atZone(ZoneId.systemDefault())
    			      .toLocalDate();
			if(vremeTretmana.compareTo(LocalDate.now().minusDays(30)) >= 0 && vremeTretmana.compareTo(LocalDate.now()) <= 0)
			{
				switch (zakazanTretman.getStanje()) {
					case ZAKAZAN:
						zakazan++;
						break;
					case IZVRSEN:
						izvrsen++;
						break;
					case NIJE_SE_POJAVIO:
						nijeSePojavio++;
						break;
					case OTKAZAO_KLIJENT:
						otkazaoK++;
						break;
					case OTKAZAO_SALON:
						otkazaoS++;
						break;
				}
			}
    	}
    	cPieChart3.addSeries("ZAKAZAN", zakazan);
    	cPieChart3.addSeries("IZVRSEN", izvrsen);
    	cPieChart3.addSeries("NIJE SE POJAVIO", nijeSePojavio);
    	cPieChart3.addSeries("OTKAZAO KLIJENT", otkazaoK);
    	cPieChart3.addSeries("OTKAZAO SALON", otkazaoS);
	    
	    JPanel chartPanel3 = new XChartPanel<PieChart>(cPieChart3);
	    panel_23.add(chartPanel3, BorderLayout.CENTER);
	}
	
	private String OdrediMesec(int x) 
	{
		switch (x) {
			case 0:
				return "Januar";
			case 1:
				return "Februar";
			case 2:
				return "Mart";
			case 3:
				return "April";
			case 4:
				return "Maj";
			case 5:
				return "Jun";
			case 6:
				return "Jul";
			case 7:
				return "Avgust";
			case 8:
				return "Septembar";
			case 9:
				return "Oktobar";
			case 10:
				return "Novembar";
			case 11:
				return "Decembar";
		default:
			throw new IllegalArgumentException("Unexpected value: " + x);
		}
	}
	private void AzurirajBonuse() 
	{
		int nacin = KozmetickiSalon.getBonus();
		switch (nacin) {
			case 0:
				for (Kozmeticar kozmeticar : KozmetickiSalon.kozmeticari) {
					kozmeticar.setBonus(kozmeticar.getPlata() * 0.07);
					kozmeticar.racunajPlatu();
				}
				break;
			case 1:
				for (Kozmeticar kozmeticar : KozmetickiSalon.kozmeticari) {
					int br = 0;
					for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
						LocalDate vremeTretmana = zakazanTretman.getVreme().toInstant()
							      .atZone(ZoneId.systemDefault())
							      .toLocalDate();
						if(vremeTretmana.compareTo(LocalDate.now().minusDays(30)) >= 0 && vremeTretmana.compareTo(LocalDate.now()) <= 0 && zakazanTretman.getIdKozmeticara() == kozmeticar.getId() && br < 16) 
						{
							br++;
						}
						else 
						{
							break;
						}
					}
					kozmeticar.setBonus(kozmeticar.getPlata() * 0.1);
					kozmeticar.racunajPlatu();
				}
				break;
			case 2:
				break;
		}
		
		Kozmeticar.SacuvajKozmeticare(KozmetickiSalon.kozmeticari);
	}
}
