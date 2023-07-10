package funkcionalnosti;

import javax.swing.JPanel;

import entitetiSalona.KozmetickiSalon;
import entitetiSalona.Tretman;

import java.awt.BorderLayout;
import javax.swing.JComboBox;

public class FilterPanel extends JPanel {

	public static JComboBox comboBoxTretman;
	/**
	 * Create the panel.
	 */
	public FilterPanel() {
		setLayout(new BorderLayout(0, 0));
		
		comboBoxTretman = new JComboBox();
		add(comboBoxTretman, BorderLayout.NORTH);
		PopuniComboBoxSveTretmane();

	}

	private void PopuniComboBoxSveTretmane() 
	{
		for (Tretman tretman : KozmetickiSalon.tretmani) {
			comboBoxTretman.addItem(new ComboItem(tretman.getId(), tretman.getNaziv()));
		}
	}
}
