package forme;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entitetiSalona.KlijentAdmin;
import entitetiSalona.KozmetickiSalon;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enumi.Pol;
import korisnici.Klijent;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIme;
	private JTextField textFieldPrezime;
	private JTextField textFieldTelefon;
	private JTextField textFieldAdresa;
	private JTextField textFieldKorisnickoIme;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterFrame() {
		setTitle("Registracija");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow]", "[][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Ime:");
		contentPane.add(lblNewLabel, "cell 2 1,alignx trailing");
		
		textFieldIme = new JTextField();
		contentPane.add(textFieldIme, "cell 3 1,alignx left");
		textFieldIme.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Prezime:");
		contentPane.add(lblNewLabel_1, "cell 2 2,alignx trailing");
		
		textFieldPrezime = new JTextField();
		contentPane.add(textFieldPrezime, "cell 3 2,alignx left");
		textFieldPrezime.setColumns(20);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pol:");
		contentPane.add(lblNewLabel_1_1, "cell 2 3,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Pol.values()));
		contentPane.add(comboBox, "cell 3 3,alignx leading");
		
		JLabel lblNewLabel_1_2 = new JLabel("Telefon:");
		contentPane.add(lblNewLabel_1_2, "cell 2 4,alignx trailing");
		
		textFieldTelefon = new JTextField();
		textFieldTelefon.setColumns(20);
		contentPane.add(textFieldTelefon, "cell 3 4,alignx left");
		
		JLabel lblNewLabel_1_3 = new JLabel("Adresa:");
		contentPane.add(lblNewLabel_1_3, "cell 2 5,alignx trailing");
		
		textFieldAdresa = new JTextField();
		textFieldAdresa.setColumns(20);
		contentPane.add(textFieldAdresa, "cell 3 5,alignx left");
		
		JLabel lblNewLabel_1_4 = new JLabel("Korisnicko ime:");
		contentPane.add(lblNewLabel_1_4, "cell 2 6,alignx trailing");
		
		textFieldKorisnickoIme = new JTextField();
		textFieldKorisnickoIme.setColumns(20);
		contentPane.add(textFieldKorisnickoIme, "cell 3 6,alignx left");
		
		JLabel lblNewLabel_1_5 = new JLabel("Lozinka:");
		contentPane.add(lblNewLabel_1_5, "cell 2 7,alignx trailing");
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldIme.getText().equals("") || textFieldPrezime.getText().equals("") || textFieldTelefon.getText().equals("") ||
						textFieldAdresa.getText().equals("") || textFieldKorisnickoIme.getText().equals("") || new String(passwordField1.getPassword()).equals("") ||
						new String(passwordField1.getPassword()).equals("")) 
				{
					JOptionPane.showMessageDialog(getContentPane(), "Sva polja moraju biti popunjena!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
				else if(!new String(passwordField1.getPassword()).equals(new String(passwordField2.getPassword()))) 
				{
					JOptionPane.showMessageDialog(getContentPane(), "Lozinke se ne poklapaju!", "Greska", JOptionPane.WARNING_MESSAGE);  
					return;
				}
				else 
				{
					Klijent novi = new Klijent(textFieldIme.getText(), textFieldPrezime.getText(), (Pol)comboBox.getSelectedItem(), textFieldTelefon.getText(), textFieldAdresa.getText(), 
							textFieldKorisnickoIme.getText(), new String(passwordField1.getPassword()), 0, 0, false);
					KlijentAdmin.DodajKlijenta(novi);
					JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste se registrovali!", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new KlijentFrame(novi).setVisible(true);
				}
			}
		});
		
		passwordField1 = new JPasswordField();
		passwordField1.setColumns(20);
		contentPane.add(passwordField1, "cell 3 7,alignx left");
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Potvrdi lozinku:");
		contentPane.add(lblNewLabel_1_5_1, "cell 2 9,alignx trailing");
		
		passwordField2 = new JPasswordField();
		passwordField2.setColumns(20);
		contentPane.add(passwordField2, "cell 3 9,alignx left");
		contentPane.add(btnPotvrdi, "cell 3 13,alignx center");
	}

}
