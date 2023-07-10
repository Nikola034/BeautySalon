package forme;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.plaf.OptionPaneUI;

import entitetiSalona.KozmetickiSalon;
import entitetiSalona.Tretman;
import entitetiSalona.ZakazanTretman;
import funkcionalnosti.Funkcionalnost;
import korisnici.Klijent;
import korisnici.Kozmeticar;
import korisnici.Menadzer;
import korisnici.Recepcioner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;


public class LoginFrame {
	
	private JFrame frmLogin;
	private JTextField textFieldKorisnickoIme;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame(){
		initialize();
		UcitajPodatke();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 327, 223);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmLogin.setLocation(dim.width/2-frmLogin.getWidth()/2, dim.height/2-frmLogin.getHeight()/2);

		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lozinka = new String(passwordField.getPassword());
				boolean ind = false;
				for (Menadzer menadzer : KozmetickiSalon.menadzeri) {
					if(menadzer.getKorisnickoIme().equals(textFieldKorisnickoIme.getText()) && menadzer.getLozinka().equals(lozinka)) 
					{
						ind = true;
						frmLogin.dispose();
						MenadzerFrame menadzerFrame = new MenadzerFrame(menadzer);
						menadzerFrame.setVisible(true);
						break;
					}
				} 
				if(!ind) 
				{
					for (Kozmeticar kozmeticar : KozmetickiSalon.kozmeticari) {
						if(kozmeticar.getKorisnickoIme().equals(textFieldKorisnickoIme.getText()) && kozmeticar.getLozinka().equals(lozinka)) 
						{
							ind = true;
							frmLogin.dispose();
							KozmeticarFrame kozmeticarFrame = new KozmeticarFrame(kozmeticar);
							kozmeticarFrame.setVisible(true);
							break;
						}
					}
				}
				if(!ind) 
				{
					for (Recepcioner recepcioner : KozmetickiSalon.recepcioneri) {
						if(recepcioner.getKorisnickoIme().equals(textFieldKorisnickoIme.getText()) && recepcioner.getLozinka().equals(lozinka)) 
						{
							ind = true;
							frmLogin.dispose();
							RecepcionerFrame recepcionerFrame = new RecepcionerFrame(recepcioner);
							recepcionerFrame.setVisible(true);
							break;
						}
					}
				}
				if(!ind) 
				{
					for (Klijent klijent : KozmetickiSalon.klijenti) {
						if(klijent.getKorisnickoIme().equals(textFieldKorisnickoIme.getText()) && klijent.getLozinka().equals(lozinka)) 
						{
							ind = true;
							frmLogin.dispose();
							KlijentFrame klijentFrame = new KlijentFrame(klijent);
							klijentFrame.setVisible(true);
							break;
						}
					}
				}
				if(!ind) 
				{
					JOptionPane.showMessageDialog(null, "Pogresno korisnicko ime ili lozinka!", "Greska", JOptionPane.OK_OPTION);
				}
			}
		});
		btnPotvrdi.setBounds(110, 109, 145, 23);
		frmLogin.getContentPane().add(btnPotvrdi);
		
		textFieldKorisnickoIme = new JTextField();
		textFieldKorisnickoIme.setBounds(110, 47, 145, 20);
		frmLogin.getContentPane().add(textFieldKorisnickoIme);
		textFieldKorisnickoIme.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Korisnicko ime:");
		lblNewLabel.setBounds(10, 50, 90, 14);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lozinka:");
		lblNewLabel_1.setBounds(10, 81, 67, 14);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		JButton btnRegistracija = new JButton("Registruj se");
		btnRegistracija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterFrame().setVisible(true);
			}
		});
		btnRegistracija.setBounds(110, 143, 145, 23);
		frmLogin.getContentPane().add(btnRegistracija);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(110, 78, 145, 20);
		frmLogin.getContentPane().add(passwordField);
	}
	
	private void UcitajPodatke() {
		KozmetickiSalon.menadzeri = Menadzer.UcitajMenadzere();
		KozmetickiSalon.kozmeticari = Kozmeticar.UcitajKozmeticare();
		KozmetickiSalon.recepcioneri = Recepcioner.UcitajRecepcionere();
		KozmetickiSalon.klijenti = Klijent.UcitajKlijente();
		KozmetickiSalon.tretmani = Tretman.UcitajTretmane();
		KozmetickiSalon.zakazaniTretmani = ZakazanTretman.UcitajZakazaneTretmane();
	}
}
